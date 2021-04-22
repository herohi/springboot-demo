package qin.spring.demo.service.user;

import qin.spring.demo.entity.user.User;

import java.util.Optional;

public interface UserService {
    String login(String username, String pwd);
    Optional<User> findOneById(Long id);
    User findOneByUsername(String username);
    User findOneByPhone(String phone);
}
