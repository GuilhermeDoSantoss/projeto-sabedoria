package com.tech.guilherme.conhecimentos.CRUD.business.mapstruct;

import com.tech.guilherme.conhecimentos.CRUD.business.dto.UsuarioRequestDTO;
import com.tech.guilherme.conhecimentos.CRUD.business.dto.UsuarioResponseDTO;
import com.tech.guilherme.conhecimentos.CRUD.infrastructure.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "nome", target = "name")
    UsuarioEntity paraUsuarioEntity(UsuarioRequestDTO dto);

    UsuarioResponseDTO paraResponseDTO(UsuarioEntity entity);

    List<UsuarioResponseDTO> paraListaUsuarioResponseDTO(List<UsuarioEntity> lista);
}
