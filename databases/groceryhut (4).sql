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
-- Database: `groceryhut`
--

-- --------------------------------------------------------

--
-- Table structure for table `addressmaster`
--

CREATE TABLE `addressmaster` (
  `addId` int(100) NOT NULL,
  `phoneNo` int(10) NOT NULL,
  `AtlPhoneNo` int(10) DEFAULT NULL,
  `address` varchar(250) NOT NULL,
  `altAddress` varchar(250) DEFAULT NULL,
  `regId` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `addressmaster`
--

INSERT INTO `addressmaster` (`addId`, `phoneNo`, `AtlPhoneNo`, `address`, `altAddress`, `regId`) VALUES
(1, 987654321, 323453253, 'surat', 'althan', 1),
(2, 987654322, 323453253, 'vadodara', 'althan', 1),
(3, 1234567897, 1234567453, 'dindoli ', 'kharvasha', 4),
(4, 1234567894, 123345678, 'sachin', 'bardoli', 4),
(5, 5678900, 798765456, 'patiya', 'parvat', 2),
(6, 1234535534, 234567896, 'vayara', 'meetkigaliyan', 6),
(7, 1234567890, 123456788, 'surat', 'althan', 7),
(8, 234234, 3424, 'asdfsf', 'asfsf', 5);

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `cartid` int(100) NOT NULL,
  `regId` int(100) NOT NULL,
  `pId` int(100) NOT NULL,
  `quantity` int(100) NOT NULL,
  `price` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`cartid`, `regId`, `pId`, `quantity`, `price`) VALUES
(16, 4, 7, 3, 675),
(18, 2, 7, 6, 1350),
(20, 6, 18, 5, 202),
(22, 7, 6, 3, 114),
(23, 5, 6, 3, 114);

-- --------------------------------------------------------

--
-- Table structure for table `getintouch`
--

