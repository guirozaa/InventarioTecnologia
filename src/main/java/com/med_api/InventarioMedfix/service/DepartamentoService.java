package com.med_api.InventarioMedfix.service;

import com.med_api.InventarioMedfix.dto.DepartamentoDTO;
import com.med_api.InventarioMedfix.models.Departamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface DepartamentoService {
    Page<Departamento>findAll(Specification<Departamento> spec, Pageable page);

    DepartamentoDTO save(DepartamentoDTO departamentoDTO) ;

    Optional<DepartamentoDTO> findById(UUID id);

    Optional<DepartamentoDTO> update(UUID id,DepartamentoDTO departamentoDTO);

    boolean deleteById(UUID id);
}
