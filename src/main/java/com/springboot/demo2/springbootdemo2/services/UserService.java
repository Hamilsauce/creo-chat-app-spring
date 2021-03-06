package com.springboot.demo2.springbootdemo2.services;
import java.util.Optional;
import com.springboot.demo2.springbootdemo2.entities.User;
import com.springboot.demo2.springbootdemo2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public Optional<User> getUserById(int id) {
    Optional<User> newUser = userRepository.findById(id);

    // TODO: Do i need to validate returned object here?
    return newUser;
  }
  public Optional<User> getUserByEmail(int id) {
    Optional<User> newUser = userRepository.findById(id);

    // TODO: Do i need to validate returned object here?
    return newUser;
  }

  public Iterable<User> getAllUsers() {
    Iterable<User> users = userRepository.findAll();

    return users;
  }

  public Optional<User> authenticateUser(String email, String password) {
    Optional<User> authResult = userRepository.findByEmailAndPassword(email, password);

    return authResult;
  }

  public User saveUser(User user) {

    User savedUser = userRepository.save(user);
    return savedUser;
  }

}
