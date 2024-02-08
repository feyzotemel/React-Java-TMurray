package feyz.com.basicApp.Data.Abstracts;

import feyz.com.basicApp.Entities.Concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface UserRepository extends JpaRepository<User,Integer> {
List<User> getAll();
User getById(int id);
 User Add(User user);
 User Update(User user);


}
