package com.example.hidework.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "shoppingbag", schema = "schema", catalog = "postgres")
public class ShoppingBag {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long shoppingBagId;
    @Column(name = "count")
    private int count;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "userid")
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "productid")
    private Product product;
    public ShoppingBag() {}

    public ShoppingBag(int count,User user, Product product) {
        this.count=count;
        this.user = user;
        this.product = product;
    }
}
