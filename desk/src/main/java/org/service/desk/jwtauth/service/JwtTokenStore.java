package org.service.desk.jwtauth.service;

import java.io.Serializable;


public class JwtTokenStore implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtTokenStore(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
