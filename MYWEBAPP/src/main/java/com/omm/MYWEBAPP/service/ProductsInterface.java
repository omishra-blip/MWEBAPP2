package com.omm.MYWEBAPP.service;

import com.omm.MYWEBAPP.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductsInterface {
    List<Product> getProducts();

    Product getProductById(int id);

    String addProduct(List<Product> product);

    String updateProduct(Product product);

    String deleteProduct(int id);

    String deleteallProduct();

    List<Product> getProductSorted(String sortBy);

    List<Product> getProductSorted(String sortBy, String dir);

    Page<Product> getProductPaginated(int pageNo, int pageSize);
}
