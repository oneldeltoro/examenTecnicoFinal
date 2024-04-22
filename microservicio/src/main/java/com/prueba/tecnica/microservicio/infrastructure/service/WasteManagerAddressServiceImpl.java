package com.prueba.tecnica.microservicio.infrastructure.service;

import com.prueba.tecnica.microservicio.application.request.WasteManagerAddressEntityDto;
import com.prueba.tecnica.microservicio.application.response.ServicesResponse;
import com.prueba.tecnica.microservicio.domain.models.WasteManagerAddressEntity;
import com.prueba.tecnica.microservicio.domain.service.IWasteManagerAddressService;
import com.prueba.tecnica.microservicio.infrastructure.mapper.WasteManagerAddressEntityMapper;
import com.prueba.tecnica.microservicio.infrastructure.repository.IWasteManagerAddressEntityRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
@Slf4j
public class WasteManagerAddressServiceImpl implements IWasteManagerAddressService {
    @Autowired
    IWasteManagerAddressEntityRepository repository;
    @Autowired
    WasteManagerAddressEntityMapper mapper;

    @Override
    @SneakyThrows
    public ServicesResponse create(WasteManagerAddressEntityDto dto, BindingResult bindingResult)  {
        var response = ServicesResponse.builder();

        if (bindingResult.hasErrors())
            response.estado(HttpStatus.BAD_REQUEST.value()).mensaje("error de validaciones de entidad").datos(bindingResult.getAllErrors());
        else {
            try {
                var entidad = repository.save(mapper.wasteManagerAddressEntityDtoTOWasteManagerAddressEntity(dto));
                var result = mapper.wasteManagerAddressEntityTOWasteManagerAddressEntityDto(entidad);
                response.estado(HttpStatus.OK.value()).mensaje("ok").datos(result);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("error en funcion create, debido a: {} ", e.getMessage());
                response.estado(HttpStatus.BAD_REQUEST.value()).mensaje(e.getMessage());
            }
        }
        return response.build();
    }

    @Override
    @SneakyThrows
    public ServicesResponse update(WasteManagerAddressEntityDto dto, BindingResult bindingResult) {
        var response = ServicesResponse.builder();
        if (bindingResult.hasErrors())
            response.estado(HttpStatus.BAD_REQUEST.value()).mensaje("error de validaciones de entidad").datos(bindingResult.getAllErrors());
        else {
            try {
                Optional<WasteManagerAddressEntity> resultado = repository.findById(dto.getId());
                response = resultado.map(e -> {
                    mapper.updateWasteManagerAddressEntityFromWasteManagerAddressEntityDto(dto, e);
                    repository.save(e);
                    var result = mapper.wasteManagerAddressEntityTOWasteManagerAddressEntityDto(e);
                    return ServicesResponse.builder().estado(HttpStatus.OK.value()).mensaje("ok").datos(result);
                }).orElseGet(() -> ServicesResponse.builder().estado(HttpStatus.NOT_FOUND.value()).mensaje("Not Found").datos(dto.getId()));
            } catch (Exception e) {
                log.error("error en funcion update, debido a: {} ", e.getMessage());
                response.estado(HttpStatus.BAD_REQUEST.value()).mensaje(e.getMessage());
            }
        }
        return response.build();
    }

    @Override
    @SneakyThrows
    public ServicesResponse findById(long wasteManagerAddressId)  {
        var response = ServicesResponse.builder();
        try {
            Optional<WasteManagerAddressEntity> resultado = repository.findById(wasteManagerAddressId);
            var value = resultado.map(e -> {
                var result = mapper.wasteManagerAddressEntityTOWasteManagerAddressEntityDto(e);
                return response.estado(HttpStatus.OK.value()).mensaje("ok").datos(result);
            }).orElseGet(() -> response.estado(HttpStatus.NOT_FOUND.value()).mensaje("Not Found").datos(wasteManagerAddressId));

            response.estado(HttpStatus.OK.value()).mensaje("ok").datos(value.build());
        } catch (Exception e) {
            log.error("error en funcion findById, debido a: {} ", e.getMessage());
            response.estado(HttpStatus.BAD_REQUEST.value()).mensaje(e.getMessage());
        }

        return response.build();
    }

    @Override
    @SneakyThrows
    public ServicesResponse deleteById(long wasteManagerAddressId) {
        var response = ServicesResponse.builder();
        try {
            Optional<WasteManagerAddressEntity> resultado = repository.findById(wasteManagerAddressId);
            var value = resultado.map(e -> {
                repository.delete(e);
                return response.estado(HttpStatus.OK.value()).mensaje("ok").datos(Boolean.TRUE);
            }).orElseGet(() -> response.estado(HttpStatus.NOT_FOUND.value()).mensaje("Not Found").datos(wasteManagerAddressId));

            response.estado(HttpStatus.OK.value()).mensaje("ok").datos(value.build());
        } catch (Exception e) {
            log.error("error en funcion deleteById, debido a: {} ", e.getMessage());
            response.estado(HttpStatus.BAD_REQUEST.value()).mensaje(e.getMessage());
        }

        return response.build();
    }

    @Override
    @SneakyThrows
    public ServicesResponse getAll() {
        var response = ServicesResponse.builder();
        try {
            var resultado = repository.findAll();
            response.estado(HttpStatus.OK.value()).mensaje("ok").datos(resultado);
        } catch (Exception e) {
            log.error("error en funcion getAll, debido a: {} ", e.getMessage());
            response.estado(HttpStatus.BAD_REQUEST.value()).mensaje(e.getMessage());
        }

        return response.build();
    }
}
