package com.example.demo.backend;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://127.0.0.1:5500")  // allow frontend
public class ProductController {
    private List<Product> products = new ArrayList<>();
    public ProductController() {
        // sample data
        products.add(new Product(1, "Gold Bracelet", "Jewelry", 2000, 2,"maven/img.png"));
        products.add(new Product(2, "Silver Bracelet", "Jewelry", 1200, 4,"/maven/img.png"));
    }

    // Get all products
    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    // Add product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        product.setId(products.size() + 1);
        products.add(product);
        return product;
    }

    // Update product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(updatedProduct.getName());
                p.setCategory(updatedProduct.getCategory()); // 👈 category update
                p.setPrice(updatedProduct.getPrice());
                p.setImg(updatedProduct.getImg());
                return p;
            }
        }
        return null;
    }

    // Delete product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        products.removeIf(p -> p.getId() == id);
        return "Product deleted with id: " + id;
    }
}
