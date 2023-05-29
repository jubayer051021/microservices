package com.bjit.userapp.repository;

import com.bjit.userapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUserId(Integer userId);
}
