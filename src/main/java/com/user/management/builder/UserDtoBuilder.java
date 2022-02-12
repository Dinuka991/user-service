package com.user.management.builder;

import com.user.management.dto.UserDto;
import com.user.management.modal.Department;
import com.user.management.modal.User;
import com.user.management.modal.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDtoBuilder {


    public User build(UserDto userDto) {
        User user = new User();
        UserRole userRole = new UserRole();
        List<Department> departments = new ArrayList<>();

        if(userDto.getId() > 0 ){
            user.setId(userDto.getId());
        }

        if( userDto.getDepartments() != null) {
            for (Long id : userDto.getDepartments()) {
                Department department = new Department();
                department.setId(id);
                departments.add(department);
            }
            user.setDepartments(departments);
        }
        user.setUserName(userDto.getUserName());

       if(userDto.getRoleId() != null) {
           userRole.setId(userDto.getRoleId());
           user.setUserRole(userRole);
       }

        return user;
    }


    public UserDto build(User user){

        UserDto userDto = new UserDto();
        List<Long> ids = new ArrayList<>();


        userDto.setUserName(user.getUserName());
        userDto.setId(user.getId());

       if(user.getDepartments() != null) {
           user.getDepartments().forEach(data -> ids.add(data.getId()));
           userDto.setDepartments(ids);
       }
       if(user.getUserRole() != null) {
           userDto.setRoleId(user.getUserRole().getId());
           userDto.setId(user.getId());
       }

        return userDto;
    }

    public List<UserDto> build(List<User> userList){

        List<UserDto> userDtoList = new ArrayList<>();

        userList.forEach(data -> {
            UserDto userDto = new UserDto();
            List<Long> ids = new ArrayList<>();

            if(data.getDepartments() != null) {
                data.getDepartments().forEach(data2 -> ids.add(data2.getId()));
            }
            userDto.setUserName(data.getUserName());
            userDto.setDepartments(ids);

            if(data.getUserRole() != null) {
                userDto.setRoleId(data.getUserRole().getId());
                userDto.setId(data.getId());
            }

            userDtoList.add(userDto);
        });
        return userDtoList;
    }

}
