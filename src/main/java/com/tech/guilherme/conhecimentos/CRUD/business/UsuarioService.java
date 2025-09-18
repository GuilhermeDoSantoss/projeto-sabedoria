package com.tech.guilherme.conhecimentos.CRUD.business;

import com.tech.guilherme.conhecimentos.CRUD.business.dto.UsuarioRequestDTO;
import com.tech.guilherme.conhecimentos.CRUD.business.dto.UsuarioResponseDTO;
import com.tech.guilherme.conhecimentos.CRUD.business.mapstruct.UsuarioMapper;
import com.tech.guilherme.conhecimentos.CRUD.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    // Salva um usuário no banco e retorna um DTO de resposta
    public UsuarioResponseDTO salvaUsuario(UsuarioRequestDTO request){
                // 1. Converte o DTO de request em entidade
        return mapper.paraResponseDTO(repository.save(
                // 2. Salva a entidade no banco
                mapper.paraUsuarioEntity(request)));
                // 3. Converte a entidade salva em DTO de resposta e retorna

    }

        // Retorna todos os usuários cadastrados como lista de DTOs
    public List<UsuarioResponseDTO> buscaTodosUsuarios(){
        // 1. Busca todas as entidades no banco
        return mapper.paraListaUsuarioResponseDTO(repository.findAll());
        // 2. Converte cada entidade em DTO e retorna a lista
    }
         // Busca um usuário pelo email e retorna como DTO
    public UsuarioResponseDTO buscarUsuarioPorEmail(String email){
        // 1. Busca a entidade no banco pelo email
        return mapper.paraResponseDTO(repository.findByEmail(email));
        // 2. Converte em DTO e retorna
    }

        // Deleta um usuário pelo email
    public void deletaUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
        // Remove a entidade correspondente ao email
    }
}

// salvaUsuario → converte DTO → salva no banco → converte para DTO de resposta
// buscaTodosUsuarios → busca todas entidades → converte para lista de DTOs
// buscarUsuarioPorEmail → busca entidade por email → converte para DTO
// deletaUsuarioPorEmail → deleta entidade pelo email