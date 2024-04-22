package com.prueba.tecnica.microservicio.domain.service;

import com.prueba.tecnica.microservicio.application.request.WasteManagerAddressEntityDto;
import com.prueba.tecnica.microservicio.application.response.ServicesResponse;
import org.springframework.validation.BindingResult;

public interface IWasteManagerAddressService {
    ServicesResponse create (WasteManagerAddressEntityDto wasteManagerDto,
                             BindingResult bindingResult );
    ServicesResponse update( WasteManagerAddressEntityDto dto,
                           BindingResult bindingResult ) ;
    ServicesResponse findById(long wasteManagerAddressId) ;
    ServicesResponse deleteById(long wasteManagerAddressId) ;
    ServicesResponse getAll() ;
}
