package feyz.com.basicApp.Webapi.Controllers;

import feyz.com.basicApp.Business.Abstracts.UserService;
import feyz.com.basicApp.Data.Abstracts.UserRepository;
import feyz.com.basicApp.Entities.Concretes.User;
import feyz.com.basicApp.Enums.RoleEnum;
import feyz.com.basicApp.Views.AuthenticationRequestView;
import feyz.com.basicApp.Views.RegisterRequestView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {

    return  ResponseEntity.ok("hello from otherside");
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestView request) {
        String encodedPassword = request.getPassword();
       var registeredUser = User.builder().
               RoleId(RoleEnum.ROLE_ORDINARY.getNumVal())
               .UsrPassword(encodedPassword)
               .Email(request.getEmail())
               .Full_Name(request.getFull_Name())
               .Date_Birthday(request.getDate_Birthday())
               .build();

        userService.Add(registeredUser);
        return  ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestView request) {
        return  ResponseEntity.ok("service.authenticate(request)");
    }

}
