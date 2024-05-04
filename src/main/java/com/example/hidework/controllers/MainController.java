package com.example.hidework.controllers;

import com.example.hidework.dal.DataAccessLayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")//используется для управления запросами к внешним ресурсам
@RequestMapping("/unauthorized")
public class MainController {
    private final DataAccessLayer dataAccessLayer;
    @Autowired
    public MainController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }

    @GetMapping("/users")
    public ResponseEntity getUser() {
        return ResponseEntity.ok(dataAccessLayer.getUsers());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUserById(@PathVariable("id") long id) {
        return ResponseEntity.ok(dataAccessLayer.getUserId(id));
    }
    @GetMapping("/roles")
    public ResponseEntity getRoles() {
        return ResponseEntity.ok(dataAccessLayer.getRoles());
    }

    @GetMapping("/role/{id}")
    public ResponseEntity getRoleId(@PathVariable("id") long id) {
        return ResponseEntity.ok(dataAccessLayer.getRoleId(id));
    }
    @GetMapping("/productsTypes")
    public ResponseEntity getProductsTypes() {
        return ResponseEntity.ok(dataAccessLayer.getProductsTypes());
    }
    @GetMapping("/productTypr/{id}")
    private ResponseEntity getProductType(@PathVariable("id") long id) {
        return ResponseEntity.ok(dataAccessLayer.getProductTypeId(id));
    }
    @GetMapping("/product/{id}")
    public ResponseEntity getProduct(@PathVariable("id") long id) {
        return ResponseEntity.ok(dataAccessLayer.getProductId(id));
    }
    @GetMapping("/products")
    public ResponseEntity getProducts() {
        return ResponseEntity.ok(dataAccessLayer.getProducts());
    }
    @GetMapping("/shoppingBag")
    public ResponseEntity getShoppingBag() {
        return ResponseEntity.ok(dataAccessLayer.getShoppingBag());
    }
    @GetMapping("/shoppingBag/{id}")
    public ResponseEntity getShoppingBagId(@PathVariable("id") long id) {
        return ResponseEntity.ok(dataAccessLayer.getShoppingBagId(id));
    }
}
