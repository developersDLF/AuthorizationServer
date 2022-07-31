package com.aavaaram.authorization.service;

import com.aavaaram.authorization.entity.UserEntity;
import com.aavaaram.authorization.model.UserDTO;
import com.aavaaram.authorization.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    /**
     * @param userEmailId the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userEmailId) throws UsernameNotFoundException {
        UserEntity userEntity = userDetailsRepository.findByUserEmailId(userEmailId);
        if (userEntity != null) {
            return new User(userEntity.getUserEmailId(), userEntity.getUserPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User with email id : " + userEmailId + " was not found");
        }


    }

    public UserDTO saveUserToDatabase(UserDTO userDTO) {
        UserEntity userEntity = UserEntity.builder().userId(userDTO.getUserId()).userEmailId(userDTO.getUserEmailId()).userPhoneNumber(userDTO.getUserPhoneNumber()).userPassword(bcryptEncoder.encode(userDTO.getPassword())).build();
        UserEntity savedUser = userDetailsRepository.save(userEntity);
        return UserDTO.builder().userId(savedUser.getUserId()).userEmailId(savedUser.getUserEmailId()).userName(savedUser.getUserName()).build();
    }


}
