package com.omm.MYWEBAPP.controller;

import com.omm.MYWEBAPP.model.Product;
import com.omm.MYWEBAPP.service.productservice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class productcontroller {

   final private productservice productservice;
    @GetMapping ("/product")
    public List<Product> getProducts() {
        return productservice.getProducts();
    }
    @GetMapping ("/product/{id}")
    public Product getProductById(@PathVariable int id){
        return productservice.getProductById(id);
    }
    @GetMapping("/product/sort/{sortBy}")
    public List<Product> getProductSorted(
            @PathVariable String sortBy)
    {
        return  productservice.getProductSorted( sortBy);
    }
    @GetMapping("/product/sort/{sortBy}/{dir}")
    public List<Product> getProductSorted(
            @PathVariable String sortBy,
            @PathVariable String dir){
        return (List<Product>) productservice.getProductSorted( sortBy, dir);
    }
    @GetMapping("/product/page/{pageNo}/{pageSize}")
    public List<Product> getProductPaginated(
            @PathVariable int pageNo,
            @PathVariable int pageSize){
        return productservice.getProductPaginated(pageNo,pageSize).getContent();
    }
    @PostMapping("/product")
    public String addProduct(@RequestBody List<Product> product){
        return productservice.addProduct(product);
    }
    @PutMapping("/product")
    public String updateProduct(@RequestBody Product product){
        return productservice.updateProduct(product);

    }
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productservice.deleteProduct(id);
    }
    @DeleteMapping("/product/deleteall")
    public String deleteallProduct(){
        return productservice.deleteallProduct();
    }
}
