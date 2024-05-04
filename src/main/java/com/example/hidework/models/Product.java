package com.example.hidework.models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@Table(name = "product",schema = "schema", catalog = "postgres")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int productId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "count")
    private int count;
    @Column(name = "material")
    private String material;
    @Column(name = "price")
    private int price;
    @ManyToOne
    @JoinColumn(name = "producttype_id",referencedColumnName = "producttypeid")
    private ProductType productType;
}

