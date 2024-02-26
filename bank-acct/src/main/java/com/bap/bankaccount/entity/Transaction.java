package com.bap.bankaccount.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "Type cannot be blank")
    @NonNull
    @Column(name = "type")
    private String type;

    @NotBlank(message = "amount cannot be blank")
    @NonNull
    @Column(name = "amount")
    private Double amount;

    @NotBlank(message = "Description cannot be blank")
    @NonNull
    @Column(name = "description")
    private String description;

    @NotBlank(message = "Date cannot be blank")
    @NonNull
    @Column(name = "date")
    private Date transactionDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    
}
