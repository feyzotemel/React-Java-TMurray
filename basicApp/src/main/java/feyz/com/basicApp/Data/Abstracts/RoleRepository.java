package feyz.com.basicApp.Data.Abstracts;

import feyz.com.basicApp.Entities.Concretes.Role;
import feyz.com.basicApp.Entities.Concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface RoleRepository extends JpaRepository<Role,Long> {

}
