package com.pknu26.product_mng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu26.product_mng.entity.Product;
import com.pknu26.product_mng.service.ProductService;
import com.pknu26.product_mng.validation.ProductForm;

import jakarta.validation.Valid;

@RequestMapping("/product")  // 공통 URL http://localhost:8080/product
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // 상품 목록 보기
    @GetMapping("/list")
    public String showList(Model model) {
        List<Product> productList = this.productService.getProductList();  // Product 테이블 데이터 리스트

        model.addAttribute("productList", productList);  // HTML로 보낼 모델데이터 설정
        return "/product/list";  // /product/list.html 파일 리턴
    }

    // 상품 한건 상세보기
    @GetMapping("/detail/{productId}")
    public String showDetail(Model model, ProductForm productForm, @PathVariable("productId") Long productId) {
        Product product = this.productService.getProductOne(productId);

        model.addAttribute("product", product);
        return "/product/detail";
    }

    // 상품 등록 화면
    @GetMapping("/create")
    public String showCreate(ProductForm productForm) {
        return "/product/create";
    }

    // 상품 등록 DB 처리
    @PostMapping("/create")
    public String createProduct(@Valid ProductForm productForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/product/create";  // /product/create.html로 다시 돌아감
        }
        // 실제 저장
        this.productService.setProductOne(
                productForm.getProductName(), 
                productForm.getCategory(), 
                productForm.getPrice(), 
                productForm.getDescription()
            );

        return "redirect:/product/list";
    }

    // 상품 수정 화면 전환
    @GetMapping("/modify/{productId}")
    public String showModify(Model model, ProductForm productForm, @PathVariable("productId") Long productId) {
        // 상품 번호로 데이터를 조회한 다음 html 화면으로 전달
        Product product = this.productService.getProductOne(productId);

        productForm.setProductName(product.getProductName());  // 실제 DB에서 넘어온 상품 데이터를 입력용 ProductForm 클래스 멤버변수로 할당
        productForm.setCategory(product.getCategory());
        productForm.setPrice(product.getPrice());
        productForm.setDescription(product.getDescription());

        model.addAttribute("productId", product.getProductId());
        
        return "/product/create";  // /product/create.html에서 수정도 가능
    }

    // 상품 수정 DB 처리
    @PostMapping("/modify/{productId}")
    public String modifyProduct(Model model, @Valid ProductForm productForm, BindingResult bindingResult, @PathVariable("productId") Long productId) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productId", productId);
            return "/product/create";
        }

        Product product = this.productService.getProductOne(productId);
        this.productService.putProductOne(
                product, 
                productForm.getProductName(), 
                productForm.getCategory(), 
                productForm.getPrice(), 
                productForm.getDescription()
            );

            return "redirect:/product/list";
    }

    // 상품 삭제 처리
    @PostMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        Product product = this.productService.getProductOne(productId);  // 삭제할 데이터 가져오기

        // 필요 처리 후
        this.productService.deleteProductOne(product);

        return "redirect:/product/list";  // 삭제 후 목록으로 돌아감
    }

}


