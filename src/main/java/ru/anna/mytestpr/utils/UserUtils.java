package ru.anna.mytestpr.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.anna.mytestpr.jdo.User;
import ru.anna.mytestpr.service.MyUserDetailsService;

public class UserUtils {

    public static User getCurrUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       return  ((MyUserDetailsService.MyUserPrincipal)authentication.getPrincipal()).getUser();

    }



}
