package br.com.compassoul.pb.challenge.msproducts.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(value = MockitoExtension.class)
class ProductTest {

    @Test
    void testToString() {
        Product product = new Product();
        product.setProductId(1);
        product.setDate(LocalDateTime.of(2020, 2, 2,22,22));
        product.setDescription("Paulo");
        product.setProductName("Paulo");
        product.setImgUrl("Paulo");
        product.setCategories(getCategories());

        String productTest = product.toString();

        assertEquals("Product{" +
                "productId=" + null +
                ", date=" + null +
                ", description=" + null +
                ", productName=" + null +
                ", imgUrl= " + null +
                ", price=" + null +
                ", category=" + null +
                '}', productTest);
    }

    @Test
    void getProductId() {
        Product product = new Product();
        Integer productId = 1;
        product.setProductId(productId);
        assertEquals(1, product.getProductId());
    }

    @Test
    void getDate() {
        Product product = new Product();
        LocalDateTime date = product.getDate();
        assertNull(date);
    }

    @Test
    void getDescription() {
        Product product = new Product();
        String description = product.getDescription();
        assertNull(description);
    }

    @Test
    void getProductName() {
        Product product = new Product();
        String name = product.getProductName();
        assertNull(name);
    }

    @Test
    void getImgUrl() {
        Product product = new Product();
        String url = product.getImgUrl();
        assertNull(url);
    }

    @Test
    void getPrice() {
        Product product = new Product();
        BigDecimal price = product.getPrice();
        assertNull(price);
    }

    @Test
    List<Category> getCategories(){
        Product product = new Product();
        List<Category> categories = product.getCategories();
        assertNull(categories);
        return categories;
    }

    @Test
    void setProductId() {
        Product product = new Product();
        Integer productId = 1;
        product.setProductId(productId);
        assertEquals(1, product.getProductId());
    }

    @Test
    void setDate() {
        Product product = new Product();
        LocalDateTime productDate = LocalDateTime.of(2020, 2, 2,22,22);
        product.setDate(productDate);
        assertEquals(LocalDateTime.parse("2020-02-02"), product.getDate());
    }

    @Test
    void setDescription() {
        Product product = new Product();
        String productDescription = "Paulo";
        product.setDescription(productDescription);
        assertEquals("Paulo", product.getDescription());
    }

    @Test
    void setProductName() {
        Product product = new Product();
        String productName = "Paulo";
        product.setProductName(productName);
        assertEquals("Paulo", product.getProductName());
    }

    @Test
    void setImgUrl() {
        Product product = new Product();
        String productUrl = "Paulo";
        product.setImgUrl(productUrl);
        assertEquals("Paulo", product.getImgUrl());
    }

    @Test
    void setPrice() {
        Product product = new Product();
        BigDecimal productPrice = BigDecimal.valueOf(100.0);
        product.setPrice(productPrice);
        assertEquals(BigDecimal.valueOf(100.0), product.getPrice());
    }

    @Test
    void setCategories() {
        Product product = new Product();
        List<Category> categories = product.getCategories();
        product.setCategories(categories);
        assertEquals(categories, product.getCategories());
    }
}