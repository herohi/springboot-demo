package qin.spring.demo.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import qin.spring.demo.entity.user.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>, JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    User findByPhone(String phone);

    User findByUsername(String userName);
}
