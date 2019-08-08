package com.womencancode.projetofinal.model;

import com.mongodb.lang.NonNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Data
@Document
public class Role {

    @Id
    private String id;
    @NonNull
    @NotEmpty(message = "O campo NAME é obrigatório.")
    private String name;

}
