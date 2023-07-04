package br.com.compassoul.pb.challenge.msproducts.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product_Category")
public class Product_Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_categoryId;

    @Column(name = "productId")
    private Product productId;

    @Column(name = "categoryId")
    private Product categoryId;

    @Override
    public String toString() {
        return "Product_Category{" +
                "product_categoryId=" + product_categoryId +
                ", productId=" + productId +
                ", categoryId=" + categoryId +
                '}';
    }
}