package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.*;
import com.api.greenway.repositories.ImprovementMeasurementRepository;
import com.api.greenway.repositories.MeasurementProcessStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MeasurementProcessStepService {

    private final MeasurementProcessStepRepository measurementProcessStepRepository;

    private final ProcessStepService processStepService;

    private final MeasurementService measurementService;

    @Autowired
    public MeasurementProcessStepService(MeasurementProcessStepRepository measurementProcessStepRepository,
                                         ProcessStepService processStepService, MeasurementService measurementService) {
        this.measurementProcessStepRepository = measurementProcessStepRepository;
        this.processStepService = processStepService;
        this.measurementService = measurementService;
    }

    public MeasurementProcessStep find(Long id) {
        return measurementProcessStepRepository.findOneByFinishedAtIsNullAndIdMeasurementProcessStep(id);
    }

    public MeasurementProcessStep create(MeasurementProcessStepRegisterDTO measurementProcessStepRegisterDTO) {
        MeasurementProcessStep measurementProcessStep = new MeasurementProcessStep(measurementProcessStepRegisterDTO);

        ProcessStep processStep = processStepService.find(measurementProcessStepRegisterDTO.idProcessStep());
        Measurement measurement = measurementService.find(measurementProcessStepRegisterDTO.idMeasurement());

        measurementProcessStep.setProcessStep(processStep);
        measurementProcessStep.setMeasurement(measurement);

        return measurementProcessStepRepository.save(measurementProcessStep);
    }

    public Page<MeasurementProcessStepDetailedDTO> list(Pageable pagination) {
        return measurementProcessStepRepository.findByFinishedAtIsNull(pagination).map(MeasurementProcessStepDetailedDTO::new);
    }

    public MeasurementProcessStepDetailedDTO get(Long id) {
        return new MeasurementProcessStepDetailedDTO(measurementProcessStepRepository.findOneByFinishedAtIsNullAndIdMeasurementProcessStep(id));
    }

    public void delete(Long id) {
        MeasurementProcessStep measurementProcessStep = measurementProcessStepRepository.findOneByFinishedAtIsNullAndIdMeasurementProcessStep(id);

        measurementProcessStep.disable();

        measurementProcessStepRepository.save(measurementProcessStep);
    }

    public MeasurementProcessStepDetailedDTO update(Long id, MeasurementProcessStepUpdateDTO measurementProcessStepUpdateDTO) {
        MeasurementProcessStep measurementProcessStep = measurementProcessStepRepository.findOneByFinishedAtIsNullAndIdMeasurementProcessStep(id);

        measurementProcessStep.updateInformation(measurementProcessStepUpdateDTO);

        measurementProcessStepRepository.save(measurementProcessStep);

        return new MeasurementProcessStepDetailedDTO(measurementProcessStep);
    }

}
