package com.womencancode.projetofinal.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;

@Document
@Data
@Builder
@Wither
public class User {

    @Id
    private String id;

    private String lastName;
    private String username;
    @Email
    private String email;

    private LocalDate birthDate;

    @DBRef(db = "role", lazy = false)
    private Role role;

    @NotEmpty(message = "O campo NAME é obrigatório.")
    private String name;


    public void setId(String id) {
        this.id=id;
    }
}
