package com.yeef93.demoJpa.pocket.entity;

import com.yeef93.demoJpa.wallet.entity.Wallet;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbl_pocket")
public class Pocket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_pocket_id_gen")
    @SequenceGenerator(name = "tbl_pocket_id_gen", sequenceName = "tbl_pocket_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "name is required" )
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "descr", nullable = false, length = 100)
    private String descr;

    @NotNull(message = "currency is required")
    @Column(name = "currency_id", nullable = false)
    private Integer currency;

    @NotNull(message = "budget is required")
    @Min(value = 0, message = "Budget must be non-negative")
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
    @JoinColumn(name = "wallet_id", referencedColumnName = "id", nullable = false)
    private Wallet wallet;

    @Column(name = "emoji", nullable = false, length = 100)
    private String emoji;
}
