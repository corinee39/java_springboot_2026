package com.pknu26.product_mng.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pknu26.product_mng.entity.Product;
import com.pknu26.product_mng.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // 상품 목록 모두 가져오기
    public List<Product> getProductList() {
        return this.productRepository.findAll(Sort.by(Sort.Direction.DESC, "productId"));
    }

    // 상품 목록 중 한 건만 가져오기
    public Product getProductOne(Long productId) {
        Optional<Product> opProduct = this.productRepository.findById(productId);

        if(opProduct.isPresent()) {
            return opProduct.get();  // opProduct 내의 Product 객체값 리턴
        } else {
            throw new RuntimeException("Product Data not found");
        }
    }

    // 상품 등록
    public boolean setProductOne(String productName, String category, Integer price, String description) {
        Product product = new Product();

        try {
            product.setProductName(productName);  // product.productName 필드에 할당
            product.setCategory(category);  // product.category 필드에 할당
            product.setPrice(price);  //product.price 필드에 할당
            product.setDescription(description);  //product.description 필드에 할당
            product.setCreatedAt(LocalDateTime.now());  // 현재 일시 할당

            // 리포지토리로 DB에 저장
            // PK bno가 없기 때문에 save 실행하면 INSERT INTO 쿼리 실행
            this.productRepository.save(product); 
            return true;
        } catch(Exception e) {
            // 에러 로그 출력
            return false;
        }
    }

    // 상품 수정
    public boolean putProductOne(Product product, String productName, String category, Integer price, String description) {
        try {
            product.setProductName(productName);
            product.setCategory(category);
            product.setPrice(price);
            product.setDescription(description);
            product.setUpdatedAt(LocalDateTime.now());

            // productId가 있으면 save 실행시 UPDATE 쿼리 실행
            this.productRepository.save(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 상품 삭제
    public void deleteProductOne(Product product) {
        this.productRepository.delete(product);  // DELETE 쿼리 실행
    }

}
