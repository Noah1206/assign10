package com.example.demo.dto;

import com.example.demo.entity.Product;

import java.time.LocalDateTime;

public record ProductResponse(Long id, String name, String description,  String category, Integer price, LocalDateTime createdAt,
                              LocalDateTime updateAt) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getCategory(), product.getPrice(),  product.getCreatedAt(), product.getUpdateAt()
        );
    }
}