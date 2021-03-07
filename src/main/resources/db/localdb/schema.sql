-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- 생성 시간: 21-03-07 15:17
-- 서버 버전: 10.1.13-MariaDB
-- PHP 버전: 7.0.0p1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 데이터베이스: `kgichan1`
--

-- --------------------------------------------------------

--
-- 테이블 구조 `TMV_FOLLOW`
--

CREATE TABLE IF NOT EXISTS `TMV_FOLLOW` (
  `follower` varchar(40) NOT NULL,
  `followee` varchar(40) NOT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`follower`,`followee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 테이블 구조 `TMV_GROUP`
--

CREATE TABLE IF NOT EXISTS `TMV_GROUP` (
  `GROUP_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `GROUP_NAME` varchar(60) NOT NULL,
  `GROUP_DESC` text NOT NULL,
  `GROUP_STATUS` varchar(45) NOT NULL,
  `GROUP_INSERT_DT` datetime DEFAULT NULL,
  PRIMARY KEY (`GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 테이블 구조 `TMV_QNA`
--

CREATE TABLE IF NOT EXISTS `TMV_QNA` (
  `QNA_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `AUTHOR_ID` bigint(20) NOT NULL,
  `TYPE` varchar(20) NOT NULL,
  `TITLE` varchar(200) NOT NULL,
  `CONTENTS` varchar(1000) NOT NULL,
  `CREATEDATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`QNA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 테이블 구조 `TMV_USER`
--

CREATE TABLE IF NOT EXISTS `TMV_USER` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '회원 인덱스',
  `USER_EMAIL` varchar(60) NOT NULL COMMENT '회원 이메일',
  `USER_PASSWORD` varchar(256) NOT NULL COMMENT '회원 비밀번호',
  `USER_ROLE` varchar(20) NOT NULL COMMENT '회원 권한',
  `USER_NAME` varchar(20) NOT NULL COMMENT '회원 이름',
  `USER_NICK` varchar(60) NOT NULL COMMENT '회원 닉네임',
  `USER_GENDER` varchar(1) NOT NULL COMMENT '회원 성별',
  `USER_TEL1` varchar(4) NOT NULL COMMENT '횐원 전화전호 앞자리',
  `USER_TEL2` varchar(4) NOT NULL COMMENT '회원 전화전호 중간자리',
  `USER_TEL3` varchar(4) NOT NULL COMMENT '회원 전화번호 뒷자리',
  `USER_ZIPCODE` varchar(10) DEFAULT NULL COMMENT '회원 우편번호 (사용 미정)',
  `USER_ADDR1` varchar(100) DEFAULT NULL COMMENT '회원 주소1 (우편번호주소)',
  `USER_ADDR2` varchar(100) DEFAULT NULL COMMENT '회원 주소2 (상세 주소)',
  `USER_LEVEL` int(11) NOT NULL DEFAULT '0' COMMENT '회원 레벨',
  `USER_POINT` int(11) NOT NULL DEFAULT '0' COMMENT '회원 포인트',
  `USER_DI` varchar(1000) DEFAULT NULL COMMENT '회원 DI',
  `USER_INSERT_DT` datetime DEFAULT NULL COMMENT '회원 가입일',
  `USER_UPDATE_DT` datetime DEFAULT NULL COMMENT '회원 수정일',
  `USER_STATUS` varchar(45) NOT NULL COMMENT '회원 상태',
  `USER_LAST_LOGIN_DT` datetime DEFAULT NULL COMMENT '회원 마지막 로그인',
  `USER_SESSION_ID` varchar(40) DEFAULT NULL COMMENT '회원 세션 ID (자동로그인 구현)',
  `USER_SESSION_EXPIRE_DT` datetime DEFAULT NULL COMMENT '회원 세션 만료일',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `EMAIL_UNIQUE` (`USER_EMAIL`),
  UNIQUE KEY `NICK_UNIQUE` (`USER_NICK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='탈모빔 회원 테이블';


-- --------------------------------------------------------

--
-- 테이블 구조 `TMV_SNS_USER`
--

CREATE TABLE IF NOT EXISTS `TMV_SNS_USER` (
  `SNS_KEY` varchar(20) NOT NULL,
  `SNS_TYPE` varchar(20) NOT NULL,
  `SNS_EMAIL` varchar(60) DEFAULT NULL,
  `SNS_INSERT_DT` datetime DEFAULT NULL,
  `SNS_TOKEN` varchar(1000) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`SNS_KEY`,`SNS_TYPE`),
  KEY `FK_USER_ID_idx` (`USER_ID`),
  CONSTRAINT `FK_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `TMV_USER` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SNS 회원 테이블';


-- --------------------------------------------------------

--
-- 테이블 구조 `TMV_MEMBER`
--

CREATE TABLE IF NOT EXISTS `TMV_MEMBER` (
  `MEMBER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `GROUP_ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NOT NULL,
  `MEMBER_ROLE` varchar(45) NOT NULL,
  `MEMBER_STATUS` varchar(45) NOT NULL,
  `MEMBER_REGIST_DT` datetime DEFAULT NULL,
  PRIMARY KEY (`MEMBER_ID`),
  KEY `FK_USER_ID_idx` (`USER_ID`),
  KEY `FK_GROUP_ID_GROUP_GROUP_ID` (`GROUP_ID`),
  CONSTRAINT `FK_GROUP_ID_GROUP_GROUP_ID` FOREIGN KEY (`GROUP_ID`) REFERENCES `TMV_GROUP` (`GROUP_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_USER_ID_USER_USRE_ID` FOREIGN KEY (`USER_ID`) REFERENCES `TMV_USER` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 덤프된 테이블의 제약사항
--

--
-- 테이블의 제약사항 `TMV_MEMBER`
--
CREATE TABLE IF NOT EXISTS `TMV_USER_DROP` (
  `ID` varchar(40) NOT NULL COMMENT '회원 아이디',
  `PASSWORD` varchar(256) NOT NULL COMMENT '회원 비밀번호',
  `USER_ROLE` varchar(20) DEFAULT NULL COMMENT '회원 권한',
  `NAME` varchar(20) DEFAULT NULL COMMENT '회원 이름',
  `NICK` varchar(40) DEFAULT NULL COMMENT '회원 닉네임',
  `EMAIL` varchar(80) DEFAULT NULL COMMENT '회원 이메일',
  `GENDER` varchar(1) DEFAULT NULL COMMENT '회원 성별',
  `BIRTH` varchar(10) DEFAULT NULL COMMENT '회원 생년월일',
  `TEL1` varchar(4) DEFAULT NULL COMMENT '회원 전화번호 앞',
  `TEL2` varchar(4) DEFAULT NULL COMMENT '회원 전화번호 중',
  `TEL3` varchar(4) DEFAULT NULL COMMENT '회원 전화번호 끝',
  `ZIPCODE` varchar(10) DEFAULT NULL COMMENT '회원 우편번호',
  `ADDR1` varchar(100) DEFAULT NULL COMMENT '회원 주소1',
  `ADDR2` varchar(100) DEFAULT NULL COMMENT '회원 주소2',
  `LEVEL` bigint(20) DEFAULT '0' COMMENT '회원 레벨',
  `POINT` bigint(20) DEFAULT '0' COMMENT '회원 포인트',
  `DI` varchar(1000) DEFAULT NULL COMMENT '회원 중복 정보(본인인증 시 사용)',
  `INSERT_DT` datetime DEFAULT NULL COMMENT '회원 가입 날짜',
  `DELETE_DT` datetime DEFAULT NULL COMMENT '회원 탈퇴 날짜',
  `STATUS` varchar(45) DEFAULT NULL COMMENT '회원 상태',
  `LAST_LOGIN` datetime DEFAULT NULL COMMENT '회원 마지막 로그인',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
