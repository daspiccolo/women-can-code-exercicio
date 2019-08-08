package com.womencancode.projetofinal.service;

import com.womencancode.projetofinal.exception.EntityNotFoundException;
import com.womencancode.projetofinal.exception.ServiceException;
import com.womencancode.projetofinal.model.Role;
import com.womencancode.projetofinal.model.User;
import com.womencancode.projetofinal.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(@Autowired RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role insertRole(Role role) {
        return roleRepository.insert(role);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(String id) throws ServiceException {
        return roleRepository.findById(id).orElseThrow(() -> {
            String message = String.format("Role %s not found.", id);
            return new EntityNotFoundException(message);
        });
    }
    public Role updateRole (Role role){
        return roleRepository.save(role);
    }

    public void delete(String id) {
        roleRepository.deleteById(id);
    }
}


