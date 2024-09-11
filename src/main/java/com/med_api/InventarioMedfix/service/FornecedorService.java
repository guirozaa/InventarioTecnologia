package com.med_api.InventarioMedfix.service;

import com.med_api.InventarioMedfix.dto.FornecedorDTO;
import com.med_api.InventarioMedfix.models.Fornecedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface FornecedorService {
    Page<Fornecedor> findAll(Specification<Fornecedor> spec, Pageable page);

    FornecedorDTO save(FornecedorDTO fornecedorDTO) ;

    Optional<FornecedorDTO> findById(UUID id);

    Optional<FornecedorDTO> update(UUID id,FornecedorDTO fornecedorDTO);

    boolean deleteById(UUID id);
}
