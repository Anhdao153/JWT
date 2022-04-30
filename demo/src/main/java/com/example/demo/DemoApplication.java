package com.example.demo;

import com.example.demo.dto.Role;
import com.example.demo.dto.User;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_EMPLOYEE"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_BUSINESS_OWNER"));

            userService.saveUser(new User(null, "mr.A", "admin1", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "mr.B", "admin2", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "mr.C", "admin3", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "mr.D", "admin4", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "mr.E", "admin5", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "mr.F", "admin6", "1234", new ArrayList<>()));

            userService.addRoletoUser("admin1", "ROLE_USER");
            userService.addRoletoUser("admin2", "ROLE_USER");
            userService.addRoletoUser("admin3", "ROLE_EMPLOYEE");
            userService.addRoletoUser("admin4", "ROLE_EMPLOYEE");
            userService.addRoletoUser("admin5", "ROLE_ADMIN");
            userService.addRoletoUser("admin6", "ROLE_ADMIN");

        };
    }

}
