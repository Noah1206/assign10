package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>// Entity는 Jpa가 관리할 객체의 타입이고, Long은 이 객체를 식별하는 id 데이터의 타입이다.
// JpaRepository에서 기본 제공하는 메서드는 실제로 직접 작성하는 Query Method와 다르게, jpa가 메서드의 기능에 맞게 직접 sql 문을 작성해서 db에 반영까지 하지만, 개발자가 작성하는 쿼리 메서드는 직접 Query Method를 적는것 뿐만 아니라, 개발자가 sql문까지 직접 작성해서 DB에 변경사항을 반영해야합니다.
{
//    기존 Entity를 이용하여 서로 다른 조건의 Query Method 3개 이상을 구현합니다.
//
//        구현 조건
//
//    단일 조건 검색 1개 이상
//    복합 조건 검색(And, Or, Between 등) 1개 이상
//    정렬 기능(OrderBy, Asc, Desc)을 포함한 검색 1개 이상
//    각 Query Method를 호출하는 REST API를 구현합니다.
//    Postman으로 검색 결과를 확인합니다.
//    자신의 Entity 필드에 맞게 검색 조건을 작성합니다.

    List<Product> findByName(String name);
    List<Product> findByPriceGreaterThan(Integer price);
    List<Product> findAllByOrderByPriceAsc();
}
