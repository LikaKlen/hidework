package com.example.hidework.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Data
@Table(name = "role",schema = "schema", catalog = "postgres")
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long roleId;
    @Column(name = "roleName")
    private String roleName;

    @JsonIgnore
    private List<User> user;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;
}
