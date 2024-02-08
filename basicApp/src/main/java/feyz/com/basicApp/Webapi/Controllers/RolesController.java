package feyz.com.basicApp.Webapi.Controllers;

import feyz.com.basicApp.Business.Abstracts.RoleService;
import feyz.com.basicApp.Entities.Concretes.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolesController {
    private RoleService roleService;
    public RolesController(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping("/getall")
    public List<Role> getAll(){
        return roleService.GetAll();
    }
}
