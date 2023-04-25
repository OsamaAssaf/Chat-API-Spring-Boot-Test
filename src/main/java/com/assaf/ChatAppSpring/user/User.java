package com.assaf.ChatAppSpring.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.util.Date;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(nullable = false)
    private String username;
    @NaturalId
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(nullable = false)
    private boolean verified = false;
    @Column(name = "created_at",nullable = false)
    private Date createdAt = new Date();
    @Column(nullable = false)
    private String role = "ROLE_USER";

    public static User toEntity(UserDto dto){
        return User
                .builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
//                .password(dto.getPassword())
                .phoneNumber(dto.getPhoneNumber())
                .verified(false)
                .createdAt(new Date())
                .role("ROLE_USER")
                .build();
    }

}
