package org.cap.account.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;


@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Transactional
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 70)
    private String designation;
    private double price;
    private int quantity;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "category_id_cat")
    private Category category;

    public Product(String designation, double price, int quantity) {
        this.designation = designation;
        this.price = price;
        this.quantity = quantity;
    }
    public Product(String designation, double price, int quantity,Category category) {
        this.designation = designation;
        this.price = price;
        this.quantity = quantity;
        this.category=category;
    }
}
