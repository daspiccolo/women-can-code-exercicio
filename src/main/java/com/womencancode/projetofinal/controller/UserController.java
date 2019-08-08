package com.womencancode.projetofinal.controller;

import com.womencancode.projetofinal.exception.EntityNotFoundException;
import com.womencancode.projetofinal.exception.ServiceException;
import com.womencancode.projetofinal.model.User;
import com.womencancode.projetofinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<User> insertUser(@Valid @RequestBody User user) throws Exception {
        return ResponseEntity.ok(userService.insertUser(user));
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user, @PathVariable String id) throws Exception {
        verifyUserExists(id);
        user.setId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(@SortDefault.SortDefaults(
            {@SortDefault(sort = "name", direction = Sort.Direction.ASC)}) Pageable pageable) {
        return ResponseEntity.ok(userService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable String id) throws Exception {
        verifyUserExists(id);
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable String id) throws Exception {
        verifyUserExists(id);
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
    private void verifyUserExists(String id) throws ServiceException {
        String message = String.format("User %s not found", id);
        if (userService.findById(id) == null)
            throw new EntityNotFoundException(message);
    }

}
