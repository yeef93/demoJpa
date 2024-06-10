package com.yeef93.demoJpa.user.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 200)
    private String username;

    @Column(name = "email", nullable = false, length = 200)
    private String email;

    @Column(name = "salt", nullable = false, length = 64)
    private String salt;

    @Column(name = "hash", length = 64)
    private String hash;

    @Column(name = "create_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createAt;

    @Column(name = "update_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp updateAt;

    @Column(name = "delete_at", columnDefinition = "TIMESTAMP")
    private Timestamp deleteAt;

    @Column(name = "isfinish_onboarding", nullable = false, columnDefinition = "CHAR(1) DEFAULT '0'")
    private char isFinishOnboarding;

    @Column(name = "pin")
    private String pin;

    @Column(name = "language", length = 4)
    private String language;

    @Column(name = "quotes")
    private String quotes;

    @Column(name = "profilepict")
    private String profilePict;
}
