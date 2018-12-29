package my.newspring.project.service;

import java.util.List;

import my.newspring.project.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    
    List<User> findAll();
}
