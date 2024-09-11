package com.med_api.InventarioMedfix.controller;

import com.med_api.InventarioMedfix.dto.FornecedorDTO;
import com.med_api.InventarioMedfix.mapper.FornecedorMapper;
import com.med_api.InventarioMedfix.models.Fornecedor;
import com.med_api.InventarioMedfix.service.FornecedorService;
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
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/findAll")
    public ResponseEntity<Page<FornecedorDTO>> findAll(SpecTemplate.FornecedorSpec spec, Pageable page){
        Page<Fornecedor> consultaPage = fornecedorService.findAll(spec, page);

        if(consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(FornecedorMapper.INSTANCE::fornecedorToDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(FornecedorMapper.INSTANCE::fornecedorToDTO), HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<FornecedorDTO> create(@RequestBody FornecedorDTO fornecedorDTO){
        FornecedorDTO savedFornecedor = fornecedorService.save(fornecedorDTO);
        return ResponseEntity.ok(savedFornecedor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDTO> getById(@PathVariable UUID id){
        return fornecedorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorDTO> update(@PathVariable UUID id, @RequestBody FornecedorDTO fornecedorDTO) {
        return fornecedorService.update(id, fornecedorDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (fornecedorService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}
