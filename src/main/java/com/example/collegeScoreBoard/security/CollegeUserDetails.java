package com.example.collegeScoreBoard.security;

import com.example.collegeScoreBoard.model.CollegeUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.Collections;

public class CollegeUserDetails implements UserDetails {

    CollegeUser collegeUserObject;

    public CollegeUserDetails(CollegeUser collegeUserObject){
        super();
        this.collegeUserObject=collegeUserObject;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(collegeUserObject.getRole()));
    }

    @Override
    public String getPassword() {
        return collegeUserObject.getPassword();
    }

    @Override
    public String getUsername() {
        return collegeUserObject.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
