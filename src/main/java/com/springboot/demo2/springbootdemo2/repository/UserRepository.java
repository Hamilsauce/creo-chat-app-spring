package com.springboot.demo2.springbootdemo2.repository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;

import com.springboot.demo2.springbootdemo2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  @Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
  public User findById(@Param("username") String username);

  @Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username) and u.password = :password")
  public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

  // public User setUserByIdUser(User user) {

  //   User savedUser = userRepository.save(user);
  //   return savedUser;
  // }
}




// public class UserRepository {


// }


// @Repository
// public class UserRepository extends JpaRepository {

// @Autowired
// private JdbcTemplate jdbcTemplate;

// public static void main(String[] ...args) {
// SpringApplication.run(UserRepository.class, args);
// }

// @Override
// public void run(String... args) throws Exception {
// String sql = "INSERT INTO users (fullname, email, password) VALUES (?, ?,
// ?)";

// // String[] defaults = { "jake2", "jake@email2.com", "password" };

// int result = jdbcTemplate.update(sql, args[0], args[1], args[2]);

// System.out.println("result");
// System.out.println(result);

// if (result > 0) {
// System.out.println("A new row has been inserted.");
// }

// }
// }
