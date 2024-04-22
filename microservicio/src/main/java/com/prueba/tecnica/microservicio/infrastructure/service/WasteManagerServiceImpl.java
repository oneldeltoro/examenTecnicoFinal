package com.prueba.tecnica.microservicio.infrastructure.service;

import com.prueba.tecnica.microservicio.application.request.WasteManagerEntityDto;
import com.prueba.tecnica.microservicio.application.response.ServicesResponse;
import com.prueba.tecnica.microservicio.domain.models.WasteManagerEntity;
import com.prueba.tecnica.microservicio.domain.service.IWasteManagerService;
import com.prueba.tecnica.microservicio.infrastructure.mapper.WasteManagerAddressEntityMapper;
import com.prueba.tecnica.microservicio.infrastructure.mapper.WasteManagerEntityMapper;
import com.prueba.tecnica.microservicio.infrastructure.repository.IWasteManagerAddressEntityRepository;
import com.prueba.tecnica.microservicio.infrastructure.repository.IWasteManagerEntityRepository;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
@Slf4j
public class WasteManagerServiceImpl implements IWasteManagerService {
    @Autowired
    IWasteManagerEntityRepository repository;
    @Autowired
    IWasteManagerAddressEntityRepository addressRepository;
    @Autowired
    WasteManagerEntityMapper mapper;
    @Autowired
    WasteManagerAddressEntityMapper addressMapper;

    @Override
    @SneakyThrows
    @Transactional
    public ServicesResponse create(WasteManagerEntityDto dto, BindingResult bindingResult) {
        var response = ServicesResponse.builder();

        if (bindingResult.hasErrors())
            response.estado(HttpStatus.BAD_REQUEST.value()).mensaje("error de validaciones de entidad").datos(bindingResult.getAllErrors());
        else {
            try {
                var addressDO = addressRepository.save(addressMapper.wasteManagerAddressEntityDtoTOWasteManagerAddressEntity(dto.getWasteManagerAddressEntity()));
                var entidad = mapper.wasteManagerEntityDtoTOWasteManagerEntity(dto);
                entidad.setIdAddress(addressDO.getId());
                repository.save(entidad);
                var result = mapper.wasteManagerEntityTOWasteManagerEntityDto(entidad);
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
    public ServicesResponse update(WasteManagerEntityDto dto, BindingResult bindingResult) {
        var response = ServicesResponse.builder();
        if (bindingResult.hasErrors())
            response.estado(HttpStatus.BAD_REQUEST.value()).mensaje("error de validaciones de entidad").datos(bindingResult.getAllErrors());
        else {
            try {
                Optional<WasteManagerEntity> resultado = repository.findById(dto.getId());
                response = resultado.map(e -> {
                    mapper.updateWasteManagerEntityFromWasteManagerEntityDto(dto, e);
                    repository.save(e);
                    var result = mapper.wasteManagerEntityTOWasteManagerEntityDto(e);
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
    public ServicesResponse findById(long wasteManagerId) {
        var response = ServicesResponse.builder();
        try {
            Optional<WasteManagerEntity> resultado = repository.findById(wasteManagerId);
            var value = resultado.map(e -> {
                var result = mapper.wasteManagerEntityTOWasteManagerEntityDto(e);
                return response.estado(HttpStatus.OK.value()).mensaje("ok").datos(result);
            }).orElseGet(() -> response.estado(HttpStatus.NOT_FOUND.value()).mensaje("Not Found").datos(wasteManagerId));

            response.estado(HttpStatus.OK.value()).mensaje("ok").datos(value.build());
        } catch (Exception e) {
            log.error("error en funcion findById, debido a: {} ", e.getMessage());
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

    @Override
    @SneakyThrows
    public ServicesResponse deleteById(long wasteManagerId) {
        var response = ServicesResponse.builder();
        try {
            Optional<WasteManagerEntity> resultado = repository.findById(wasteManagerId);
            var value = resultado.map(e -> {
                repository.delete(e);
                return response.estado(HttpStatus.OK.value()).mensaje("ok").datos(Boolean.TRUE);
            }).orElseGet(() -> response.estado(HttpStatus.NOT_FOUND.value()).mensaje("Not Found").datos(wasteManagerId));

            response.estado(HttpStatus.OK.value()).mensaje("ok").datos(value.build());
        } catch (Exception e) {
            log.error("error en funcion deleteById, debido a: {} ", e.getMessage());
            response.estado(HttpStatus.BAD_REQUEST.value()).mensaje(e.getMessage());
        }

        return response.build();
    }
}
