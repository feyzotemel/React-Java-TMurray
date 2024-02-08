package feyz.com.basicApp.Data.Concretes;

import feyz.com.basicApp.Data.Abstracts.RoleRepository;
import feyz.com.basicApp.Entities.Concretes.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class InMemoryRoleRepository implements RoleRepository {

    List<Role> roles;
    public InMemoryRoleRepository() {
        roles = new ArrayList<Role>();
        roles.add(
                new Role(
                        1,
                        "Admin"
                )
        );
        roles.add(
                new Role(
                        2,
                        "Ordinary"
                )
        );
    }

    @Override
    public List<Role> getAll() {
        return roles;
    }

    @Override
    public Role getById(int id) {
//        Role role = roles.stream().filter(x -> x.getId() == id).findFirst();
        return null;
    }

}
