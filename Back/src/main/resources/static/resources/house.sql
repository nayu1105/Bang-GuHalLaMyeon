select * from housedeal;
select * from houseinfo;
select * from dong_code;
select * from gugun_code;
select * from users;

-- 조회 
select distinct hd.no,
	   -- hd.house_no,
	   dc.city_name, dc.gugun_name,
       hd.dong, hd.AptName,
       hd.floor, hd.area, hd.dealAmount,
       hi.lat, hi.lng, hi.img
from housedeal hd,
	 houseinfo hi,
     dong_code dc
where hd.house_no = hi.no
	  and dc.gugun_code = hd.code
      and (dc.city_name like '%서울%'
		   and dc.gugun_name like '%종로%')
limit 10 offset 0;

-- 조회 카운팅
select count(*)
from housedeal hd,
     dong_code dc
where dc.gugun_code = hd.code
      and (dc.city_name like '%서울%'
		   and dc.gugun_name like '%종로%')
limit 10 offset 0;


-- 검색 조회 
select distinct hd.no,
	   -- hd.house_no,
	   dc.city_name, dc.gugun_name,
       hd.dong, hd.AptName,
       hd.floor, hd.area, hd.dealAmount,
       hi.lat, hi.lng, hi.img
from housedeal hd,
	 houseinfo hi,
     dong_code dc
where hd.house_no = hi.no
	  and hd.code = dc.gugun_code
	  and (dc.city_name like '%서울특별시%'
		   and dc.gugun_name like '%종로%'
		   and (hd.AptName like '%광화문%' or hd.dong like '%광화문%'));
-- order by hd.AptName
-- limit 10 offset 0;

select * from favorite;

select count(*)
from favorite
where userSeq = 1;

-- 검색 조회 카운팅
select distinct count(*)
from housedeal hd,
     dong_code dc
where hd.code = dc.gugun_code
	  and (dc.city_name like '%서울특별시%'
		   and dc.gugun_name like '%종로%'
		   and (hd.AptName like '%광화문%' and hd.dong like '%%'));

-- 상세 조회 
select distinct hd.no, 
	   dc.city_name, dc.gugun_name,
       hd.dong , hd.AptName,
       hd.floor, hd.area, hd.dealAmount,
       hd.buildYear, hd.dealYear, hd.dealMonth,
       hd.type, hd.rentMoney,
       hi.lat, hi.lng, hi.img
from housedeal hd,
	 houseinfo hi,
     dong_code dc
where hd.house_no = hi.no
	  and hd.code = dc.gugun_code
      -- and hd.dong = dc.name
      and hd.no = 1;
      
select *
from housedeal hd, houseinfo hi
where hd.house_no = hi.no
	  and hd.no = 1;

select *
from housedeal hd
	 left join houseinfo hi on hd.house_no = hi.no
	 left join dong_code dc on hd.code = dc.gugun_code
where hd.house_no = hi.no
	  and hd.no = 1;

select *
from housedeal hd,
	 houseinfo hi,
     dong_code dc
where hd.house_no = hi.no
	  and hd.code = dc.gugun_code
      and hd.dong = dc.name
      and hd.no = 1;



-- 관심아파트 테이블 생성 
CREATE TABLE IF NOT EXISTS `favorite` (
  `favoriteId` int AUTO_INCREMENT NOT NULL UNIQUE,
  `userSeq` int DEFAULT NULL,
  `houseSeq` int DEFAULT NULL,
  `sido` VARCHAR(30) NOT NULL,
  `gugun` VARCHAR(30) NOT NULL,
  `dong` VARCHAR(30) NOT NULL,
  `aptName` VARCHAR(30) NOT NULL,
  `floor` VARCHAR(30) NOT NULL,
  `area` VARCHAR(30) NOT NULL,
  `dealAmount` VARCHAR(30) NOT NULL,
  `img` VARCHAR(30) DEFAULT "noAptImg.jpg", 
  PRIMARY KEY (`favoriteId`),
  FOREIGN KEY (`houseSeq`) REFERENCES `housedeal` (`no`),
  FOREIGN KEY (`userSeq`) REFERENCES `users` (`user_seq`))
