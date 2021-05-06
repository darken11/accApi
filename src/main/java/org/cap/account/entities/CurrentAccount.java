package org.cap.account.entities;

import lombok.Data;
import lombok.ToString;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Collection;

@Entity
@Data
@ToString
@DiscriminatorValue("CC")
public class CurrentAccount extends Account {
    public CurrentAccount() {

    }

    public CurrentAccount(Double balance, Client client, Collection<Transaction> transactions) {
        super(balance, client, transactions);
    }

    public CurrentAccount(Client client) {
        super(client);
    }

}
