package com.prueba.tecnica.microservicio.infrastructure.mapper;

import com.prueba.tecnica.microservicio.application.request.WasteManagerAddressEntityDto;
import com.prueba.tecnica.microservicio.domain.models.WasteCenterAuthorizationEntity;
import com.prueba.tecnica.microservicio.application.request.WasteCenterAuthorizationEntityDto;
import com.prueba.tecnica.microservicio.domain.models.WasteManagerAddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface WasteCenterAuthorizationEntityMapper {
    WasteCenterAuthorizationEntity wasteCenterAuthorizationEntityDtoTOWasteCenterAuthorizationEntity(WasteCenterAuthorizationEntityDto entityDto);

    WasteCenterAuthorizationEntityDto WasteCenterAuthorizationEntityTOWasteCenterAuthorizationEntityDto(WasteCenterAuthorizationEntity entity);

    @Mapping(target = "id", ignore = true)
    void updateWasteCenterAuthorizationEntityFromWasteCenterAuthorizationEntityDto(WasteCenterAuthorizationEntityDto dto, @MappingTarget WasteCenterAuthorizationEntity entity);
}
