# TalmoVim
탈모..빔!

# 탈모Vim 첫 프로젝트 선택

Created: 2020년 12월 23일 오후 10:46
Priority: P1 🔥
Product Manager: Hyun-jin Won, Gichan Kim
Status: 개발 진행
Timeline: 2020년 12월 27일
Type: 버그접수
작성자: 원현진

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

베이스 구조를 먼저 생성할 것

해당 내용은 프로젝트 시작 시 같이 협의할 것

Include links to other pages as necessary (e.g. technical design doc, project proposal, etc.)
