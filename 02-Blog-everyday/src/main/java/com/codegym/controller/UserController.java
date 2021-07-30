package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.role.RoleService;
import com.codegym.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> findAll(){
        Iterable<User> cities= userService.findAll();
        return new ResponseEntity(cities, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> findOne(@PathVariable Long id){
        return new ResponseEntity(userService.findById(id).get(), HttpStatus.OK);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<Void> create(@PathVariable Long id,@RequestBody User user) {
        Optional<User> lastUser = userService.findById(id);
        if (!lastUser.isPresent()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        user.setId(id);
        userService.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
