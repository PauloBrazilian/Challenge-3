package br.com.compassoul.pb.challenge.msproducts.service;

import br.com.compassoul.pb.challenge.msproducts.exceptions.ProductExceptions;
import br.com.compassoul.pb.challenge.msproducts.models.Category;
import br.com.compassoul.pb.challenge.msproducts.models.Product;
import br.com.compassoul.pb.challenge.msproducts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ResponseEntity<Product> productSave(Product productProps) {
        Date date = productProps.getDate();
        String description = productProps.getDescription();
        String productname = productProps.getProductName();
        String imgUrl = productProps.getImgUrl();
        String price = productProps.getPrice();
        List<Category> category = productProps.getCategories();

        if ( date == null || description == null ||  productname == null || imgUrl == null || price == null || category == null){
            throw new ProductExceptions.ProductException("Todos os campos devem ser completados");
        } else {
            Product savedproduct = productRepository.save(productProps);
            return ResponseEntity.ok(savedproduct);
        }
    }

    @Override
    public ResponseEntity<Product> findProductById(Integer productId) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()){
            Product product = productOptional.get();
            return ResponseEntity.ok(product);
        }else {
            throw new ProductExceptions.ProductNotFoundException("Product " + productId + " invalido");
        }
    }

    @Override
    public Product productUpdate(Integer productId, Product productProps) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            Date newDate = productProps.getDate();
            String newDescription = productProps.getDescription();
            String newProductname = productProps.getProductName();
            String newImgUrl = productProps.getImgUrl();
            String newPrice = productProps.getPrice();
            List<Category> newCategory = productProps.getCategories();

            if (newDate == null || newDescription == null || newProductname == null || newImgUrl == null || newPrice == null || newCategory == null) {
                throw new ProductExceptions.ProductException("Todos os campos devem ser preenchidos");
            }

            product.setDate(newDate);
            product.setDescription(newDescription);
            product.setProductName(newProductname);
            product.setImgUrl(newImgUrl);
            product.setPrice(newPrice);
            product.setCategories(newCategory);

            return productRepository.save(product);
        } else {
            throw new ProductExceptions.ProductNotFoundException("Usuário " + productId + " não encontrado");
        }
    }

    public ResponseEntity<Product> productDelete(Integer productId) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            productRepository.deleteById(productId);
            return ResponseEntity.ok().build();
        } else {
            throw new ProductExceptions.ProductNotFoundException("Produto" + productId + " não encontrado");
        }
    }
}