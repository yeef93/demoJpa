package com.yeef93.demoJpa.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_user_id_gen")
    @SequenceGenerator(name = "tbl_user_id_gen", sequenceName = "tbl_user_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false, length = 200)
    private String username;

    @Column(name = "email", nullable = false, length = 200)
    private String email;

    @Column(name = "salt", nullable = false, length = 64)
    private String salt;

    @Column(name = "hash", length = 64)
    private String hash;

    @CreationTimestamp
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "create_at", nullable = false, updatable = false)
    private Date createAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private Date updateAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "delete_at")
    private Date deleteAt;

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

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Wallet> wallet = new HashSet<>();
}
