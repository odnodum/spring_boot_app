package spring.boot.spring_boot_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.spring_boot_app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
