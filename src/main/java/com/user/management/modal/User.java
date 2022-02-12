package com.user.management.modal;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class User extends Audit<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userName;

    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;



    @ManyToMany
    @ToString.Exclude
    private List<Department> departments;



}
