package com.med_api.InventarioMedfix.mapper;

import com.med_api.InventarioMedfix.dto.EquipamentoDTO;
import com.med_api.InventarioMedfix.dto.FornecedorDTO;
import com.med_api.InventarioMedfix.models.Equipamento;
import com.med_api.InventarioMedfix.models.Fornecedor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EquipamentoMapper {
    EquipamentoMapper INSTANCE = Mappers.getMapper(EquipamentoMapper.class);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    EquipamentoDTO equipamentoToDTO(Equipamento equipamento);


    Equipamento DTOtoEquipamento(EquipamentoDTO equipamentoDTO);
}
