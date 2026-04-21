package com.pknu26.foodie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu26.foodie.dto.Food;
import com.pknu26.foodie.mapper.FoodMapper;

@Service
public class FoodService {

    @Autowired
    private FoodMapper foodMapper;

    // 전체 조회
    public List<Food> getAllFoods() {
        return foodMapper.findAll();
    }

    // 한건씩 조회
    public Food getFoodById(Long id) {
        return foodMapper.findById(id);
    }

    // 등록
    public int addFood(Food food) {
        return foodMapper.insert(food);
    }

    // 수정
    public int updateFood(Food food) {
        return foodMapper.update(food);
    }

    // 삭제
    public int deleteFood(Long id) {
        return foodMapper.deleteById(id);
    }

}
