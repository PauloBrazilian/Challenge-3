package br.com.compassoul.pb.challenge.msproducts.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name = "categoryname")
    private String categoryname;

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryname='" + categoryname + '\'' +
                '}';
    }
}