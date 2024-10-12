package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.ResourceType;
import com.api.greenway.repositories.ResourceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ResourceTypeService {

    private final ResourceTypeRepository resourceTypeRepository;

    @Autowired
    public ResourceTypeService(ResourceTypeRepository resourceTypeRepository){
        this.resourceTypeRepository = resourceTypeRepository;
    }

    public ResourceType find(Long id) {
        return resourceTypeRepository.findOneByFinishedAtIsNullAndIdResourceType(id);
    }

    public ResourceType create(ResourceTypeRegisterDTO resourceTypeRegisterDTO){
        return resourceTypeRepository.save(new ResourceType(resourceTypeRegisterDTO));
    }

    public Page<ResourceTypeDetailedDTO> list(Pageable pagination) {
        return resourceTypeRepository.findByFinishedAtIsNull(pagination).map(ResourceTypeDetailedDTO::new);
    }

    public ResourceTypeDetailedDTO get(Long id) {
        return new ResourceTypeDetailedDTO(resourceTypeRepository.findOneByFinishedAtIsNullAndIdResourceType(id));
    }

    public void delete(Long id) {
        ResourceType resourceType = resourceTypeRepository.findOneByFinishedAtIsNullAndIdResourceType(id);

        resourceType.disable();

        resourceTypeRepository.save(resourceType);
    }

    public ResourceTypeDetailedDTO update(Long id, ResourceTypeUpdateDTO productTypeUpdateDTO) {
        ResourceType resourceType = resourceTypeRepository.findOneByFinishedAtIsNullAndIdResourceType(id);

        resourceType.updateInformation(productTypeUpdateDTO);

        resourceTypeRepository.save(resourceType);

        return new ResourceTypeDetailedDTO(resourceType);
    }



}
