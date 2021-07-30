package com.codegym.controller;

import com.codegym.model.Role;
import com.codegym.repository.IRoleRepository;
import com.codegym.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RoleController {
    @Autowired
    IRoleRepository roleRepository;

    @GetMapping("roles")
    public ResponseEntity<Iterable<Role>> findAll(){
        List<Role> roles= (List<Role>) roleRepository.findAll();
        return new ResponseEntity(roles, HttpStatus.OK);
    }
}
