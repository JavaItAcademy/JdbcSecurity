package it.academy.JdbcSecurity.bootstrap;

import it.academy.JdbcSecurity.model.User;
import it.academy.JdbcSecurity.model.UserRoles;
import it.academy.JdbcSecurity.repository.UserRepository;
import it.academy.JdbcSecurity.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRolesRepository userRolesRepository;

    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user1 = new User("user1",
                passwordEncoder.encode("123"),
                1);
        userRepository.save(user1);

        User user2 = new User("user2",
                passwordEncoder.encode("123"),
                1);
        userRepository.save(user2);

        User user3 = new User("user3",
                passwordEncoder.encode("123"),
                1);
        userRepository.save(user3);

        UserRoles userRoles1 = new UserRoles("ROLE_ADMIN", user1);
        userRolesRepository.save(userRoles1);

        UserRoles userRoles2 = new UserRoles("ROLE_USER", user2);
        userRolesRepository.save(userRoles2);

        UserRoles userRoles3 = new UserRoles("ROLE_USER", user3);
        userRolesRepository.save(userRoles3);
    }
}
