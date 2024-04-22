package com.prueba.tecnica.microservicio.domain.models;

import com.prueba.tecnica.microservicio.domain.models.base.BaseIdEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "WASTE_MANAGER_ENTITY")
public class WasteManagerEntity extends BaseIdEntity implements Serializable {

    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "nif", nullable = false)
    private String nif;

    @Column(name = "address_entity_id", nullable = false)
    private Long idAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_entity_id", updatable = false, insertable = false)
    private WasteManagerAddressEntity wasteManagerAddressEntity;


    @OneToMany(mappedBy = "entity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WasteCenterAuthorizationEntity> listOfWasteCenterAuthorization = new ArrayList<>();
    private Boolean isEnabled = Boolean.TRUE;
    @Version
    private Long version = 0L;

}
