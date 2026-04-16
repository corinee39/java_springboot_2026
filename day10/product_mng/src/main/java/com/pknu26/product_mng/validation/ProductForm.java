package com.pknu26.product_mng.validation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {

    @Size(max = 200)
    @NotBlank(message = "상품명은 필수입니다")
    private String productName;

    @Size(max = 100)
    private String category;

    @Min(value = 0, message = "가격은 0 이상이어야합니다.")
    @NotNull(message = "가격 입력은 필수입니다")
    private Integer price;

    @Size(max = 8000)
    private String description;
}
