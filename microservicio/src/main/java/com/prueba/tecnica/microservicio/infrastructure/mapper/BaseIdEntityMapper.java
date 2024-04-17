package com.prueba.tecnica.microservicio.infrastructure.mapper;

import com.prueba.tecnica.microservicio.application.response.BaseEntityResponse;
import com.prueba.tecnica.microservicio.domain.models.base.BaseIdEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BaseIdEntityMapper {
    BaseEntityResponse baseIdEntityTOBaseEntityResponse(BaseIdEntity entity);

}
