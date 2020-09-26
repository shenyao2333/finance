package com.sy.finance.surictiy;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @author sy
 * @date Created in 2020.9.26 14:25
 * @description
 */

public class SelfUserService {



    public static SelfUserDetails getUserInfo(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        SelfUserDetails user =(SelfUserDetails)  authentication.getPrincipal();
        System.out.println(user);
        return user;
    }


}
