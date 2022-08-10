CREATE DATABASE  IF NOT EXISTS `cis` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cis`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: cis
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `AddressID` bigint NOT NULL,
  `StreetAddress` varchar(100) NOT NULL,
  `Area` varchar(100) DEFAULT NULL,
  `City` varchar(100) NOT NULL,
  `State` varchar(100) NOT NULL,
  `PinCode` varchar(10) NOT NULL,
  `Country` varchar(100) NOT NULL,
  `CollegeID` bigint NOT NULL,
  `ParentTableNo` tinyint NOT NULL,
  `ParentID` bigint NOT NULL,
  `CreateDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LastUpdateDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LastUpdateUser` varchar(32) NOT NULL,
  PRIMARY KEY (`AddressID`),
  KEY `idx_address_CollegeID` (`CollegeID`),
  KEY `idx_address_ParentTableNo_ParentID` (`ParentTableNo`,`ParentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Address Table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Street1','Area1','City1','State1','PinCode1','Country1',1,6,1,'2022-07-10 14:23:17','2022-07-10 14:23:17','rohith'),(2,'Street2','Area2','City2','State2','PinCode2','Country2',1,6,2,'2022-07-10 14:23:17','2022-07-10 14:23:17','rohith'),(3,'Street3','Area3','City3','State3','PinCode3','Country3',1,6,3,'2022-07-10 14:23:17','2022-07-10 14:23:17','rohith'),(4,'Street4','Area4','City4','State4','PinCode4','Country4',1,6,4,'2022-07-10 14:23:17','2022-07-10 14:23:17','rohith'),(5,'Street5','Area5','City5','State5','PinCode5','Country5',1,6,5,'2022-07-10 14:23:17','2022-07-10 14:23:17','rohith'),(6,'Street6','Area6','City6','State6','PinCode6','Country6',1,6,6,'2022-07-10 14:23:18','2022-07-10 14:23:18','rohith'),(7,'Street7','Area7','City7','State7','PinCode7','Country7',1,6,7,'2022-07-10 14:23:18','2022-07-10 14:23:18','rohith'),(8,'Street8','Area8','City8','State8','PinCode8','Country8',1,6,8,'2022-07-10 14:23:18','2022-07-10 14:23:18','rohith'),(9,'Street9','Area9','City9','State9','PinCode9','Country9',1,6,9,'2022-07-10 14:23:18','2022-07-10 14:23:18','rohith'),(10,'Street10','Area10','City10','State10','PinCode10','Country10',1,6,10,'2022-07-10 14:23:18','2022-07-10 14:23:18','rohith'),(11,'Street11','Area11','City11','State11','PinCode11','Country11',1,6,11,'2022-07-10 14:23:18','2022-07-10 14:23:18','rohith'),(12,'Street12','Area12','City12','State12','PinCode12','Country12',1,6,12,'2022-07-10 14:23:18','2022-07-10 14:23:18','rohith'),(13,'Street13','Area13','City13','State13','PinCode13','Country13',1,6,13,'2022-07-10 14:23:18','2022-07-10 14:23:18','rohith'),(14,'Street14','Area14','City14','State14','PinCode14','Country14',1,6,14,'2022-07-10 14:23:18','2022-07-10 14:23:18','rohith'),(15,'Street15','Area15','City15','State15','PinCode15','Country15',1,6,15,'2022-07-10 14:23:18','2022-07-10 14:23:18','rohith'),(16,'Street16','Area16','City16','State16','PinCode16','Country16',1,6,16,'2022-07-10 14:23:19','2022-07-10 14:23:19','rohith'),(17,'Street17','Area17','City17','State17','PinCode17','Country17',1,6,17,'2022-07-10 14:23:19','2022-07-10 14:23:19','rohith'),(18,'Street18','Area18','City18','State18','PinCode18','Country18',1,6,18,'2022-07-10 14:23:19','2022-07-10 14:23:19','rohith'),(19,'Street19','Area19','City19','State19','PinCode19','Country19',1,6,19,'2022-07-10 14:23:19','2022-07-10 14:23:19','rohith'),(20,'Street20','Area20','City20','State20','PinCode20','Country20',1,6,20,'2022-07-10 14:23:19','2022-07-10 14:23:19','rohith'),(21,'Street21','Area21','City21','State21','PinCode21','Country21',1,6,21,'2022-07-10 14:23:19','2022-07-10 14:23:19','rohith'),(22,'Street22','Area22','City22','State22','PinCode22','Country22',1,6,22,'2022-07-10 14:23:19','2022-07-10 14:23:19','rohith'),(23,'Street23','Area23','City23','State23','PinCode23','Country23',1,6,23,'2022-07-10 14:23:19','2022-07-10 14:23:19','rohith'),(24,'Street24','Area24','City24','State24','PinCode24','Country24',1,6,24,'2022-07-10 14:23:19','2022-07-10 14:23:19','rohith'),(25,'Street25','Area25','City25','State25','PinCode25','Country25',2,6,25,'2022-07-10 14:23:19','2022-07-10 14:23:19','rohith'),(26,'Street26','Area26','City26','State26','PinCode26','Country26',2,6,26,'2022-07-10 14:23:19','2022-07-10 14:23:19','rohith'),(27,'Street27','Area27','City27','State27','PinCode27','Country27',2,6,27,'2022-07-10 14:23:19','2022-07-10 14:23:19','rohith'),(28,'Street28','Area28','City28','State28','PinCode28','Country28',2,6,28,'2022-07-10 14:23:19','2022-07-10 14:23:19','rohith'),(29,'Street29','Area29','City29','State29','PinCode29','Country29',2,6,29,'2022-07-10 14:23:20','2022-07-10 14:23:20','rohith'),(30,'Street30','Area30','City30','State30','PinCode30','Country30',2,6,30,'2022-07-10 14:23:20','2022-07-10 14:23:20','rohith'),(31,'Street31','Area31','City31','State31','PinCode31','Country31',2,6,31,'2022-07-10 14:23:20','2022-07-10 14:23:20','rohith'),(32,'Street32','Area32','City32','State32','PinCode32','Country32',2,6,32,'2022-07-10 14:23:20','2022-07-10 14:23:20','rohith'),(33,'Street33','Area33','City33','State33','PinCode33','Country33',2,6,33,'2022-07-10 14:23:20','2022-07-10 14:23:20','rohith'),(34,'Street34','Area34','City34','State34','PinCode34','Country34',2,6,34,'2022-07-10 14:23:20','2022-07-10 14:23:20','rohith'),(35,'Street35','Area35','City35','State35','PinCode35','Country35',2,6,35,'2022-07-10 14:23:20','2022-07-10 14:23:20','rohith'),(36,'Street36','Area36','City36','State36','PinCode36','Country36',2,6,36,'2022-07-10 14:23:20','2022-07-10 14:23:20','rohith'),(37,'Street37','Area37','City37','State37','PinCode37','Country37',2,6,37,'2022-07-10 14:23:20','2022-07-10 14:23:20','rohith'),(38,'Street38','Area38','City38','State38','PinCode38','Country38',2,6,38,'2022-07-10 14:23:20','2022-07-10 14:23:20','rohith'),(39,'Street39','Area39','City39','State39','PinCode39','Country39',2,6,39,'2022-07-10 14:23:20','2022-07-10 14:23:20','rohith'),(40,'Street40','Area40','City40','State40','PinCode40','Country40',2,6,40,'2022-07-10 14:23:20','2022-07-10 14:23:20','rohith'),(41,'Street41','Area41','City41','State41','PinCode41','Country41',2,6,41,'2022-07-10 14:23:20','2022-07-10 14:23:20','rohith'),(42,'Street42','Area42','City42','State42','PinCode42','Country42',2,6,42,'2022-07-10 14:23:20','2022-07-10 14:23:20','rohith'),(43,'Street43','Area43','City43','State43','PinCode43','Country43',2,6,43,'2022-07-10 14:23:20','2022-07-10 14:23:20','rohith'),(44,'Street44','Area44','City44','State44','PinCode44','Country44',2,6,44,'2022-07-10 14:23:20','2022-07-10 14:23:20','rohith'),(45,'Street45','Area45','City45','State45','PinCode45','Country45',2,6,45,'2022-07-10 14:23:20','2022-07-10 14:23:20','rohith'),(46,'Street46','Area46','City46','State46','PinCode46','Country46',2,6,46,'2022-07-10 14:23:21','2022-07-10 14:23:21','rohith'),(47,'Street47','Area47','City47','State47','PinCode47','Country47',2,6,47,'2022-07-10 14:23:21','2022-07-10 14:23:21','rohith'),(48,'Street48','Area48','City48','State48','PinCode48','Country48',2,6,48,'2022-07-10 14:23:21','2022-07-10 14:23:21','rohith'),(49,'Street49','Area49','City49','State49','PinCode49','Country49',3,6,49,'2022-07-10 14:23:21','2022-07-10 14:23:21','rohith'),(50,'Street50','Area50','City50','State50','PinCode50','Country50',3,6,50,'2022-07-10 14:23:21','2022-07-10 14:23:21','rohith'),(51,'Street51','Area51','City51','State51','PinCode51','Country51',3,6,51,'2022-07-10 14:23:21','2022-07-10 14:23:21','rohith'),(52,'Street52','Area52','City52','State52','PinCode52','Country52',3,6,52,'2022-07-10 14:23:21','2022-07-10 14:23:21','rohith'),(53,'Street53','Area53','City53','State53','PinCode53','Country53',3,6,53,'2022-07-10 14:23:21','2022-07-10 14:23:21','rohith'),(54,'Street54','Area54','City54','State54','PinCode54','Country54',3,6,54,'2022-07-10 14:23:21','2022-07-10 14:23:21','rohith'),(55,'Street55','Area55','City55','State55','PinCode55','Country55',3,6,55,'2022-07-10 14:23:21','2022-07-10 14:23:21','rohith'),(56,'Street56','Area56','City56','State56','PinCode56','Country56',3,6,56,'2022-07-10 14:23:21','2022-07-10 14:23:21','rohith'),(57,'Street57','Area57','City57','State57','PinCode57','Country57',3,6,57,'2022-07-10 14:23:21','2022-07-10 14:23:21','rohith'),(58,'Street58','Area58','City58','State58','PinCode58','Country58',3,6,58,'2022-07-10 14:23:21','2022-07-10 14:23:21','rohith'),(59,'Street59','Area59','City59','State59','PinCode59','Country59',3,6,59,'2022-07-10 14:23:21','2022-07-10 14:23:21','rohith'),(60,'Street60','Area60','City60','State60','PinCode60','Country60',3,6,60,'2022-07-10 14:23:21','2022-07-10 14:23:21','rohith'),(61,'Street61','Area61','City61','State61','PinCode61','Country61',3,6,61,'2022-07-10 14:23:22','2022-07-10 14:23:22','rohith'),(62,'Street62','Area62','City62','State62','PinCode62','Country62',3,6,62,'2022-07-10 14:23:22','2022-07-10 14:23:22','rohith'),(63,'Street63','Area63','City63','State63','PinCode63','Country63',3,6,63,'2022-07-10 14:23:22','2022-07-10 14:23:22','rohith'),(64,'Street64','Area64','City64','State64','PinCode64','Country64',3,6,64,'2022-07-10 14:23:22','2022-07-10 14:23:22','rohith'),(65,'Street65','Area65','City65','State65','PinCode65','Country65',3,6,65,'2022-07-10 14:23:22','2022-07-10 14:23:22','rohith'),(66,'Street66','Area66','City66','State66','PinCode66','Country66',3,6,66,'2022-07-10 14:23:22','2022-07-10 14:23:22','rohith'),(67,'Street67','Area67','City67','State67','PinCode67','Country67',3,6,67,'2022-07-10 14:23:22','2022-07-10 14:23:22','rohith'),(68,'Street68','Area68','City68','State68','PinCode68','Country68',3,6,68,'2022-07-10 14:23:22','2022-07-10 14:23:22','rohith'),(69,'Street69','Area69','City69','State69','PinCode69','Country69',3,6,69,'2022-07-10 14:23:22','2022-07-10 14:23:22','rohith'),(70,'Street70','Area70','City70','State70','PinCode70','Country70',3,6,70,'2022-07-10 14:23:22','2022-07-10 14:23:22','rohith'),(71,'Street71','Area71','City71','State71','PinCode71','Country71',3,6,71,'2022-07-10 14:23:22','2022-07-10 14:23:22','rohith'),(72,'Street72','Area72','City72','State72','PinCode72','Country72',3,6,72,'2022-07-10 14:23:22','2022-07-10 14:23:22','rohith'),(73,'Street73','Area73','City73','State73','PinCode73','Country73',1,3,1,'2022-07-10 14:23:22','2022-07-10 14:23:22','rohith'),(74,'Street74','Area74','City74','State74','PinCode74','Country74',1,3,2,'2022-07-10 14:23:22','2022-07-10 14:23:22','rohith'),(75,'Street75','Area75','City75','State75','PinCode75','Country75',1,3,3,'2022-07-10 14:23:22','2022-07-10 14:23:22','rohith'),(76,'Street76','Area76','City76','State76','PinCode76','Country76',1,3,4,'2022-07-10 14:23:22','2022-07-10 14:23:22','rohith'),(77,'Street77','Area77','City77','State77','PinCode77','Country77',1,3,5,'2022-07-10 14:23:23','2022-07-10 14:23:23','rohith'),(78,'Street78','Area78','City78','State78','PinCode78','Country78',1,3,6,'2022-07-10 14:23:23','2022-07-10 14:23:23','rohith'),(79,'Street79','Area79','City79','State79','PinCode79','Country79',1,3,7,'2022-07-10 14:23:23','2022-07-10 14:23:23','rohith'),(80,'Street80','Area80','City80','State80','PinCode80','Country80',1,3,8,'2022-07-10 14:23:23','2022-07-10 14:23:23','rohith'),(81,'Street81','Area81','City81','State81','PinCode81','Country81',1,3,9,'2022-07-10 14:23:23','2022-07-10 14:23:23','rohith'),(82,'Street82','Area82','City82','State82','PinCode82','Country82',1,3,10,'2022-07-10 14:23:23','2022-07-10 14:23:23','rohith'),(83,'Street83','Area83','City83','State83','PinCode83','Country83',1,3,11,'2022-07-10 14:23:23','2022-07-10 14:23:23','rohith'),(84,'Street84','Area84','City84','State84','PinCode84','Country84',1,3,12,'2022-07-10 14:23:23','2022-07-10 14:23:23','rohith'),(85,'Street85','Area85','City85','State85','PinCode85','Country85',1,3,13,'2022-07-10 14:23:23','2022-07-10 14:23:23','rohith'),(86,'Street86','Area86','City86','State86','PinCode86','Country86',1,3,14,'2022-07-10 14:23:23','2022-07-10 14:23:23','rohith'),(87,'Street87','Area87','City87','State87','PinCode87','Country87',1,3,15,'2022-07-10 14:23:23','2022-07-10 14:23:23','rohith'),(88,'Street88','Area88','City88','State88','PinCode88','Country88',2,3,16,'2022-07-10 14:23:23','2022-07-10 14:23:23','rohith'),(89,'Street89','Area89','City89','State89','PinCode89','Country89',2,3,17,'2022-07-10 14:23:23','2022-07-10 14:23:23','rohith'),(90,'Street90','Area90','City90','State90','PinCode90','Country90',2,3,18,'2022-07-10 14:23:23','2022-07-10 14:23:23','rohith'),(91,'Street91','Area91','City91','State91','PinCode91','Country91',2,3,19,'2022-07-10 14:23:23','2022-07-10 14:23:23','rohith'),(92,'Street92','Area92','City92','State92','PinCode92','Country92',2,3,20,'2022-07-10 14:23:23','2022-07-10 14:23:23','rohith'),(93,'Street93','Area93','City93','State93','PinCode93','Country93',2,3,21,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(94,'Street94','Area94','City94','State94','PinCode94','Country94',2,3,22,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(95,'Street95','Area95','City95','State95','PinCode95','Country95',2,3,23,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(96,'Street96','Area96','City96','State96','PinCode96','Country96',2,3,24,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(97,'Street97','Area97','City97','State97','PinCode97','Country97',2,3,25,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(98,'Street98','Area98','City98','State98','PinCode98','Country98',2,3,26,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(99,'Street99','Area99','City99','State99','PinCode99','Country99',2,3,27,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(100,'Street100','Area100','City100','State100','PinCode100','Country100',2,3,28,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(101,'Street101','Area101','City101','State101','PinCode101','Country101',2,3,29,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(102,'Street102','Area102','City102','State102','PinCode102','Country102',2,3,30,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(103,'Street103','Area103','City103','State103','PinCode103','Country103',3,3,31,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(104,'Street104','Area104','City104','State104','PinCode104','Country104',3,3,32,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(105,'Street105','Area105','City105','State105','PinCode105','Country105',3,3,33,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(106,'Street106','Area106','City106','State106','PinCode106','Country106',3,3,34,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(107,'Street107','Area107','City107','State107','PinCode107','Country107',3,3,35,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(108,'Street108','Area108','City108','State108','PinCode108','Country108',3,3,36,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(109,'Street109','Area109','City109','State109','PinCode109','Country109',3,3,37,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(110,'Street110','Area110','City110','State110','PinCode110','Country110',3,3,38,'2022-07-10 14:23:24','2022-07-10 14:23:24','rohith'),(111,'Street111','Area111','City111','State111','PinCode111','Country111',3,3,39,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(112,'Street112','Area112','City112','State112','PinCode112','Country112',3,3,40,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(113,'Street113','Area113','City113','State113','PinCode113','Country113',3,3,41,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(114,'Street114','Area114','City114','State114','PinCode114','Country114',3,3,42,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(115,'Street115','Area115','City115','State115','PinCode115','Country115',3,3,43,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(116,'Street116','Area116','City116','State116','PinCode116','Country116',3,3,44,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(117,'Street117','Area117','City117','State117','PinCode117','Country117',3,3,45,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(118,'Street118','Area118','City118','State118','PinCode118','Country118',1,2,1,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(119,'Street119','Area119','City119','State119','PinCode119','Country119',1,2,2,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(120,'Street120','Area120','City120','State120','PinCode120','Country120',1,2,3,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(121,'Street121','Area121','City121','State121','PinCode121','Country121',2,2,4,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(122,'Street122','Area122','City122','State122','PinCode122','Country122',2,2,5,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(123,'Street123','Area123','City123','State123','PinCode123','Country123',2,2,6,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(124,'Street124','Area124','City124','State124','PinCode124','Country124',3,2,7,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(125,'Street125','Area125','City125','State125','PinCode125','Country125',3,2,8,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(126,'Street126','Area126','City126','State126','PinCode126','Country126',3,2,9,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(127,'Street127','Area127','City127','State127','PinCode127','Country127',1,1,1,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(128,'Street128','Area128','City128','State128','PinCode128','Country128',2,1,2,'2022-07-10 14:23:25','2022-07-10 14:23:25','rohith'),(129,'Street129','Area129','City129','State129','PinCode129','Country129',3,1,3,'2022-07-10 14:23:26','2022-07-10 14:23:26','rohith');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `college`
