package com.doyur.demo.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LoginUserRequest {
    private String email;
    private String password;
}
