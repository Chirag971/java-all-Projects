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
-- Database: `currency`
--

-- --------------------------------------------------------

--
-- Table structure for table `currencyconversionrate`
--

CREATE TABLE `currencyconversionrate` (
  `id` int(11) NOT NULL,
  `from_currency` varchar(3) DEFAULT NULL,
  `to_currency` varchar(3) DEFAULT NULL,
  `conversion_rate` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `currencyconversionrate`
--

INSERT INTO `currencyconversionrate` (`id`, `from_currency`, `to_currency`, `conversion_rate`) VALUES
(1, 'USD', 'EUR', 0.85),
(2, 'USD', 'JPY', 110.36),
(3, 'EUR', 'USD', 1.18),
(4, 'EUR', 'JPY', 130.44),
(5, 'JPY', 'USD', 0.01),
(6, 'JPY', 'EUR', 0.01);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `currencyconversionrate`
--
ALTER TABLE `currencyconversionrate`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
