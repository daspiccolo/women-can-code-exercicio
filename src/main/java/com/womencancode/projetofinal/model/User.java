package com.womencancode.projetofinal.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document
@Data
@Builder
@Wither
public class User {

    @Id
    private String id;
    private String name;
    private String lastName;
    private String username;
    private String email;

    private LocalDate birthDate;

    @DBRef(db = "role", lazy = false)
    private Role role;


}
