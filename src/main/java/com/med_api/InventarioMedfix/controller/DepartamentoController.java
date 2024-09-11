package com.med_api.InventarioMedfix.controller;

import com.med_api.InventarioMedfix.dto.DepartamentoDTO;
import com.med_api.InventarioMedfix.mapper.DepartamentoMapper;
import com.med_api.InventarioMedfix.models.Departamento;
import com.med_api.InventarioMedfix.service.DepartamentoService;
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
@RequestMapping("/departamento")
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/findAll")
    public ResponseEntity<Page<DepartamentoDTO>> findAll(SpecTemplate.DepartamentoSpec spec, Pageable page){
        Page<Departamento> consultaPage = departamentoService.findAll(spec, page);

        if(consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(DepartamentoMapper.INSTANCE::departamentoToDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(DepartamentoMapper.INSTANCE::departamentoToDTO), HttpStatus.OK);
        }
    }

//    @PostMapping("/")
//    public ResponseEntity<DepartamentoDTO> create(@RequestBody DepartamentoDTO departamentoDTO){
//        DepartamentoDTO savedDepartamento = departamentoService.save(departamentoDTO);
//        return ResponseEntity.ok(savedDepartamento);
//    }

    @PostMapping("/")
    public ResponseEntity<DepartamentoDTO> create(@RequestBody DepartamentoDTO departamentoDTO) {
        if (departamentoDTO.getNome() == null || departamentoDTO.getNome().isEmpty()) {
            return ResponseEntity.badRequest().body(null);  // Retorna erro se nome for nulo ou vazio
        }

        DepartamentoDTO savedDepartamento = departamentoService.save(departamentoDTO);
        return ResponseEntity.ok(savedDepartamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoDTO> getById(@PathVariable UUID id){
        return departamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoDTO> update(@PathVariable UUID id, @RequestBody DepartamentoDTO departamentoDTO) {
        return departamentoService.update(id, departamentoDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (departamentoService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}
