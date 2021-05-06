package org.cap.account.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@ToString

public class Client  implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String firstName;
    private String lastName;
    @JsonIgnore
    @OneToMany(mappedBy = "client", orphanRemoval = true, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Collection<Account> accounts;




    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Client(Long idClient,String firstName, String lastName) {
        this.clientId=idClient;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
