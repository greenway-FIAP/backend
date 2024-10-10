package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.BadgeLevel;
import com.api.greenway.repositories.BadgeLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BadgeLevelService {

    private final BadgeLevelRepository badgeLevelRepository;

    @Autowired
    public BadgeLevelService(BadgeLevelRepository badgeLevelRepository) {
        this.badgeLevelRepository = badgeLevelRepository;
    }
    public BadgeLevel find(Long id) {
        return badgeLevelRepository.findOneByFinishedAtIsNullAndIdBadgeLevel(id);
    }

    public BadgeLevel create(BadgeLevelRegisterDTO badgeLevelRegisterDTO) {
        return badgeLevelRepository.save(new BadgeLevel(badgeLevelRegisterDTO));
    }

    public Page<BadgeLevelDetailedDTO> list(Pageable pagination) {
        return badgeLevelRepository.findByFinishedAtIsNull(pagination).map(BadgeLevelDetailedDTO::new);
    }

    public BadgeLevelDetailedDTO get(Long id) {
        return new BadgeLevelDetailedDTO(badgeLevelRepository.findOneByFinishedAtIsNullAndIdBadgeLevel(id));
    }

    public void delete(Long id) {
        BadgeLevel badgeLevel = badgeLevelRepository.findOneByFinishedAtIsNullAndIdBadgeLevel(id);

        badgeLevel.disable();

        badgeLevelRepository.save(badgeLevel);
    }

    public BadgeLevelDetailedDTO update(Long id, BadgeLevelUpdateDTO badgeLevelUpdateDTO) {
        BadgeLevel badgeLevel = badgeLevelRepository.findOneByFinishedAtIsNullAndIdBadgeLevel(id);

        badgeLevel.updateInformation(badgeLevelUpdateDTO);

        badgeLevelRepository.save(badgeLevel);

        return new BadgeLevelDetailedDTO(badgeLevel);
    }
}