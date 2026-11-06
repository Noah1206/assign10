package com.example.demo.entity;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import jakarta.persistence.*;

@Entity // @Entity는 객체와 데이터베이스를 맵핑하는 객체를 나타내는 어노테이션
@Table(name="product")
public class Product {
    @Id // @Id는 엔티티를 식별하는 기준
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue는 해당 엔티티를 생성했을때, PK값을 자동으로 추가하는 어노테이션
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 100)
    private String description;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(nullable = false, length = 200)
    private Integer date;

    @Column(nullable = false)
    private Integer price;

    protected Product() { } // JPA uses the no-args constructor.

    public Product(ProductRequest request) {
        this.name = request.name();
        this.description = request.description();
        this.price = request.price();
        this.date = request.date();
        this.category = request.category();
    }


    public void update(ProductRequest request) {
        this.name = request.name();
        this.description = request.description();
        this.category = request.category();
        this.price = request.price();
        this.date = request.date();
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public Integer getDate() { return date; }
    public Integer getPrice() { return price; }
}
