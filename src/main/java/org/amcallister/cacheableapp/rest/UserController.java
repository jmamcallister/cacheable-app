package org.amcallister.cacheableapp.rest;

import org.amcallister.cacheableapp.entities.User;
import org.amcallister.cacheableapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name) {
        return new ResponseEntity<>(this.userService.findByName(name), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUsers(@RequestBody List<User> usersToCreate) {
        this.userService.save(usersToCreate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
