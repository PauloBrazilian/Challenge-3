package br.com.compassoul.pb.challenge.msproducts.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name = "category_Name")
    private String categoryName;

    @ManyToMany(mappedBy = "categories")
    @Column(nullable = false)
    @JsonIgnore
    private List<Product> products;

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", products=" + products +
                '}';
    }
}