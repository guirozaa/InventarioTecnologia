package com.med_api.InventarioMedfix.service.impl;

import com.med_api.InventarioMedfix.dto.FornecedorDTO;
import com.med_api.InventarioMedfix.mapper.FornecedorMapper;
import com.med_api.InventarioMedfix.models.Fornecedor;
import com.med_api.InventarioMedfix.repository.FornecedorRepository;
import com.med_api.InventarioMedfix.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FornecedorServiceImpl implements FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    public Page<Fornecedor> findAll(Specification<Fornecedor> spec, Pageable page) {
        return fornecedorRepository.findAll(spec, page);
    }

    @Override
    public FornecedorDTO save(FornecedorDTO fornecedorDTO){
        Fornecedor fornecedor = FornecedorMapper.INSTANCE.DTOtoFornecedor(fornecedorDTO);
        fornecedor = fornecedorRepository.save(fornecedor);
        return FornecedorMapper.INSTANCE.fornecedorToDTO(fornecedor);
    }

    @Override
    public Optional<FornecedorDTO> findById(UUID id) {
        return fornecedorRepository.findById(id).map(FornecedorMapper.INSTANCE::fornecedorToDTO);
    }

    @Override
    public Optional<FornecedorDTO> update(UUID id, FornecedorDTO fornecedorDTO) {
        if (fornecedorRepository.existsById(id)) {
            Fornecedor fornecedor = FornecedorMapper.INSTANCE.DTOtoFornecedor(fornecedorDTO);
            fornecedor.setId(id);
            fornecedorRepository.save(fornecedor);

            return Optional.of(FornecedorMapper.INSTANCE.fornecedorToDTO(fornecedor));
        } else {
            System.out.println("Id não cadastrado");
        }
        return Optional.empty();
    }
    @Override
    public boolean deleteById(UUID id) {
        if (fornecedorRepository.existsById(id)){
            fornecedorRepository.deleteById(id);
            return true;
        }
        return false;
    }

}

