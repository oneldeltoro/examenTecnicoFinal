package com.prueba.tecnica.microservicio.infrastructure.repository;

import com.prueba.tecnica.microservicio.domain.models.WasteManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWasteManagerEntityRepository extends JpaRepository<WasteManagerEntity, Long> {
}
