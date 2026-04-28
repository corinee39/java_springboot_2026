package com.pknu26.studygroup.dto;

import lombok.Data;

// 페이지 요청할 때 필요한 값 계산
@Data
public class PageRequest {

    public int page = 1;  // 현재 페이지, 1, 2, 3
    public int size = 10;  // 한 페이지당 게시글 수

   /**
    * page = 1 : (1 - 1) * 10 = 0 
    * page = 2 : (2 - 1) * 10 = 10
    * page = 3 : (3 - 1) * 10 = 20
    * @return 오프셋값 리턴
    */
    public int getOffset() {
        return (page - 1) * size;
    }

}
