package com.med_api.InventarioMedfix.service;

import com.med_api.InventarioMedfix.dto.UsuarioDTO;
import com.med_api.InventarioMedfix.models.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioService {
    Page<Usuario> findAll(Specification<Usuario> spec, Pageable page);

    UsuarioDTO save(UsuarioDTO usuarioDTO) ;

    Optional<UsuarioDTO> findById(UUID id);

    Optional<UsuarioDTO> update(UUID id,UsuarioDTO usuarioDTO);

    boolean deleteById(UUID id);
}
