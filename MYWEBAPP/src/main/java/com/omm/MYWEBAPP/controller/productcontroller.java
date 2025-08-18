package com.omm.MYWEBAPP.controller;

import com.omm.MYWEBAPP.model.Product;
import com.omm.MYWEBAPP.service.productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productcontroller {
    @Autowired
    private productservice productservice;
    @GetMapping ("/product")
    public List<Product> getProducts() {
        return productservice.getProducts();
    }
    @GetMapping ("/product/{id}")
    public Product getProductById(@PathVariable int id){
        return productservice.getProductById(id);
    }
    @GetMapping("/products/page")
    public List<Product> getProductSorted(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String dir
               ){
        return (List<Product>) productservice.getProductSorted( sortBy, dir);
    }
    @PostMapping("/product")
    public List<Product> addProduct(@RequestBody List<Product> product){
        return productservice.addProduct(product);
    }
    @PutMapping("/product")
    public void updateProduct(@RequestBody Product product){
        productservice.updateProduct(product);
    }
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productservice.deleteProduct(id);
    }
}
