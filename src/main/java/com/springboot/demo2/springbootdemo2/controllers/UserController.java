package com.springboot.demo2.springbootdemo2.controllers;

import java.net.URI;

import com.springboot.demo2.springbootdemo2.entities.User;
import com.springboot.demo2.springbootdemo2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/home")
  public String welcome() {
    return "Welcome to the Remote Message Sending Receiving Consumer Software Module";
  }

  @GetMapping(value = "/users/{id}")
  public User getUser(@PathVariable("id") int id) {
    return userService.getUserByIdUser(id);
  }

  @PostMapping("/users")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User savedUser = userService.saveUser(user);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(savedUser.getId())
        .toUri();

    return ResponseEntity.created(location).build();
  }

  // @PostMapping(value="path")
  // public SomeEnityData postMethodName(@RequestBody SomeEnityData entity) {
  // //TODO: process POST request
  // return userService.getUserByIdUser(id);
  // return entity;
  // }

  // private UserRepository userRepository;

  // @PostMapping(path="/add") // Map ONLY POST Requests
  // public @ResponseBody String addNewUser (@RequestParam String name
  // , @RequestParam String email) {
  // // @ResponseBody means the returned String is the response, not a view name
  // // @RequestParam means it is a parameter from the GET or POST request

  // User n = new User();
  // n.setName(name);
  // n.setEmail(email);
  // userRepository.save(n);
  // return "Saved";
  // }

  // @GetMapping(path="/all")
  // public @ResponseBody Iterable<User> getAllUsers() {
  // // This returns a JSON or XML with the users
  // return userRepository.findAll();
  // }
  // }
}
