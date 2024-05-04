package com.api.greenway.services;

import com.api.greenway.controllers.dtos.ResourceDetailedDTO;
import com.api.greenway.controllers.dtos.ResourceRegisterDTO;
import com.api.greenway.controllers.dtos.ResourceUpdateDTO;
import com.api.greenway.models.*;
import com.api.greenway.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private final ResourceTypeService resourceTypeService;

    @Autowired
    public ResourceService(ResourceRepository resourceRepository, ResourceTypeService resourceTypeService) {
        this.resourceRepository = resourceRepository;
        this.resourceTypeService = resourceTypeService;
    }

    public Resource find(Long id) {
        return resourceRepository.findOneByFinishedAtIsNullAndIdResource(id);
    }

    public Resource create(ResourceRegisterDTO resourceRegisterDTO) {
        Resource resource = new Resource(resourceRegisterDTO);

        ResourceType resourceType = resourceTypeService.find(resourceRegisterDTO.idResourceType());

        resource.setResourceType(resourceType);

        return resourceRepository.save(resource);
    }

    public Page<ResourceDetailedDTO> list(Pageable pagination) {
        return resourceRepository.findByFinishedAtIsNull(pagination).map(ResourceDetailedDTO::new);
    }

    public ResourceDetailedDTO get(Long id) {
        return new ResourceDetailedDTO(resourceRepository.findOneByFinishedAtIsNullAndIdResource(id));
    }

    public void delete(Long id) {
        Resource resource = resourceRepository.findOneByFinishedAtIsNullAndIdResource(id);

        resource.disable();

        resourceRepository.save(resource);
    }

    public ResourceDetailedDTO update(Long id, ResourceUpdateDTO resourceUpdateDTO) {
        Resource resource = resourceRepository.findOneByFinishedAtIsNullAndIdResource(id);

        resource.updateInformation(resourceUpdateDTO);

        resourceRepository.save(resource);

        return new ResourceDetailedDTO(resource);
    }

}
