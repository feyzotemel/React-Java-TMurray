package feyz.com.basicApp.Webapi.Controllers;

import feyz.com.basicApp.Entities.Concretes.User;
import feyz.com.basicApp.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {
    private final UserService userService;
    public UserController(UserService service) {
        this.userService = service;
    }

    @GetMapping("/admin")
    public String getAdminString() {
        return "This is ADMIN!";
    }

    @GetMapping("/getall")
    public List<User> GetAll(){
        return  userService.GetAll();
    }
    @GetMapping("/getById")
    public User getById(@RequestParam("id") Long id){
        return  userService.GetById(id);
    }
    @GetMapping("/deleteById")
    public boolean deleteById(@RequestParam("id") Long id){
        userService.DeleteById(id);
        return true ;
    }



}