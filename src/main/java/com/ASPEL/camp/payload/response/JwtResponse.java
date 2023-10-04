package com.ASPEL.camp.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private Long campistaId;
    private List<String> roles;

    public JwtResponse(String accessToken, Long id, String username, String email, Long campistaId, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.campistaId = campistaId;
        this.roles = roles;
    }
}
