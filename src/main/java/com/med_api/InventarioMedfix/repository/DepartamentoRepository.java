package com.med_api.InventarioMedfix.repository;

import com.med_api.InventarioMedfix.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, UUID>, JpaSpecificationExecutor<Departamento> {
}
