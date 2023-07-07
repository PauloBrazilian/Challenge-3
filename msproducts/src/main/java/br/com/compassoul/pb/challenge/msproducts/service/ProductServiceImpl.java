package br.com.compassoul.pb.challenge.msproducts.service;

import br.com.compassoul.pb.challenge.msproducts.exceptions.ProductExceptions;
import br.com.compassoul.pb.challenge.msproducts.models.Category;
import br.com.compassoul.pb.challenge.msproducts.models.Product;
import br.com.compassoul.pb.challenge.msproducts.repository.CategoryRepository;
import br.com.compassoul.pb.challenge.msproducts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;


    private CategoryRepository categoryRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product productSave(Product productProps) {
        LocalDateTime date = productProps.getDate();
        String description = productProps.getDescription();
        String productName = productProps.getProductName();
        String imgUrl = productProps.getImgUrl();
        BigDecimal price = productProps.getPrice();
        List<Category> categories = productProps.getCategories();

        if (date == null || description == null || productName == null || imgUrl == null || price == null || categories == null) {
            throw new ProductExceptions.ProductException("Todos os campos devem ser completados");
        } else {
            Product savedproduct = new Product();
            savedproduct.setDate(date);
            savedproduct.setDescription(description);
            savedproduct.setProductName(productName);
            savedproduct.setImgUrl(imgUrl);
            savedproduct.setPrice(price);

            List<Category> savedCategories = new ArrayList<>();
            for (Category category : categories) {
                if (category.getCategoryId() == null) {
                    savedCategories.add(categoryRepository.save(category));
                } else {
                    savedCategories.add(category);
                }
            }
            savedproduct.setCategories(savedCategories);
            return productRepository.save(savedproduct);
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

            LocalDateTime newDate = productProps.getDate();
            String newDescription = productProps.getDescription();
            String newProductname = productProps.getProductName();
            String newImgUrl = productProps.getImgUrl();
            BigDecimal newPrice = productProps.getPrice();
            List<Category> newCategory = productProps.getCategories();

            if (newDate == null || newDescription == null || newProductname == null || newImgUrl == null || newPrice == null || newCategory == null) {
                throw new ProductExceptions.ProductException("Todos os campos devem ser preenchidos");
            }

            List<Category> savedCategories = new ArrayList<>();
            for (Category category : newCategory) {
                if (category.getCategoryId() == null) {
                    savedCategories.add(categoryRepository.save(category));
                } else {
                    savedCategories.add(category);
                }
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