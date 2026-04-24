package com.pknu26.studygroup.validation;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryForm {
    private Long categoryId;
    
    @NotBlank(message = "카테고리명은 필수입니다.")
    private String categoryName;

}
