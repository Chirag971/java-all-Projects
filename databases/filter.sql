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
-- Database: `filter`
--

-- --------------------------------------------------------

--
-- Table structure for table `groupmaster`
--

CREATE TABLE `groupmaster` (
  `gid` int(10) NOT NULL,
  `gname` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `groupmaster`
--

INSERT INTO `groupmaster` (`gid`, `gname`) VALUES
(1, 'Admin'),
(2, 'User');

-- --------------------------------------------------------

--
-- Table structure for table `usermaster`
--

CREATE TABLE `usermaster` (
  `uid` int(10) NOT NULL,
  `username` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `gname` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usermaster`
--

INSERT INTO `usermaster` (`uid`, `username`, `password`, `gname`) VALUES
(1, 'zotifiruf', 'Sit est culpa qui b', 'User'),
(2, 'harsh', 'PBKDF2WithHmacSHA256:2048:evAuRYaPS4qnpOwdV8+mqlRqW3Jy3dUBXyr/jwsTgaA=:zU5omvO+gIh+f/PMXSL8IOQ34ro+5qDlcSTZ1dgxcMg=', 'User'),
(3, 'sujeet', 'PBKDF2WithHmacSHA256:2048:eNuA7cJi+wKjGyjkqY/3FjUj46a7/++q+qr8efF+ClA=:cg/rEbF66XL25IeyN6NI5KSG50bbp46er1TKRPwozJE=', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `groupmaster`
--
ALTER TABLE `groupmaster`
  ADD PRIMARY KEY (`gname`);

--
-- Indexes for table `usermaster`
--
ALTER TABLE `usermaster`
  ADD PRIMARY KEY (`uid`),
  ADD KEY `gname` (`gname`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `usermaster`
--
ALTER TABLE `usermaster`
  MODIFY `uid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `usermaster`
--
ALTER TABLE `usermaster`
  ADD CONSTRAINT `usermaster_ibfk_1` FOREIGN KEY (`gname`) REFERENCES `groupmaster` (`gname`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
