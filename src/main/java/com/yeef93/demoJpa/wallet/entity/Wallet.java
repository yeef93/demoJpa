package com.yeef93.demoJpa.wallet.entity;

import com.yeef93.demoJpa.users.entity.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_wallet_id_gen")
    @SequenceGenerator(name = "tbl_wallet_id_gen", sequenceName = "tbl_wallet_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Size(max = 255)
    @NotBlank(message = "wallet name is required")
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @NotNull(message = "currency is required")
    @Column(name = "currency_id", nullable = false)
    private Integer currency;

    @NotNull(message = "amount is required")
    @Min(value = 0, message = "Amount must be non-negative")
    @Column(name = "amount", nullable = false)
    private Double amount;

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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private Users user;
}
