package com.med_api.InventarioMedfix.mapper;


import com.med_api.InventarioMedfix.dto.FornecedorDTO;
import com.med_api.InventarioMedfix.models.Fornecedor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FornecedorMapper {
    FornecedorMapper INSTANCE = Mappers.getMapper(FornecedorMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    FornecedorDTO fornecedorToDTO(Fornecedor fornecedor);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    Fornecedor DTOtoFornecedor(FornecedorDTO fornecedorDTO);
}
