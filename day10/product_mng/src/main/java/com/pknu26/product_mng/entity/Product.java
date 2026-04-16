package com.pknu26.product_mng.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity  // JPA 테이블 매핑 선언
@Getter
@Setter
public class Product {

    @Id  // PK
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")  // productId를 1씩 자동 증가
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)  // 1씩 증가
    private Long productId;  // 상품 번호

    @Column(length = 200, nullable = false)
    private String productName;  // 상품명

    @Column(length = 100)
    private String category;  // 카테고리

    @Column(nullable = false)
    private Integer price;  // 가격

    // @Column
    // private Integer stock;  // 재고 수량

    // @Column(length = 100)
    // private String brand;  // 브랜드

    // @Column(length = 200)
    // private String manufacturer;  // 제조사

    @Lob  // Large OBject. 대용량 이미지, 텍스트, 비디오 등을 담을 때 사용하는 타입
    @Column
    private String description;  // 상품 설명

    // @Column(length = 500)
    // private String imageUrl;  // 이미지 경로

    // @Column(length = 20)
    // private String status;  // 상태 (SALE, SOLDOUT 등)

    @CreatedDate
    @Column(updatable = false)  // 최초 작성시 생성후 수정X 
    private LocalDateTime createdAt;  // 등록일

    @LastModifiedDate
    private LocalDateTime updatedAt;  // 수정일





}
