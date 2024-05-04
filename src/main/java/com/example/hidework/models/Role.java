package com.example.hidework.models;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "role",schema = "schema", catalog = "postgres")
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long roleId;
    @Column(name = "roleName")
    private String roleName;


}
