package org.example.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthRequest {
    private String login;
    private String password;
    private int useJwt;
}