package com.tech.guilherme.conhecimentos.CRUD.business.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO {

    @JsonProperty(required = true)
    private String nome;
    @JsonProperty(required = true)
    private String email;
}
