package com.springboot.demo2.springbootdemo2.controllers;

import java.net.URI;
import java.util.Optional;

import com.springboot.demo2.springbootdemo2.entities.User;
import com.springboot.demo2.springbootdemo2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/")
  public String welcome() {
    return "Welcome to the Remote Message Sending Receiving Consumer Software Module";
  }

  @GetMapping(value = "/users/{id}")
  public Optional<User> getUserById(@PathVariable("id") int id) {
    return userService.getUserById(id);
  }

  // @GetMapping(value = "/users/{email}")
  // public Optional<User> getUserByEmail(@PathVariable("email") int email) {
  // return userService.getUserByEmail(email);
  // }

  @PostMapping(value = "/login")
  public Optional<User> userLogin(@RequestBody User user) {
    Optional<User> authResult = userService.authenticateUser(user.getEmail(), user.getPassword());
    // .orElseThrow("User not authenticated!");

    if (authResult == null) {

      return null;
    } else {
      return authResult;
    }
  }

  @PostMapping("/users")
  public ResponseEntity<Object> createUser(@RequestBody User user) {
    // TODO: Username validation (at least just uniqueness)

    User savedUser = userService.saveUser(user);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getId())
        .toUri();

    return ResponseEntity.created(location).build();
  }

  @GetMapping(path = "/users")
  public @ResponseBody Iterable<User> getAllUsers() {
    return userService.getAllUsers();
  }
}
