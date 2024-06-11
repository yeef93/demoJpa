package com.yeef93.demoJpa.currency.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tbl_currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_currency_id_gen")
    @SequenceGenerator(name = "tbl_currency_id_gen", sequenceName = "tbl_currency_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 3)
    private String name;

    @Column(name = "symbol", nullable = false, length = 5)
    private String symbol;

}
