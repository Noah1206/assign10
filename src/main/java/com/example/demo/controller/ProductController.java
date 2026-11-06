package com.example.demo.controller;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request) {
        ProductResponse productResponse = productService.create(request);
        return ResponseEntity.created(URI.create("/api/books/" + productResponse.id())).body(productResponse);
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ProductRequest request) {
        productService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(params = "name")
    public List<Product> getProducts(@RequestParam String name) {
        return productService.getProduct(name);
    }

    @GetMapping(params = "price")
    public List<Product> getProductPriceGreaterThan(@RequestParam Integer price) {
        return productService.getPriceGreaterThan(price);
    }

    @GetMapping(params = "orderAsc")
    public List<Product> getAllOrderAsc() {
        return productService.getPriceAsc();
    }
}
