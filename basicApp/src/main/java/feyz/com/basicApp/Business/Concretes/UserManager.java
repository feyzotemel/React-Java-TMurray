package feyz.com.basicApp.Business.Concretes;

import feyz.com.basicApp.Business.Abstracts.UserService;
import feyz.com.basicApp.Data.Abstracts.UserRepository;
import feyz.com.basicApp.Entities.Concretes.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserManager implements UserService {
    private final UserRepository userRepository;
    //    public UserManager(UserRepository userRepository) {
    //        this.userRepository = userRepository;
    //    }

    @Override
    public List<User> GetAll() {
        return userRepository.findAll();
    }

    @Override
    public User GetById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public void DeleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User Add(User user) {
        return userRepository.save(user);
    }
    @Override
    public User Update(User user) {
        return userRepository.save(user);
    }
}
