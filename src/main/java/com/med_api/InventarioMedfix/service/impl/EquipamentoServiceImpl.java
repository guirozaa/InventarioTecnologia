package com.med_api.InventarioMedfix.service.impl;

import com.med_api.InventarioMedfix.dto.EquipamentoDTO;
import com.med_api.InventarioMedfix.mapper.EquipamentoMapper;
import com.med_api.InventarioMedfix.models.Equipamento;
import com.med_api.InventarioMedfix.repository.EquipamentoRepository;
import com.med_api.InventarioMedfix.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EquipamentoServiceImpl implements EquipamentoService{
    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Override
    public Page<Equipamento> findAll(Specification<Equipamento> spec, Pageable page) {
        return equipamentoRepository.findAll(spec, page);
    }

    @Override
    public EquipamentoDTO save(EquipamentoDTO equipamentoDTO){
        Equipamento equipamento = EquipamentoMapper.INSTANCE.DTOtoEquipamento(equipamentoDTO);
        equipamento = equipamentoRepository.save(equipamento);
        return EquipamentoMapper.INSTANCE.equipamentoToDTO(equipamento);
    }

    @Override
    public Optional<EquipamentoDTO> findById(UUID id) {
        return equipamentoRepository.findById(id).map(EquipamentoMapper.INSTANCE::equipamentoToDTO);
    }

    @Override
    public Optional<EquipamentoDTO> update(UUID id, EquipamentoDTO equipamentoDTO) {
        if (equipamentoRepository.existsById(id)) {
            Equipamento equipamento = EquipamentoMapper.INSTANCE.DTOtoEquipamento(equipamentoDTO);
            equipamento.setId(id);
            equipamentoRepository.save(equipamento);

            return Optional.of(EquipamentoMapper.INSTANCE.equipamentoToDTO(equipamento));
        } else {
            System.out.println("Id não cadastrado");
        }
        return Optional.empty();
    }
    @Override
    public boolean deleteById(UUID id) {
        if (equipamentoRepository.existsById(id)){
            equipamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
