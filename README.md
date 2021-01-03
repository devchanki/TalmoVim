# TalmoVim
탈모..빔!

# 탈모Vim 프로젝트 (게임 공략 사이트)
- 채널(게임) 구분 없이 공략만을 올리는 사이트
- 자신의 팀들의 게임 공략 기록을 짤막하게 올릴 수 있는 사이트
- 자신이 원하는데로 사이트를 꾸밀수 있게 (보류)

## 컨셉

- 자신이 발견한 공략을 기록하는 사이트 (커밋, 로그 처럼)
- 개인 타임라인 생성. 게임 관련 페이지마다 타임라인이 나오게
    - 공략에 좋아요, 싫어요  개수 - > 레벨, 포인트
    - 게시글 공개, 비공개 → collaborator..(길드 안에 있는 사람)
    - 유튜브 embed
    - markdown - 탈모초기증세(진행중 보류)
    - 

    [https://youtu.be/3nwLyVus-RA?t=600](https://youtu.be/3nwLyVus-RA?t=600)

    - 개인 프로필에 스타
    - 공략에 이슈 가지고 오기
    - 포인트 → 출석 1점
- MSA 보류
- SSO 보류
- Spring boot + MyBatis

## 구현 사항

### 회원

- 소셜 로그인
- 회원 가입
- 레벨, 포인트 기능 (고민)
- 본인 인증 (가능 하다면 구현)
- 그룹 구현
- 프로필
    - 사진, 소개
    - 타임라인
    - Repository - 권한(CRUD)

### Repository

- 타임라인 방식
- 댓글 기능
- 좋아요, 싫어요 기능
- 신고(원탈현모진)
- Watch 기능(알람)-팔로우
- 조회수
- 에디터 기능(마크다운)
- 권한 (CRUD) + 작성자별 레벨
- 태그 구현 (해시태그)

### 관리자

- 회원 관리
- 신고 관리
- 그룹 관리
- 문의 관리
- 공지 사항

### 메인 페이지

- 맨 처음 페이지
    - 검색 : 레포지토리 , 게시글, 작성자
    - 네이버 방식, 에타 방식 추천 레포지토리 목록

- 검색시 뷰
    - 페이지네이션? 무한스크롤?

- 관리자 뷰

- WonHyunJin.remove(teamOne,hair)
    - teamOne.isLimitedOnePerDay(hair)=false;
    - 레포지토리 , 게시글, 작성자

[https://steemit.com/trending/my](https://steemit.com/trending/my)

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/54403e13-9125-4e56-841e-27e38c51fe84/330124AA-AB29-4123-B357-40B342142792.jpeg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/54403e13-9125-4e56-841e-27e38c51fe84/330124AA-AB29-4123-B357-40B342142792.jpeg)

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/67c9111f-12f5-4229-a8db-0d7f93884d43/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/67c9111f-12f5-4229-a8db-0d7f93884d43/Untitled.png)

## 공통사항

- 채팅 구현
    - organization → 채팅
    - 게임별 or 그룹.....................

    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/734582d1-a42f-42b5-bdbb-56cf1ce1b15a/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/734582d1-a42f-42b5-bdbb-56cf1ce1b15a/Untitled.png)

# 개요

프로젝트 선택 전 기준사양 및 협의사항 정리

# 프로젝트

## Project

### 선정기준

1. 어느정도 현실 가능성이 있는가?
2. 확장이 가능한가?
3. 내가 하고 싶은가? (중요)
4. 팀원과 협의를 거쳤는가? (중요)

### 현황

1. 게임공략사이트 (탈모르파티 idea)
    - 유명 게임부터 인디게임까지의 공략을 개인, 단체가 적을 수 있는 사이트
    - 공략이 없는 게임의 경우 유저가 직접 생성하여 올릴 수 있는 서비스 제공
2. 고라니 모발 빠짐 예측 사이트 (탈모르파티 idea)
    - X까

## Service

프로젝트에서 구현하고 싶은, 사용하고 싶은 서비스 기능

### 선택기준

- 자신이 하고 싶은 것 (중요!)
- 어느정도 구현 방향이 잡히는 것

### 선택된 내용

- MSA (빌리헤링턴 idea)
- 영상, 또는 스트리밍 기능 (고라니 idea)
- CMS, 게임관련 (탈모르파티 idea)
- 자동 빌드, 배포까지 고려 (전원 공통 협의 idea)

# 개발환경

## Framework

개발 시 사용할 Framework

프로젝트 선정 후 선택할 것, 협의한 사심 가득 환영

### Backend

- Spring-boot (유력)
- Django
- NodeJS

### Frontend

- 템플릿엔진
    - 머스테치(유력)
- 리엑트
- Vue.js
- Angular

## Server

프로젝트 서버 선택

비용적인 문제를 고려해볼 것

필요) DB서버, 배포서버, 기타(프로젝트에 따라 변경 예정)

- Oracle Server (빌리헤링턴)
- AWS EC2

## Version Control

- git
- github
- 관리계획 필요

# 규칙사항

## 역활

- Service 단위 기준으로 각각 배분
    1. Not Only BE, FE
    2. 자신의 구현 서비스에 필요한 BE, FE를 전부 구현할 것 
- 서버 관리 (미정)

## 규칙

- 명명 규칙
- 배치 구조
[구조 제안](https://github.com/devchanki/TalmoVim/blob/main/BlueprintOfTemplate.md)   

베이스 구조를 먼저 생성할 것

해당 내용은 프로젝트 시작 시 같이 협의할 것

Include links to other pages as necessary (e.g. technical design doc, project proposal, etc.)
