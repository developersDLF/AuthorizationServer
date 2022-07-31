package com.aavaaram.authorization.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AVM_USER_DATA")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "USER_EMAIL_ID", nullable = false)
    private String userEmailId;
    @Column(name = "USER_PASSWORD", nullable = false)
    private String userPassword;
    @Column(name = "USER_NAME", nullable = false)
    private String userName;
    @Column(name = "USER_ID", nullable = false)
    private String userId;
    @Column(name = "USER_PHONE_NUMBER", nullable = false)
    private int userPhoneNumber;
    @Column(name = "USER_TOKEN", nullable = false)
    private String userToken;

}
