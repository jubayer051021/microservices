package com.bjit.userapp.service;

import com.bjit.userapp.dto.UserRequestDto;
import com.bjit.userapp.dto.UserResponseDto;
import com.bjit.userapp.entity.UserEntity;
import com.bjit.userapp.mapper.MappingModel;
import com.bjit.userapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public UserResponseDto addUser(UserRequestDto userDto) {
        UserEntity userEntity= MappingModel.UserDtoToEntity(userDto);
        return  MappingModel.UserEntityToDto( userRepository.save(userEntity));
    }

    public List<UserResponseDto> getAllUser() {
        List<UserEntity> userEntity=userRepository.findAll();
        return userEntity.stream().map(MappingModel::UserEntityToDto).toList();
    }

    public UserResponseDto getUserDetails(Integer userId) {
        UserEntity userEntity= userRepository.findByUserId(userId);
        return MappingModel.UserEntityToDto(userEntity);
    }

    public String withdrawMoney(Integer userId,Integer amount) {
        UserEntity userEntity= userRepository.findByUserId(userId);
        if(userEntity!=null&& userEntity.getAccountBalance()>=amount){
            userEntity.setAccountBalance(userEntity.getAccountBalance()-amount);
            userRepository.save(userEntity);
            return amount+" Withdraw successFully";
        }
        return amount+" Can't Withdraw";
    }

    public String refundMoney(Integer userId, Integer amount) {
        UserEntity userEntity= userRepository.findByUserId(userId);
        userEntity.setAccountBalance(userEntity.getAccountBalance()+amount);
        userRepository.save(userEntity);
        return amount+" refund SuccessFully";
    }
}
