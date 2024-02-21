package feyz.com.basicApp.Views;

import feyz.com.basicApp.Entities.Concretes.Role;
import lombok.Builder;

import java.util.Date;
import java.util.Set;

@Builder
public record CreateUserRequest(
        String name,
        String username,
        String email,
        String password,
        Date dateBirthday,
        Set<Role> authorities
){
}