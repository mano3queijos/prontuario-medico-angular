package com.api.prontuario.entites;


import com.api.prontuario.enums.UsuarioAcaoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Table(name = "auditoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Auditoria {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "id_usuario")
    private User usuario;

    @Enumerated(EnumType.STRING)
    private UsuarioAcaoEnum usuarioAcao;

    private LocalDateTime horarioAcao;

}
