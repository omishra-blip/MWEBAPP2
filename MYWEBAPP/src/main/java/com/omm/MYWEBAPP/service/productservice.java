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
public class productservice implements ProductsInterface {

    private final Productrepo productrepo;

    @Autowired
    public productservice(Productrepo productrepo) {
        this.productrepo = productrepo;
    }

    //  List<product> product= new ArrayList<>(Arrays.asList(new product("Iphone","56000","Its an Iphone",56),
               // new product("Vioo","42000","Its  a vivo phone",24),
           //  new product("Iqoo","78000","Its a iqoo phone",82)));

    @Override
    public List<Product> getProducts(){
        return productrepo.findAll();
    }
    @Override
    public Product getProductById(int id){
        return productrepo.findById(id).orElse(new Product());
    }

    @Override
    public String addProduct(List<Product> product){

          productrepo.saveAll(product);
          return"Products added successfully";


    }

    @Override
    public String updateProduct(Product product){
      productrepo.save(product);
      return " product Updated";
    }

    @Override
    public String deleteProduct(int id){
        productrepo.deleteById(id);
        return "Product Deleted";
    }

    @Override
    public String deleteallProduct(){
        productrepo.deleteAll();
        return " all Product Deleted";
    }

    @Override
    public List<Product> getProductSorted(String sortBy){
        return productrepo.findAll(Sort.by(sortBy));
    }

    @Override
    public List<Product> getProductSorted(String sortBy, String dir){
        Sort sort=dir.equalsIgnoreCase("asc")? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        return productrepo.findAll(sort);
    }

    @Override
    public Page<Product> getProductPaginated(int pageNo, int pageSize){
        Pageable pageable=PageRequest.of(pageNo-1,pageSize);
        return productrepo.findAll(pageable);
    }


}
