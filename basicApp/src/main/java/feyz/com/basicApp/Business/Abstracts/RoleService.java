package feyz.com.basicApp.Business.Abstracts;

import feyz.com.basicApp.Entities.Concretes.Role;
import feyz.com.basicApp.Entities.Concretes.User;

import java.util.List;

public interface RoleService {
    List<Role> GetAll();
    Role Add(Role role);
    Role Update(Role role);


}
