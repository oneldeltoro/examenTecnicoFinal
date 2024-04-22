package com.prueba.tecnica.microservicio.infrastructure.mapper;

import com.prueba.tecnica.microservicio.application.request.WasteCenterAuthorizationEntityDto;
import com.prueba.tecnica.microservicio.application.request.WasteManagerAddressEntityDto;
import com.prueba.tecnica.microservicio.domain.models.WasteCenterAuthorizationEntity;
import com.prueba.tecnica.microservicio.domain.models.WasteManagerAddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface WasteManagerAddressEntityMapper {
    WasteManagerAddressEntity wasteManagerAddressEntityDtoTOWasteManagerAddressEntity(WasteManagerAddressEntityDto entityDto);

    WasteManagerAddressEntityDto wasteManagerAddressEntityTOWasteManagerAddressEntityDto(WasteManagerAddressEntity entity);

    @Mapping(target = "id", ignore = true)
    void updateWasteManagerAddressEntityFromWasteManagerAddressEntityDto(WasteManagerAddressEntityDto dto, @MappingTarget WasteManagerAddressEntity entity);

}
