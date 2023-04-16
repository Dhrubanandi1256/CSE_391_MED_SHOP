package com.example.carg.config;

import com.example.carg.model.UserDtls;
import com.example.carg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
   @Autowired
    private UserRepository userRepo;//validate kori userrepo diye
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDtls user= userRepo.findByEmail(email);
        if(user!=null){
            return new CustomUserDetails(user);

        }

        throw new UsernameNotFoundException("user not available");
    }
}
