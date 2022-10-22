package com.example.diploma.service;

import com.example.diploma.entity.User;
import com.example.diploma.exceptions.UnauthorizedUserException;
import com.example.diploma.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User myUser = userRepository.findByLogin(username)
                .orElseThrow(() -> new UnauthorizedUserException("Unauthorized user"));
        //List<GrantedAuthority> authorities = new ArrayList<>();
        return (UserDetails) User.builder()
                .login(myUser.getLogin())
                .password(myUser.getPassword())
                .build();
    }
}
