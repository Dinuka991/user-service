package com.user.management.service;

import com.user.management.dto.UserDto;
import com.user.management.modal.User;

import java.util.List;

public interface UserService {


    UserDto saveUser(UserDto userDto);
    List<UserDto> users();
}
