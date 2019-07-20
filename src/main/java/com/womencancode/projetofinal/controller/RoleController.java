package com.womencancode.projetofinal.controller;

import com.womencancode.projetofinal.model.Role;
import com.womencancode.projetofinal.service.RoleService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/role", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController {
    private RoleService roleService;

    public RoleController(@Autowired RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<Role> insertRole(@RequestBody Role role) {
                return ResponseEntity.ok(roleService.insertRole(role));
    }

    @GetMapping
    public ResponseEntity<List<Role>> findAll() {

        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> findById(@PathVariable String id) {

        return ResponseEntity.ok(roleService.findById(id));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Role> delete(@PathVariable String id){
        roleService.delete(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{role}")
    public ResponseEntity<Role> updateRole(@PathVariable Role role){
       return ResponseEntity.ok(roleService.updateRole(role));
    }

}