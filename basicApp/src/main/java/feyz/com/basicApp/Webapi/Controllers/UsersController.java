package feyz.com.basicApp.Webapi.Controllers;

import feyz.com.basicApp.Business.Abstracts.UserService;
import feyz.com.basicApp.Entities.Concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UserService userService;
    public UsersController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/getall")
        public List<User> GetAll(){
            return  userService.GetAll();
        }

    @PostMapping("/add")
    public User Add(@RequestBody User user) {
        return userService.Add(user);
    }
    @PostMapping("/update")
    public User Update(@RequestBody User user) {
        return userService.Update(user);
    }
}