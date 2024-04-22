package com.prueba.tecnica.microservicio.domain.models;

import com.prueba.tecnica.microservicio.domain.models.base.BaseIdEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.io.Serializable;
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "WASTE_MANAGER_ADDRESS_ENTITY")
public class WasteManagerAddressEntity extends BaseIdEntity implements Serializable {
    @Column(name = "direccion", nullable = false)
    private String direccion;
    private Boolean isEnabled = Boolean.TRUE;
    @Version
    private Long version = 0L;

}
