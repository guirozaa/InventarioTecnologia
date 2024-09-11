package com.med_api.InventarioMedfix.service.impl;

import com.med_api.InventarioMedfix.dto.DepartamentoDTO;
import com.med_api.InventarioMedfix.mapper.DepartamentoMapper;
import com.med_api.InventarioMedfix.models.Departamento;
import com.med_api.InventarioMedfix.repository.DepartamentoRepository;
import com.med_api.InventarioMedfix.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public Page<Departamento> findAll(Specification<Departamento> spec, Pageable page) {
        return departamentoRepository.findAll(spec, page);
    }

    @Override
    public DepartamentoDTO save(DepartamentoDTO departamentoDTO){
        Departamento departamento = DepartamentoMapper.INSTANCE.DTOtoDepartamento(departamentoDTO);
        departamento = departamentoRepository.save(departamento);
        return DepartamentoMapper.INSTANCE.departamentoToDTO(departamento);
    }

    @Override
    public Optional<DepartamentoDTO> findById(UUID id) {
        return departamentoRepository.findById(id).map(DepartamentoMapper.INSTANCE::departamentoToDTO);
    }

    @Override
    public Optional<DepartamentoDTO> update(UUID id, DepartamentoDTO departamentoDTO) {
        if (departamentoRepository.existsById(id)) {
            Departamento departamento = DepartamentoMapper.INSTANCE.DTOtoDepartamento(departamentoDTO);
            departamento.setId(id);
            departamentoRepository.save(departamento);

            return Optional.of(DepartamentoMapper.INSTANCE.departamentoToDTO(departamento));
        } else {
            System.out.println("Id não cadastrado");
        }
        return Optional.empty();
    }


    @Override
    public boolean deleteById(UUID id) {
        if (departamentoRepository.existsById(id)){
            departamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}




