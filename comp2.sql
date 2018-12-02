-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- 생성 시간: 18-12-02 08:49
-- 서버 버전: 5.7.23
-- PHP 버전: 7.1.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 데이터베이스: `comp2`
--
CREATE DATABASE IF NOT EXISTS `comp2` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `comp2`;

-- --------------------------------------------------------

--
-- 테이블 구조 `user`
--

CREATE TABLE `user` (
  `ID` varchar(20) NOT NULL,
  `PW` varchar(20) NOT NULL,
  `GameMoney` int(11) NOT NULL,
  `level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 삽입 전에 테이블 비우기 `user`
--

TRUNCATE TABLE `user`;
--
-- 테이블의 덤프 데이터 `user`
--

INSERT INTO `user` (`ID`, `PW`, `GameMoney`, `level`) VALUES
('201401317', '201401317', 0, 1),
('201503069', '201503069', 0, 1),
('201503985', '201503985', 0, 1),
('GM', 'kimjaehyun08', 100000, 3);

--
-- 덤프된 테이블의 인덱스
--

--
-- 테이블의 인덱스 `user`
--
ALTER TABLE `user`
  ADD UNIQUE KEY `ID` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
