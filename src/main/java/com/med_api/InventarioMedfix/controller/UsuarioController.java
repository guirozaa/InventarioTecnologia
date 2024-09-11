package com.med_api.InventarioMedfix.controller;

import com.med_api.InventarioMedfix.dto.UsuarioDTO;
import com.med_api.InventarioMedfix.mapper.UsuarioMapper;
import com.med_api.InventarioMedfix.models.Usuario;
import com.med_api.InventarioMedfix.service.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/findAll")
    public ResponseEntity<Page<UsuarioDTO>> findAll(SpecTemplate.UsuarioSpec spec, Pageable page){
        Page<Usuario> consultaPage = usuarioService.findAll(spec, page);

        if(consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(UsuarioMapper.INSTANCE::usuarioToDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(UsuarioMapper.INSTANCE::usuarioToDTO), HttpStatus.OK);
        }
    }
    @PostMapping("/")
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO savedUsuario = usuarioService.save(usuarioDTO);
        return ResponseEntity.ok(savedUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable UUID id){
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable UUID id, @RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.update(id, usuarioDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (usuarioService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}
