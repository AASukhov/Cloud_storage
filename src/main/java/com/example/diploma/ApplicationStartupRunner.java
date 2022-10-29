package com.example.diploma;

import com.example.diploma.entity.User;
import com.example.diploma.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ApplicationStartupRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        userRepository.save(User.builder()
                .login("admin@gmail.ru")
                .password(passwordEncoder.encode("0000"))
                .build());
        userRepository.save(User.builder()
                .login("reader@gmail.ru")
                .password(passwordEncoder.encode("1111"))
                .build());
        userRepository.save(User.builder()
                .login("editor@gmail.ru")
                .password(passwordEncoder.encode("2222"))
                .build());
    }
}