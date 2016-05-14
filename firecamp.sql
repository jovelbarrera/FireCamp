-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: firecamp
-- ------------------------------------------------------
-- Server version	5.7.12

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
-- Table structure for table `firecamp`
--

DROP TABLE IF EXISTS `firecamp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `firecamp` (
  `idfirecamp` int(11) NOT NULL,
  `title` varchar(500) NOT NULL,
  `description` varchar(500) NOT NULL,
  `idproject` int(11) NOT NULL,
  PRIMARY KEY (`idfirecamp`),
  KEY `idproject` (`idproject`),
  CONSTRAINT `firecamp_ibfk_1` FOREIGN KEY (`idproject`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `firecamp`
--

LOCK TABLES `firecamp` WRITE;
/*!40000 ALTER TABLE `firecamp` DISABLE KEYS */;
/*!40000 ALTER TABLE `firecamp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invited`
--

DROP TABLE IF EXISTS `invited`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invited` (
  `idinvited` int(11) NOT NULL,
  `idfirecamp` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  KEY `idfirecamp` (`idfirecamp`),
  KEY `iduser` (`iduser`),
  KEY `idfirecamp_2` (`idfirecamp`),
  KEY `iduser_2` (`iduser`),
  CONSTRAINT `invited_ibfk_1` FOREIGN KEY (`idfirecamp`) REFERENCES `firecamp` (`idfirecamp`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `invited_ibfk_2` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invited`
--

LOCK TABLES `invited` WRITE;
/*!40000 ALTER TABLE `invited` DISABLE KEYS */;
/*!40000 ALTER TABLE `invited` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phase`
--

DROP TABLE IF EXISTS `phase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phase` (
  `idphase` int(11) NOT NULL,
  `phase` varchar(50) NOT NULL,
  `description` varchar(500) NOT NULL,
  `idproject` int(11) NOT NULL,
  PRIMARY KEY (`idphase`),
  KEY `idproject` (`idproject`),
  CONSTRAINT `phase_ibfk_1` FOREIGN KEY (`idproject`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phase`
--

LOCK TABLES `phase` WRITE;
/*!40000 ALTER TABLE `phase` DISABLE KEYS */;
/*!40000 ALTER TABLE `phase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `idpost` int(11) NOT NULL,
  `post` varchar(1000) NOT NULL,
  `idfirecamp` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  PRIMARY KEY (`idpost`),
  KEY `idfirecamp` (`idfirecamp`),
  KEY `iduser` (`iduser`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`idfirecamp`) REFERENCES `firecamp` (`idfirecamp`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `post_ibfk_2` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `level` varchar(45) NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `createdBy` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user` (`userId`),
  KEY `FK_createdBy` (`createdBy`),
  CONSTRAINT `FK_createdBy` FOREIGN KEY (`createdBy`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES (5,1,'1','2016-05-14 19:05:35','2016-05-14 19:05:35',1),(6,2,'1','2016-05-14 19:11:08','2016-05-14 19:11:08',1),(7,4,'2','2016-05-14 19:12:07','2016-05-14 19:12:07',2),(8,2,'2','2016-05-14 19:12:46','2016-05-14 19:22:31',4);
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `accepted` tinyint(1) DEFAULT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '0',
  `startedAt` datetime DEFAULT NULL,
  `deadlineAt` datetime DEFAULT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `managerId` int(10) DEFAULT NULL,
  `clientId` int(10) DEFAULT NULL,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `acceptedBy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_managerId` (`managerId`),
  KEY `FK_clientId` (`clientId`),
  KEY `FK_acceptedBy` (`acceptedBy`),
  CONSTRAINT `FK_acceptedBy` FOREIGN KEY (`acceptedBy`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_clientId` FOREIGN KEY (`clientId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`managerId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'Página web Empresa cliente','Desarrollo de un página web para la empresa cliente',1,1,NULL,'2016-04-30 04:05:40','2016-04-12 06:58:05',2,2,'2016-05-10 03:52:47',NULL),(2,'Software tracking de tareas','Desarrollo de un software para el tracking de las tareas internas de la organización',1,1,'2016-04-01 00:00:00','2016-08-01 00:00:00','2016-04-16 17:33:57',2,2,'2016-04-16 17:33:57',NULL),(3,'Tienda en línea','Se necesita una tienda accesible vía web para la compra de abarrotes',NULL,0,NULL,NULL,'2016-05-10 21:53:13',NULL,3,'2016-05-10 21:53:50',NULL);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource` (
  `idresource` int(11) NOT NULL,
  `resourcename` varchar(500) NOT NULL,
  `resource` varchar(500) NOT NULL,
  `idphase` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  PRIMARY KEY (`idresource`),
  KEY `idphase` (`idphase`),
  KEY `iduser` (`iduser`),
  CONSTRAINT `resource_ibfk_1` FOREIGN KEY (`idphase`) REFERENCES `phase` (`idphase`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `resource_ibfk_2` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `idrole` int(11) NOT NULL,
  `roletype` varchar(50) NOT NULL,
  `idproject` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  KEY `idproject` (`idproject`),
  KEY `iduser` (`iduser`),
  CONSTRAINT `role_ibfk_1` FOREIGN KEY (`idproject`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_ibfk_2` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `idtask` int(11) NOT NULL,
  `task` varchar(50) NOT NULL,
  `description` varchar(500) NOT NULL,
  `state` varchar(25) NOT NULL,
  `iduser` int(11) NOT NULL,
  `idphase` int(11) NOT NULL,
  KEY `iduser` (`iduser`),
  KEY `idphase` (`idphase`),
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `task_ibfk_2` FOREIGN KEY (`idphase`) REFERENCES `phase` (`idphase`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `username` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(500) NOT NULL,
  `picture` varchar(500) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `organization` varchar(100) NOT NULL,
  `isActive` tinyint(1) NOT NULL,
  `position` varchar(100) NOT NULL,
  `isInternal` tinyint(1) NOT NULL DEFAULT '0',
  `isAdmin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2016-04-16 16:47:33','2016-05-09 12:04:59','admin@firecamp.com','admin@firecamp.com','21232f297a57a5a743894a0e4a801fc3','https://lh3.googleusercontent.com/-xCrormdfTRM/AAAAAAAAAAI/AAAAAAAAAAA/ueh-recAOIE/photo.jpg','José Manuel','Calderón','FireCamp',1,'Administrator',0,1),(2,'2016-04-12 05:48:25','2016-05-08 21:46:00','roberto@mail.com','roberto@mail.com','e10adc3949ba59abbe56e057f20f883e','https://media.licdn.com/mpr/mpr/shrinknp_400_400/AAEAAQAAAAAAAALoAAAAJGExNGVhZGE2LTdjNTktNGQyNi04YTA3LTg2ZjRmYzA5MGQ3Nw.jpg','Roberto Ernesto','Jovel Barrera','FireCamp',1,'Project Manager',1,1),(3,'2016-05-10 21:47:16','2016-05-10 21:47:16','fatima@cliente.com','fatima@cliente.com','e10adc3949ba59abbe56e057f20f883e','http://hugsrprecious.com/wp-content/uploads/2016/04/woman-placeholder.jpg','Fátima','Pérez','Empresa Cliente',1,'Software Development',0,0),(4,'2016-05-10 23:17:53','2016-05-10 23:17:53','secretary@firecamp.com','secretary@firecamp.com','e10adc3949ba59abbe56e057f20f883e','http://hugsrprecious.com/wp-content/uploads/2016/04/woman-placeholder.jpg','Any','López','FireCamp',1,'Secretaria',1,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'firecamp'
--

--
-- Dumping routines for database 'firecamp'
--
/*!50003 DROP PROCEDURE IF EXISTS `getUserPrivileges` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUserPrivileges`(IN user_id INT)
BEGIN
	SELECT *
    FROM privilege
    WHERE userId = user_id
    ORDER BY updatedAt DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getUsers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUsers`(IN whereString INT)
BEGIN
	SELECT *
    FROM user
    WHERE whereString;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertUserPrivileges` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertUserPrivileges`(IN user_id INT, IN p_level INT, IN created_by INT )
BEGIN
	INSERT INTO privilege (userId, level, createdBy)
	VALUES (user_id, p_level, created_by);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-14 13:24:08
