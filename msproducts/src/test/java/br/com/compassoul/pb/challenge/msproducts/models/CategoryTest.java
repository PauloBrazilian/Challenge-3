package br.com.compassoul.pb.challenge.msproducts.models;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void testToString() {
        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("Admin");

        String categoryTest = category.toString();

        assertEquals("Category{" +
                "categoryId=" + null +
                ", categoryName='" + null + '\'' +
                ", products=" + null +
                '}', categoryTest);
    }

    @Test
    void getCategoryId() {
        Category category = new Category();
        Integer categoryId = 1;
        category.setCategoryId(categoryId);
        assertEquals(1, category.getCategoryId());
    }

    @Test
    void getCategoryName() {
        Category category = new Category();
        String name = category.getCategoryName();
        assertNull(name);
    }

    @Test
    void getProducts() {
        Category category = new Category();
        String name = category.getCategoryName();
        assertNull(name);
    }

    @Test
    void setCategoryId() {
        Category category = new Category();
        Integer Id = 1;
        category.setCategoryId(Id);
        assertEquals(1, category.getCategoryId());
    }

    @Test
    void setCategoryName() {
        Category category = new Category();
        String name = "Paulo";
        category.setCategoryName(name);
        assertEquals("Paulo", category.getCategoryName());
    }

    @Test
    void setProducts() {
        Category category = new Category();
        List<Product> productList = category.getProducts();
        category.setProducts(productList);
        assertEquals(productList, category.getProducts());
    }
}