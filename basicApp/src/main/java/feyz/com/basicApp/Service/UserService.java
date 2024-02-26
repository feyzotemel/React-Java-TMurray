package feyz.com.basicApp.Service;


import feyz.com.basicApp.Data.Abstracts.UserRepository;
import feyz.com.basicApp.Entities.Concretes.Role;
import feyz.com.basicApp.Entities.Concretes.User;
import feyz.com.basicApp.Views.CreateUserRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUsername(username);
        return user.orElseThrow(EntityNotFoundException::new);
    }

    public User createUser(CreateUserRequest request) {

        User newUser = User.builder()
                .fullName(request.name())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .dateBirthday(request.dateBirthday())
                .dateRegistered(new Date())
                .authorities(request.authorities())
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .build();

        return userRepository.save(newUser);
    }

    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> GetAll() {
        return userRepository.findAll();
    }

    public User GetById(Long id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            var loginUsername = authentication.getName();
            var currentUser = userRepository.findByUsername(loginUsername);
            var curentUserRoles = currentUser.get().getAuthorities();
            if ((currentUser.get().getId() == id &&
                    curentUserRoles.stream().anyMatch(x -> x.getValue() == Role.ROLE_USER.getValue())) ||
                    (curentUserRoles.stream().anyMatch(x -> x.getValue() == Role.ROLE_ADMIN.getValue()))) {
                Optional<User> userOptional = userRepository.findById(id);
                return userOptional.orElse(null);
            }
        }
        return null;
    }

    public void DeleteById(Long id) {
        userRepository.deleteById(id);
    }

}