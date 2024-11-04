package APISpring.api_spring.Controllers;

import APISpring.api_spring.Models.ProductModel;
import APISpring.api_spring.Services.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Configuration
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductModel> getAllProducts() {
        return productService.list();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity findById(@Valid @PathVariable @NotNull(message = "Id is not null") @Min(value = 0L, message = "Id is invalid") Long id){
        return productService.findById(id);
    }

    @ResponseBody
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody ProductModel productModel){
        productService.createProduct(productModel);
    }

    @ResponseBody
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody ProductModel productModel){
        return productService.updateProduct(id, productModel);
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return productService.deleteProduct(id);

    }

}