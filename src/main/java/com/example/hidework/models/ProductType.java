package com.example.hidework.models;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "producttype",schema = "schema", catalog = "postgres")
public class ProductType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int productTypeId;
    @Column(name = "productTypeName")
    private String productTypeName;
}
