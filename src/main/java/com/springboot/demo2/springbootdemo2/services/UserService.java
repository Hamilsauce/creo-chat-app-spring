package com.springboot.demo2.springbootdemo2.services;

import com.springboot.demo2.springbootdemo2.entities.User;
import com.springboot.demo2.springbootdemo2.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User getUserByIdUser(int id) {
    User newUser = userRepository.findById(id).get();

    return newUser;
  }

  public User saveUser(User user) {

    User savedUser = userRepository.save(user);
    return savedUser;
  }

}
