package com.tech.guilherme.conhecimentos.CRUD.controller;

import com.tech.guilherme.conhecimentos.CRUD.business.UsuarioService;
import com.tech.guilherme.conhecimentos.CRUD.business.dto.UsuarioRequestDTO;
import com.tech.guilherme.conhecimentos.CRUD.business.dto.UsuarioResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> salvaUsuario(@RequestBody UsuarioRequestDTO dto){
        // Recebe os dados do usuário via corpo da requisição (JSON) e chama o service para salvar no banco
        // Retorna o usuário salvo em um DTO de resposta com status HTTP 200 (OK)
        return ResponseEntity.ok(service.salvaUsuario(dto));
    }

    @GetMapping("/{email}")
    public ResponseEntity<UsuarioResponseDTO> buscarUsuarioPorEmail(@PathVariable("email") String email){
        // Recebe o email via path da URL e busca o usuário correspondente no banco
        // Retorna o usuário encontrado em um DTO de resposta com status HTTP 200 (OK)
        return ResponseEntity.ok(service.buscarUsuarioPorEmail(email));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> buscaTodosUsuarios(){
        // Busca todos os usuários cadastrados no banco
        // Retorna a lista de usuários em DTOs de resposta com status HTTP 200 (OK)
        return ResponseEntity.ok(service.buscaTodosUsuarios());
    }

    @DeleteMapping
    public ResponseEntity<Void> deletaUsuario(@RequestParam("email") String email){
        // Recebe o email via query param e remove o usuário correspondente do banco
        // Retorna apenas status HTTP 200 (OK), sem corpo
        service.deletaUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }
}
