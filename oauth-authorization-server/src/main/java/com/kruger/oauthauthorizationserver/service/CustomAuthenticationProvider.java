package com.kruger.oauthauthorizationserver.service;

import com.kruger.oauthauthorizationserver.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails user= customUserDetailsService.loadUserByUsername(username);
        return checkPassword(user,password);
    }

    private Authentication checkPassword(UserDetails user, String rawPassword) {
        if(org.apache.commons.codec.digest.DigestUtils.sha256Hex(rawPassword).equals(user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(user.getUsername(),
                    user.getPassword(),
                    user.getAuthorities());
        }
        else {
            throw new BadCredentialsException(Messages.Info.BAD_CREDENTIALS.toString());
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
