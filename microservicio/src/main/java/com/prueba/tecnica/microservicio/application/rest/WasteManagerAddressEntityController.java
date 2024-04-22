package com.prueba.tecnica.microservicio.application.rest;

import com.prueba.tecnica.microservicio.application.request.WasteManagerAddressEntityDto;
import com.prueba.tecnica.microservicio.application.request.WasteManagerEntityDto;
import com.prueba.tecnica.microservicio.application.response.ServicesResponse;
import com.prueba.tecnica.microservicio.domain.service.IWasteManagerAddressService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@Slf4j
public class WasteManagerAddressEntityController {
    @Autowired
    IWasteManagerAddressService addressService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<ServicesResponse> getAllAddress() {
        log.debug("invocando servicio para obtener listado de Address Entidades");
        ServicesResponse resultado = addressService.getAll();
        return new ResponseEntity(resultado, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ServicesResponse> getAddress(
            @PathVariable(name = "id") Long identificador) {
        log.debug("invocando servicio para obtener una Address Entidad");
        ServicesResponse findResponse = addressService.findById(identificador);
        return new ResponseEntity(findResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<ServicesResponse> postAddress(@RequestBody @Valid WasteManagerAddressEntityDto dto, BindingResult bindingResult) {
        log.debug("invocando servicio para almacenar Address Entidad");
        ServicesResponse stored = addressService.create(dto, bindingResult);
        return new ResponseEntity(stored, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<ServicesResponse> putAddress(@RequestBody @Valid WasteManagerAddressEntityDto dto, BindingResult bindingResult) {
        log.debug("invocando servicio para modificar una Address Address Entidad");
        ServicesResponse update = addressService.update(dto, bindingResult);
        return new ResponseEntity(update, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAddress(
            @PathVariable(name = "id") Long identificador) {
        log.debug("invocando servicio para eliminar una Address Address Entidad");
        ServicesResponse delete = addressService.deleteById(identificador);
        return new ResponseEntity(delete, HttpStatus.OK);
    }
}
