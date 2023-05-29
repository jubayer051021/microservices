package com.bjit.userapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private Integer userId;
    private Integer userPassword;
    private String userEmail;
    private  Integer accountBalance;
}
