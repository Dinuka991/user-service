package com.user.management.service.impl;

import com.user.management.builder.UserDtoBuilder;
import com.user.management.dao.UserRepository;
import com.user.management.dto.UserDto;
import com.user.management.modal.User;
import com.user.management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDtoBuilder userDtoBuilder;
    private final UserRepository userRepository;


    @Override
    public UserDto saveUser(UserDto userDto) {
        User savedUser =  userRepository.save(userDtoBuilder.build(userDto));
        return  userDtoBuilder.build(savedUser);
    }

    @Override
    public List<UserDto> users() {
        return  userDtoBuilder.build(userRepository.findAll()) ;
    }
}