--

DROP TABLE IF EXISTS `college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `college` (
  `CollegeID` bigint NOT NULL,
  `Name` varchar(32) NOT NULL,
  `CreateDateTime` datetime NOT NULL,
  `LastUpdateDateTime` datetime NOT NULL,
  `LastUpdateUser` varchar(32) NOT NULL,
  PRIMARY KEY (`CollegeID`),
  UNIQUE KEY `Name_UNIQUE` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='College Table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `college`
--

LOCK TABLES `college` WRITE;
/*!40000 ALTER TABLE `college` DISABLE KEYS */;
INSERT INTO `college` VALUES (1,'RV College','2022-07-10 12:40:16','2022-07-10 12:40:16','rohith'),(2,'BMS College','2022-07-10 12:40:16','2022-07-10 12:40:16','rohith'),(3,'PES College','2022-07-10 12:40:16','2022-07-10 12:40:16','rohith');
/*!40000 ALTER TABLE `college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courseinstances`
--

DROP TABLE IF EXISTS `courseinstances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courseinstances` (
  `CourseInstanceID` bigint NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `CollegeID` bigint NOT NULL,
  `ParentTableNo` tinyint NOT NULL,
  `ParentID` bigint NOT NULL,
  `CreateDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LastUpdateDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LastUpdateUser` varchar(32) NOT NULL,
  PRIMARY KEY (`CourseInstanceID`),
  KEY `idx_courseinstances_CollegeID` (`CollegeID`),
  KEY `idx_courseinstances_ParentTableNo_ParentID` (`ParentTableNo`,`ParentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courseinstances`
--

LOCK TABLES `courseinstances` WRITE;
/*!40000 ALTER TABLE `courseinstances` DISABLE KEYS */;
INSERT INTO `courseinstances` VALUES (1,'2022-07-01','2022-07-01',1,4,1,'2022-07-10 13:26:29','2022-07-10 13:26:29','rohith'),(2,'2022-07-01','2023-06-30',1,4,1,'2022-07-10 13:26:29','2022-07-10 13:26:29','rohith'),(3,'2022-07-01','2022-07-01',1,4,2,'2022-07-10 13:26:29','2022-07-10 13:26:29','rohith'),(4,'2022-07-01','2023-06-30',1,4,2,'2022-07-10 13:26:29','2022-07-10 13:26:29','rohith'),(5,'2022-07-01','2022-07-01',1,4,3,'2022-07-10 13:26:29','2022-07-10 13:26:29','rohith'),(6,'2022-07-01','2023-06-30',1,4,3,'2022-07-10 13:26:29','2022-07-10 13:26:29','rohith'),(7,'2022-07-01','2022-07-01',1,4,10,'2022-07-10 13:26:29','2022-07-10 13:26:29','rohith'),(8,'2022-07-01','2023-06-30',1,4,10,'2022-07-10 13:26:29','2022-07-10 13:26:29','rohith'),(9,'2022-07-01','2022-07-01',1,4,11,'2022-07-10 13:26:29','2022-07-10 13:26:29','rohith'),(10,'2022-07-01','2023-06-30',1,4,11,'2022-07-10 13:26:29','2022-07-10 13:26:29','rohith'),(11,'2022-07-01','2022-07-01',1,4,12,'2022-07-10 13:26:30','2022-07-10 13:26:30','rohith'),(12,'2022-07-01','2023-06-30',1,4,12,'2022-07-10 13:26:30','2022-07-10 13:26:30','rohith'),(13,'2022-07-01','2022-07-01',2,4,4,'2022-07-10 13:26:30','2022-07-10 13:26:30','rohith'),(14,'2022-07-01','2023-06-30',2,4,4,'2022-07-10 13:26:30','2022-07-10 13:26:30','rohith'),(15,'2022-07-01','2022-07-01',2,4,5,'2022-07-10 13:26:30','2022-07-10 13:26:30','rohith'),(16,'2022-07-01','2023-06-30',2,4,5,'2022-07-10 13:26:30','2022-07-10 13:26:30','rohith'),(17,'2022-07-01','2022-07-01',2,4,6,'2022-07-10 13:26:30','2022-07-10 13:26:30','rohith'),(18,'2022-07-01','2023-06-30',2,4,6,'2022-07-10 13:26:31','2022-07-10 13:26:31','rohith'),(19,'2022-07-01','2022-07-01',2,4,13,'2022-07-10 13:26:31','2022-07-10 13:26:31','rohith'),(20,'2022-07-01','2023-06-30',2,4,13,'2022-07-10 13:26:31','2022-07-10 13:26:31','rohith'),(21,'2022-07-01','2022-07-01',2,4,14,'2022-07-10 13:26:31','2022-07-10 13:26:31','rohith'),(22,'2022-07-01','2023-06-30',2,4,14,'2022-07-10 13:26:31','2022-07-10 13:26:31','rohith'),(23,'2022-07-01','2022-07-01',2,4,15,'2022-07-10 13:26:31','2022-07-10 13:26:31','rohith'),(24,'2022-07-01','2023-06-30',2,4,15,'2022-07-10 13:26:31','2022-07-10 13:26:31','rohith'),(25,'2022-07-01','2022-07-01',3,4,7,'2022-07-10 13:26:31','2022-07-10 13:26:31','rohith'),(26,'2022-07-01','2023-06-30',3,4,7,'2022-07-10 13:26:31','2022-07-10 13:26:31','rohith'),(27,'2022-07-01','2022-07-01',3,4,8,'2022-07-10 13:26:31','2022-07-10 13:26:31','rohith'),(28,'2022-07-01','2023-06-30',3,4,8,'2022-07-10 13:26:31','2022-07-10 13:26:31','rohith'),(29,'2022-07-01','2022-07-01',3,4,9,'2022-07-10 13:26:31','2022-07-10 13:26:31','rohith'),(30,'2022-07-01','2023-06-30',3,4,9,'2022-07-10 13:26:31','2022-07-10 13:26:31','rohith'),(31,'2022-07-01','2022-07-01',3,4,16,'2022-07-10 13:26:31','2022-07-10 13:26:31','rohith'),(32,'2022-07-01','2023-06-30',3,4,16,'2022-07-10 13:26:31','2022-07-10 13:26:31','rohith'),(33,'2022-07-01','2022-07-01',3,4,17,'2022-07-10 13:26:31','2022-07-10 13:26:31','rohith'),(34,'2022-07-01','2023-06-30',3,4,17,'2022-07-10 13:26:32','2022-07-10 13:26:32','rohith'),(35,'2022-07-01','2022-07-01',3,4,18,'2022-07-10 13:26:32','2022-07-10 13:26:32','rohith'),(36,'2022-07-01','2023-06-30',3,4,18,'2022-07-10 13:26:32','2022-07-10 13:26:32','rohith');
/*!40000 ALTER TABLE `courseinstances` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `CourseID` bigint NOT NULL,
  `Name` varchar(32) NOT NULL,
  `CollegeID` bigint NOT NULL,
  `ParentTableNo` tinyint NOT NULL,
  `ParentID` bigint NOT NULL,
  `CreateDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LastUpdateDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LastUpdateUser` varchar(32) NOT NULL,
  PRIMARY KEY (`CourseID`),
  UNIQUE KEY `Name` (`Name`),
  KEY `idx_courses_CollegeID` (`CollegeID`),
  KEY `idx_courses_ParentTableNo_ParentID` (`ParentTableNo`,`ParentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Programming in C',1,2,1,'2022-08-07 17:56:47','2022-08-07 17:56:47','rohith'),(2,'Programming in Python',1,2,2,'2022-08-07 17:56:47','2022-08-07 17:56:47','rohith'),(3,'Basic Electronics',1,2,3,'2022-08-07 17:56:47','2022-08-07 17:56:47','rohith'),(4,'Data structures ',2,2,4,'2022-08-07 17:56:47','2022-08-07 17:56:47','rohith'),(5,'Cyber Security',2,2,5,'2022-08-07 17:56:47','2022-08-07 17:56:47','rohith'),(6,'Analog Electronics',2,2,6,'2022-08-07 17:56:47','2022-08-07 17:56:47','rohith'),(7,'Operating Systems',3,2,7,'2022-08-07 17:56:47','2022-08-07 17:56:47','rohith'),(8,'Machine Learning',3,2,8,'2022-08-07 17:56:47','2022-08-07 17:56:47','rohith'),(9,'Digital Electronics',3,2,9,'2022-08-07 17:56:47','2022-08-07 17:56:47','rohith'),(10,'Programming in C2',1,2,1,'2022-08-07 17:56:48','2022-08-07 17:56:48','rohith'),(11,'Programming in Python2',1,2,2,'2022-08-07 17:56:48','2022-08-07 17:56:48','rohith'),(12,'Basic Electronics2',1,2,3,'2022-08-07 17:56:48','2022-08-07 17:56:48','rohith'),(13,'Data structures2 ',2,2,4,'2022-08-07 17:56:48','2022-08-07 17:56:48','rohith'),(14,'Cyber Security2',2,2,5,'2022-08-07 17:56:48','2022-08-07 17:56:48','rohith'),(15,'Analog Electronics2',2,2,6,'2022-08-07 17:56:48','2022-08-07 17:56:48','rohith'),(16,'Operating Systems2',3,2,7,'2022-08-07 17:56:48','2022-08-07 17:56:48','rohith'),(17,'Machine Learning2',3,2,8,'2022-08-07 17:56:48','2022-08-07 17:56:48','rohith'),(18,'Digital Electronics2',3,2,9,'2022-08-07 17:56:49','2022-08-07 17:56:49','rohith');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `DepartmentID` bigint NOT NULL,
  `Name` varchar(32) NOT NULL,
  `CollegeID` bigint NOT NULL,
  `ParentTableNo` tinyint NOT NULL,
  `ParentID` bigint NOT NULL,
  `CreateDateTime` datetime NOT NULL,
  `LastUpdateDateTime` datetime NOT NULL,
  `LastUpdateUser` varchar(32) NOT NULL,
  PRIMARY KEY (`DepartmentID`),
  KEY `idx_department_CollegeID` (`CollegeID`),
  KEY `idx_department_ParentTableNo_ParentID` (`ParentTableNo`,`ParentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Department Table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'CSE',1,1,1,'2022-07-10 13:20:18','2022-07-10 13:20:18','rohith'),(2,'ISE',1,1,1,'2022-07-10 13:20:18','2022-07-10 13:20:18','rohith'),(3,'ECE',1,1,1,'2022-07-10 13:20:18','2022-07-10 13:20:18','rohith'),(4,'CSE',2,1,2,'2022-07-10 13:20:19','2022-07-10 13:20:19','rohith'),(5,'ISE',2,1,2,'2022-07-10 13:20:19','2022-07-10 13:20:19','rohith'),(6,'ECE',2,1,2,'2022-07-10 13:20:19','2022-07-10 13:20:19','rohith'),(7,'CSE',3,1,3,'2022-07-10 13:20:19','2022-07-10 13:20:19','rohith'),(8,'ISE',3,1,3,'2022-07-10 13:20:19','2022-07-10 13:20:19','rohith'),(9,'ECE',3,1,3,'2022-07-10 13:20:19','2022-07-10 13:20:19','rohith');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty` (
  `FacultyID` bigint NOT NULL,
  `Name` varchar(32) NOT NULL,
  `Designation` tinyint NOT NULL,
  `CollegeID` bigint NOT NULL,
  `ParentTableNo` tinyint NOT NULL,
  `ParentID` bigint NOT NULL,
  `CreateDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LastUpdateDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LastUpdateUser` varchar(32) NOT NULL,
  PRIMARY KEY (`FacultyID`),
  UNIQUE KEY `Name` (`Name`),
  KEY `idx_faculty_CollegeID` (`CollegeID`),
  KEY `idx_faculty_ParentTableNo_ParentID` (`ParentTableNo`,`ParentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Faculty Table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES (1,'Name1',1,1,2,1,'2022-08-07 17:50:12','2022-08-07 17:50:12','rohith'),(2,'Name2',2,1,2,1,'2022-08-07 17:50:12','2022-08-07 17:50:12','rohith'),(3,'Name3',3,1,2,1,'2022-08-07 17:50:12','2022-08-07 17:50:12','rohith'),(4,'Name4',4,1,2,1,'2022-08-07 17:50:12','2022-08-07 17:50:12','rohith'),(5,'Name5',5,1,2,1,'2022-08-07 17:50:12','2022-08-07 17:50:12','rohith'),(6,'Name6',1,1,2,2,'2022-08-07 17:50:12','2022-08-07 17:50:12','rohith'),(7,'Name7',2,1,2,2,'2022-08-07 17:50:12','2022-08-07 17:50:12','rohith'),(8,'Name8',3,1,2,2,'2022-08-07 17:50:12','2022-08-07 17:50:12','rohith'),(9,'Name9',4,1,2,2,'2022-08-07 17:50:13','2022-08-07 17:50:13','rohith'),(10,'Name10',5,1,2,2,'2022-08-07 17:50:13','2022-08-07 17:50:13','rohith'),(11,'Name11',1,1,2,3,'2022-08-07 17:50:13','2022-08-07 17:50:13','rohith'),(12,'Name12',2,1,2,3,'2022-08-07 17:50:13','2022-08-07 17:50:13','rohith'),(13,'Name13',3,1,2,3,'2022-08-07 17:50:13','2022-08-07 17:50:13','rohith'),(14,'Name14',4,1,2,3,'2022-08-07 17:50:14','2022-08-07 17:50:14','rohith'),(15,'Name15',5,1,2,3,'2022-08-07 17:50:14','2022-08-07 17:50:14','rohith'),(16,'Name16',1,2,2,4,'2022-08-07 17:50:14','2022-08-07 17:50:14','rohith'),(17,'Name17',2,2,2,4,'2022-08-07 17:50:14','2022-08-07 17:50:14','rohith'),(18,'Name18',3,2,2,4,'2022-08-07 17:50:14','2022-08-07 17:50:14','rohith'),(19,'Name19',4,2,2,4,'2022-08-07 17:50:14','2022-08-07 17:50:14','rohith'),(20,'Name20',5,2,2,4,'2022-08-07 17:50:14','2022-08-07 17:50:14','rohith'),(21,'Name21',1,2,2,5,'2022-08-07 17:50:14','2022-08-07 17:50:14','rohith'),(22,'Name22',2,2,2,5,'2022-08-07 17:50:14','2022-08-07 17:50:14','rohith'),(23,'Name23',3,2,2,5,'2022-08-07 17:50:14','2022-08-07 17:50:14','rohith'),(24,'Name24',4,2,2,5,'2022-08-07 17:50:14','2022-08-07 17:50:14','rohith'),(25,'Name25',5,2,2,5,'2022-08-07 17:50:14','2022-08-07 17:50:14','rohith'),(26,'Name26',1,2,2,6,'2022-08-07 17:50:14','2022-08-07 17:50:14','rohith'),(27,'Name27',2,2,2,6,'2022-08-07 17:50:15','2022-08-07 17:50:15','rohith'),(28,'Name28',3,2,2,6,'2022-08-07 17:50:15','2022-08-07 17:50:15','rohith'),(29,'Name29',4,2,2,6,'2022-08-07 17:50:15','2022-08-07 17:50:15','rohith'),(30,'Name30',5,2,2,6,'2022-08-07 17:50:15','2022-08-07 17:50:15','rohith'),(31,'Name31',1,3,2,7,'2022-08-07 17:50:15','2022-08-07 17:50:15','rohith'),(32,'Name32',2,3,2,7,'2022-08-07 17:50:15','2022-08-07 17:50:15','rohith'),(33,'Name33',3,3,2,7,'2022-08-07 17:50:15','2022-08-07 17:50:15','rohith'),(34,'Name34',4,3,2,7,'2022-08-07 17:50:15','2022-08-07 17:50:15','rohith'),(35,'Name35',5,3,2,7,'2022-08-07 17:50:15','2022-08-07 17:50:15','rohith'),(36,'Name36',1,3,2,8,'2022-08-07 17:50:15','2022-08-07 17:50:15','rohith'),(37,'Name37',2,3,2,8,'2022-08-07 17:50:15','2022-08-07 17:50:15','rohith'),(38,'Name38',3,3,2,8,'2022-08-07 17:50:15','2022-08-07 17:50:15','rohith'),(39,'Name39',4,3,2,8,'2022-08-07 17:50:15','2022-08-07 17:50:15','rohith'),(40,'Name40',5,3,2,8,'2022-08-07 17:50:15','2022-08-07 17:50:15','rohith'),(41,'Name41',1,3,2,9,'2022-08-07 17:50:15','2022-08-07 17:50:15','rohith'),(42,'Name42',2,3,2,9,'2022-08-07 17:50:15','2022-08-07 17:50:15','rohith'),(43,'Name43',3,3,2,9,'2022-08-07 17:50:16','2022-08-07 17:50:16','rohith'),(44,'Name44',4,3,2,9,'2022-08-07 17:50:16','2022-08-07 17:50:16','rohith'),(45,'Name45',5,3,2,9,'2022-08-07 17:50:16','2022-08-07 17:50:16','rohith');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `StudentID` bigint NOT NULL,
  `Name` varchar(32) NOT NULL,
  `CollegeID` bigint NOT NULL,
  `ParentTableNo` tinyint NOT NULL,
  `ParentID` bigint NOT NULL,
  `CreateDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LastUpdateDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LastUpdateUser` varchar(32) NOT NULL,
  PRIMARY KEY (`StudentID`),
  UNIQUE KEY `Name` (`Name`),
  KEY `idx_student_CollegeID` (`CollegeID`),
  KEY `idx_student_ParentTableNo_ParentID` (`ParentTableNo`,`ParentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'1',1,5,1,'2022-07-10 14:22:35','2022-07-10 14:22:35','rohith'),(2,'2',1,5,1,'2022-07-10 14:22:36','2022-07-10 14:22:36','rohith'),(3,'3',1,5,2,'2022-07-10 14:22:36','2022-07-10 14:22:36','rohith'),(4,'4',1,5,2,'2022-07-10 14:22:36','2022-07-10 14:22:36','rohith'),(5,'5',1,5,3,'2022-07-10 14:22:36','2022-07-10 14:22:36','rohith'),(6,'6',1,5,3,'2022-07-10 14:22:36','2022-07-10 14:22:36','rohith'),(7,'7',1,5,4,'2022-07-10 14:22:36','2022-07-10 14:22:36','rohith'),(8,'8',1,5,4,'2022-07-10 14:22:36','2022-07-10 14:22:36','rohith'),(9,'9',1,5,5,'2022-07-10 14:22:36','2022-07-10 14:22:36','rohith'),(10,'10',1,5,5,'2022-07-10 14:22:36','2022-07-10 14:22:36','rohith'),(11,'11',1,5,6,'2022-07-10 14:22:37','2022-07-10 14:22:37','rohith'),(12,'12',1,5,6,'2022-07-10 14:22:37','2022-07-10 14:22:37','rohith'),(13,'13',1,5,7,'2022-07-10 14:22:37','2022-07-10 14:22:37','rohith'),(14,'14',1,5,7,'2022-07-10 14:22:37','2022-07-10 14:22:37','rohith'),(15,'15',1,5,8,'2022-07-10 14:22:37','2022-07-10 14:22:37','rohith'),(16,'16',1,5,8,'2022-07-10 14:22:37','2022-07-10 14:22:37','rohith'),(17,'17',1,5,9,'2022-07-10 14:22:37','2022-07-10 14:22:37','rohith'),(18,'18',1,5,9,'2022-07-10 14:22:37','2022-07-10 14:22:37','rohith'),(19,'19',1,5,10,'2022-07-10 14:22:37','2022-07-10 14:22:37','rohith'),(20,'20',1,5,10,'2022-07-10 14:22:37','2022-07-10 14:22:37','rohith'),(21,'21',1,5,11,'2022-07-10 14:22:37','2022-07-10 14:22:37','rohith'),(22,'22',1,5,11,'2022-07-10 14:22:37','2022-07-10 14:22:37','rohith'),(23,'23',1,5,12,'2022-07-10 14:22:37','2022-07-10 14:22:37','rohith'),(24,'24',1,5,12,'2022-07-10 14:22:37','2022-07-10 14:22:37','rohith'),(25,'25',2,5,13,'2022-07-10 14:22:38','2022-07-10 14:22:38','rohith'),(26,'26',2,5,13,'2022-07-10 14:22:38','2022-07-10 14:22:38','rohith'),(27,'27',2,5,14,'2022-07-10 14:22:38','2022-07-10 14:22:38','rohith'),(28,'28',2,5,14,'2022-07-10 14:22:38','2022-07-10 14:22:38','rohith'),(29,'29',2,5,15,'2022-07-10 14:22:38','2022-07-10 14:22:38','rohith'),(30,'30',2,5,15,'2022-07-10 14:22:38','2022-07-10 14:22:38','rohith'),(31,'31',2,5,16,'2022-07-10 14:22:38','2022-07-10 14:22:38','rohith'),(32,'32',2,5,16,'2022-07-10 14:22:38','2022-07-10 14:22:38','rohith'),(33,'33',2,5,17,'2022-07-10 14:22:38','2022-07-10 14:22:38','rohith'),(34,'34',2,5,17,'2022-07-10 14:22:38','2022-07-10 14:22:38','rohith'),(35,'35',2,5,18,'2022-07-10 14:22:38','2022-07-10 14:22:38','rohith'),(36,'36',2,5,18,'2022-07-10 14:22:38','2022-07-10 14:22:38','rohith'),(37,'37',2,5,19,'2022-07-10 14:22:38','2022-07-10 14:22:38','rohith'),(38,'38',2,5,19,'2022-07-10 14:22:38','2022-07-10 14:22:38','rohith'),(39,'39',2,5,20,'2022-07-10 14:22:38','2022-07-10 14:22:38','rohith'),(40,'40',2,5,20,'2022-07-10 14:22:39','2022-07-10 14:22:39','rohith'),(41,'41',2,5,21,'2022-07-10 14:22:39','2022-07-10 14:22:39','rohith'),(42,'42',2,5,21,'2022-07-10 14:22:39','2022-07-10 14:22:39','rohith'),(43,'43',2,5,22,'2022-07-10 14:22:39','2022-07-10 14:22:39','rohith'),(44,'44',2,5,22,'2022-07-10 14:22:39','2022-07-10 14:22:39','rohith'),(45,'45',2,5,23,'2022-07-10 14:22:39','2022-07-10 14:22:39','rohith'),(46,'46',2,5,23,'2022-07-10 14:22:39','2022-07-10 14:22:39','rohith'),(47,'47',2,5,24,'2022-07-10 14:22:39','2022-07-10 14:22:39','rohith'),(48,'48',2,5,24,'2022-07-10 14:22:39','2022-07-10 14:22:39','rohith'),(49,'49',3,5,25,'2022-07-10 14:22:39','2022-07-10 14:22:39','rohith'),(50,'50',3,5,25,'2022-07-10 14:22:39','2022-07-10 14:22:39','rohith'),(51,'51',3,5,26,'2022-07-10 14:22:39','2022-07-10 14:22:39','rohith'),(52,'52',3,5,26,'2022-07-10 14:22:39','2022-07-10 14:22:39','rohith'),(53,'53',3,5,27,'2022-07-10 14:22:39','2022-07-10 14:22:39','rohith'),(54,'54',3,5,27,'2022-07-10 14:22:39','2022-07-10 14:22:39','rohith'),(55,'55',3,5,28,'2022-07-10 14:22:39','2022-07-10 14:22:39','rohith'),(56,'56',3,5,28,'2022-07-10 14:22:40','2022-07-10 14:22:40','rohith'),(57,'57',3,5,29,'2022-07-10 14:22:40','2022-07-10 14:22:40','rohith'),(58,'58',3,5,29,'2022-07-10 14:22:40','2022-07-10 14:22:40','rohith'),(59,'59',3,5,30,'2022-07-10 14:22:40','2022-07-10 14:22:40','rohith'),(60,'60',3,5,30,'2022-07-10 14:22:40','2022-07-10 14:22:40','rohith'),(61,'61',3,5,31,'2022-07-10 14:22:40','2022-07-10 14:22:40','rohith'),(62,'62',3,5,31,'2022-07-10 14:22:40','2022-07-10 14:22:40','rohith'),(63,'63',3,5,32,'2022-07-10 14:22:40','2022-07-10 14:22:40','rohith'),(64,'64',3,5,32,'2022-07-10 14:22:40','2022-07-10 14:22:40','rohith'),(65,'65',3,5,33,'2022-07-10 14:22:40','2022-07-10 14:22:40','rohith'),(66,'66',3,5,33,'2022-07-10 14:22:40','2022-07-10 14:22:40','rohith'),(67,'67',3,5,34,'2022-07-10 14:22:40','2022-07-10 14:22:40','rohith'),(68,'68',3,5,34,'2022-07-10 14:22:40','2022-07-10 14:22:40','rohith'),(69,'69',3,5,35,'2022-07-10 14:22:40','2022-07-10 14:22:40','rohith'),(70,'70',3,5,35,'2022-07-10 14:22:40','2022-07-10 14:22:40','rohith'),(71,'71',3,5,36,'2022-07-10 14:22:40','2022-07-10 14:22:40','rohith'),(72,'72',3,5,36,'2022-07-10 14:22:40','2022-07-10 14:22:40','rohith');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'cis'
--

--
-- Dumping routines for database 'cis'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-10 19:49:22
