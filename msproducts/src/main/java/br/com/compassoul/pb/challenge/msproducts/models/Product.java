package br.com.compassoul.pb.challenge.msproducts.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "description")
    private String description;

    @Column(name = "product_Name")
    private String productName;

    @Column(name = "img_Url")
    private String imgUrl;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "productId" ),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    public Product(LocalDateTime date, String description, String productname, String imgUrl, BigDecimal price, List<Category> category) {
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", productName='" + productName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", price='" + price + '\'' +
                ", category=" + categories +
                '}';
    }
}