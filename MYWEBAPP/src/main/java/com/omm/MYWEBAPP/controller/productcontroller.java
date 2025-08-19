package com.omm.MYWEBAPP.controller;

import com.omm.MYWEBAPP.model.Product;
import com.omm.MYWEBAPP.service.ProductsInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController

public class productcontroller {

   final private ProductsInterface ProductsInterface;
    @GetMapping ("/product")
    public List<Product> getProducts() {
        return ProductsInterface.getProducts();
    }
    @GetMapping ("/product/{id}")
    public Product getProductById(@PathVariable int id){
        return ProductsInterface.getProductById(id);
    }
    @GetMapping("/product/sort/{sortBy}")
    public List<Product> getProductSorted(
            @PathVariable String sortBy)
    {
        return  ProductsInterface.getProductSorted( sortBy);
    }
    @GetMapping("/product/sort/{sortBy}/{dir}")
    public List<Product> getProductSorted(
            @PathVariable String sortBy,
            @PathVariable String dir){
        return (List<Product>) ProductsInterface.getProductSorted( sortBy, dir);
    }
    @GetMapping("/product/page/{pageNo}/{pageSize}")
    public List<Product> getProductPaginated(
            @PathVariable int pageNo,
            @PathVariable int pageSize){
        return ProductsInterface.getProductPaginated(pageNo,pageSize).getContent();
    }
    @PostMapping("/product")
    public String addProduct(@RequestBody List<Product> product){
        return ProductsInterface.addProduct(product);
    }
    @PutMapping("/product")
    public String updateProduct(@RequestBody Product product){
        return ProductsInterface.updateProduct(product);

    }
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Integer id){
        ProductsInterface.deleteProduct(id);
    }
    @DeleteMapping("/product/deleteall")
    public String deleteallProduct(){
        return ProductsInterface.deleteallProduct();
    }
}
