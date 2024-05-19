package org.server.fiftybees.service.impl;

import org.server.fiftybees.dao.UserRepository;
import org.server.fiftybees.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(userName);

        if (!optionalUser.isPresent()) throw new UsernameNotFoundException("User not found");

        return optionalUser.get();
    }
}
