package com.api.greenway.services;

import com.api.greenway.controllers.dtos.BadgeDetailedDTO;
import com.api.greenway.controllers.dtos.BadgeRegisterDTO;
import com.api.greenway.controllers.dtos.BadgeUpdateDTO;
import com.api.greenway.models.*;
import com.api.greenway.repositories.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BadgeService {

    private final BadgeRepository badgeRepository;

    private final SustainableGoalService sustainableGoalService;

    private final BadgeLevelService badgeLevelService;

    @Autowired
    public BadgeService(BadgeRepository badgeRepository, SustainableGoalService sustainableGoalService, BadgeLevelService badgeLevelService) {
        this.badgeRepository = badgeRepository;
        this.sustainableGoalService = sustainableGoalService;
        this.badgeLevelService = badgeLevelService;
    }

    public Badge find(Long id) {
        return badgeRepository.findOneByFinishedAtIsNullAndIdBadge(id);
    }

    public Badge create(BadgeRegisterDTO badgeRegisterDTO) {

        Badge badge = new Badge(badgeRegisterDTO);

        SustainableGoal sustainableGoal = sustainableGoalService.find(badgeRegisterDTO.idSustainableGoal());
        BadgeLevel badgeLevel = badgeLevelService.find(badgeRegisterDTO.idBadgeLevel());

        badge.setSustainableGoal(sustainableGoal);
        badge.setBadgeLevel(badgeLevel);

        return badgeRepository.save(badge);
    }

    public Page<BadgeDetailedDTO> list(Pageable pagination) {
        return badgeRepository.findByFinishedAtIsNull(pagination).map(BadgeDetailedDTO::new);
    }

    public BadgeDetailedDTO get(Long id) {
        return new BadgeDetailedDTO(badgeRepository.findOneByFinishedAtIsNullAndIdBadge(id));
    }

    public void delete(Long id) {
        Badge badge = badgeRepository.findOneByFinishedAtIsNullAndIdBadge(id);

        badge.disable();

        badgeRepository.save(badge);
    }

    public BadgeDetailedDTO update(Long id, BadgeUpdateDTO badgeUpdateDTO) {
        Badge badge = badgeRepository.findOneByFinishedAtIsNullAndIdBadge(id);

        badge.updateInformation(badgeUpdateDTO);

        badgeRepository.save(badge);

        return new BadgeDetailedDTO(badge);
    }

}
