package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>// Entity는 Jpa가 관리할 객체의 타입이고, Long은 이 객체를 식별하는 id 데이터의 타입이다.
// JpaRepository에서 기본 제공하는 메서드는 실제로 직접 작성하는 Query Method와 다르게, jpa가 메서드의 기능에 맞게 직접 sql 문을 작성해서 db에 반영까지 하지만, 개발자가 작성하는 쿼리 메서드는 직접 Query Method를 적는것 뿐만 아니라, 개발자가 sql문까지 직접 작성해서 DB에 변경사항을 반영해야합니다.
{
}
