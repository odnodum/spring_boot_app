package spring.boot.spring_boot_app.service;

import spring.boot.spring_boot_app.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
    void delete(int id);
    void update(int id, User user);
    User findOne(int id);
}
