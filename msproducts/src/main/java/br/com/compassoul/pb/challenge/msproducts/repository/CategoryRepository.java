package br.com.compassoul.pb.challenge.msproducts.repository;

import br.com.compassoul.pb.challenge.msproducts.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
