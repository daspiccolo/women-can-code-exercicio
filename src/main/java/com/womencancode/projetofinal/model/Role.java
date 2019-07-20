package com.womencancode.projetofinal.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@Document
public class Role {

    @Id
    private String id;
    private String name;

}
