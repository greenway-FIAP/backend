package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.MeasurementType;
import com.api.greenway.repositories.MeasurementTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MeasurementTypeService {

    private final MeasurementTypeRepository measurementTypeRepository;

    @Autowired
    public MeasurementTypeService(MeasurementTypeRepository measurementTypeRepository) {
        this.measurementTypeRepository = measurementTypeRepository;
    }

    public MeasurementType create(MeasurementTypeRegisterDTO measurementTypeRegisterDTO) {
        return measurementTypeRepository.save(new MeasurementType(measurementTypeRegisterDTO));
    }

    public Page<MeasurementTypeDetailedDTO> list(Pageable pagination) {
        return measurementTypeRepository.findByFinishedAtIsNull(pagination).map(MeasurementTypeDetailedDTO::new);
    }

    public MeasurementTypeDetailedDTO get(Long id) {
        return new MeasurementTypeDetailedDTO(measurementTypeRepository.findOneByFinishedAtIsNullAndIdMeasurementType(id));
    }

    public void delete(Long id) {
        MeasurementType measurementType = measurementTypeRepository.findOneByFinishedAtIsNullAndIdMeasurementType(id);

        measurementType.disable();

        measurementTypeRepository.save(measurementType);
    }

    public MeasurementTypeDetailedDTO update(Long id, MeasurementTypeUpdateDTO measurementTypeUpdateDTO) {
        MeasurementType measurementType = measurementTypeRepository.findOneByFinishedAtIsNullAndIdMeasurementType(id);

        measurementType.updateInformation(measurementTypeUpdateDTO);

        measurementTypeRepository.save(measurementType);

        return new MeasurementTypeDetailedDTO(measurementType);
    }

    public MeasurementType find(Long id) {
        return measurementTypeRepository.findOneByFinishedAtIsNullAndIdMeasurementType(id);
    }

}
