package feyz.com.basicApp;

import feyz.com.basicApp.Business.Abstracts.RoleService;
import feyz.com.basicApp.Business.Abstracts.UserService;
import feyz.com.basicApp.Entities.Concretes.Role;
import feyz.com.basicApp.Entities.Concretes.User;
import feyz.com.basicApp.Enums.RoleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class BasicAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicAppApplication.class, args);
    }

    @Bean
	CommandLineRunner run(RoleService roleService, UserService userService) {
        return args -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


            roleService.Add(new Role(1, "ROLE_ADMIN"));
            roleService.Add(new Role(2, "ROLE_ORDINARY"));

            userService.Add(new User(1, "feyzullah.temel@hotmail.com", dateFormat.parse("1991-01-13"), "Feyzullah Temel", new Date(), RoleEnum.ROLE_ADMIN.getNumVal(),"123456"));
            userService.Add(new User(2, "test@hotmail.com", dateFormat.parse("1998-02-10"), "Test Name", new Date(), RoleEnum.ROLE_ORDINARY.getNumVal(),"123456"));
        };
    }
}
