package com.pknu26.webboard.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/*
class Board는 DB 테이블 Boards 로 생성
클래스 멤버필드가 전부 테이블의 컬럼으로 생성
어노테이션이 이 역할을 수행
*/

@Entity  // JPA 테이블 매핑 선언
@Getter  // getter 메서드를 필드별로 자동 생성
@Setter  // setter 메서드를 자동 생성
public class Board {

    @Id  // Primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  // bno를 1씩 자동 증가하도록 만듬
    private Long bno;  // 테이블 Board의 PK, bno / Long => H2에서는 BIGINT 타입

    @Column(length = 250)
    private String title;  // 게시판 제목

    @Column(length = 8000)
    private String content;  // 게시글

    @CreatedDate  // 생성일자
    @Column(updatable = false)   // 최초 작성시 생성후 수정X 
    private LocalDateTime createDate;  // 작성일

    @LastModifiedDate  // 수정될 때마다 날짜 변경
    private LocalDateTime modifyDate;  // 게시글 수정일

}
