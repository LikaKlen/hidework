package com.example.hidework.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "shoppingbag", schema = "schema", catalog = "postgres")
public class ShoppingBag {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int shoppingBagId;
    @Column(name = "count")
    private String count;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "userid")
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "productid")
    private Product product;
}