CREATE TABLE `getintouch` (
  `getId` int(100) NOT NULL,
  `regId` int(100) NOT NULL,
  `query` varchar(250) NOT NULL,
  `response` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `getintouch`
--

INSERT INTO `getintouch` (`getId`, `regId`, `query`, `response`) VALUES
(1, 1, 'why milk is white', 'bro,don\'t take weed in early morning'),
(2, 4, 'why lava is to hot', 'i don\'t know'),
(3, 5, 'fasdasfas', 'asdfsds');

-- --------------------------------------------------------

--
-- Table structure for table `managebrand`
--

CREATE TABLE `managebrand` (
  `bId` int(100) NOT NULL,
  `bName` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `managebrand`
--

INSERT INTO `managebrand` (`bId`, `bName`) VALUES
(1, 'Amul'),
(4, 'Balaji'),
(5, 'Coca Cola'),
(6, 'Diary Milk'),
(7, 'Taj Mahal'),
(8, 'Parle'),
(9, 'Mother Dairy'),
(10, 'Nestle'),
(11, 'Britannia'),
(12, 'Sunfeast'),
(13, 'Bisk Farm'),
(14, 'Monginis'),
(15, 'Pescafresh'),
(16, 'TastyFish'),
(17, 'Pedigree'),
(18, 'Drools'),
(19, 'Harpic'),
(20, 'Lizol'),
(21, 'Vim'),
(22, 'Himalaya Herbals'),
(23, 'Dabur'),
(24, 'Patanjali'),
(25, 'Fortune'),
(26, 'Tirupati'),
(27, 'Tata'),
(28, 'Ashirwad'),
(29, 'Detol'),
(30, 'Surf Excel'),
(31, 'Maggie'),
(32, 'Jolo'),
(33, 'Lays'),
(34, 'Fresho');

-- --------------------------------------------------------

--
-- Table structure for table `managecategory`
--

CREATE TABLE `managecategory` (
  `cId` int(100) NOT NULL,
  `cName` varchar(200) NOT NULL,
  `cImage` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `managecategory`
--

INSERT INTO `managecategory` (`cId`, `cName`, `cImage`) VALUES
(17, 'Fruits & Vegetable', 'vagetable.png'),
(18, 'Dairy', 'dairy.png'),
(19, 'Meat', 'meat.png'),
(20, 'Sea Food', 'seafood.png'),
(21, 'Bakery', 'bakery.png'),
(22, 'Grains and Cereals', 'Grains and Cereals.png'),
(23, 'Pasta and Rice', 'pasta and rice.png'),
(24, 'Canned Food', 'canned food.png'),
(25, 'Condiments', 'Condiments.png'),
(26, 'Baking Supplies', 'Baking Supplies.png'),
(27, 'Snacks', 'Snacks.png'),
(28, 'Beverages', 'Beverages.png'),
(29, 'Candy and Sweets', 'Candy and Sweets.png'),
(30, 'Personal Care', 'Personal Care.png'),
(31, 'Baby Care', 'baby care.png'),
(32, 'Household and Cleaning', 'Household and Cleaning.png');

-- --------------------------------------------------------

--
-- Table structure for table `manageproduct`
--

CREATE TABLE `manageproduct` (
  `pId` int(100) NOT NULL,
  `pName` varchar(250) NOT NULL,
  `pImage` varchar(250) NOT NULL,
  `ammount` double NOT NULL,
  `description` varchar(250) NOT NULL,
  `unit` int(100) NOT NULL,
  `stock` int(100) NOT NULL,
  `discount` double DEFAULT NULL,
  `discountedPrice` double DEFAULT NULL,
  `tax` double NOT NULL,
  `gst` double NOT NULL,
  `sgst` double NOT NULL,
  `totalDiscount` double NOT NULL,
  `cId` int(100) NOT NULL,
  `bId` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `manageproduct`
--

INSERT INTO `manageproduct` (`pId`, `pName`, `pImage`, `ammount`, `description`, `unit`, `stock`, `discount`, `discountedPrice`, `tax`, `gst`, `sgst`, `totalDiscount`, `cId`, `bId`) VALUES
(4, 'crunchex (100g)', 'crunchex.webp', 40, 'crunchey and simplae potato made', 1, 82, 10, 4, 12, 16, 16, 36, 27, 4),
(6, 'Coca Cola (200ml)', 'coca cola.jpg', 40, 'Black Color Soda', 10, 42, 5, 2, 10, 10, 10, 38, 28, 5),
(7, 'Ashirwad Select Atta (5 kg)', 'ashirwad select aata.webp', 250, 'pure flour with carbs Good For Health.', 1, 14, 10, 25, 20, 12, 12, 225, 22, 28),
(8, 'Detol Original', 'detol original.webp', 30, 'it\'s use for cleaning and washing', 2, 50, 10, 3, 5, 10, 10, 27, 32, 29),
(9, 'White Sugar (1kg)', 'white sugar 1kg.webp', 90, 'white and clean sugar', 1, 150, 15, 13.5, 10, 8, 8, 76.5, 26, 28),
(10, 'Surf Excel Matic', 'surf excel matic.webp', 230, 'Clean and White and Easy to Apply', 1, 450, 10, 23, 20, 13, 13, 207, 32, 30),
(11, 'Detoal Handwash Gulab', 'detol handwash gulab.webp', 47, 'Our Dettol Kill 100% becteria', 1, 34, 10, 4.7, 20, 9, 9, 42.3, 32, 29),
(12, 'Toor Dal', 'tata toor dal.webp', 350, 'Properly Clean and Fully Polished Dal', 1, 467, 10, 35, 7, 8, 8, 315, 22, 27),
(13, 'Vim Mega Value (2L)', 'vim mega value.webp', 135, 'Easy to Clean Dishes', 1, 236, 20, 27, 10, 12, 12, 108, 32, 21),
(14, 'Fortune Sun Lite (1L)', 'fortune sun lite.webp', 123, 'Soft Cotton Oil', 1, 254, 10, 12.3, 14, 15, 15, 110.7, 22, 25),
(15, 'Tata Salt (1kg)', 'tata salt.jpg', 20, 'Clean and vitmin salt', 1, 256, 1, 0.2, 4, 5, 5, 19.8, 26, 27),
(16, 'Britania Cake', 'britania cake.jpg', 24, 'Egg Free Cake with chocho falkes', 2, 23, 10, 2.4000000000000004, 3, 3, 5, 21.6, 21, 11),
(17, 'Dairy Milk Pack of 5', 'pack of 5 Dairy.jpg', 120, 'True value pack', 1, 46, 10, 12, 13, 12, 13, 108, 29, 6),
(18, 'Dairy Milk Cake ', 'Dairy Milk Cakes.jpg', 45, 'cake with delicious taste', 1, 41, 10, 4.5, 12, 12, 12, 40.5, 21, 6),
(19, 'Maggie Family Pack', 'maggie family fun.webp', 150, 'true value pack', 1, 26, 10, 15, 12, 5, 5, 135, 23, 31),
(20, 'Patanjali Honey', 'patanjali honey.webp', 79, 'pure honey made by bee ð', 2, 37, 10, 7.9, 9, 12, 13, 71.1, 26, 24),
(21, 'Anti Dandruff Shampoo', 'patanjali anti dandruf shampoo.webp', 127, 'anti dandruff shampoo clean hair properly', 1, 341, 10, 12.700000000000001, 11, 11, 11, 114.3, 30, 24),
(22, 'Coconut Oil', 'patanjali coconut oil.webp', 135, 'Coconut Oil made By Beach Oil', 1, 234, 15, 20.25, 12, 14, 14, 114.75, 30, 24),
(23, 'Dodh Biscuit', 'patanjali doodh bicuite.webp', 10, 'Dhodh with Biscuit', 1, 124, 10, 1, 15, 13, 13, 9, 27, 24),
(24, 'Jolo Chip', 'jolo chip.webp', 250, 'World hotest chips another way for death ', 1, 144, 10, 25, 12, 12, 15, 225, 27, 32),
(25, 'Sizaling Potato', 'lays sizaling hot potato.webp', 50, 'hot potato with sizaling', 1, 678, 18, 9, 12, 12, 12, 41, 27, 33),
(26, 'Fresh Bean', 'french beans.webp', 56, 'French Beans with high protien', 1, 45, 10, 5.6000000000000005, 12, 12, 12, 50.4, 17, 34),
(27, 'Strawberry', 'blue barry.webp', 67, 'strawberry naam hi kafi hai ', 1, 46, 34, 22.78, 2, 2, 2, 44.22, 17, 34),
(28, 'Brocoli', 'brocoli.webp', 34, 'Alien Species of Cauliflower', 2, 684, 34, 11.56, 5, 638, 54, 22.439999999999998, 17, 34),
(29, 'Blueberry', 'blue barry.webp', 846, 'Berry filled with blue color', 2, 47, 65, 549.9, 74, 8, 21, 296.1, 17, 34),
(31, 'Cucumber', 'cucumber.webp', 12, 'Sab Jante hai isaka use', 2, 345, 12, 1.44, 12, 12, 22, 10.56, 17, 34),
(32, 'Dragon Food', 'dragon fruit.webp', 461, 'Fruits From Game of Throns age', 2, 79, 45, 207.45000000000002, 12, 12, 74, 253.54999999999998, 17, 34),
(33, 'Loctose Free Milk', 'lactose free dodh.webp', 250, 'Aamiro Log ke Nakhre', 1, 45, 15, 37.5, 12, 17, 25, 212.5, 18, 1),
(34, 'Cow Ghee', 'Ghee.webp', 235, 'Pure made By Cow', 1, 35434, 23, 54.050000000000004, 3, 2, 4, 180.95, 18, 1),
(35, 'Pure Ghee', 'pure ghee.webp', 324, 'Ye Pakka Pure Hai', 2, 2342, 12, 38.879999999999995, 12, 12, 12, 285.12, 18, 1);

-- --------------------------------------------------------

--
-- Table structure for table `orderdeatails`
--

CREATE TABLE `orderdeatails` (
  `orderId` int(100) NOT NULL,
  `regId` int(100) NOT NULL,
  `taxAmt` double NOT NULL,
  `gstAmt` double NOT NULL,
  `sgstAmt` double NOT NULL,
  `pName` varchar(250) NOT NULL,
  `pQty` int(100) NOT NULL,
  `Amt` double NOT NULL,
  `oId` int(100) NOT NULL,
  `pId` int(100) NOT NULL,
  `addid` int(100) NOT NULL,
  `odate` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orderdeatails`
--

INSERT INTO `orderdeatails` (`orderId`, `regId`, `taxAmt`, `gstAmt`, `sgstAmt`, `pName`, `pQty`, `Amt`, `oId`, `pId`, `addid`, `odate`) VALUES
(10, 4, 108, 108, 135, 'Jolo Chip', 2, 900, 13, 24, 3, '2023-12-24'),
(11, 4, 405, 243, 243, 'Ashirwad Select Atta (5 kg)', 3, 2025, 14, 7, 4, '2023-12-24'),
(12, 4, 405, 243, 243, 'Ashirwad Select Atta (5 kg)', 3, 2025, 15, 7, 4, '2023-12-24'),
(13, 2, 1620, 972, 972, 'Ashirwad Select Atta (5 kg)', 6, 8100, 16, 7, 5, '2023-12-25'),
(14, 6, 121.19999999999999, 121.19999999999999, 121.19999999999999, 'Dairy Milk Cake ', 5, 1010, 17, 18, 6, '2023-12-28'),
(15, 7, 34.2, 34.2, 34.2, 'Coca Cola (200ml)', 3, 342, 18, 6, 7, '2023-12-29'),
(16, 5, 34.2, 34.2, 34.2, 'Coca Cola (200ml)', 3, 342, 19, 6, 8, '2023-12-29');

-- --------------------------------------------------------

--
-- Table structure for table `ordermaster`
--

CREATE TABLE `ordermaster` (
  `oId` int(100) NOT NULL,
  `regId` int(100) NOT NULL,
  `grandTotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ordermaster`
--

INSERT INTO `ordermaster` (`oId`, `regId`, `grandTotal`) VALUES
(13, 4, 1224),
(14, 4, 2916),
(15, 4, 2916),
(16, 2, 11664),
(17, 6, 1373.6000000000001),
(18, 7, 444.59999999999997),
(19, 5, 444.59999999999997);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payId` int(100) NOT NULL,
  `oId` int(100) NOT NULL,
  `regId` int(100) NOT NULL,
  `paymentMode` varchar(250) DEFAULT 'Cash',
  `upiId` varchar(100) DEFAULT NULL,
  `amt` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `productreview`
--

CREATE TABLE `productreview` (
  `reId` int(100) NOT NULL,
  `review` varchar(250) NOT NULL,
  `regId` int(100) NOT NULL,
  `pId` int(100) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `productreview`
--

INSERT INTO `productreview` (`reId`, `review`, `regId`, `pId`, `date`) VALUES
(2, 'this is awesome', 5, 4, '2023-12-10'),
(3, 'this drink is best but method to drink in casual', 4, 6, '2023-12-10'),
(4, 'sdfafsa', 5, 4, '2023-12-11'),
(5, '4 bottle coca cola ka', 4, 6, '2023-12-24'),
(6, 'sdfgsf', 2, 6, '2023-12-25'),
(7, 'sdafsafsa', 5, 6, '2023-12-29');

-- --------------------------------------------------------

--
-- Table structure for table `registermaster`
--

CREATE TABLE `registermaster` (
  `regId` int(100) NOT NULL,
  `name` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `userName` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `registermaster`
--

INSERT INTO `registermaster` (`regId`, `name`, `email`, `password`, `userName`) VALUES
(1, 'sujeet', 'sujeet@gmail.com', 'PBKDF2WithHmacSHA256:2048:w+G8JZYiyVsFkqb1lD7Ts6p7ZGZHW1Bepp3dAfnuhYI=:eZrnBBFQqfd/chly09IvOTzynv5IkrViMDSlIXaSxVw=', 'sujeet'),
(2, 'bhagyashree', 'bhagyshree@gmail.com', 'PBKDF2WithHmacSHA256:2048:eQSdHWzzICdEgRrrg28MFAy9KNUpPdz8TYG97xX5BpQ=:M8F1Edk3bzCopDRwW5hqnuSW4PbjdMfjqmIDwdfSQ1I=', 'bhagyashree'),
(3, 'meet', 'meet@gmail.com', 'PBKDF2WithHmacSHA256:2048:JEbegFqvFEZdL8tYAU200jR+WI+jmoLgB69AeYuf484=:c048K8Ux+HYtL9+pHsVWam3FkwI0GRwmXPYu0xO0mwg=', 'meetorwhat'),
(4, 'vanshika', 'vanshika@gmail.com', 'PBKDF2WithHmacSHA256:2048:MFc1xAvwXwlJ2h3aFpUMz1asECn8HvZSoUk6kFs1EcU=:r8utWeZS4NcQ438IPofmEZQszbBewt+sY+MjR2X7q70=', 'vanshika'),
(5, 'sanjeev', 'sanjeev@gmail.com', 'PBKDF2WithHmacSHA256:2048:H7YoaLmjlriBGtBinRxsx6oNEEq20IIhOsRsg+j7smE=:WL2dcTkXxo2DaLjowC9Q8YOIsNCDF4w1p+C3sqVJEjA=', 'sanjeev'),
(6, 'Dhara', 'dhara@gmail.com', 'PBKDF2WithHmacSHA256:2048:FbWGRfWXCf2Aaw3jxDVQf1d/xJEHskgOSbTIcPFy9lc=:C+ujIn0MfhU7R5r0ondg3CHleC2fq7nFX4ibGjEHDTQ=', 'meet'),
(7, 'vikram', 'vikram@gmail.com', 'PBKDF2WithHmacSHA256:2048:oukF89F6DcLytSUjjAaGm1icx23ZFBIQUHFOLd4/QI4=:fVPmCZHIuvPto5cMhuqAr/W7+3ETSJsU01Lo5xNHmuc=', 'vikram');

-- --------------------------------------------------------

--
-- Table structure for table `rolemaster`
--

CREATE TABLE `rolemaster` (
  `userName` varchar(250) NOT NULL,
  `role` varchar(100) NOT NULL DEFAULT 'User'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rolemaster`
--

INSERT INTO `rolemaster` (`userName`, `role`) VALUES
('bhagyashree', 'User'),
('meet', 'User'),
('meetorwhat', 'User'),
('sanjeev', 'User'),
('sujeet', 'Admin'),
('vanshika', 'User'),
('vikram', 'User');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `addressmaster`
--
ALTER TABLE `addressmaster`
  ADD PRIMARY KEY (`addId`),
  ADD KEY `regId` (`regId`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cartid`),
  ADD KEY `regId` (`regId`),
  ADD KEY `pId` (`pId`);

--
-- Indexes for table `getintouch`
--
ALTER TABLE `getintouch`
  ADD PRIMARY KEY (`getId`),
  ADD KEY `regId` (`regId`);

--
-- Indexes for table `managebrand`
--
ALTER TABLE `managebrand`
  ADD PRIMARY KEY (`bId`);

--
-- Indexes for table `managecategory`
--
ALTER TABLE `managecategory`
  ADD PRIMARY KEY (`cId`);

--
-- Indexes for table `manageproduct`
--
ALTER TABLE `manageproduct`
  ADD PRIMARY KEY (`pId`),
  ADD KEY `cId` (`cId`),
  ADD KEY `bId` (`bId`);

--
-- Indexes for table `orderdeatails`
--
ALTER TABLE `orderdeatails`
  ADD PRIMARY KEY (`orderId`),
  ADD KEY `oId` (`oId`),
  ADD KEY `pId` (`pId`),
  ADD KEY `regId` (`regId`),
  ADD KEY `addid` (`addid`);

--
-- Indexes for table `ordermaster`
--
ALTER TABLE `ordermaster`
  ADD PRIMARY KEY (`oId`),
  ADD KEY `regId` (`regId`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payId`),
  ADD KEY `oId` (`oId`),
  ADD KEY `regId` (`regId`);

--
-- Indexes for table `productreview`
--
ALTER TABLE `productreview`
  ADD PRIMARY KEY (`reId`),
  ADD KEY `regId` (`regId`),
  ADD KEY `pId` (`pId`);

--
-- Indexes for table `registermaster`
--
ALTER TABLE `registermaster`
  ADD PRIMARY KEY (`regId`),
  ADD KEY `userName` (`userName`);

--
-- Indexes for table `rolemaster`
--
ALTER TABLE `rolemaster`
  ADD PRIMARY KEY (`userName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `addressmaster`
--
ALTER TABLE `addressmaster`
  MODIFY `addId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `cartid` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `getintouch`
--
ALTER TABLE `getintouch`
  MODIFY `getId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `managebrand`
--
ALTER TABLE `managebrand`
  MODIFY `bId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `managecategory`
--
ALTER TABLE `managecategory`
  MODIFY `cId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `manageproduct`
--
ALTER TABLE `manageproduct`
  MODIFY `pId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `orderdeatails`
--
ALTER TABLE `orderdeatails`
  MODIFY `orderId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `ordermaster`
--
ALTER TABLE `ordermaster`
  MODIFY `oId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `productreview`
--
ALTER TABLE `productreview`
  MODIFY `reId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `registermaster`
--
ALTER TABLE `registermaster`
  MODIFY `regId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `addressmaster`
--
ALTER TABLE `addressmaster`
  ADD CONSTRAINT `addressmaster_ibfk_1` FOREIGN KEY (`regId`) REFERENCES `registermaster` (`regId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`regId`) REFERENCES `registermaster` (`regId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`pId`) REFERENCES `manageproduct` (`pId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `getintouch`
--
ALTER TABLE `getintouch`
  ADD CONSTRAINT `getintouch_ibfk_1` FOREIGN KEY (`regId`) REFERENCES `registermaster` (`regId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `manageproduct`
--
ALTER TABLE `manageproduct`
  ADD CONSTRAINT `manageproduct_ibfk_1` FOREIGN KEY (`cId`) REFERENCES `managecategory` (`cId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `manageproduct_ibfk_2` FOREIGN KEY (`bId`) REFERENCES `managebrand` (`bId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `orderdeatails`
--
ALTER TABLE `orderdeatails`
  ADD CONSTRAINT `orderdeatails_ibfk_1` FOREIGN KEY (`oId`) REFERENCES `ordermaster` (`oId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orderdeatails_ibfk_2` FOREIGN KEY (`pId`) REFERENCES `manageproduct` (`pId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orderdeatails_ibfk_3` FOREIGN KEY (`regId`) REFERENCES `registermaster` (`regId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orderdeatails_ibfk_4` FOREIGN KEY (`addid`) REFERENCES `addressmaster` (`addId`);

--
-- Constraints for table `ordermaster`
--
ALTER TABLE `ordermaster`
  ADD CONSTRAINT `ordermaster_ibfk_1` FOREIGN KEY (`regId`) REFERENCES `registermaster` (`regId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`oId`) REFERENCES `ordermaster` (`oId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`regId`) REFERENCES `registermaster` (`regId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `productreview`
--
ALTER TABLE `productreview`
  ADD CONSTRAINT `productreview_ibfk_1` FOREIGN KEY (`regId`) REFERENCES `registermaster` (`regId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productreview_ibfk_2` FOREIGN KEY (`pId`) REFERENCES `manageproduct` (`pId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `registermaster`
--
ALTER TABLE `registermaster`
  ADD CONSTRAINT `registermaster_ibfk_1` FOREIGN KEY (`userName`) REFERENCES `rolemaster` (`userName`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
