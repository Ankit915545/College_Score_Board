package com.example.collegeScoreBoard.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class ApplicationConfigurationDetails extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().disable();
        http.authorizeRequests()
                .antMatchers("/addStudentDetails").hasAnyAuthority("dean","college clerk")
                .antMatchers("/addStudentMarks").hasAnyAuthority("dean","teacher")
                .antMatchers("/displayById/{id}").hasAnyAuthority("principal","dean","college clerk","teacher")
                .antMatchers("DisplayByIdMarks/{id}").hasAnyAuthority("principal","dean")
                .antMatchers("/deleteById/{id}").hasAnyAuthority("principal","dean")
                .antMatchers("/deleteByIdMarks/{id}").hasAnyAuthority("principal","dean")
                .antMatchers("/updateMarks{id}").hasAnyAuthority("teacher","dean")
                .antMatchers("/update{id}").hasAnyAuthority("teacher","dean")
                .antMatchers("/displayAllMarks").hasAnyAuthority("dean","principal")
                .antMatchers("/displayAll").hasAnyAuthority("dean","principal")
                .antMatchers("/deleteAll").hasAuthority("principal")
                .antMatchers("/deleteAllMarks").hasAuthority("principal")
                .antMatchers("/findByName/{name}").permitAll()
                .antMatchers("/displayByBranch/{branch}").hasAnyAuthority("dean","principal","teacher","college user","college clerk")
                .antMatchers("/displayBySession").hasAnyAuthority("principal","dean","college clerk")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }
}
