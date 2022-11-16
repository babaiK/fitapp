package com.fittapp.auth.dto;

import lombok.Getter;

@Getter
public class RegisterDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
