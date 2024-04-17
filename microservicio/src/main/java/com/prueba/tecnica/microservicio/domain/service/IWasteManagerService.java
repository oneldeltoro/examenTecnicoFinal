package com.prueba.tecnica.microservicio.domain.service;

import com.prueba.tecnica.microservicio.application.request.WasteManagerEntityDto;
import com.prueba.tecnica.microservicio.application.response.ServicesResponse;
import org.springframework.validation.BindingResult;

public interface IWasteManagerService {
    ServicesResponse create (WasteManagerEntityDto wasteManagerDto,
                             BindingResult bindingResult );
    ServicesResponse update( WasteManagerEntityDto dto,
                           BindingResult bindingResult ) ;
    ServicesResponse findById(long wasteManagerId) ;
    ServicesResponse getAll();
    ServicesResponse deleteById(long wasteManagerId) ;
}
