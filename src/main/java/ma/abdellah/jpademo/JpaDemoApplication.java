package ma.abdellah.jpademo;

import ma.abdellah.jpademo.entities.Role;
import ma.abdellah.jpademo.entities.User;
import ma.abdellah.jpademo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService) {
        return args -> {
            User u1=new User();
            u1.setUsername("user1");
            u1.setPassword("1234");
            userService.addNewUser(u1);

            User u2=new User();
            u2.setUsername("admin");
            u2.setPassword("1234");
            userService.addNewUser(u2);

            Stream.of("STUDENT","USER","ADMIN").forEach(
                    r->{
                        Role r1=new Role();
                        r1.setRoleName(r);
                        userService.addNewRole(r1);
                    }
            );

            userService.addRoleToUser("user1","STUDENT");
            userService.addRoleToUser("user1","USER");
            userService.addRoleToUser("admin","ADMIN");
            userService.addRoleToUser("admin","USER");

            try {
                User user=userService.authenticate("user1","1234");
                System.out.println(user.getUserId());
                System.out.println(user.getPassword());
                System.out.println("Roles=>");
                user.getRoles().forEach(r->{
                    System.out.println("Role "+r.toString());
                });
            }catch (Exception e) {
                e.printStackTrace();
            }
        };

    }
}
