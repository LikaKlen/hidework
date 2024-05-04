package com.example.hidework.controllers;

import com.example.hidework.dal.DataAccessLayer;
import com.example.hidework.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/authorized")
public class AdminController {
    private final DataAccessLayer dataAccessLayer;//

    @Autowired
    public AdminController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }


    //USER

    @PostMapping("/newuser")
    public ResponseEntity addUser(@RequestBody User user) {

        dataAccessLayer.addUser(user);
        return ResponseEntity.ok("");

    }

    @DeleteMapping("deluser/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") long id) {
        dataAccessLayer.delUserById(id);
        return ResponseEntity.ok("");
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity updateUserById(@PathVariable("id") long id, @RequestBody User user) {
        dataAccessLayer.updateUser(id, user);
        return ResponseEntity.ok("");
    }

    //ROLE


    @PostMapping("/newrole")
    public ResponseEntity addRole(@RequestBody Role role) {
        dataAccessLayer.addRole(role);
        return ResponseEntity.ok("");

    }

    @DeleteMapping("/delrole/{id}")
    public ResponseEntity delRoleId(@PathVariable("id") long id) {
        dataAccessLayer.delRoleById(id);
        return ResponseEntity.ok("");
    }

    @PutMapping("/updaterole/{id}")
    public ResponseEntity updateRoleById(@PathVariable("id") long id, @RequestBody Role role) {
        dataAccessLayer.updateRole(id, role);
        return ResponseEntity.ok("");
    }

    //PRODUCT TYPE


    @PostMapping("/newproductType")
    public ResponseEntity addProductType(@RequestBody ProductType productType) {
        dataAccessLayer.addProductType(productType);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/delproductType")
    public ResponseEntity delProductType(@PathVariable("id") long id) {
        dataAccessLayer.delProductTypeId(id);
        return ResponseEntity.ok("");
    }

    @PutMapping("/upproducttype/{id}")
    public ResponseEntity updateProductType(@PathVariable("id") long id, @RequestBody ProductType productType) {
        dataAccessLayer.updateProductTypeId(id, productType);
        return ResponseEntity.ok("");
    }

    //PRODUCT


    @PostMapping("/newproduct")
    public ResponseEntity addProduct(@RequestBody Product product) {
        dataAccessLayer.addProduct(product);
        return ResponseEntity.ok("");

    }

    @DeleteMapping("/delproduct/{id}")
    public ResponseEntity delProduct(@PathVariable("id") long id) {
        dataAccessLayer.delProductId(id);
        return ResponseEntity.ok("");
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        dataAccessLayer.updateProductId(id, product);
        return ResponseEntity.ok("");
    }

    //SHOPPING BAG


    @PostMapping("/newshoppingBag")
    public ResponseEntity addShopingBag(@RequestBody ShoppingBag shoppingBag) {
        dataAccessLayer.addShoppingBug(shoppingBag);
        return ResponseEntity.ok("");

    }

    @DeleteMapping("/delshoppingbag/{id}")
    public ResponseEntity delShoppingBag(@PathVariable("id") long id) {
        dataAccessLayer.delShoppingBagId(id);
        return ResponseEntity.ok("");
    }

    @PutMapping("/upshoppingbag/{id}")
    public ResponseEntity updateShoppingBagId(@PathVariable("id") long id, @RequestBody ShoppingBag shoppingBag) {
        dataAccessLayer.updateShoppingBagId(id, shoppingBag);
        return ResponseEntity.ok("");
    }
}
