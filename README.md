# 방명록

  - 네이버 부스트코드 프로젝트 B(방명록 만들기)
  
## 개요

두번째 프로젝트는 Servlet, JSP, JSTL & EL, JDBC를 이용하여 방명록 웹 어플리케이션을 작성하는 것입니다.

크게 방명록 저장하기, 방명록 목록보기를 구현합니다.

## DB 설정

  - 데이터베이스 생성
  ```git
  CREATE DATABASE connectdb;
  ```

  - 유저 생성 및 권한 설정
  ```git
  CREATE USER 'connectuser'@'localhost' IDENTIFIED BY '1234';       // DB 유저 생성
  
  GRANT ALL PRIVILEGES ON connectdb.* to 'connectuser'@'localhost'; // 접근 권한 설정
  ```

  - 테이블 생성
  ```git
  CREATE TABLE `guestbook` (
      `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'guestbook id',
      `content` TEXT NOT NULL COMMENT 'guestbook content',
      `regdate` DATETIME NULL DEFAULT NULL COMMENT '등록일',
      PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
  ```