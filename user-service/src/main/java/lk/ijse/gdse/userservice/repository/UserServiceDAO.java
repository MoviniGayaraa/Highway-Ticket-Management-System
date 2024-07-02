package lk.ijse.gdse.userservice.repository;

import lk.ijse.gdse.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserServiceDAO extends JpaRepository<User, String> {
    boolean existsByEmailAndPassword(String email, String password);
}
