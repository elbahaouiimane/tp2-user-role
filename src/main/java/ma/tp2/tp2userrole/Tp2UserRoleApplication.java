package ma.tp2.tp2userrole;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ma.tp2.tp2userrole.entities.Role;
import ma.tp2.tp2userrole.entities.User;
import ma.tp2.tp2userrole.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Tp2UserRoleApplication {
    public static void main(String[] args) {

        SpringApplication.run(Tp2UserRoleApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService) {
        return args -> {
            User u = new User();
            u.setUserName("user");
            u.setPassword("123456");
            userService.addNewUser(u);

            User u2 = new User();
            u2.setUserName("admin");
            u2.setPassword("123456");
            userService.addNewUser(u2);

            Stream.of("STUDENT", "USER", "ADMIN").forEach(r -> {
                Role role1 = new Role();
                role1.setRoleName(r);
                userService.addNewRole(role1);

            });

            userService.addRoleToUser("user", "STUDENT");
            userService.addRoleToUser("user", "USER");
            userService.addRoleToUser("admin", "USER");
            userService.addRoleToUser("admin", "ADMIN");

            try{
                User user=userService.authentificate("user","123456");
                System.out.println(user.getUserId());
                System.out.println(user.getUserName());
                System.out.println("Role ==> ");
                user.getRoles().forEach(r->{
                    System.out.println(r.toString());
                });
            }catch(Exception e){
                e.printStackTrace();

            }
        };
    }

}