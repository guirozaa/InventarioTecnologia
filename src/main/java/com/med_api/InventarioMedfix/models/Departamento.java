package com.med_api.InventarioMedfix.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "departamentoEquipamento", cascade = CascadeType.ALL)
    private List<Equipamento> equipamentos = new ArrayList<>();
}
