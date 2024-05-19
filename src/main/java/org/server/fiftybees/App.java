package org.server.fiftybees;

import org.server.fiftybees.dao.AuthorityRepository;
import org.server.fiftybees.dao.UserRepository;
import org.server.fiftybees.domain.Authority;
import org.server.fiftybees.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(App.class);
        AuthorityRepository authorityRepository =
                configurableApplicationContext.getBean(AuthorityRepository.class);
        UserRepository userRepository =
                configurableApplicationContext.getBean(UserRepository.class);

        authorityRepository.save(new Authority("ROLE_ADMIN"));
        authorityRepository.save(new Authority("ROLE_USER"));

        // admin user
        User admin_user = new User("admin", "111@ya.ru", "$2a$10$eObqG4zk7CbKPPTv0daHm.bcpK6zwyFPpjAVXOeDWrT/3TpVcxpia");
        // get admin role
        Set<Authority> authority = new HashSet<>();
        authority.add(authorityRepository.findByAuthority("ROLE_ADMIN").get());
        admin_user.setAuthorities(authority);

        userRepository.save(admin_user);

    }
}
