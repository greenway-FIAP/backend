package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.ImprovementMeasurement;
import com.api.greenway.models.Measurement;
import com.api.greenway.models.SustainableImprovementActions;
import com.api.greenway.repositories.ImprovementMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ImprovementMeasurementService {

    private final ImprovementMeasurementRepository improvementMeasurementRepository;

    private final SustainableImprovementActionsService sustainableImprovementActionsService;

    private final MeasurementService measurementService;

    @Autowired
    public ImprovementMeasurementService(ImprovementMeasurementRepository improvementMeasurementRepository,
                                         SustainableImprovementActionsService sustainableImprovementActionsService, MeasurementService measurementService) {
        this.improvementMeasurementRepository = improvementMeasurementRepository;
        this.sustainableImprovementActionsService = sustainableImprovementActionsService;
        this.measurementService = measurementService;
    }

    public ImprovementMeasurement find(Long id) {
        return improvementMeasurementRepository.findOneByFinishedAtIsNullAndIdImprovementMeasurement(id);
    }

    public ImprovementMeasurement create(ImprovementMeasurementRegisterDTO improvementMeasurementRegisterDTO) {
        ImprovementMeasurement improvementMeasurement = new ImprovementMeasurement(improvementMeasurementRegisterDTO);

        SustainableImprovementActions sustainableImprovementActions = sustainableImprovementActionsService.find(improvementMeasurementRegisterDTO.idSustainableImprovementActions());
        Measurement measurement = measurementService.find(improvementMeasurementRegisterDTO.idMeasurement());

        improvementMeasurement.setSustainableImprovementActions(sustainableImprovementActions);
        improvementMeasurement.setMeasurement(measurement);

        return improvementMeasurementRepository.save(improvementMeasurement);
    }

    public Page<ImprovementMeasurementDetailedDTO> list(Pageable pagination) {
        return improvementMeasurementRepository.findByFinishedAtIsNull(pagination).map(ImprovementMeasurementDetailedDTO::new);
    }

    public ImprovementMeasurementDetailedDTO get(Long id) {
        return new ImprovementMeasurementDetailedDTO(improvementMeasurementRepository.findOneByFinishedAtIsNullAndIdImprovementMeasurement(id));
    }

    public void delete(Long id) {
        ImprovementMeasurement improvementMeasurement = improvementMeasurementRepository.findOneByFinishedAtIsNullAndIdImprovementMeasurement(id);

        improvementMeasurement.disable();

        improvementMeasurementRepository.save(improvementMeasurement);
    }

    public ImprovementMeasurementDetailedDTO update(Long id, ImprovementMeasurementUpdateDTO improvementMeasurementUpdateDTO) {
        ImprovementMeasurement improvementMeasurement = improvementMeasurementRepository.findOneByFinishedAtIsNullAndIdImprovementMeasurement(id);

        improvementMeasurement.updateInformation(improvementMeasurementUpdateDTO);

        improvementMeasurementRepository.save(improvementMeasurement);

        return new ImprovementMeasurementDetailedDTO(improvementMeasurement);
    }

}
