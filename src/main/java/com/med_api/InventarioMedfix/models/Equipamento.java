package com.med_api.InventarioMedfix.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "memoria", nullable = false)
    private String memoria;

    @Column(name = "processador", nullable = false)
    private String processador;

    @Column(name = "hd", nullable = false)
    private String hd;

    @Column(name = "sistemaOperacional", nullable = false)
    private String sistemaOperacional;

    @Column(name = "monitor", nullable = false)
    private String monitor;

    @Column(name = "observacoes", nullable = false)
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "id_departamento", nullable = false)
    private Departamento departamentoEquipamento;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedor fornecedorEquipamento;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuarioEquipamento;
}

