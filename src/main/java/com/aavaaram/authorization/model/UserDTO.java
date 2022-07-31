package com.aavaaram.authorization.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {


    private String userEmailId;
    private String password;
    private String userName;
    private String userId;
    private int userPhoneNumber;
    private String userToken;

}

