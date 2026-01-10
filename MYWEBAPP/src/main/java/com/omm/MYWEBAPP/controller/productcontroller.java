package com.omm.MYWEBAPP.controller;

import com.omm.MYWEBAPP.model.Product;
import com.omm.MYWEBAPP.service.ProductsInterface;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class productcontroller {

   @Autowired
   private ProductsInterface productsInterface;
    @GetMapping ("/product")
    @Operation(summary = "Get all products",description = "Get all products" )
    public List<Product> getProducts() {
        return productsInterface.getProducts();
    }
    @GetMapping ("/product/{id}")
    public Product getProductById(@PathVariable int id){
        return productsInterface.getProductById(id);
    }
    @GetMapping("/product/sort/{sortBy}")
    public List<Product> getProductSorted(
            @PathVariable String sortBy)
    {
        return  productsInterface.getProductSorted( sortBy);
    }
    @GetMapping("/product/sort/{sortBy}/{dir}")
    public List<Product> getProductSorted(
            @PathVariable String sortBy,
            @PathVariable String dir){
        return (List<Product>) productsInterface.getProductSorted( sortBy, dir);
    }
    @GetMapping("/product/page/{pageNo}/{pageSize}")
    public List<Product> getProductPaginated(
            @PathVariable int pageNo,
            @PathVariable int pageSize){
        return productsInterface.getProductPaginated(pageNo,pageSize).getContent();
    }
    @PostMapping("/product")
    public String addProduct(@RequestBody List<Product> product){
        return productsInterface.addProduct(product);
    }
    @PutMapping("/product")
    public String updateProduct(@RequestBody Product product){
        return productsInterface.updateProduct(product);

    }
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productsInterface.deleteProduct(id);
    }
    @DeleteMapping("/product/deleteall")
    public String deleteallProduct(){
        return productsInterface.deleteallProduct();
    }
}
