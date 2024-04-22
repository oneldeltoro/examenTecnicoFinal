package com.prueba.tecnica.microservicio.application.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class WasteManagerBaseController {
    @RequestMapping(value = "/heartbeat", method = RequestMethod.GET)
  //  @ApiOperation(value = "Obtener estado de salud", notes = "Retorna un mensaje para comprobar el estado de salud del microservicio")
    public ResponseEntity<String> heartbeat() {
        return ResponseEntity.ok("Hello WasteManagerBaseController");
    }
}
