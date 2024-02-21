package feyz.com.basicApp.Data.Abstracts;

import feyz.com.basicApp.Entities.Concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String userName);

}

