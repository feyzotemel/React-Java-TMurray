package feyz.com.basicApp.Entities.Concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import feyz.com.basicApp.Enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
@Entity
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    @Column(name = "Id")
    private int Id;

    @JsonProperty("Email")
    @Column(name = "Email")
    private String Email;

    @JsonProperty("Date_Birthday")
    @Column(name = "Date_Birthday")
    private Date Date_Birthday;

    @JsonProperty("Full_Name")
    @Column(name = "Full_Name")
    private String Full_Name;

    @JsonProperty("Date_Registered")
    @Column(name = "Date_Registered")
    private Date Date_Registered;

    @JsonProperty("RoleId")
    @Column(name = "RoleId")
    private Integer RoleId;

    @JsonProperty("UsrPassword")
    @Column(name = "UsrPassword")
    private String UsrPassword;

    //UserDetails implementations
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(RoleEnum.getRoleName(RoleId)));
    }

    @Override
    public String getPassword() {
        return UsrPassword;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}