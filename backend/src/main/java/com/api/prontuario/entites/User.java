package com.api.prontuario.entites;
import com.api.prontuario.entites.Pessoa;
import com.api.prontuario.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends Pessoa {

    private Role role;
    private String login;
    private String password;


}
