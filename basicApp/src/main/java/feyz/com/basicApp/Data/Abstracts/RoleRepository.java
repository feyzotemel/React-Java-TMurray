package feyz.com.basicApp.Data.Abstracts;

import feyz.com.basicApp.Entities.Concretes.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface RoleRepository {
    List<Role> getAll();
    Role getById( int id);
}
