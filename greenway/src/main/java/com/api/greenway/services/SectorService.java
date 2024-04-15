package com.api.greenway.services;

import com.api.greenway.controllers.dtos.SectorDetailedDTO;
import com.api.greenway.controllers.dtos.SectorRegisterDTO;
import com.api.greenway.controllers.dtos.SectorUpdateDTO;
import com.api.greenway.models.Sector;
import com.api.greenway.repositories.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SectorService {
    private final SectorRepository sectorRepository;

    @Autowired
    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    public Sector create(SectorRegisterDTO sectorRegisterDTO) {
        return sectorRepository.save(new Sector(sectorRegisterDTO));
    }

    public Page<SectorDetailedDTO> list(Pageable pagination) {
        return sectorRepository.findByFinishedAtIsNull(pagination).map(SectorDetailedDTO::new);
    }

    public SectorDetailedDTO get(Long id) {
        return new SectorDetailedDTO(sectorRepository.findOneByFinishedAtIsNullAndIdSector(id));
    }

    public void delete(Long id) {
        Sector sector = sectorRepository.findOneByFinishedAtIsNullAndIdSector(id);

        sector.disable();

        sectorRepository.save(sector);
    }

    public SectorDetailedDTO update(Long id, SectorUpdateDTO sectorUpdateDTO) {
        Sector sector = sectorRepository.findOneByFinishedAtIsNullAndIdSector(id);

        sector.updateInformation(sectorUpdateDTO);

        sectorRepository.save(sector);

        return new SectorDetailedDTO(sector);
    }

    public Sector find(Long id) {
        return sectorRepository.findOneByFinishedAtIsNullAndIdSector(id);
    }
}
