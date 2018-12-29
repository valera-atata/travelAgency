package my.newspring.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import my.newspring.project.model.User;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
    List<User> findAll();
}
