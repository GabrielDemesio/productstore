package APISpring.api_spring.Repositories;

import APISpring.api_spring.Models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
