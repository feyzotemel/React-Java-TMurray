package feyz.com.basicApp.Webapi.Controllers;

import feyz.com.basicApp.Business.Abstracts.RoleService;
import feyz.com.basicApp.Entities.Concretes.Role;
import feyz.com.basicApp.Entities.Concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin
public class RolesController {
    private RoleService roleService;
    public RolesController(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping("/getall")
    public List<Role> getAll(){
        return roleService.GetAll();
    }

    @PostMapping("/add")
    public Role Add(@RequestBody Role role) {
        return roleService.Add(role);
    }
    @PostMapping("/update")
    public Role Update(@RequestBody Role role) {
        return roleService.Update(role);
    }
}
