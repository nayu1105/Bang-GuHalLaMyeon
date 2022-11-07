-- dongcode
DROP TABLE IF EXISTS `dongcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dongcode` (
  `dongCode` varchar(10) NOT NULL,
  `sidoName` varchar(30) DEFAULT NULL,
  `gugunName` varchar(30) DEFAULT NULL,
  `dongName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`dongCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- housedeal
DROP TABLE IF EXISTS `housedeal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `housedeal` (
  `no` bigint NOT NULL,
  `dealAmount` varchar(20) DEFAULT NULL,
  `dealYear` int DEFAULT NULL,
  `dealMonth` int DEFAULT NULL,
  `dealDay` int DEFAULT NULL,
  `area` varchar(20) DEFAULT NULL,
  `floor` varchar(4) DEFAULT NULL,
  `cancelDealType` varchar(1) DEFAULT NULL,
  `aptCode` bigint DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `housedeal_aptCode_houseinfo_aptCode_fk_idx` (`aptCode`),
  CONSTRAINT `housedeal_aptCode_houseinfo_aptCode_fk` FOREIGN KEY (`aptCode`) REFERENCES `houseinfo` (`aptCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- houseinfo 
DROP TABLE IF EXISTS `houseinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `houseinfo` (
  `aptCode` bigint NOT NULL,
  `buildYear` int DEFAULT NULL,
  `roadName` varchar(40) DEFAULT NULL,
  `roadNameBonbun` varchar(5) DEFAULT NULL,
  `roadNameBubun` varchar(5) DEFAULT NULL,
  `roadNameSeq` varchar(2) DEFAULT NULL,
  `roadNameBasementCode` varchar(1) DEFAULT NULL,
  `roadNameCode` varchar(7) DEFAULT NULL,
  `dong` varchar(40) DEFAULT NULL,
  `bonbun` varchar(4) DEFAULT NULL,
  `bubun` varchar(4) DEFAULT NULL,
  `sigunguCode` varchar(5) DEFAULT NULL,
  `eubmyundongCode` varchar(5) DEFAULT NULL,
  `dongCode` varchar(10) DEFAULT NULL,
  `landCode` varchar(1) DEFAULT NULL,
  `apartmentName` varchar(40) DEFAULT NULL,
  `jibun` varchar(10) DEFAULT NULL,
  `lng` varchar(30) DEFAULT NULL,
  `lat` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`aptCode`),
  UNIQUE KEY `UNIQUE` (`buildYear`,`apartmentName`,`jibun`,`sigunguCode`,`eubmyundongCode`) /*!80000 INVISIBLE */,
  KEY `houseinfo_dongCode_dongcode_dongCode_fk_idx` (`dongCode`) /*!80000 INVISIBLE */,
  CONSTRAINT `houseinfo_dongCode_dongcode_dongCode_fk` FOREIGN KEY (`dongCode`) REFERENCES `dongcode` (`dongCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

select * from housedeal;
select * from houseinfo;
select * from dongcode;



-- 시/광역시 뽑기 
select *
from dongcode
where right(dongcode, 8) = '00000000';

-- 구/군 뽑기 
select *
from dongcode
where right(dongcode, 6) = '000000'
	  and not right(dongcode, 8) = '00000000';

-- 동 뽑기 
select *
from dongcode
where right(dongcode, 2) = '00';


