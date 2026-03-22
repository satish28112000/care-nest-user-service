package com.carenest.user_service.model.entity;

import com.carenest.user_service.model.common.Auditable;
import com.carenest.user_service.model.enums.Role;
import com.carenest.user_service.model.enums.Status;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "users",
       uniqueConstraints = {@UniqueConstraint(columnNames = "email"),
                           @UniqueConstraint(columnNames = "phone1")})
public class User extends Auditable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "user_name")
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone1;

    private String phone2;
//    private String encrypted_password;
//    the roles will be (PATIENT, DOCTOR , NURSE, ADMIN)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;

}
