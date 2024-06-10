package com.yeef93.demoJpa.wallet.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.Date;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_wallet")
@SQLRestriction("delete_at IS NULL")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotBlank(message = "wallet name is required")
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Size(max = 5)
    @NotBlank(message = "currency is required")
    @Column(name = "currency", nullable = false, length = 5)
    private String currency;

    @NotBlank(message = "amount is required")
    @Min(value = 0, message = "Amount must be non-negative")
    @Column(name = "amount", nullable = false)
    private Double amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at", nullable = false, updatable = false)
    private Date createAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at", nullable = false)
    private Date updateAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "delete_at")
    private Date deleteAt;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private Long userId;

    @PrePersist
    protected void onCreate(){
        createAt = new Date();
        updateAt = new Date();
    }

    @PreUpdate
    protected  void onUpdate(){
        updateAt = new Date();
    }
}
