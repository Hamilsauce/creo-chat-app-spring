package com.springboot.demo2.springbootdemo2.repository;

import java.util.List;
import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;

import com.springboot.demo2.springbootdemo2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  @Query("SELECT u FROM User u WHERE LOWER(u.email) = LOWER(:email)")
  public User findByEmail(@Param("email") String email);

  @Override
  default List<User> findAll() {
    return null;
  }

  // Optional<User> findByName(final String name);

  @Query("SELECT u FROM User u WHERE LOWER(u.email) = LOWER(:email) and u.password = :password")
  public Optional<User> findByEmailAndPassword(
      @Param("email") String email,
      @Param("password") String password);

}
