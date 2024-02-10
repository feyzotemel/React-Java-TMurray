package feyz.com.basicApp.Business.Concretes;

import feyz.com.basicApp.Business.Abstracts.RoleService;
import feyz.com.basicApp.Data.Abstracts.RoleRepository;
import feyz.com.basicApp.Entities.Concretes.Role;
import feyz.com.basicApp.Entities.Concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleManager implements RoleService {
    private RoleRepository roleRepository;
    public RoleManager(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> GetAll() {
        return roleRepository.findAll();
    }
    @Override
    public Role Add(Role role) {
        return roleRepository.save(role);
    }
    @Override
    public Role Update(Role role) {
        return roleRepository.save(role);
    }
}
