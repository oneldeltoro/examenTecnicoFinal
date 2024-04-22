package com.prueba.tecnica.microservicio.application.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ApiOperation(value = "Tarea Modelo DTO")
public class ServicesResponse  implements Serializable {
    private int estado;

    private String mensaje;

    private Object datos;
}
