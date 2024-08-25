-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.3.0 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.7.0.6850
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para bdrestfull
CREATE DATABASE IF NOT EXISTS `bdrestfull` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bdrestfull`;

-- Copiando estrutura para tabela bdrestfull.pessoa
CREATE TABLE IF NOT EXISTS `pessoa` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `endereco` varchar(100) NOT NULL,
  `nome_pessoa` varchar(100) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `sobrenome_pessoa` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela bdrestfull.pessoa: ~5 rows (aproximadamente)
INSERT INTO `pessoa` (`id`, `endereco`, `nome_pessoa`, `sexo`, `sobrenome_pessoa`) VALUES
	(2, 'parana', 'kiara', 'f', 'rodrigues'),
	(3, 'piaui', 'eliana', 'f', 'leite'),
	(5, 'ubatuba', 'Antonella linda ', 'f', 'rosa'),
	(6, 'Ubatuba', 'Yasmin', 'f', 'Leite'),
	(7, 'Ubatuba', 'Renan', 'M', 'Leite');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
