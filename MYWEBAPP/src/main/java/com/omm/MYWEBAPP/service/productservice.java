package com.omm.MYWEBAPP.service;

import com.omm.MYWEBAPP.model.Product;
import com.omm.MYWEBAPP.repo.Productrepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class productservice {
    @Autowired
    Productrepo productrepo;

    public productservice(Productrepo productrepo) {
        this.productrepo = productrepo;
    }

    //  List<product> product= new ArrayList<>(Arrays.asList(new product("Iphone","56000","Its an Iphone",56),
               // new product("Vioo","42000","Its  a vivo phone",24),
              //  new product("Iqoo","78000","Its a iqoo phone",82)));
        public List<Product> getProducts() {
            return productrepo.findAll();
        }
        public Product getProductById(int id){
        return productrepo.findById(id).orElse(new Product());
    }
    public List<Product>addProduct(List<Product> product){

       return productrepo.saveAll(product);

    }
    public void updateProduct(Product product){
      productrepo.save(product);
    }
    public void deleteProduct(int id){
        productrepo.deleteById(id);
    }
    public String deleteProduct(Product product){
        productrepo.delete(product);
        return "Product Deleted";
    }
    public List<Product> getProductSorted( String sortBy){
        return productrepo.findAll(Sort.by(sortBy));
    }
    public List<Product> getProductSorted( String sortBy, String dir){
        Sort sort=dir.equalsIgnoreCase("asc")? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        return productrepo.findAll(sort);
    }


}
