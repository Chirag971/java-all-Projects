-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 31, 2023 at 06:46 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `records`
--

-- --------------------------------------------------------

--
-- Table structure for table `category_master`
--

CREATE TABLE `category_master` (
  `Category_id` int(20) NOT NULL,
  `Category_Name` varchar(100) NOT NULL,
  `parent_category_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customer_records`
--

CREATE TABLE `customer_records` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `home_address` varchar(13) NOT NULL,
  `phone_number` varchar(13) NOT NULL,
  `business_address` varchar(100) NOT NULL,
  `business_phone_number` varchar(13) NOT NULL,
  `fax_number` varchar(13) NOT NULL,
  `cellular_phone` varchar(14) NOT NULL,
  `pager_number` varchar(15) NOT NULL,
  `marital_status` varchar(16) NOT NULL,
  `number_of_children` int(12) NOT NULL,
  `annual_income` decimal(12,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer_records`
--

INSERT INTO `customer_records` (`id`, `name`, `home_address`, `phone_number`, `business_address`, `business_phone_number`, `fax_number`, `cellular_phone`, `pager_number`, `marital_status`, `number_of_children`, `annual_income`) VALUES
(1, 'sujeeet', 'sdafsaf', '23423', 'dsfsf', '24234', '32432', '2424', '242323', 'unmarid', 15, 124565),
(2, 'sujeeet', 'sdafsaf', '23423', 'dsfsf', '24234', '32432', '2424', '242323', 'unmarid', 15, 124565);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category_master`
--
ALTER TABLE `category_master`
  ADD PRIMARY KEY (`Category_id`),
  ADD KEY `parent_category_id` (`parent_category_id`);

--
-- Indexes for table `customer_records`
--
ALTER TABLE `customer_records`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category_master`
--
ALTER TABLE `category_master`
  MODIFY `Category_id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customer_records`
--
ALTER TABLE `customer_records`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `category_master`
--
ALTER TABLE `category_master`
  ADD CONSTRAINT `category_master_ibfk_1` FOREIGN KEY (`parent_category_id`) REFERENCES `category_master` (`Category_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
