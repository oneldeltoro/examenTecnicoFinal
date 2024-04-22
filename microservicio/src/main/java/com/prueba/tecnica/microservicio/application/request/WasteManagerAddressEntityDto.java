package com.prueba.tecnica.microservicio.application.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WasteManagerAddressEntityDto implements Serializable {
    private Long id;
    @NotBlank(message = "la direccion es obligatoria")
    private String direccion;
    private Boolean isEnabled = Boolean.TRUE;


}
