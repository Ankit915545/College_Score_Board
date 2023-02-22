package com.example.collegeScoreBoard.service;

import com.example.collegeScoreBoard.model.CollegeUser;
import com.example.collegeScoreBoard.repository.CollegeUserRepository;
import com.example.collegeScoreBoard.security.CollegeUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CollegeUserDetailsService implements UserDetailsService {

    @Autowired
    CollegeUserRepository collegeUserRepositoryObject;


        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            CollegeUser userObject = collegeUserRepositoryObject.findByUsername(username);
            if (userObject == null) {
                throw new UsernameNotFoundException("User not found!..");
            }
            return new CollegeUserDetails(userObject);
        }

}
