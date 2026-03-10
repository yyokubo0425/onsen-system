-- MySQL dump 10.13  Distrib 9.4.0, for Win64 (x86_64)
--
-- Host: onsen-db.cqviegmqi8k3.us-east-1.rds.amazonaws.com    Database: onsen_db
-- ------------------------------------------------------
-- Server version	8.0.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `favorite`
--

DROP TABLE IF EXISTS `favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorite` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `onsen_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcpq5fqdq6iue3wvc3sj10bb8k` (`onsen_id`),
  KEY `FKh3f2dg11ibnht4fvnmx60jcif` (`user_id`),
  CONSTRAINT `FKcpq5fqdq6iue3wvc3sj10bb8k` FOREIGN KEY (`onsen_id`) REFERENCES `onsen` (`id`),
  CONSTRAINT `FKh3f2dg11ibnht4fvnmx60jcif` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite`
--

LOCK TABLES `favorite` WRITE;
/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `onsen`
--

DROP TABLE IF EXISTS `onsen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `onsen` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `description` text,
  `image1` varchar(255) DEFAULT NULL,
  `image1public_id` varchar(255) DEFAULT NULL,
  `image2` varchar(255) DEFAULT NULL,
  `image2public_id` varchar(255) DEFAULT NULL,
  `image3` varchar(255) DEFAULT NULL,
  `image3public_id` varchar(255) DEFAULT NULL,
  `image4` varchar(255) DEFAULT NULL,
  `image4public_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `prefecture` varchar(255) DEFAULT NULL,
  `ranking` int DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `onsen`
--

LOCK TABLES `onsen` WRITE;
/*!40000 ALTER TABLE `onsen` DISABLE KEYS */;
INSERT INTO `onsen` VALUES (14,'2025-11-30 11:28:10.565575','海と山に囲まれた自然豊かな温泉地。湯量が豊富で肌にやさしい泉質が魅力です。駅からのアクセスも良く、旅館やグルメも充実。海を眺めながらゆったり浸かれる絶景露天風呂が人気です。','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764497941/onsen_images/rjhnfp0cseufmjhuvbej.jpg','onsen_images/rjhnfp0cseufmjhuvbej','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764497942/onsen_images/ylsze7y9wtiwacfcaxv5.avif','onsen_images/ylsze7y9wtiwacfcaxv5','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764497943/onsen_images/p136qqvygmn1xfrdvws4.webp','onsen_images/p136qqvygmn1xfrdvws4','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764497944/onsen_images/hwlwakq0j4qhrne5tu1k.jpg','onsen_images/hwlwakq0j4qhrne5tu1k','熱海温泉','静岡県',1,'2025-11-30 20:30:55.539223'),(15,'2025-11-30 19:18:05.154933','渓谷沿いに佇む歴史ある温泉地。四季折々の自然が美しく、開放感あふれる露天風呂が魅力。肌にやさしい湯と静かな川のせせらぎが心を癒やし、都会の喧騒を忘れさせてくれる癒しの宿場。','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502281/onsen_images/jzlwrgivlrxzt7ywk6rw.webp','onsen_images/jzlwrgivlrxzt7ywk6rw','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502281/onsen_images/xhqpncae5onbyjkemnvx.webp','onsen_images/xhqpncae5onbyjkemnvx','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764497886/onsen_images/kpyggnkurvcv6bf4kb4m.jpg','onsen_images/kpyggnkurvcv6bf4kb4m','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764497887/onsen_images/qwqwe12zkfj95bwi23rw.jpg','onsen_images/qwqwe12zkfj95bwi23rw','鬼怒川温泉','栃木県',2,'2025-11-30 20:31:20.375403'),(16,'2025-11-30 20:31:51.734904','古くから文人や旅人に愛される名湯。  やわらかな湯ざわりと穏やかな街並みが魅力です。渓流沿いの露天風呂では四季の自然を感じながら、静かな癒しの時間をゆっくりと過ごせます。','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502311/onsen_images/ztnlgxd3bnped7x5rs5x.avif','onsen_images/ztnlgxd3bnped7x5rs5x','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502312/onsen_images/dbamanxewtu83wxyqvbm.avif','onsen_images/dbamanxewtu83wxyqvbm','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502312/onsen_images/fuaef4gzcdeyl1bjni0l.jpg','onsen_images/fuaef4gzcdeyl1bjni0l','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502313/onsen_images/wss1rebqy69apwgemj4r.jpg','onsen_images/wss1rebqy69apwgemj4r','湯河原温泉','神奈川県',3,'2025-11-30 20:31:51.734926'),(17,'2025-11-30 20:32:21.584245','「日本三名泉」に数えられる名湯。\r\nとろりとした湯ざわりで“美人の湯”として知られます。飛騨の自然と温泉街の風情が調和し、心も体も癒やされる穏やかな時間を過ごせます。','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502341/onsen_images/cz5hhl0fe8lmh3wfgv5m.jpg','onsen_images/cz5hhl0fe8lmh3wfgv5m','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502342/onsen_images/nwduswklsuyd9126hghi.jpg','onsen_images/nwduswklsuyd9126hghi','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502342/onsen_images/hut9tdvqdfqyji4pws8m.jpg','onsen_images/hut9tdvqdfqyji4pws8m','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502342/onsen_images/dtlqdyu9k0wybz2hxf8i.jpg','onsen_images/dtlqdyu9k0wybz2hxf8i','下呂温泉','岐阜県',4,'2025-11-30 20:32:21.584262'),(18,'2025-11-30 20:33:03.273324','栃木県那須の山あいに広がる名湯。  渓谷美と滝の音に包まれた自然豊かな温泉地です。泉質の多彩さが魅力で、湯巡りを楽しみながら四季折々の風景と静かな癒しを味わえます。','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502383/onsen_images/a7uz9axnfvdvcdpmznlc.jpg','onsen_images/a7uz9axnfvdvcdpmznlc','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502383/onsen_images/epilj9q5ywcsr0sgqpnx.jpg','onsen_images/epilj9q5ywcsr0sgqpnx','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502384/onsen_images/u2qayohpxxc8lydmhbl5.jpg','onsen_images/u2qayohpxxc8lydmhbl5','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502385/onsen_images/urf0iep5cmaqkual8aua.jpg','onsen_images/urf0iep5cmaqkual8aua','塩原温泉','栃木県',5,'2025-11-30 20:33:03.273343'),(19,'2025-11-30 20:35:00.105892','伊東温泉は豊富な湯量と歴史ある湯治文化で知られる国内屈指の温泉地です。海と山に囲まれた温暖な気候で、源泉かけ流しの宿や共同浴場が多く、肌に優しい弱アルカリ性の湯が特徴。観光とリラクゼーションを同時に楽しめる人気の温泉地です。','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502500/onsen_images/bdqzkzpuvqk4wrni92n0.avif','onsen_images/bdqzkzpuvqk4wrni92n0','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502500/onsen_images/sowlnyyxxntjm9wcpbgy.avif','onsen_images/sowlnyyxxntjm9wcpbgy','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502500/onsen_images/pfbjtgw2q23xjj8x0n0n.webp','onsen_images/pfbjtgw2q23xjj8x0n0n','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502501/onsen_images/k2ypmwamj5kn7klao2fh.webp','onsen_images/k2ypmwamj5kn7klao2fh','伊東温泉','静岡県',6,'2025-11-30 20:35:00.105911'),(20,'2025-11-30 20:35:22.845835','鳴子温泉は千年以上の歴史を持ち、日本でも珍しい多彩な泉質が一度に楽しめる名湯です。白濁・黒湯・硫黄泉など種類が豊富で、美肌効果や疲労回復に優れる湯治場として発展。鳴子峡の自然美も魅力で、四季を通じて訪れる人が絶えない温泉地です。','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502547/onsen_images/a5kv32bni21tf24nyu7e.jpg','onsen_images/a5kv32bni21tf24nyu7e','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502547/onsen_images/vygbfdnrxngiywgoek4d.jpg','onsen_images/vygbfdnrxngiywgoek4d','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502547/onsen_images/nu4bzlktuyswzbkvee1v.jpg','onsen_images/nu4bzlktuyswzbkvee1v','https://res.cloudinary.com/dq8sg2lr6/image/upload/v1764502548/onsen_images/tqesiz7w3mdxace5bx78.jpg','onsen_images/tqesiz7w3mdxace5bx78','鳴子温泉','宮城県',7,'2025-11-30 20:35:47.053183');
/*!40000 ALTER TABLE `onsen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin@admin.com','$2a$10$A2X9mv4VgLXIpwsngJwIyOfEY0fCxZTEysuDziXE0RQo64P7z9fl.','ROLE_ADMIN','admin'),(2,'user1@user1.com','$2a$10$.ZePTlfO5wceV/frM.e0F.5yJI8CZumYKq5BW988N9II1akITNKT6','ROLE_USER','user1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-10 16:44:21
