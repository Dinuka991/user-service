package com.user.management.controller;

import com.user.management.builder.UserDtoBuilder;
import com.user.management.dao.UserRepository;
import com.user.management.dto.UserDto;
import com.user.management.modal.User;
import com.user.management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-service")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;
    private final UserRepository userRepository;


    @PostMapping("/user")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){

        return new ResponseEntity<>( userService.saveUser(userDto), HttpStatus.OK);
    }

    @GetMapping("/users")
    public  ResponseEntity<List<UserDto>> users(){
        return new ResponseEntity<>(userService.users(),HttpStatus.OK);
    }
}
