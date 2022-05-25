import com.springboot.demo2.springbootdemo2.entities.User;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryMonster extends JpaRepository<User, Integer> {
  User findByUserName(String username);
}














// @Repository
// public class QueryMonster extends JpaRepository {

// @Autowired
// private JdbcTemplate jdbcTemplate;

// public static void main(String[] ...args) {
// SpringApplication.run(QueryMonster.class, args);
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
