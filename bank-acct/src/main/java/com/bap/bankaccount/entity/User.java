package com.bap.bankaccount.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    
    private Long id;

    private String username;

    private String password;
}
