package br.com.compassoul.pb.challenge.msproducts.repository;

import br.com.compassoul.pb.challenge.msproducts.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
