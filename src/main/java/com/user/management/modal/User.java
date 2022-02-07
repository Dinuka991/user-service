package com.user.management.modal;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User extends Audit<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String userName;

    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;


    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    @ManyToMany
    private List<Department> departments;



}
