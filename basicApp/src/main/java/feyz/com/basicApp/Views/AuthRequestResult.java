package feyz.com.basicApp.Views;

import feyz.com.basicApp.Entities.Concretes.Role;
import feyz.com.basicApp.Entities.Concretes.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequestResult {
    private Long id;
    private String fullName;
    private String email;
    private String username;
    private Date dateBirthday;
    private Date dateRegistered;
    private String token;

    private boolean accountNonExpired;
    private boolean isEnabled;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    @Enumerated(EnumType.STRING)
    private Set<Role> authorities;
}