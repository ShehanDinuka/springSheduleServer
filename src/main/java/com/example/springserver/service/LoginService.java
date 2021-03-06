package com.example.springserver.service;

import com.example.springserver.model.CustomUserDetails;
import com.example.springserver.model.User;
import com.example.springserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        User user = userRepository.findByName(userName);
        CustomUserDetails customUserDetails = new CustomUserDetails();
        if(user != null){
            customUserDetails.setUser(user);
        }else{
            throw new UsernameNotFoundException("User name is not exists");
        }
        return customUserDetails;
    }
}
