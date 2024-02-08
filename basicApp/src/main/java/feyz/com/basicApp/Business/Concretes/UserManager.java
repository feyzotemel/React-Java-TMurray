package feyz.com.basicApp.Business.Concretes;

import feyz.com.basicApp.Business.Abstracts.UserService;
import feyz.com.basicApp.Data.Abstracts.UserRepository;
import feyz.com.basicApp.Entities.Concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserManager implements UserService {
private UserRepository userRepository;
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> GetAll() {
        return userRepository.getAll();
    }
    @Override
    public User Add(User user) {
        return userRepository.Add(user);
    }
    @Override
    public User Update(User user) {
        return userRepository.Update(user);
    }
}
