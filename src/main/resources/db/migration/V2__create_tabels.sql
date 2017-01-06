
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cars_java`
--

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE IF NOT EXISTS `brand` (
`id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `yearly_turnover` decimal(19,2) DEFAULT NULL,
  `storehouse_id` bigint(20) DEFAULT NULL,
  `location_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE IF NOT EXISTS `location` (
`id` bigint(20) NOT NULL,
  `country` varchar(255) DEFAULT NULL,
  `post_code` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `model`
--

CREATE TABLE IF NOT EXISTS `model` (
`id` bigint(20) NOT NULL,
  `engine_type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `speed` smallint(6) DEFAULT NULL,
  `brand_id` bigint(20) DEFAULT NULL,
  `model_type_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `model_type`
--

CREATE TABLE IF NOT EXISTS `model_type` (
`id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `model_type_model_list`
--

CREATE TABLE IF NOT EXISTS `model_type_model_list` (
  `model_type_id` bigint(20) NOT NULL,
  `model_list_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brand`
--
ALTER TABLE `brand`
 ADD PRIMARY KEY (`id`), ADD KEY `FKoco38xjkqa2o7giswpxlacls2` (`storehouse_id`), ADD KEY `FKqn3rgbbhyepkxumey4qo88hg5` (`location_id`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `model`
--
ALTER TABLE `model`
 ADD PRIMARY KEY (`id`), ADD KEY `FKhbgv4j3vpt308sepyq9q79mhu` (`brand_id`), ADD KEY `FK4predchy67lxyol7lv15spd6d` (`model_type_id`);

--
-- Indexes for table `model_type`
--
ALTER TABLE `model_type`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `model_type_model_list`
--
ALTER TABLE `model_type_model_list`
 ADD UNIQUE KEY `UK_qn67tia111g9ipj7lu8pcqdde` (`model_list_id`), ADD KEY `FK3o49xlwvx5gp62l6o30jrww2p` (`model_type_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `brand`
--
ALTER TABLE `brand`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `model`
--
ALTER TABLE `model`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `model_type`
--
ALTER TABLE `model_type`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `brand`
--
ALTER TABLE `brand`
ADD CONSTRAINT `FKqn3rgbbhyepkxumey4qo88hg5` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
ADD CONSTRAINT `FKoco38xjkqa2o7giswpxlacls2` FOREIGN KEY (`storehouse_id`) REFERENCES `location` (`id`);

--
-- Constraints for table `model`
--
ALTER TABLE `model`
ADD CONSTRAINT `FK4predchy67lxyol7lv15spd6d` FOREIGN KEY (`model_type_id`) REFERENCES `model_type` (`id`),
ADD CONSTRAINT `FKhbgv4j3vpt308sepyq9q79mhu` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`);

--
-- Constraints for table `model_type_model_list`
--
ALTER TABLE `model_type_model_list`
ADD CONSTRAINT `FK3o49xlwvx5gp62l6o30jrww2p` FOREIGN KEY (`model_type_id`) REFERENCES `model_type` (`id`),
ADD CONSTRAINT `FK94ltsngrs8rynegjqhwd86du1` FOREIGN KEY (`model_list_id`) REFERENCES `model` (`id`);


