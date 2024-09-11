package com.med_api.InventarioMedfix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipamentoDTO {
    private UUID id;
    private String nome;
    private String descricao;
    private String tipo;
    private String memoria;
    private String processador;
    private String hd;
    private String sistemaOperacional;
    private String monitor;
    private String observacoes;
}
