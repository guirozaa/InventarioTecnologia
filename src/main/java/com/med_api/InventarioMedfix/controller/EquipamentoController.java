package com.med_api.InventarioMedfix.controller;

import com.med_api.InventarioMedfix.dto.EquipamentoDTO;
import com.med_api.InventarioMedfix.mapper.EquipamentoMapper;
import com.med_api.InventarioMedfix.models.Equipamento;
import com.med_api.InventarioMedfix.service.EquipamentoService;
import com.med_api.InventarioMedfix.specifications.SpecTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/equipamento")
public class EquipamentoController {
    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping("/findAll")
    public ResponseEntity<Page<EquipamentoDTO>> findAll(SpecTemplate.EquipamentoSpec spec, Pageable page){
        Page<Equipamento> consultaPage = equipamentoService.findAll(spec, page);

        if(consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(EquipamentoMapper.INSTANCE::equipamentoToDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(EquipamentoMapper.INSTANCE::equipamentoToDTO), HttpStatus.OK);
        }
    }
    @PostMapping("/")
    public ResponseEntity<EquipamentoDTO> create(@RequestBody EquipamentoDTO equipamentoDTO){
        EquipamentoDTO savedEquipamento = equipamentoService.save(equipamentoDTO);
        return ResponseEntity.ok(savedEquipamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoDTO> getById(@PathVariable UUID id){
        return equipamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoDTO> update(@PathVariable UUID id, @RequestBody EquipamentoDTO equipamentoDTO) {
        return equipamentoService.update(id, equipamentoDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (equipamentoService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}

