package com.pknu26.product_mng.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pknu26.product_mng.entity.Product;

// JpaRepository 클래스가 가지고 있는 메서드를 ProductRepository에서 다 쓸 수 있음
public interface ProductRepository extends JpaRepository<Product, Long> {

}
