package br.com.compassoul.pb.challenge.msproducts.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

    @Column(name = "productname")
    private String productname;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "price")
    private String price;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", productname='" + productname + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", price='" + price + '\'' +
                ", category=" + category +
                '}';
    }
}