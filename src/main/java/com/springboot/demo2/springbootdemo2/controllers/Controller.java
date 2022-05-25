package com.springboot.demo2.springbootdemo2.controllers;

import com.springboot.demo2.springbootdemo2.QueryMonster;
import com.springboot.demo2.springbootdemo2.entities.User;
import com.springboot.demo2.springbootdemo2.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;

// import com.springboot.demo2.springbootdemo2.QueryMonster;
// import com.springboot.demo2.springbootdemo2.entities.User;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.apache.tomcat.jni.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @GetMapping("/home")
  public String welcome() {
    return "Welcome to the Remote Message Sending Receiving Consumer Software Module";
  }

  @GetMapping(value = "/users/{id}")
  public User getUser(@PathVariable("id") int id) {
    return userService.getUserByIdUser(id);
  }

  @Autowired
  private UserService userService;

}