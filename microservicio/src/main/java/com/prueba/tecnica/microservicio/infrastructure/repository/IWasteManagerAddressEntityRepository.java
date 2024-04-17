package com.prueba.tecnica.microservicio.infrastructure.repository;

import com.prueba.tecnica.microservicio.domain.models.WasteManagerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWasteManagerAddressEntityRepository extends JpaRepository<WasteManagerAddressEntity, Long> {
}
