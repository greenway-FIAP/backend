package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.*;
import com.api.greenway.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final MeasurementTypeService measurementTypeService;
    private final SustainableGoalService sustainableGoalService;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, MeasurementTypeService measurementTypeService,SustainableGoalService sustainableGoalService) {
        this.measurementRepository = measurementRepository;
        this.measurementTypeService = measurementTypeService;
        this.sustainableGoalService = sustainableGoalService;
    }

    public Measurement find(Long id) {
        return measurementRepository.findOneByFinishedAtIsNullAndIdMeasurement(id);
    }

    public Measurement create(MeasurementRegisterDTO measurementRegisterDTO) {
        Measurement measurement = new Measurement(measurementRegisterDTO);

        MeasurementType measurementType = measurementTypeService.find(measurementRegisterDTO.idMeasurementType());
        SustainableGoal sustainableGoal = sustainableGoalService.find(measurementRegisterDTO.idSustainableGoal());

        measurement.setMeasurementType(measurementType);
        measurement.setSustainableGoal(sustainableGoal);

        return measurementRepository.save(measurement);
    }

    public Page<MeasurementDetailedDTO> list(Pageable pagination) {
        return measurementRepository.findByFinishedAtIsNull(pagination).map(MeasurementDetailedDTO::new);
    }

    public MeasurementDetailedDTO get(Long id) {
        return new MeasurementDetailedDTO(measurementRepository.findOneByFinishedAtIsNullAndIdMeasurement(id));
    }

    public void delete(Long id) {
        Measurement measurement = measurementRepository.findOneByFinishedAtIsNullAndIdMeasurement(id);

        measurement.disable();

        measurementRepository.save(measurement);
    }

    public MeasurementDetailedDTO update(Long id, MeasurementUpdateDTO measurementUpdateDTO) {
        Measurement measurement = measurementRepository.findOneByFinishedAtIsNullAndIdMeasurement(id);

        measurement.updateInformation(measurementUpdateDTO);

        measurementRepository.save(measurement);

        return new MeasurementDetailedDTO(measurement);
    }

}
