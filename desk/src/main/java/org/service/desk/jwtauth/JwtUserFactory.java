package org.service.desk.jwtauth;

import java.util.List;
import java.util.stream.Collectors;

import org.service.desk.entities.models.Authority;
import org.service.desk.entities.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getPassword(),
                user.getEnabled(),
                user.getLastPasswordResetDate()
        );
    }

}
