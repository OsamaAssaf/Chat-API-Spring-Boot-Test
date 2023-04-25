package com.assaf.ChatAppSpring.user;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long userId;
    private String username;
    private String email;
    private String phoneNumber;
    private boolean verified;
    private Date createdAt;
    private String role;

    public static UserDto toDto(User entity){
        return UserDto
                .builder()
                .userId(entity.getUserId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .verified(entity.isVerified())
                .createdAt(entity.getCreatedAt())
                .role(entity.getRole())
                .build();
    }

}
