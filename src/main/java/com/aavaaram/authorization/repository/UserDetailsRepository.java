package com.aavaaram.authorization.repository;

import com.aavaaram.authorization.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByUserEmailId(String userEmailId);
}
