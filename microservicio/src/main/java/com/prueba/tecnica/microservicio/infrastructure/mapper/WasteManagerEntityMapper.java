package com.prueba.tecnica.microservicio.infrastructure.mapper;

import com.prueba.tecnica.microservicio.application.request.WasteManagerAddressEntityDto;
import com.prueba.tecnica.microservicio.application.request.WasteManagerEntityDto;
import com.prueba.tecnica.microservicio.domain.models.WasteManagerAddressEntity;
import com.prueba.tecnica.microservicio.domain.models.WasteManagerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = WasteCenterAuthorizationEntityMapper.class)
public interface WasteManagerEntityMapper {
    @Mapping(target = "wasteManagerAddressEntity", ignore = true)
    WasteManagerEntity wasteManagerEntityDtoTOWasteManagerEntity(WasteManagerEntityDto entityDto);

    WasteManagerEntityDto wasteManagerEntityTOWasteManagerEntityDto(WasteManagerEntity entity);

    @Mapping(target = "id", ignore = true)
    void updateWasteManagerEntityFromWasteManagerEntityDto(WasteManagerEntityDto dto, @MappingTarget WasteManagerEntity entity);
}
