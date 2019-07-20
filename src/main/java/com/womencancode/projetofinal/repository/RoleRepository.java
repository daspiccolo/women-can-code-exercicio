package com.womencancode.projetofinal.repository;

import com.womencancode.projetofinal.model.Role;
import com.womencancode.projetofinal.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {

}
