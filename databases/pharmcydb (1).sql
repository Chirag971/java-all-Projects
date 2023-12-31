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
-- Database: `pharmcydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `brandtable`
--

CREATE TABLE `brandtable` (
  `BrandId` int(25) NOT NULL,
  `BrandName` varchar(25) NOT NULL,
  `Address` varchar(25) NOT NULL,
  `ContactNo` int(12) NOT NULL,
  `Website` varchar(25) NOT NULL,
  `Email` varchar(25) NOT NULL,
  `Logo` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `brandtable`
--

INSERT INTO `brandtable` (`BrandId`, `BrandName`, `Address`, `ContactNo`, `Website`, `Email`, `Logo`) VALUES
(1, 'A', 'AA', 34567654, 'www.google.com', 'www@gmail.com', 'logo.png');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `CartId` int(25) NOT NULL,
  `UserId` int(25) NOT NULL,
  `CartTotal` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `CatId` int(25) NOT NULL,
  `CatName` varchar(25) NOT NULL,
  `CatType` varchar(25) NOT NULL,
  `CatImg` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`CatId`, `CatName`, `CatType`, `CatImg`) VALUES
(1, 'Meet', 'leg', 'img'),
(2, 'Painkillers', 'Medicine', 'img'),
(3, 'Antibiotics', 'Medicine', 'img'),
(4, 'Multivitamins', 'Medicine', 'img'),
(5, 'Plain', 'Full Body', 'cat.png');

-- --------------------------------------------------------

--
-- Table structure for table `ordertable`
--

CREATE TABLE `ordertable` (
  `OrderId` int(25) NOT NULL,
  `UserId` int(25) NOT NULL,
  `PayMode` varchar(25) NOT NULL,
  `OrderStatus` varchar(25) NOT NULL,
  `OrderTotal` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `productcart`
--

CREATE TABLE `productcart` (
  `CartProId` int(25) NOT NULL,
  `CartId` int(25) NOT NULL,
  `ProId` int(25) NOT NULL,
  `ProCartQuantity` int(25) NOT NULL,
  `ProCartPrice` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `productimg`
--

CREATE TABLE `productimg` (
  `ProImgId` int(25) NOT NULL,
  `ProId` int(25) NOT NULL,
  `FirstImg` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `productorder`
--

CREATE TABLE `productorder` (
  `OrderProId` int(25) NOT NULL,
  `OrderId` int(25) NOT NULL,
  `ProId` int(25) NOT NULL,
  `ProOderQuantity` int(25) NOT NULL,
  `ProOrderPrice` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `productreview`
--

CREATE TABLE `productreview` (
  `ReviewId` int(25) NOT NULL,
  `ProId` int(25) NOT NULL,
  `UserId` int(25) NOT NULL,
  `ProRating` varchar(25) NOT NULL,
  `ProReview` varchar(25) NOT NULL,
  `AddedDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `ProId` int(25) NOT NULL,
  `ProName` varchar(25) NOT NULL,
  `CatId` int(25) NOT NULL,
  `ProDescription` varchar(150) NOT NULL,
  `ExpDate` date NOT NULL,
  `ManDate` date NOT NULL,
  `BrandId` int(25) NOT NULL,
  `ProImg` varchar(25) NOT NULL,
  `ProPrice` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `usermaster`
--

CREATE TABLE `usermaster` (
  `userName` varchar(250) NOT NULL,
  `role` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `usertable`
--

CREATE TABLE `usertable` (
  `UserId` int(20) NOT NULL,
  `UserEmail` varchar(25) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `UserNumber` int(20) NOT NULL,
  `UserPassword` varchar(25) NOT NULL,
  `userName` varchar(250) NOT NULL,
  `Registerdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brandtable`
--
ALTER TABLE `brandtable`
  ADD PRIMARY KEY (`BrandId`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`CartId`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`CatId`);

--
-- Indexes for table `ordertable`
--
ALTER TABLE `ordertable`
  ADD PRIMARY KEY (`OrderId`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `productcart`
--
ALTER TABLE `productcart`
  ADD PRIMARY KEY (`CartProId`),
  ADD KEY `ProId` (`ProId`),
  ADD KEY `CartId` (`CartId`);

--
-- Indexes for table `productimg`
--
ALTER TABLE `productimg`
  ADD PRIMARY KEY (`ProImgId`);

--
-- Indexes for table `productorder`
--
ALTER TABLE `productorder`
  ADD PRIMARY KEY (`OrderProId`),
  ADD KEY `OrderId` (`OrderId`),
  ADD KEY `ProId` (`ProId`);

--
-- Indexes for table `productreview`
--
ALTER TABLE `productreview`
  ADD PRIMARY KEY (`ReviewId`),
  ADD KEY `ProId` (`ProId`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ProId`),
  ADD KEY `CatId` (`CatId`),
  ADD KEY `BrandId` (`BrandId`);

--
-- Indexes for table `usermaster`
--
ALTER TABLE `usermaster`
  ADD PRIMARY KEY (`userName`);

--
-- Indexes for table `usertable`
--
ALTER TABLE `usertable`
  ADD PRIMARY KEY (`UserId`),
  ADD KEY `userName` (`userName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `brandtable`
--
ALTER TABLE `brandtable`
  MODIFY `BrandId` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `CartId` int(25) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `CatId` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `ordertable`
--
ALTER TABLE `ordertable`
  MODIFY `OrderId` int(25) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `productcart`
--
ALTER TABLE `productcart`
  MODIFY `CartProId` int(25) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `productimg`
--
ALTER TABLE `productimg`
  MODIFY `ProImgId` int(25) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `productorder`
--
ALTER TABLE `productorder`
  MODIFY `OrderProId` int(25) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `productreview`
--
ALTER TABLE `productreview`
  MODIFY `ReviewId` int(25) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `ProId` int(25) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usertable`
--
ALTER TABLE `usertable`
  MODIFY `UserId` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `Cart_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `usertable` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ordertable`
--
ALTER TABLE `ordertable`
  ADD CONSTRAINT `OrderTable_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `usertable` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `productcart`
--
ALTER TABLE `productcart`
  ADD CONSTRAINT `ProductCart_ibfk_1` FOREIGN KEY (`ProId`) REFERENCES `products` (`ProId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ProductCart_ibfk_2` FOREIGN KEY (`CartId`) REFERENCES `cart` (`CartId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `productorder`
--
ALTER TABLE `productorder`
  ADD CONSTRAINT `ProductOrder_ibfk_1` FOREIGN KEY (`OrderId`) REFERENCES `ordertable` (`OrderId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ProductOrder_ibfk_2` FOREIGN KEY (`ProId`) REFERENCES `products` (`ProId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `productreview`
--
ALTER TABLE `productreview`
  ADD CONSTRAINT `ProductReview_ibfk_1` FOREIGN KEY (`ProId`) REFERENCES `products` (`ProId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ProductReview_ibfk_2` FOREIGN KEY (`UserId`) REFERENCES `usertable` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `Products_ibfk_1` FOREIGN KEY (`CatId`) REFERENCES `category` (`CatId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Products_ibfk_2` FOREIGN KEY (`BrandId`) REFERENCES `brandtable` (`BrandId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `usertable`
--
ALTER TABLE `usertable`
  ADD CONSTRAINT `usertable_ibfk_1` FOREIGN KEY (`userName`) REFERENCES `usermaster` (`userName`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
