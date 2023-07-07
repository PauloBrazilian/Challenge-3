package br.com.compassoul.pb.challenge.msproducts.controller;


import br.com.compassoul.pb.challenge.msproducts.models.Product;
import br.com.compassoul.pb.challenge.msproducts.service.ProductService;
import br.com.compassoul.pb.challenge.msproducts.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("/product")
    public List<Product> findAllProducts(){
        return productServiceImpl.findAllProducts();
    }

    @PostMapping("/product")
    public Product productSave(@RequestBody Product productProps){
        return productServiceImpl.productSave(productProps);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> findProductById(@PathVariable Integer productId){
        return productServiceImpl.findProductById(productId);
    }

    @PutMapping("/product/{productId}")
    public Product productUpdate(@PathVariable Integer productId,@RequestBody Product productProps){
        return productServiceImpl.productUpdate(productId, productProps);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Product> productDelete(@PathVariable  Integer productId){
        return productServiceImpl.productDelete(productId);
    }

}