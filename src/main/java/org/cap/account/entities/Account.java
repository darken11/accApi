package org.cap.account.entities;


import lombok.Data;
import lombok.ToString;
import org.cap.account.constants.ApiConstants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data @ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_ACCOUNT", discriminatorType = DiscriminatorType.STRING, length = 2)

public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "REF_CLIENT")
    private Client client;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Collection<Transaction> transactions;

    public Account() {

    }

    public Account(Double balance, Client client, Collection<Transaction> transactions) {
        this.balance = balance;
        this.client = client;
        this.transactions = transactions;
    }

    public Account(Client client) {
        this.client = client;
        this.balance = ApiConstants.zero;
        this.transactions = new ArrayList<>();
    }
}
