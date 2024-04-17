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
@Table(name = "WASTE_CENTER_AUTHORIZATION_ENTITY")
public class WasteCenterAuthorizationEntity extends BaseIdEntity implements Serializable {

    @Column(name = "AUTH_NUMBER")
    private String authorizationNumber;
    @ManyToOne()
    @JoinColumn(name = "WASTE_MANAGER_ENTITY_ID")
    private WasteManagerEntity entity;



}
