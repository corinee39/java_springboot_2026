package com.pknu26.springmvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 같은 프로젝트라도 다른 패키지에 있는 클래스 가져오려면 import 필요
import com.pknu26.springmvc.Service.MessageService;

@Controller
public class HomeController {

    final MessageService messageService;

    public HomeController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    // @ResponseBody   // HTML없이 HOME이라는 글자 출력
    public String home(Model model) {

        String message = messageService.getHomeMessage();
        model.addAttribute("msg", message);   // Model 내용을 View에 전달
        // home.html 페이지로 model, msg 전달
        return "home";   // @ResponseBody 없으면 View의 home.html을 출력
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello SpringBoot!";
    }

    @GetMapping("/bye")
    @ResponseBody
    public String bye() {
        return "GoodBye~";
    }

}
