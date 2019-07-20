package com.womencancode.projetofinal.service;

import com.womencancode.projetofinal.model.User;
import com.womencancode.projetofinal.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User insertUser(User user)  {
        return userRepository.insert(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User findById(String id) {
        return userRepository.findById(id).get();

    }

    public List<User> findAll(Pageable pageable) {
        return userRepository.findAll();
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
