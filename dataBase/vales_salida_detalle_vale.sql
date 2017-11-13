-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: vales_salida
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `detalle_vale`
--

DROP TABLE IF EXISTS `detalle_vale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_vale` (
  `ID_DETALLE_VALE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_VALE` int(11) NOT NULL,
  `ID_UNIDAD_MEDIDA` int(11) NOT NULL,
  `FILA` int(11) NOT NULL,
  `CODIGO` varchar(45) NOT NULL,
  `DESCRIPCION` varchar(200) NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  `VALOR` double DEFAULT NULL,
  `PESO` double DEFAULT NULL,
  `REGRESA` varchar(2) DEFAULT NULL,
  `PERTENECE_MAQUINA` varchar(2) DEFAULT NULL,
  `NO_OC` int(11) DEFAULT NULL,
  `FECHA_ESPERADA` date DEFAULT NULL,
  `FECHA_PRORROGA` date DEFAULT NULL,
  `RECIBIDO` varchar(2) DEFAULT NULL,
  `FECHA_FINAL` date DEFAULT NULL,
  `VALOR_UNI` double DEFAULT NULL,
  `APROBADO` varchar(2) DEFAULT NULL,
  `OC_AD` int(11) DEFAULT NULL,
  `CENTRO` varchar(45) DEFAULT NULL,
  `UNIDAD` varchar(45) DEFAULT NULL,
  `PORT` varchar(10) DEFAULT NULL,
  `COMENTARIO` varchar(1000) DEFAULT NULL,
  `CANTIDAD_RECIBIDO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_DETALLE_VALE`),
  KEY `FK_DV_ID_VALE_idx` (`ID_VALE`),
  KEY `FK_DV_ID_UNIDAD_MEDIDA_idx` (`ID_UNIDAD_MEDIDA`),
  CONSTRAINT `FK_DV_ID_UNIDAD_MEDIDA` FOREIGN KEY (`ID_UNIDAD_MEDIDA`) REFERENCES `unidad_medida_vale` (`ID_UNIDAD_MEDIDA_VALE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_DV_ID_VALE` FOREIGN KEY (`ID_VALE`) REFERENCES `vale` (`ID_VALE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=822 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_vale`
--

LOCK TABLES `detalle_vale` WRITE;
/*!40000 ALTER TABLE `detalle_vale` DISABLE KEYS */;
INSERT INTO `detalle_vale` VALUES (11,1,1,1,'2','2',2,4,22,'Si','Si',0,'2017-11-03',NULL,'Si','2017-11-03',2,'No',0,'2','2','','',2),(21,2,1,1,'2','2',2,4,2,'Si','Si',0,'2017-11-03',NULL,'Si','2017-11-08',2,'No',0,'2','2','Si','',2),(22,2,1,2,'4','4',4,16,4,'Si','Si',0,'2017-11-03',NULL,'Si','2017-11-08',4,'No',0,'4','4','Si','',4),(23,2,1,3,'7','7',7,49,7,'Si','Si',0,'2017-11-03',NULL,'Si','2017-11-08',7,'No',0,'7','7','Si','',7),(24,2,1,4,'9','9',9,81,9,'Si','Si',0,'2017-11-03',NULL,'Si','2017-11-08',9,'No',0,'9','9','Si','',9),(41,4,1,1,'2','2',2,4,2,'Si','Si',0,'2017-11-06',NULL,'No',NULL,2,'No',0,'CO60','2','','',0),(51,5,1,1,'2','2',2,4,2,'Si','Si',0,'2017-11-06',NULL,'No',NULL,2,'No',0,'CO06','2','','',0),(61,6,1,1,'123','2',2,4,2,'Si','Si',0,'2017-11-06',NULL,'No',NULL,2,'No',0,'CO80','2','','',0),(62,6,1,2,'2','2',2,4,2,'Si','Si',0,'2017-11-06',NULL,'No',NULL,2,'No',0,'CO06','2','','',0),(63,6,1,3,'3','33',3,9,3,'Si','Si',0,'2017-11-06',NULL,'No',NULL,3,'No',0,'CO10','3','','',0),(71,7,1,1,'2','2',2,4,2,'Si','Si',0,'2017-11-06',NULL,'No',NULL,2,'No',0,'CO10','2','','',0),(72,7,1,2,'2','2',2,4,2,'Si','Si',0,'2017-11-06',NULL,'No',NULL,2,'No',0,'CO06','2','','',0),(81,8,1,1,'2','2',2,4,2,'Si','Si',0,'2017-11-06',NULL,'No',NULL,2,'No',0,'CO10','2','','',0),(82,8,1,2,'2','2',2,4,2,'Si','Si',0,'2017-11-06',NULL,'No',NULL,2,'No',0,'CO06','2','','',0),(91,9,1,1,'2','2',2,4,2,'Si','Si',0,'2017-11-06',NULL,'No',NULL,2,'No',0,'2','2','','',0),(101,10,1,1,'5001235','Cualquier cosa',10,1230000,50,'Si','Si',0,'2017-11-08',NULL,'No',NULL,123000,'No',0,'CO05','UN','','',0),(111,11,1,1,'123545','desdes',50,50,100,'Si','Si',0,'2017-11-08',NULL,'No',NULL,1,'No',0,'CO10','un','','',0);
/*!40000 ALTER TABLE `detalle_vale` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-12 21:00:48
