package com.teachmeskills.controller;

import com.teachmeskills.model.User;
import com.teachmeskills.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createUser(@RequestBody User user) {
        Boolean result = userService.createUser(user);
        if (!result) {
            logger.info("User -> {} creation failed", user.getFirstName());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else {
            logger.info("User -> {} created successfully", user.getFirstName());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id")  Long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isEmpty()) {
            logger.info("User -> {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("User -> {} found", user.get().getFirstName());
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            logger.info("Users  not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Received -> {} users", users.size());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        Optional<User> userUpdated = userService.updateUser(user);
        if (userUpdated.isEmpty()) {
            logger.info("User -> {} is not updated", user.getFirstName());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        logger.info("User -> {} is updated", user.getFirstName());
        return new ResponseEntity<>(userUpdated.get(), HttpStatus.OK);
    }

}
