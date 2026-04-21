package com.pknu26.foodie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pknu26.foodie.dto.Food;

@Mapper
public interface FoodMapper {

    // 전체 조회
    List<Food> findAll();

    // 한건씩 조회
    Food findById(Long id);

    // 등록
    int insert(Food food);

    // 수정
    int update(Food food);

    // 삭제
    int deleteById(Long id);

}
