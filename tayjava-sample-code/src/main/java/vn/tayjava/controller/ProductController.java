package vn.tayjava.controller;

import org.springframework.web.bind.annotation.*;
import vn.tayjava.dto.request.ProductRequestDTO;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @PostMapping(value = "/", headers = "apiKey=v1.0")
    public String addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return "Product added";
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable int productId, @RequestBody ProductRequestDTO productRequestDTO) {
        System.out.println("Request update productId = " + productId);
        return "Product updated";
    }

    @PatchMapping("/{productId}")
    public String changeAvailability(@PathVariable int productId, @RequestBody ProductRequestDTO productRequestDTO) {
        System.out.println("Request change availability, productId = " + productId);
        return "Product availability changed";
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        System.out.println("Request delete productId = " + productId);
        return "Product deleted";
    }

    @GetMapping("/{productId}")
    public ProductRequestDTO getProduct(@PathVariable int productId) {
        System.out.println("Request get product detail by productId = " + productId);
        return new ProductRequestDTO("Laptop", "Electronics", 1500.0, "High performance laptop");
    }

    @GetMapping("/list")
    public List<ProductRequestDTO> getAllProducts(
            @RequestParam(required = false) String category,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize)
    {
        System.out.println("Request get product list");
        return List.of(
                new ProductRequestDTO("Laptop", "Electronics", 1500.0, "High performance laptop"),
                new ProductRequestDTO("Phone", "Electronics", 800.0, "Latest model smartphone")
        );
    }
}
