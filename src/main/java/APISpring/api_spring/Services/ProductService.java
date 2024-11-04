package APISpring.api_spring.Services;

import APISpring.api_spring.Models.ProductModel;
import APISpring.api_spring.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<ProductModel> list(){
        return productRepository.findAll();
    }
    public void createProduct(@RequestBody ProductModel product){
        productRepository.save(product);
    }
    public ResponseEntity findById(@PathVariable Long id){
        return productRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity updateProduct(Long id, @RequestBody ProductModel product){
        return productRepository.findById(id)
                .map(record -> {
                    record.setProduct(product.getProduct());
                    record.setPrice(product.getPrice());
                    record.setDescription(product.getDescription());
                    ProductModel updated = productRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity <?> deleteProduct(@PathVariable Long id){
        return productRepository.findById(id)
                .map(record ->{
                    productRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}