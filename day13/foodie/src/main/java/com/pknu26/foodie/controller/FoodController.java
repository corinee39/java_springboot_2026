package com.pknu26.foodie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu26.foodie.dto.Food;
import com.pknu26.foodie.service.FoodService;

@Controller
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    // 목록 화면
    @GetMapping("/list")
    public String showList(Model model) {
        List<Food> foodList = this.foodService.getAllFoods();
        model.addAttribute("foodList", foodList);
        return "food/list";
    }

    // 등록 화면
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("food", new Food());
        return "food/create";
    }

    // 등록 처리
    @PostMapping("/create")
    public String createFood(Food food) {
        foodService.addFood(food);
        return "redirect:/food/list";
    }

    // 상세 화면
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Long id, Model model) {
        Food food = this.foodService.getFoodById(id);
        model.addAttribute("food", food);
        return "food/detail";
    }

    // 수정 화면
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Food food = this.foodService.getFoodById(id);
        model.addAttribute("food", food);
        return "food/edit";
    }

    // 수정 처리
    @PostMapping("/edit")
    public String editFood(Food food) {
        foodService.updateFood(food);
        return "redirect:/food/list";
    }

    // 삭제 처리
    @GetMapping("/delete/{id}")
    public String deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return "redirect:/food/list";
    }


}
