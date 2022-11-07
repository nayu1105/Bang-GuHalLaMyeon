-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema my_house
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema my_house
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `my_house` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `my_house` ;

-- -----------------------------------------------------
-- Table `my_house`.`agency`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_house`.`agency` (
  `agencyId` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(30) NOT NULL,
  `sido` VARCHAR(30) NOT NULL,
  `gugun` VARCHAR(30) NOT NULL,
  `dong` VARCHAR(30) NOT NULL,
  `agencyAddress` VARCHAR(30) NOT NULL,
  `agent` VARCHAR(30) NOT NULL,
  `agencyName` VARCHAR(30) NOT NULL,
  `agencyPhone` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`agencyId`),
  UNIQUE INDEX `agencyId` (`agencyId` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my_house`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_house`.`users` (
  `USER_SEQ` INT NOT NULL DEFAULT '0',
  `USER_NAME` VARCHAR(100) NOT NULL,
  `USER_PASSWORD` VARCHAR(50) NOT NULL,
  `USER_EMAIL` VARCHAR(100) NOT NULL,
  `USER_PROFILE_IMAGE_URL` VARCHAR(500) NULL DEFAULT NULL,
  `USER_REGISTER_DATE` DATE NULL DEFAULT NULL,
  `user_clsf` CHAR(3) NULL DEFAULT NULL,
  PRIMARY KEY (`USER_SEQ`),
  UNIQUE INDEX `USER_EMAIL_UNIQUE` (`USER_EMAIL` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my_house`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_house`.`board` (
  `BOARD_ID` INT NOT NULL AUTO_INCREMENT,
  `USER_SEQ` INT NOT NULL,
  `TITLE` VARCHAR(500) NULL DEFAULT NULL,
  `CONTENT` TEXT NULL DEFAULT NULL,
  `REG_DT` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`BOARD_ID`),
  INDEX `FK_USER_idx` (`USER_SEQ` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my_house`.`group_code`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_house`.`group_code` (
  `group_code` CHAR(3) NOT NULL,
  `group_code_name` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`group_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my_house`.`code`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_house`.`code` (
  `group_code` CHAR(3) NOT NULL,
  `code` CHAR(3) NOT NULL,
  `code_name` VARCHAR(50) NULL DEFAULT NULL,
  `use_yn` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`group_code`, `code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my_house`.`sido_code`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_house`.`sido_code` (
  `code` CHAR(2) NOT NULL,
  `name` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my_house`.`dong_code`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_house`.`dong_code` (
  `code` CHAR(10) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `city_code` CHAR(2) NULL DEFAULT NULL,
  `city_name` VARCHAR(20) NOT NULL,
  `gugun_code` CHAR(5) NULL DEFAULT NULL,
  `gugun_name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`code`),
  INDEX `FK_SIDO_DONG_idx` (`city_code` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my_house`.`dongcode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_house`.`dongcode` (
  `dongCode` VARCHAR(10) NOT NULL,
  `sidoName` VARCHAR(30) NULL DEFAULT NULL,
  `gugunName` VARCHAR(30) NULL DEFAULT NULL,
  `dongName` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`dongCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my_house`.`electric_charge`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_house`.`electric_charge` (
  `stationId` INT NOT NULL AUTO_INCREMENT,
  `sido` VARCHAR(30) NOT NULL,
  `gugun` VARCHAR(30) NOT NULL,
  `stationName` VARCHAR(30) NOT NULL,
  `stationAddress` VARCHAR(30) NOT NULL,
  `startTime` VARCHAR(30) NOT NULL,
  `endTime` VARCHAR(30) NOT NULL,
  `stationPhone` VARCHAR(30) NOT NULL,
  `lat` VARCHAR(30) NOT NULL,
  `lng` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`stationId`),
  UNIQUE INDEX `stationId` (`stationId` ASC) VISIBLE,
  UNIQUE INDEX `stationId_UNIQUE` (`stationId` ASC) VISIBLE,
  UNIQUE INDEX `stationPhone_UNIQUE` (`stationPhone` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my_house`.`favorite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_house`.`favorite` (
  `favoriteId` INT NOT NULL AUTO_INCREMENT,
  `userSeq` INT NULL DEFAULT NULL,
  `houseSeq` INT NULL DEFAULT NULL,
  PRIMARY KEY (`favoriteId`),
  UNIQUE INDEX `favoriteId` (`favoriteId` ASC) VISIBLE,
  INDEX `userSeq` (`userSeq` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 39
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my_house`.`gugun_code`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_house`.`gugun_code` (
  `code` CHAR(5) NULL DEFAULT NULL,
  `name` VARCHAR(20) NULL DEFAULT NULL,
  `sido_code` CHAR(2) NULL DEFAULT NULL,
  INDEX `FK_SIDO_GUGUN_idx` (`sido_code` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my_house`.`housedeal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_house`.`housedeal` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `dong` VARCHAR(30) NOT NULL,
  `AptName` VARCHAR(50) NOT NULL,
  `code` VARCHAR(30) NOT NULL,
  `dealAmount` VARCHAR(50) NOT NULL,
  `buildYear` VARCHAR(30) NULL DEFAULT NULL,
  `dealYear` VARCHAR(30) NULL DEFAULT NULL,
  `dealMonth` VARCHAR(30) NULL DEFAULT NULL,
  `dealDay` VARCHAR(30) NULL DEFAULT NULL,
  `area` VARCHAR(30) NULL DEFAULT NULL,
  `floor` VARCHAR(30) NULL DEFAULT NULL,
  `jibun` VARCHAR(30) NULL DEFAULT NULL,
  `type` VARCHAR(30) NULL DEFAULT NULL,
  `rentMoney` VARCHAR(30) NULL DEFAULT NULL,
  `house_no` INT NULL DEFAULT NULL COMMENT '제공되지 않은, 새로 생성한 컬럼으로 houseinfo 와 연계되는 FK 성격의 column 임',
  PRIMARY KEY (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 68865
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my_house`.`houseinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_house`.`houseinfo` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `dong` VARCHAR(30) NOT NULL,
  `AptName` VARCHAR(50) NOT NULL,
  `code` VARCHAR(30) NOT NULL,
  `buildYear` VARCHAR(30) NULL DEFAULT NULL,
  `jibun` VARCHAR(30) NULL DEFAULT NULL,
  `lat` VARCHAR(30) NULL DEFAULT NULL,
  `lng` VARCHAR(30) NULL DEFAULT NULL,
  `img` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 5990
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `my_house`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_house`.`user` (
  `id` VARCHAR(30) NOT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(100) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `permission` INT NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
