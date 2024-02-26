package feyz.com.basicApp.Webapi.Controllers;

import feyz.com.basicApp.Entities.Concretes.User;
import feyz.com.basicApp.Service.JwtService;
import feyz.com.basicApp.Service.UserService;
import feyz.com.basicApp.Views.AuthRequest;
import feyz.com.basicApp.Views.AuthRequestResult;
import feyz.com.basicApp.Views.CreateUserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")

@Slf4j
public class AuthController {

    private final UserService userService;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public AuthController(UserService service, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = service;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public User addUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @PostMapping("/login")
    public AuthRequestResult login(@RequestBody AuthRequest request) {
        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
            if (authentication.isAuthenticated()) {

                var name = authentication.getName();

                var userLogin = userService.getByUsername(name);

                var token =jwtService.generateToken(request.username());

                var newObj = AuthRequestResult.builder()
                        .id(userLogin.get().getId())
                        .username(request.username())
                        .fullName(userLogin.get().getFullName())
                        .token(token)
                        .email(userLogin.get().getEmail())
                        .authorities(userLogin.get().getAuthorities())
                        .accountNonLocked(userLogin.get().isAccountNonLocked())
                        .dateRegistered(userLogin.get().getDateRegistered())
                        .dateBirthday(userLogin.get().getDateBirthday())
                        .accountNonExpired(userLogin.get().isAccountNonExpired())
                        .credentialsNonExpired(userLogin.get().isCredentialsNonExpired())
                        .build();

                return newObj;
            }
            log.info("invalid username " + request.username());
            throw new UsernameNotFoundException("invalid username {} " + request.username());
        }
        catch (Exception e){
            log.info("Exception occured: " + e.getMessage());
            throw new UsernameNotFoundException("invalid username {} " + request.username());
        }

    }

}