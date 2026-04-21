package com.pknu26.foodie.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    private Long id;                 // ID (PK)
    private String name;             // 음식 이름
    private String category;         // 음식 종류
    private Integer rating;          // 평점 (1~5)
    private String memo;             // 음식 메모
    private LocalDate eatDate;       // 먹은 날짜
    private LocalDateTime createdAt; // 생성일자

}
