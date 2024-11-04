package APISpring.api_spring.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.NotBlank;


@Validated
@Entity
@Data
@Table(name = "product")
@Getter
@Setter
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message="Product have must been required ")
    @Column(nullable = false, name = "product")
    private String product;

    @NotBlank(message = "Price have must been required")
    @Column(nullable = false, name = "price")
    private float price;

    @NotBlank(message="Description have must been required ")
    @Column(nullable = false, name = "description")
    private String description;
}
