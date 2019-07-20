package com.womencancode.projetofinal.controller;

import com.womencancode.projetofinal.model.User;
import com.womencancode.projetofinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User user)  {
        return ResponseEntity.ok(userService.insertUser(user));
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String id) {
        user.setId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(@SortDefault.SortDefaults(
            {@SortDefault(sort = "name", direction = Sort.Direction.ASC)}) Pageable pageable) {
        return ResponseEntity.ok(userService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable String id)  {
          return ResponseEntity.ok(userService.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
