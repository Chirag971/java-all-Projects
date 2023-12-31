-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 24, 2023 at 04:25 AM
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
-- Database: `fashion_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `category_master`
--

CREATE TABLE `category_master` (
  `Id` int(100) NOT NULL,
  `name` varchar(250) NOT NULL,
  `parent_category_id` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category_master`
--

INSERT INTO `category_master` (`Id`, `name`, `parent_category_id`) VALUES
(1, 'Dress', 'Clothes'),
(3, 'Snickers', 'Shoes');

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE `order_details` (
  `Id` int(100) NOT NULL,
  `order_id` int(100) NOT NULL,
  `product_id` int(100) NOT NULL,
  `product_price` int(100) NOT NULL,
  `discount` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order_master`
--

CREATE TABLE `order_master` (
  `Id` int(100) NOT NULL,
  `datetime` datetime(6) NOT NULL,
  `session_id` varchar(250) NOT NULL,
  `payment_mode` varchar(250) NOT NULL,
  `tax` varchar(250) NOT NULL,
  `total_amt` varchar(250) NOT NULL,
  `order_status` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product_master`
--

CREATE TABLE `product_master` (
  `Id` int(100) NOT NULL,
  `product_name` varchar(250) NOT NULL,
  `price` int(250) NOT NULL,
  `unit` varchar(250) NOT NULL,
  `discount` varchar(250) NOT NULL,
  `image` varchar(250) NOT NULL,
  `category_id` int(250) NOT NULL,
  `stock` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `userr_master`
--

CREATE TABLE `userr_master` (
  `Id` int(100) NOT NULL,
  `username` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `password_ques` varchar(250) NOT NULL,
  `password_ans` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `contact_no` varchar(100) NOT NULL,
  `address` varchar(250) NOT NULL,
  `city` varchar(250) NOT NULL,
  `state` varchar(250) NOT NULL,
  `country` varchar(250) NOT NULL,
  `pin` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userr_master`
--

INSERT INTO `userr_master` (`Id`, `username`, `password`, `password_ques`, `password_ans`, `email`, `contact_no`, `address`, `city`, `state`, `country`, `pin`) VALUES
(1, 'Bhagyashree', '123qwe', 'regular', 'yes', 'bhagyashree@gmail.com', '1878695022', 'patiya', 'surat', 'gujarat', 'india', '989876'),
(2, 'sujeet', 'sujeet', 'sujeet', 'sujeet', 'sujeet@gmail.com', '1234567890', 'althan', 'surat', 'gujarat', 'india', '123456'),
(3, 'null', '123wer', 'null', 'null', 'null@gmail.com', '34568765', 'udhana', 'surat', 'gujarat', 'India', '87653'),
(4, 'qwe', '13qwe', 'Regular', 'yes', 'qwe@gmail.com', '456780987', 'kdhsd sajd', 'jaiselmer', 'rajasthan', 'India', '976334'),
(5, 'ghj', '3456ygs', 'What\'s your school name?', 'vvhd', 'ghs@gmail.com', '9876542367', '', '', '', '', ''),
(7, 'kunj', '123qwe', 'What\'s yours friend\'s name?', 'kirtan', 'kunj@gmail.com', '123456789', '', '', '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category_master`
--
ALTER TABLE `category_master`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `order_master`
--
ALTER TABLE `order_master`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `product_master`
--
ALTER TABLE `product_master`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `product_master_ibfk_1` (`category_id`);

--
-- Indexes for table `userr_master`
--
ALTER TABLE `userr_master`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category_master`
--
ALTER TABLE `category_master`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `order_details`
--
ALTER TABLE `order_details`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order_master`
--
ALTER TABLE `order_master`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `product_master`
--
ALTER TABLE `product_master`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `userr_master`
--
ALTER TABLE `userr_master`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_master` (`Id`),
  ADD CONSTRAINT `order_details_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product_master` (`Id`);

--
-- Constraints for table `product_master`
--
ALTER TABLE `product_master`
  ADD CONSTRAINT `product_master_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category_master` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
