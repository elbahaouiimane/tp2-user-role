package ma.tp2.tp2userrole.repository;

import ma.tp2.tp2userrole.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String userName);
}