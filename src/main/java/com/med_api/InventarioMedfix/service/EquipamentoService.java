package com.med_api.InventarioMedfix.service;

import com.med_api.InventarioMedfix.dto.DepartamentoDTO;
import com.med_api.InventarioMedfix.dto.EquipamentoDTO;
import com.med_api.InventarioMedfix.models.Departamento;
import com.med_api.InventarioMedfix.models.Equipamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface EquipamentoService {
    Page<Equipamento> findAll(Specification<Equipamento> spec, Pageable page);

    EquipamentoDTO save(EquipamentoDTO equipamentoDTO) ;

    Optional<EquipamentoDTO> findById(UUID id);

    Optional<EquipamentoDTO> update(UUID id,EquipamentoDTO equipamentoDTO);

    boolean deleteById(UUID id);
}
