package com.springboot.demo2.springbootdemo2.services;

import com.springboot.demo2.springbootdemo2.QueryMonster;
import com.springboot.demo2.springbootdemo2.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private QueryMonster queryMonster;

  public User getUserByIdUser(int id) {

    User newUser = queryMonster.findById(id).get();
    return newUser;
  }

}
