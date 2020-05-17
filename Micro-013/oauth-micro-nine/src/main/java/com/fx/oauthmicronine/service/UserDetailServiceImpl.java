package com.fx.oauthmicronine.service;

import com.fx.oauthmicronine.model.AuthUserDetail;
import com.fx.oauthmicronine.model.User;
import com.fx.oauthmicronine.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserDetailRepository userDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> userOptional=userDetailRepository.findByUsername(name);

        userOptional.orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));

        UserDetails userDetails = new AuthUserDetail(userOptional.get());

        new AccountStatusUserDetailsChecker().check(userDetails);

        return userDetails;
    }
}
