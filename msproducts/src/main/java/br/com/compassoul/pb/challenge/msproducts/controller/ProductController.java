package br.com.compassoul.pb.challenge.msproducts.controller;


import br.com.compassoul.pb.challenge.msproducts.models.Product;
import br.com.compassoul.pb.challenge.msproducts.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v2")
public class ProductController {

    @Autowired
    private ProductService productService;

    public List<Product> findAllProducts(){
        return productService.findAllProducts();
    }

    public ResponseEntity<Product> productSave(Product productProps){
        return productService.productSave(productProps);
    }

    public ResponseEntity<Product> findProductById(Integer productId){
        return productService.findProductById(productId);
    }

    public Product productUpdate(Integer productId, Product productProps){
        return productService.productUpdate(productId, productProps);
    }

    public ResponseEntity<Product> productDelete(Integer productId){
        return productService.productDelete(productId);
    }

}