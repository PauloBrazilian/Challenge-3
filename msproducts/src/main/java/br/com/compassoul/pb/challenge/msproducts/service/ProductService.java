package br.com.compassoul.pb.challenge.msproducts.service;

import br.com.compassoul.pb.challenge.msproducts.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    public List<Product> findByProductId();
    public ResponseEntity<Product> productSave(Product productProps);
    public ResponseEntity<Product> findProductById(Integer productId);
    public Product productUpdate(Integer productId, Product productProps);
    public ResponseEntity<Product> productDelete(Integer productId);

}