ENGINE = InnoDB;

-- 관심아파트 테이블 생성 
CREATE TABLE IF NOT EXISTS `favorite` (
  `favoriteId` int AUTO_INCREMENT NOT NULL UNIQUE,
  `userSeq` int DEFAULT NULL,
  `houseSeq` int DEFAULT NULL,
  PRIMARY KEY (`favoriteId`),
  FOREIGN KEY (`houseSeq`) REFERENCES `housedeal` (`no`),
  FOREIGN KEY (`userSeq`) REFERENCES `users` (`user_seq`))
ENGINE = InnoDB;

-- 관심 아파트 조회 
select * from favorite;

-- 관심 아파트 추가 
-- insert into favorite (houseSeq, sido, gugun, dong, aptName, floor, area, dealAmount)
-- values (1, 'sido2', 'gugun2', 'dong2', 'aptName2', '5', '20.2', '1213,32');

insert into favorite (userSeq, houseSeq)
values (1, 1);

select fv.favoriteId, hd.no,
	   hd.aptName,
	   hd.dong,
       hd.floor,
       hd.area,
       hd.dealAmount
from housedeal hd, favorite fv
where hd.no = fv.houseSeq;


-- 주변 지역 부동산 중개소
CREATE TABLE IF NOT EXISTS `agency` (
  `agencyId` int AUTO_INCREMENT NOT NULL UNIQUE,
  `code` VARCHAR(30) NOT NULL,
  `sido` VARCHAR(30) NOT NULL,
  `gugun` VARCHAR(30) NOT NULL,
  `dong` VARCHAR(30) NOT NULL,
  `agencyAddress` VARCHAR(30) NOT NULL,
  `agent` VARCHAR(30) NOT NULL,
  `agencyName` VARCHAR(30) NOT NULL,
  `agencyPhone` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`agencyId`))
ENGINE = InnoDB;

-- 주변 지역 전기차 충전소
CREATE TABLE IF NOT EXISTS `electric_charge` (
  `stationId` int AUTO_INCREMENT NOT NULL UNIQUE,
  `sido` VARCHAR(30) NOT NULL,
  `gugun` VARCHAR(30) NOT NULL,
  `stationName` VARCHAR(30) NOT NULL,
  `stationAddress` VARCHAR(30) NOT NULL,
  `startTime` VARCHAR(30) NOT NULL,
  `endTime` VARCHAR(30) NOT NULL,
  `stationPhone` VARCHAR(30) NOT NULL,
  `lat` VARCHAR(30) NOT NULL,
  `lng` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`stationId`))
ENGINE = InnoDB;

ALTER TABLE `my_house`.`electric_charge` 
ADD UNIQUE INDEX `stationId_UNIQUE` (`stationId` ASC) VISIBLE,
ADD UNIQUE INDEX `stationPhone_UNIQUE` (`stationPhone` ASC) VISIBLE;

select * from electric_charge;
select * from agency;
select * from favorite; 

select agencyName, agencyAddress, agent, agencyPhone
from agency;

select stationName, stationAddress, stationPhone
from electric_charge;

select stationName, stationAddress, stationPhone
from electric_charge;

select distinct hd.no,
	   	  dc.city_name, dc.gugun_name,
       hd.dong, hd.AptName,
       hd.floor, hd.area, hd.dealAmount,
       hi.lat, hi.lng, hi.img
from housedeal hd,
		houseinfo hi,
     dong_code dc
where hd.house_no = hi.no
	  	 and hd.code = dc.gugun_code
	  	 and (dc.city_name like ?
		   	  and dc.gugun_name like ?
		   	  and (hd.AptName like ? and hd.dong like ?))
