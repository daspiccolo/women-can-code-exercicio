package com.womencancode.projetofinal.controller;

import com.womencancode.projetofinal.exception.EntityNotFoundException;
import com.womencancode.projetofinal.exception.ServiceException;
import com.womencancode.projetofinal.model.Role;
import com.womencancode.projetofinal.model.User;
import com.womencancode.projetofinal.service.RoleService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/role", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController {
    private RoleService roleService;

    public RoleController(@Autowired RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<Role> insertRole(@Valid @RequestBody Role role) throws Exception {
        return ResponseEntity.ok(roleService.insertRole(role));
    }

    @GetMapping
    public ResponseEntity<List<Role>> findAll() {

        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> findById(@PathVariable String id) throws Exception {
        verifyRoleExists(id);
        return ResponseEntity.ok(roleService.findById(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Role> delete(@PathVariable String id) throws Exception {
        verifyRoleExists(id);
        roleService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@Valid @RequestBody Role role, @PathVariable String id) throws Exception {

    verifyRoleExists(id);
    role.setId(id);
        return ResponseEntity.ok(roleService.updateRole(role));
    }
    private void verifyRoleExists(String id) throws ServiceException {
        String message = String.format("Role %s not found", id);
        if (roleService.findById(id) == null)
            throw new EntityNotFoundException(message);
    }

}