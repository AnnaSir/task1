package ru.anna.mytestpr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import ru.anna.mytestpr.dao.UserDao;
import ru.anna.mytestpr.jdo.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) {

        User user = userDao.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }

    public class MyUserPrincipal implements UserDetails {
        private User user;

        public User getUser() {
            return user;
        }

        BCryptPasswordEncoder encoder = passwordEncoder();

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            return authorities;
        }

        @Override
        public String getPassword() {
            return encoder.encode(user.getPassword());
        }

        @Override
        public String getUsername() {
            return user.getFirstName();
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

        public MyUserPrincipal(User user) {
            this.user = user;
        }

    }

    @Bean
    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}