limit ? offset ?;


select * from housedeal;

select *
from favorite;

INSERT INTO `my_house`.`favorite` (`favoriteId`, `userSeq`, `houseSeq`, `sido`, `gugun`, `dong`, `aptName`, `floor`, `area`, `dealAmount`) VALUES ('1', '1', '1', '서울특별시', '종로구', '사직동', '광화문풍림스페이스본(101동~105동)', '10', '97.61', '   105,000');
INSERT INTO `my_house`.`favorite` (`favoriteId`, `userSeq`, `houseSeq`, `sido`, `gugun`, `dong`, `aptName`, `floor`, `area`, `dealAmount`) VALUES ('2', '1', '2', '서울특별시', '종로구', '사직동', '광화문풍림스페이스본(106동)', '11', '163.33', '   162,000');

select * from agency;
select * from dong_code;

UPDATE `my_house`.`agency` SET `code` = '11710', `sido` = '서울특별시', `gugun` = '송파구', `dong` = '문정동', `agencyAddress` = '서울특별시 송파구 충민로 66 T-1035호(문정동, 가든파이브라이프)', `agent` = '유인석', `agencyName` = '조은공인중개사사무소', `agencyPhone` = '895-8181' WHERE (`agencyId` = '1');
UPDATE `my_house`.`agency` SET `agencyId` = '100', `code` = '11545', `sido` = '서울특별시', `gugun` = '금천구', `dong` = '	\n시흥동', `agencyAddress` = '서울특별시 금천구 탑골로 6 1층 일부(시흥동)', `agent` = '장훈', `agencyName` = '조은공인중개사사무소', `agencyPhone` = '895-8181' WHERE (`agencyId` = '4');

select * from agency;

select agencyId,
	   sido,
	   dong,
       gugun,
       agencyAddress,
       agent,
       agencyName,
       agencyPhone
from agency
where sido like '%서울%'
	  and gugun like '%%';

use my_house;

-- create table 
CREATE TABLE my_house.group_code (
  group_code CHAR(3) NOT NULL,
  group_code_name VARCHAR(50) NULL,
  PRIMARY KEY (group_code));

CREATE TABLE my_house.code (
  group_code CHAR(3) NOT NULL,
  code CHAR(3) NOT NULL,
  code_name VARCHAR(50) NULL,
  use_yn CHAR(1) NULL,
  PRIMARY KEY (group_code, code));

-- CREATE TABLE my_house.user (
--   user_id INT NOT NULL AUTO_INCREMENT,
--   user_name VARCHAR(50) NOT NULL,
--   user_clsf CHAR(3) NULL,
--   PRIMARY KEY (user_id));

ALTER TABLE my_house.users ADD user_clsf CHAR(3) NULL;

INSERT INTO my_house.group_code (group_code, group_code_name) VALUES ('001', '회원 구분');

INSERT INTO code VALUES 
  ('001','001','관리자','Y'),
  ('001','002','일반회원','Y');

select * from group_code;
select * from code;
select * from users;

select distinct city_name, gugun_name
from dong_code
where code like "1111%";

select agencyId, 
       agencyAddress, 
       agent, 
       agencyName, 
       agencyPhone 
from agency 
where sido like '%서울%'
	  and gugun like '%종%';
      
select * from agency;
select * from users;

select code, code_name, use_yn
from code
where group_code = "001"

CREATE TABLE board (
  BOARD_ID int NOT NULL AUTO_INCREMENT,
  USER_SEQ int NOT NULL,
  TITLE varchar(500) DEFAULT NULL,
  CONTENT text,
  REG_DT datetime DEFAULT NULL,
  PRIMARY KEY (BOARD_ID),
  KEY FK_USER_idx (USER_SEQ),
  CONSTRAINT FK_USER FOREIGN KEY (USER_SEQ) REFERENCES users (USER_SEQ)
  on delete cascade
);