package feyz.com.basicApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicAppApplication.class, args);
    }

//    @Bean
//	CommandLineRunner run(UserService userService) {
//        return args -> {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//
//
//            userService.Add(new User(1L, "feyzullah.temel@hotmail.com", dateFormat.parse("1991-01-13"), "Feyzullah Temel", new Date(), RoleEnum.ROLE_ADMIN.toString(),"123456"));
//            userService.Add(new User(2L, "test@hotmail.com", dateFormat.parse("1998-02-10"), "Test Name", new Date(), RoleEnum.ROLE_ORDINARY.toString(),"123456"));
//        };
//    }
}
