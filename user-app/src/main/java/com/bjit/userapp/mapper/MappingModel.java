package com.bjit.userapp.mapper;

import com.bjit.userapp.dto.UserRequestDto;
import com.bjit.userapp.dto.UserResponseDto;
import com.bjit.userapp.entity.UserEntity;

public class MappingModel {
    public static UserResponseDto UserEntityToDto(UserEntity userEntity){
        return UserResponseDto.builder()
                .userId(userEntity.getUserId())
                .userEmail(userEntity.getUserEmail())
                .accountBalance(userEntity.getAccountBalance())
                .build();
    }
    public static UserEntity  UserDtoToEntity(UserRequestDto userDto){
        return UserEntity.builder()
                .userEmail(userDto.getUserEmail())
                .userPassword(userDto.getUserPassword())
                .accountBalance(userDto.getAccountBalance())
                .build();
    }
}
