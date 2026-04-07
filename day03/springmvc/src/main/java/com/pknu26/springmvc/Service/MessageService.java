package com.pknu26.springmvc.Service;

import org.springframework.stereotype.Service;

// 어노테이션 추가
@Service
public class MessageService {

    public String getHomeMessage() {
        return "모두 반가워요. Sping MVC 공부합시다!";
    }
    
}
