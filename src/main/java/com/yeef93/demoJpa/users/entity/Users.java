package com.yeef93.demoJpa.users.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_user_id_gen")
    @SequenceGenerator(name = "tbl_user_id_gen", sequenceName = "tbl_user_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 200)
    @Column(name = "username", nullable = false, length = 200)
    private String username;

    @Size(max = 200)
    @NotNull
    @Column(name = "email", nullable = false, length = 200)
    private String email;

    @CreationTimestamp
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updateAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_at")
    private Date deleteAt;

//    @NotNull
//    @ColumnDefault("0")
//    @Column(name = "isfinish_onboarding", nullable = false, columnDefinition = "CHAR(1) DEFAULT '0'")
//    private char isFinishOnboarding;

    @Column(name = "pin")
    private String pin;


    @Column(name = "language", length = 4)
    @ColumnDefault("EN")
    private String language;

    @Column(name = "quotes")
    private String quotes;

    @Column(name = "avatar")
    private String avatar;

    @JsonIgnore
    @Size(max = 100)
    @NotNull
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "active_currency", nullable = false)
    private Integer activeCurrency;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Wallet> wallet = new HashSet<>();
}
