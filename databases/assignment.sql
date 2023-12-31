-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 31, 2023 at 06:45 AM
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
-- Database: `assignment`
--

-- --------------------------------------------------------

--
-- Table structure for table `category_master`
--

CREATE TABLE `category_master` (
  `Id` int(100) NOT NULL,
  `name` varchar(250) NOT NULL,
  `parent_category_id` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category_master`
--

INSERT INTO `category_master` (`Id`, `name`, `parent_category_id`) VALUES
(1, 'Dress', 'Clothes'),
(3, 'Snicker', 'Shoes'),
(4, 'Jeans', NULL);

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

--
-- Dumping data for table `order_details`
--

INSERT INTO `order_details` (`Id`, `order_id`, `product_id`, `product_price`, `discount`) VALUES
(1, 5, 1, 2300, '1'),
(2, 6, 3, 23000, '4'),
(3, 7, 3, 23000, '4'),
(4, 8, 3, 23000, '4'),
(5, 9, 3, 23000, '4'),
(6, 10, 1, 2300, '1');

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

--
-- Dumping data for table `order_master`
--

INSERT INTO `order_master` (`Id`, `datetime`, `session_id`, `payment_mode`, `tax`, `total_amt`, `order_status`) VALUES
(1, '2023-08-30 12:36:22.000000', '7', 'Cash', '1', '1', 'Pending'),
(2, '2023-08-30 21:26:47.000000', '7', 'Cash', '1', '1', 'Pending'),
(3, '2023-08-30 22:02:19.000000', '7', 'Cash', '1', '1', 'Pending'),
(4, '2023-09-01 13:34:22.000000', '7', 'Cash', '1', '3', 'Pending'),
(5, '2023-09-01 13:55:30.000000', '7', 'Cash', '1', '2', 'Pending'),
(6, '2023-09-02 22:23:50.000000', '7', 'Cash', '10', '115000', 'Pending'),
(7, '2023-09-02 22:24:36.000000', '7', 'Cash', '10', '115000', 'Pending'),
(8, '2023-09-02 22:24:54.000000', '7', 'Cash', '10', '115000', 'Pending'),
(9, '2023-09-02 22:25:07.000000', '7', 'Cash', '10', '115000', 'Pending'),
(10, '2023-09-03 00:59:55.000000', '7', 'Cash', '10', '2300', 'Pending');

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
  `image` varchar(700) NOT NULL,
  `category_id` int(250) NOT NULL,
  `stock` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product_master`
--

INSERT INTO `product_master` (`Id`, `product_name`, `price`, `unit`, `discount`, `image`, `category_id`, `stock`) VALUES
(1, 'denim jeans', 2300, '5', '1', 'https://img.freepik.com/free-photo/jeans_1203-8093.jpg?w=740&t=st=1693236575~exp=1693237175~hmac=a5dd938622ed69636600d3b343b5c23ca9970772f89a072d6ff2319aac255cc2', 1, '20'),
(3, 'Cargo', 23000, '5', '4', 'https://imgs.search.brave.com/FOvnGA-gbb0gGvss5VdvJiSeNPO-Su9pqxnm2QVybCk/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9oaXBz/LmhlYXJzdGFwcHMu/Y29tL3ZhZGVyLXBy/b2QuczMuYW1hem9u/YXdzLmNvbS8xNjkw/NTU1MzMzLTE4OS02/NGMzZDM5Y2NkMzFi/LmpwZz9jcm9wPTF4/dzoxeGg7Y2VudGVy/LHRvcCZyZXNpemU9/OTgwOio', 4, '230'),
(4, 'Cargo', 1200, '1', '4', 'https://imgs.search.brave.com/FOvnGA-gbb0gGvss5VdvJiSeNPO-Su9pqxnm2QVybCk/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9oaXBz/LmhlYXJzdGFwcHMu/Y29tL3ZhZGVyLXBy/b2QuczMuYW1hem9u/YXdzLmNvbS8xNjkw/NTU1MzMzLTE4OS02/NGMzZDM5Y2NkMzFi/LmpwZz9jcm9wPTF4/dzoxeGg7Y2VudGVy/LHRvcCZyZXNpemU9/OTgwOio', 4, '20');

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
(1, 'admin', 'admin', 'regular', 'yes', 'admin@gmail.com', '1878695022', 'patiya', 'surat', 'gujarat', 'india', '989876'),
(2, 'Dhara Gamit', '123qwe', 'Who is yours boyfriend?', 'None', 'gamit@gmail.com', '1234567890', 'althan', 'surat', 'gujarat', 'india', '123456'),
(4, 'sujeet', 'sujeet', 'Who is your girlfriend?', 'Not Exist.', 'sujeet@gmail.com', ' 456780987', 'HEll', 'jaiselmer', 'rajasthan', 'India', '976334324432'),
(5, 'Lousie', 'Lois', 'What\'s your school name?', 'vanita', 'lousie@gmail.com', '9876542367', 'Kerala', 'Kerala', 'Kerala', 'India', '741552'),
(7, 'kunj', 'sujeet', 'What\'s yours friend\'s name?', 'kirtan', 'kunj@gmail.com', '123456789', '', '', '', '', ''),
(8, 'Dhara', 'meet', 'Your Favorite Actor', 'vijay setupati', 'dhara@gmail.com', '0987654321', 'vrindavan', 'vyara', 'gujarat', 'india', '90806');

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
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `order_details`
--
ALTER TABLE `order_details`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `order_master`
--
ALTER TABLE `order_master`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `product_master`
--
ALTER TABLE `product_master`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `userr_master`
--
ALTER TABLE `userr_master`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

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
  ADD CONSTRAINT `product_master_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category_master` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
