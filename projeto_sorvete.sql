-- MySQL dump 10.13  Distrib 5.7.17, for Win32 (AMD64)
--
-- Host: localhost    Database: projeto_sorvete
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Table structure for table `adicional`
--

DROP TABLE IF EXISTS `adicional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adicional` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adicional`
--

LOCK TABLES `adicional` WRITE;
/*!40000 ALTER TABLE `adicional` DISABLE KEYS */;
INSERT INTO `adicional` VALUES (1,'Biscoito',1.5,0),(2,'Granulado',2,0),(3,'Creme',1,0);
/*!40000 ALTER TABLE `adicional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entregador`
--

DROP TABLE IF EXISTS `entregador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entregador` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `nascimento` date DEFAULT NULL,
  `cpf` varchar(100) DEFAULT NULL,
  `telefone` bigint(20) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entregador`
--

LOCK TABLES `entregador` WRITE;
/*!40000 ALTER TABLE `entregador` DISABLE KEYS */;
INSERT INTO `entregador` VALUES (1,'Daniel',NULL,'10020030045',999112233,2100,0),(2,'Martins','1995-05-04','10020030046',988123344,1950,0);
/*!40000 ALTER TABLE `entregador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entregador_pedido_delivery`
--

DROP TABLE IF EXISTS `entregador_pedido_delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entregador_pedido_delivery` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `entregador_id` bigint(20) DEFAULT NULL,
  `pedido_delivery_id` bigint(20) DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `entregador_id` (`entregador_id`,`pedido_delivery_id`),
  KEY `pedido_delivery_id` (`pedido_delivery_id`),
  CONSTRAINT `entregador_pedido_delivery_ibfk_1` FOREIGN KEY (`entregador_id`) REFERENCES `entregador` (`id`),
  CONSTRAINT `entregador_pedido_delivery_ibfk_2` FOREIGN KEY (`pedido_delivery_id`) REFERENCES `pedido_delivery` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entregador_pedido_delivery`
--

LOCK TABLES `entregador_pedido_delivery` WRITE;
/*!40000 ALTER TABLE `entregador_pedido_delivery` DISABLE KEYS */;
INSERT INTO `entregador_pedido_delivery` VALUES (1,2,1,0);
/*!40000 ALTER TABLE `entregador_pedido_delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garcom`
--

DROP TABLE IF EXISTS `garcom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `garcom` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `nascimento` date DEFAULT NULL,
  `cpf` varchar(100) DEFAULT NULL,
  `telefone` bigint(20) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garcom`
--

LOCK TABLES `garcom` WRITE;
/*!40000 ALTER TABLE `garcom` DISABLE KEYS */;
INSERT INTO `garcom` VALUES (1,'Rogério',NULL,NULL,998101112,1500,0),(2,'Alves','1990-12-01',NULL,998101112,1500,0);
/*!40000 ALTER TABLE `garcom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garcom_pedido_fisico`
--

DROP TABLE IF EXISTS `garcom_pedido_fisico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `garcom_pedido_fisico` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `garcom_id` bigint(20) DEFAULT NULL,
  `pedido_fisico_id` bigint(20) DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `garcom_id` (`garcom_id`,`pedido_fisico_id`),
  KEY `pedido_fisico_id` (`pedido_fisico_id`),
  CONSTRAINT `garcom_pedido_fisico_ibfk_1` FOREIGN KEY (`garcom_id`) REFERENCES `garcom` (`id`),
  CONSTRAINT `garcom_pedido_fisico_ibfk_2` FOREIGN KEY (`pedido_fisico_id`) REFERENCES `pedido_fisico` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garcom_pedido_fisico`
--

LOCK TABLES `garcom_pedido_fisico` WRITE;
/*!40000 ALTER TABLE `garcom_pedido_fisico` DISABLE KEYS */;
INSERT INTO `garcom_pedido_fisico` VALUES (1,2,1,0);
/*!40000 ALTER TABLE `garcom_pedido_fisico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gerente`
--

DROP TABLE IF EXISTS `gerente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gerente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `nascimento` date DEFAULT NULL,
  `cpf` varchar(100) DEFAULT NULL,
  `telefone` bigint(20) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gerente`
--

LOCK TABLES `gerente` WRITE;
/*!40000 ALTER TABLE `gerente` DISABLE KEYS */;
INSERT INTO `gerente` VALUES (1,'Nita','1979-02-07','11120030045',991223344,4750,0),(2,'Fabiana','1976-11-02','11120030046',991223345,5000,0),(3,'Alita',NULL,'11120030045',994022405,3250,0);
/*!40000 ALTER TABLE `gerente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `milkshake`
--

DROP TABLE IF EXISTS `milkshake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `milkshake` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tamanho_id` bigint(20) DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tamanho_id` (`tamanho_id`),
  CONSTRAINT `milkshake_ibfk_1` FOREIGN KEY (`tamanho_id`) REFERENCES `tamanho` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `milkshake`
--

LOCK TABLES `milkshake` WRITE;
/*!40000 ALTER TABLE `milkshake` DISABLE KEYS */;
INSERT INTO `milkshake` VALUES (1,3,0);
/*!40000 ALTER TABLE `milkshake` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_delivery`
--

DROP TABLE IF EXISTS `pedido_delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido_delivery` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_` datetime DEFAULT NULL,
  `cliente` varchar(100) DEFAULT NULL,
  `forma_pagamento` varchar(100) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `frete` double DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_delivery`
--

LOCK TABLES `pedido_delivery` WRITE;
/*!40000 ALTER TABLE `pedido_delivery` DISABLE KEYS */;
INSERT INTO `pedido_delivery` VALUES (1,'2022-07-08 21:58:41','Márcia','Cartão de Crédito','Rua ABC, 123',8.05,0);
/*!40000 ALTER TABLE `pedido_delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_delivery_milkshake`
--

DROP TABLE IF EXISTS `pedido_delivery_milkshake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido_delivery_milkshake` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pedido_delivery_id` bigint(20) DEFAULT NULL,
  `milkshake_id` bigint(20) DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pedido_delivery_id` (`pedido_delivery_id`,`milkshake_id`),
  KEY `milkshake_id` (`milkshake_id`),
  CONSTRAINT `pedido_delivery_milkshake_ibfk_1` FOREIGN KEY (`pedido_delivery_id`) REFERENCES `pedido_delivery` (`id`),
  CONSTRAINT `pedido_delivery_milkshake_ibfk_2` FOREIGN KEY (`milkshake_id`) REFERENCES `milkshake` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_delivery_milkshake`
--

LOCK TABLES `pedido_delivery_milkshake` WRITE;
/*!40000 ALTER TABLE `pedido_delivery_milkshake` DISABLE KEYS */;
INSERT INTO `pedido_delivery_milkshake` VALUES (1,1,1,0);
/*!40000 ALTER TABLE `pedido_delivery_milkshake` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_delivery_picole`
--

DROP TABLE IF EXISTS `pedido_delivery_picole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido_delivery_picole` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pedido_delivery_id` bigint(20) DEFAULT NULL,
  `picole_id` bigint(20) DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pedido_delivery_id` (`pedido_delivery_id`,`picole_id`),
  KEY `picole_id` (`picole_id`),
  CONSTRAINT `pedido_delivery_picole_ibfk_1` FOREIGN KEY (`pedido_delivery_id`) REFERENCES `pedido_delivery` (`id`),
  CONSTRAINT `pedido_delivery_picole_ibfk_2` FOREIGN KEY (`picole_id`) REFERENCES `picole` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_delivery_picole`
--

LOCK TABLES `pedido_delivery_picole` WRITE;
/*!40000 ALTER TABLE `pedido_delivery_picole` DISABLE KEYS */;
INSERT INTO `pedido_delivery_picole` VALUES (1,1,1,0);
/*!40000 ALTER TABLE `pedido_delivery_picole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_delivery_sorvete`
--

DROP TABLE IF EXISTS `pedido_delivery_sorvete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido_delivery_sorvete` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pedido_delivery_id` bigint(20) DEFAULT NULL,
  `sorvete_id` bigint(20) DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pedido_delivery_id` (`pedido_delivery_id`,`sorvete_id`),
  KEY `sorvete_id` (`sorvete_id`),
  CONSTRAINT `pedido_delivery_sorvete_ibfk_1` FOREIGN KEY (`pedido_delivery_id`) REFERENCES `pedido_delivery` (`id`),
  CONSTRAINT `pedido_delivery_sorvete_ibfk_2` FOREIGN KEY (`sorvete_id`) REFERENCES `sorvete` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_delivery_sorvete`
--

LOCK TABLES `pedido_delivery_sorvete` WRITE;
/*!40000 ALTER TABLE `pedido_delivery_sorvete` DISABLE KEYS */;
INSERT INTO `pedido_delivery_sorvete` VALUES (1,1,1,0);
/*!40000 ALTER TABLE `pedido_delivery_sorvete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_fisico`
--

DROP TABLE IF EXISTS `pedido_fisico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido_fisico` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_` datetime DEFAULT NULL,
  `cliente` varchar(100) DEFAULT NULL,
  `forma_pagamento` varchar(100) DEFAULT NULL,
  `gorjeta` double DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_fisico`
--

LOCK TABLES `pedido_fisico` WRITE;
/*!40000 ALTER TABLE `pedido_fisico` DISABLE KEYS */;
INSERT INTO `pedido_fisico` VALUES (1,'2022-07-08 21:58:41','Manuel','Pix',1,0);
/*!40000 ALTER TABLE `pedido_fisico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_fisico_milkshake`
--

DROP TABLE IF EXISTS `pedido_fisico_milkshake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido_fisico_milkshake` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pedido_fisico_id` bigint(20) DEFAULT NULL,
  `milkshake_id` bigint(20) DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pedido_fisico_id` (`pedido_fisico_id`,`milkshake_id`),
  KEY `milkshake_id` (`milkshake_id`),
  CONSTRAINT `pedido_fisico_milkshake_ibfk_1` FOREIGN KEY (`pedido_fisico_id`) REFERENCES `pedido_fisico` (`id`),
  CONSTRAINT `pedido_fisico_milkshake_ibfk_2` FOREIGN KEY (`milkshake_id`) REFERENCES `milkshake` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_fisico_milkshake`
--

LOCK TABLES `pedido_fisico_milkshake` WRITE;
/*!40000 ALTER TABLE `pedido_fisico_milkshake` DISABLE KEYS */;
INSERT INTO `pedido_fisico_milkshake` VALUES (1,1,1,0);
/*!40000 ALTER TABLE `pedido_fisico_milkshake` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_fisico_picole`
--

DROP TABLE IF EXISTS `pedido_fisico_picole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido_fisico_picole` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pedido_fisico_id` bigint(20) DEFAULT NULL,
  `picole_id` bigint(20) DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pedido_fisico_id` (`pedido_fisico_id`,`picole_id`),
  KEY `picole_id` (`picole_id`),
  CONSTRAINT `pedido_fisico_picole_ibfk_1` FOREIGN KEY (`pedido_fisico_id`) REFERENCES `pedido_fisico` (`id`),
  CONSTRAINT `pedido_fisico_picole_ibfk_2` FOREIGN KEY (`picole_id`) REFERENCES `picole` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_fisico_picole`
--

LOCK TABLES `pedido_fisico_picole` WRITE;
/*!40000 ALTER TABLE `pedido_fisico_picole` DISABLE KEYS */;
INSERT INTO `pedido_fisico_picole` VALUES (1,1,1,0);
/*!40000 ALTER TABLE `pedido_fisico_picole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_fisico_sorvete`
--

DROP TABLE IF EXISTS `pedido_fisico_sorvete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido_fisico_sorvete` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pedido_fisico_id` bigint(20) DEFAULT NULL,
  `sorvete_id` bigint(20) DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pedido_fisico_id` (`pedido_fisico_id`,`sorvete_id`),
  KEY `sorvete_id` (`sorvete_id`),
  CONSTRAINT `pedido_fisico_sorvete_ibfk_1` FOREIGN KEY (`pedido_fisico_id`) REFERENCES `pedido_fisico` (`id`),
  CONSTRAINT `pedido_fisico_sorvete_ibfk_2` FOREIGN KEY (`sorvete_id`) REFERENCES `sorvete` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_fisico_sorvete`
--

LOCK TABLES `pedido_fisico_sorvete` WRITE;
/*!40000 ALTER TABLE `pedido_fisico_sorvete` DISABLE KEYS */;
INSERT INTO `pedido_fisico_sorvete` VALUES (1,1,1,0);
/*!40000 ALTER TABLE `pedido_fisico_sorvete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picole`
--

DROP TABLE IF EXISTS `picole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picole` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tipo` enum('NATURAL','ESPECIAL') DEFAULT NULL,
  `sabor_id` bigint(20) DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sabor_id` (`sabor_id`),
  CONSTRAINT `picole_ibfk_1` FOREIGN KEY (`sabor_id`) REFERENCES `sabor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picole`
--

LOCK TABLES `picole` WRITE;
/*!40000 ALTER TABLE `picole` DISABLE KEYS */;
INSERT INTO `picole` VALUES (1,'ESPECIAL',1,0);
/*!40000 ALTER TABLE `picole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quantidade_milkshake`
--

DROP TABLE IF EXISTS `quantidade_milkshake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quantidade_milkshake` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sabor_id` bigint(20) DEFAULT NULL,
  `milkshake_id` bigint(20) DEFAULT NULL,
  `quantidade_bolas` bigint(20) DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sabor_id` (`sabor_id`,`milkshake_id`),
  KEY `milkshake_id` (`milkshake_id`),
  CONSTRAINT `quantidade_milkshake_ibfk_1` FOREIGN KEY (`milkshake_id`) REFERENCES `milkshake` (`id`),
  CONSTRAINT `quantidade_milkshake_ibfk_2` FOREIGN KEY (`sabor_id`) REFERENCES `sabor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quantidade_milkshake`
--

LOCK TABLES `quantidade_milkshake` WRITE;
/*!40000 ALTER TABLE `quantidade_milkshake` DISABLE KEYS */;
INSERT INTO `quantidade_milkshake` VALUES (1,1,1,2,0),(2,2,1,3,0),(3,3,1,1,0);
/*!40000 ALTER TABLE `quantidade_milkshake` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quantidade_sorvete`
--

DROP TABLE IF EXISTS `quantidade_sorvete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quantidade_sorvete` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sabor_id` bigint(20) DEFAULT NULL,
  `sorvete_id` bigint(20) DEFAULT NULL,
  `quantidade_bolas` bigint(20) DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sabor_id` (`sabor_id`,`sorvete_id`),
  KEY `sorvete_id` (`sorvete_id`),
  CONSTRAINT `quantidade_sorvete_ibfk_1` FOREIGN KEY (`sorvete_id`) REFERENCES `sorvete` (`id`),
  CONSTRAINT `quantidade_sorvete_ibfk_2` FOREIGN KEY (`sabor_id`) REFERENCES `sabor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quantidade_sorvete`
--

LOCK TABLES `quantidade_sorvete` WRITE;
/*!40000 ALTER TABLE `quantidade_sorvete` DISABLE KEYS */;
INSERT INTO `quantidade_sorvete` VALUES (1,1,1,3,0),(2,2,1,4,0);
/*!40000 ALTER TABLE `quantidade_sorvete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipiente`
--

DROP TABLE IF EXISTS `recipiente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipiente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipiente`
--

LOCK TABLES `recipiente` WRITE;
/*!40000 ALTER TABLE `recipiente` DISABLE KEYS */;
INSERT INTO `recipiente` VALUES (1,'Copo',0,0),(2,'Casquinha',0.5,0),(3,'Cascão',0.8,0),(4,'Taça',2,0);
/*!40000 ALTER TABLE `recipiente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sabor`
--

DROP TABLE IF EXISTS `sabor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sabor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `categoria` enum('PICOLE','PRODUTO_COMPOSTO') DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sabor`
--

LOCK TABLES `sabor` WRITE;
/*!40000 ALTER TABLE `sabor` DISABLE KEYS */;
INSERT INTO `sabor` VALUES (1,'Chocolate','PRODUTO_COMPOSTO',2,0),(2,'Morango','PRODUTO_COMPOSTO',1.5,0),(3,'Baunilha','PRODUTO_COMPOSTO',1.75,0),(4,'Chocolate','PICOLE',2,0),(5,'Manga','PICOLE',1.6,0),(6,'Melancia','PICOLE',1.6,0);
/*!40000 ALTER TABLE `sabor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sorvete`
--

DROP TABLE IF EXISTS `sorvete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sorvete` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `recipiente_id` bigint(20) DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `recipiente_id` (`recipiente_id`),
  CONSTRAINT `sorvete_ibfk_1` FOREIGN KEY (`recipiente_id`) REFERENCES `recipiente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sorvete`
--

LOCK TABLES `sorvete` WRITE;
/*!40000 ALTER TABLE `sorvete` DISABLE KEYS */;
INSERT INTO `sorvete` VALUES (1,1,0);
/*!40000 ALTER TABLE `sorvete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sorvete_adicional`
--

DROP TABLE IF EXISTS `sorvete_adicional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sorvete_adicional` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sorvete_id` bigint(20) DEFAULT NULL,
  `adicional_id` bigint(20) DEFAULT NULL,
  `quantidade` bigint(20) DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sorvete_id` (`sorvete_id`,`adicional_id`),
  KEY `adicional_id` (`adicional_id`),
  CONSTRAINT `sorvete_adicional_ibfk_1` FOREIGN KEY (`sorvete_id`) REFERENCES `sorvete` (`id`),
  CONSTRAINT `sorvete_adicional_ibfk_2` FOREIGN KEY (`adicional_id`) REFERENCES `adicional` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sorvete_adicional`
--

LOCK TABLES `sorvete_adicional` WRITE;
/*!40000 ALTER TABLE `sorvete_adicional` DISABLE KEYS */;
INSERT INTO `sorvete_adicional` VALUES (1,1,2,NULL,0),(2,1,3,NULL,0);
/*!40000 ALTER TABLE `sorvete_adicional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tamanho`
--

DROP TABLE IF EXISTS `tamanho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tamanho` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mililitros` bigint(20) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tamanho`
--

LOCK TABLES `tamanho` WRITE;
/*!40000 ALTER TABLE `tamanho` DISABLE KEYS */;
INSERT INTO `tamanho` VALUES (1,300,5.5,0),(2,400,6.5,0),(3,500,7.5,0);
/*!40000 ALTER TABLE `tamanho` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-11 16:53:52
