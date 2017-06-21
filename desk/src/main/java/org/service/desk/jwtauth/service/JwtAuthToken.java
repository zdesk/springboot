package org.service.desk.jwtauth.service;

import java.io.Serializable;


public class JwtAuthToken implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtAuthToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
