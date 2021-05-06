package org.cap.account.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data @AllArgsConstructor @ToString
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private Double amount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTransaction;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "REF_ACCOUNT")
    private Account account;

    public Transaction() {
    }

    public Transaction(Double amount, Date dateTransaction, Account account) {
        this.amount = amount;
        this.dateTransaction = dateTransaction;
        this.account = account;
    }


}
