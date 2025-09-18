package com.tech.guilherme.conhecimentos.CRUD.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "nome", nullable = false)
        private String nome;

        @Column(name = "email", unique = true, nullable = false)
        private String email;

        @Column(name = "senha", nullable = false)
        private String senha;

}
