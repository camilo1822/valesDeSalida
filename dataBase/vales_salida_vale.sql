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
-- Table structure for table `vale`
--

DROP TABLE IF EXISTS `vale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vale` (
  `ID_VALE` int(11) NOT NULL,
  `ID_ESTADO` int(11) NOT NULL,
  `PLANTA` varchar(100) DEFAULT NULL,
  `MATERIAL_PICIZ` varchar(2) DEFAULT NULL,
  `NOMBRE_DILIGENCIO` varchar(100) NOT NULL,
  `JUSTIFICACION` varchar(1000) DEFAULT NULL,
  `DESTINO_EMPRESA` varchar(100) NOT NULL,
  `DESTINO_NIT` varchar(20) NOT NULL,
  `DESTINO_DIRECCION` varchar(100) NOT NULL,
  `DESTINO_NOMBRE` varchar(100) NOT NULL,
  `DESTINO_TEL` varchar(20) DEFAULT NULL,
  `DESTINO_CIUDAD` varchar(50) DEFAULT NULL,
  `RETIRA_NOMBRE` varchar(100) NOT NULL,
  `RETIRA_IDENTIFICACION` varchar(20) NOT NULL,
  `RETIRA_EMPRESA` varchar(50) DEFAULT NULL,
  `RETIRA_PLACA` varchar(10) DEFAULT NULL,
  `FECHA_CREACION` date NOT NULL,
  `OBSERVACIONES` varchar(1000) DEFAULT NULL,
  `MOTIVO` varchar(45) NOT NULL,
  `DESTINO_PROVEEDOR` varchar(45) NOT NULL,
  `SOLICITANTE` varchar(45) NOT NULL,
  `ALMACEN` varchar(45) DEFAULT NULL,
  `PORTERIA` varchar(45) DEFAULT NULL,
  `RETIRA` varchar(45) DEFAULT NULL,
  `SENORES` varchar(100) DEFAULT NULL,
  `ALMACEN_ORIGEN` varchar(45) DEFAULT NULL,
  `APROBADORJEFE` varchar(45) DEFAULT NULL,
  `APROBADORALMACEN` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_VALE`),
  KEY `FK_ID_ESTADO_idx` (`ID_ESTADO`),
  CONSTRAINT `FK_ID_ESTADO` FOREIGN KEY (`ID_ESTADO`) REFERENCES `estado_vale` (`ID_ESTADO_VALE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vale`
--

LOCK TABLES `vale` WRITE;
/*!40000 ALTER TABLE `vale` DISABLE KEYS */;
INSERT INTO `vale` VALUES (1,1,' Medellin','No',' Marta Ligia Yepes Roldan','2','2','2','2','2','2','2','2','2','2','2','2017-11-03','2','Reparación / Fabricación','2',' Marta Ligia Yepes Roldan',' Marta Ligia Yepes Roldan',NULL,NULL,NULL,'AprobadoresMedellin','Marta Ligia Yepes Roldan','Marta Ligia Yepes Roldan'),(2,1,' Medellin','No',' Marta Ligia Yepes Roldan','2','2','2','2','2','2','2','2','2','2','2','2017-11-03','w','Procesamiento Parcial','2',' Marta Ligia Yepes Roldan',' Marta Ligia Yepes Roldan',NULL,NULL,NULL,'AprobadoresMedellin','Marta Ligia Yepes Roldan','Marta Ligia Yepes Roldan'),(4,1,' Medellin','No',' Marta Ligia Yepes Roldan','2','2','2','2','2','2','2','2','2','2','2','2017-11-06','2','Devolución','2',' Marta Ligia Yepes Roldan',NULL,NULL,NULL,NULL,'AprobadoresMedellin','Marta Ligia Yepes Roldan','Marta Ligia Yepes Roldan'),(5,1,' Medellin','No',' Marta Ligia Yepes Roldan','2','2','2','2','2','2','2','2','2','2','2','2017-11-06','2','Procesamiento Parcial','2',' Marta Ligia Yepes Roldan',' Marta Ligia Yepes Roldan',NULL,NULL,NULL,'AprobadoresMedellin','Marta Ligia Yepes Roldan','Marta Ligia Yepes Roldan'),(6,1,' Medellin','No',' Marta Ligia Yepes Roldan','2','2','2','2','2','2','2','2','2','2','2','2017-11-06','asd','Reparación / Fabricación','2',' Marta Ligia Yepes Roldan',' Marta Ligia Yepes Roldan',NULL,NULL,NULL,'AprobadoresMedellin','Marta Ligia Yepes Roldan','Marta Ligia Yepes Roldan'),(7,1,' Medellin','No',' Marta Ligia Yepes Roldan','3','2','2','2','2','2','2','2','2','2','2','2017-11-06','2','Venta Desperdicio','2',' Marta Ligia Yepes Roldan',' Marta Ligia Yepes Roldan',NULL,NULL,NULL,'AprobadoresMedellin','Marta Ligia Yepes Roldan','Marta Ligia Yepes Roldan'),(8,1,' Medellin','No',' Marta Ligia Yepes Roldan','2','22','2','2','2','2','2','2','2','2','2','2017-11-06','2','Devolución','2',' Marta Ligia Yepes Roldan',' Marta Ligia Yepes Roldan',NULL,NULL,NULL,'AprobadoresMedellin','Marta Ligia Yepes Roldan','Marta Ligia Yepes Roldan'),(9,1,' Medellin','No',' Marta Ligia Yepes Roldan','2','2','2','2','2','2','2','2','2','2','2','2017-11-06','2','Devolución','2',' Marta Ligia Yepes Roldan',NULL,NULL,NULL,NULL,'AprobadoresMedellin','Marta Ligia Yepes Roldan','Julio Cesar Duque Duque'),(10,1,' Cajica','No',' Sergio Alejandro Camacho Babativa','Salida','PRODUCTOS FAMILIA S.A.','8909001619','ereer','Sergioc','321321321321','bra','Sergio','809989898','Renault','321321321','2017-11-08','Prueba','Devolución','ererer',' Sergio Alejandro Camacho Babativa',NULL,NULL,NULL,NULL,'AprobadoresMedellin','Claudia Cecilia Uribe Segura',''),(11,1,' Cajica','No',' Sergio Alejandro Camacho Babativa','','PRODUCTOS FAMILIA CAJICA S.A.S','890900161','ppp','ppppp','321321','321','sergio','898998','321231','212121','2017-11-08','321321','Devolución','32123',' Sergio Alejandro Camacho Babativa',' Sergio Alejandro Camacho Babativa',NULL,NULL,NULL,'AprobadoresMedellin','Marta Ligia Yepes Roldan','Sergio Alejandro Camacho Babativa');
/*!40000 ALTER TABLE `vale` ENABLE KEYS */;
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
