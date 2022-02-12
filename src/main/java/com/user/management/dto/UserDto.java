package com.user.management.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserDto {


    private long id;
    private String userName;
    private Long roleId;
    private List<Long> departments;

}
