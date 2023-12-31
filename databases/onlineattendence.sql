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
-- Database: `onlineattendence`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendencetbl`
--

CREATE TABLE `attendencetbl` (
  `id` int(21) NOT NULL,
  `studId` int(21) NOT NULL,
  `divId` int(21) NOT NULL,
  `subId` int(21) NOT NULL,
  `deptId` int(21) NOT NULL,
  `teacherId` int(21) NOT NULL,
  `classId` int(21) NOT NULL,
  `date` date NOT NULL,
  `time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `status` varchar(101) NOT NULL,
  `semId` int(21) NOT NULL,
  `courseId` int(21) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `classmastertbl`
--

CREATE TABLE `classmastertbl` (
  `id` int(21) NOT NULL,
  `name` varchar(101) NOT NULL,
  `latitude` varchar(101) NOT NULL,
  `longitutde` varchar(101) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `classmastertbl`
--

INSERT INTO `classmastertbl` (`id`, `name`, `latitude`, `longitutde`) VALUES
(3, 'Classroom 1', '21.1582242', '72.7845473'),
(4, 'Classroom 2', '21.1582242', '72.7845473'),
(5, 'Classroom 3', '21.1582242', '72.7845473'),
(6, 'Classroom 4', '21.1582242', '72.7845473'),
(7, 'Classroom 5', '21.1582242', '72.7845473'),
(8, 'Classroom 6', '21.1582242', '72.7845473'),
(9, 'Classroom 7', '21.1582242', '72.7845473'),
(10, 'Classroom 8', '21.1582242', '72.7845473'),
(11, 'Classroom 9', '21.1582242', '72.7845473'),
(12, 'Classroom 10', '21.1582242', '72.7845473'),
(13, 'Seminar Hall', '21.1582242', '72.7845473'),
(14, 'Computer Lab 1', '21.1582242', '72.7845473'),
(15, 'Computer Lab 2', '21.1582242', '72.7845473'),
(16, 'Computer Lab 3', '21.1582242', '72.7845473'),
(17, 'Computer Lab 4', '21.1582242', '72.7845473'),
(18, 'Computer Lab 5', '21.1582242', '72.7845473'),
(19, 'Computer Lab 6', '21.1582242', '72.7845473');

-- --------------------------------------------------------

--
-- Table structure for table `coursetbl`
--

CREATE TABLE `coursetbl` (
  `id` int(21) NOT NULL,
  `name` varchar(101) NOT NULL,
  `depId` int(21) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `coursetbl`
--

INSERT INTO `coursetbl` (`id`, `name`, `depId`) VALUES
(1, 'IT - Information Technology', 1),
(2, 'ICT - Information and Communications Technology', 1);

-- --------------------------------------------------------

--
-- Table structure for table `departmenttable`
--

CREATE TABLE `departmenttable` (
  `id` int(21) NOT NULL,
  `name` varchar(101) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `departmenttable`
--

INSERT INTO `departmenttable` (`id`, `name`) VALUES
(1, 'J.P.Dawer institute of Information Science and Technology - BSc (IT) & MSc (ICT)');

-- --------------------------------------------------------

--
-- Table structure for table `divisiontbl`
--

CREATE TABLE `divisiontbl` (
  `id` int(21) NOT NULL,
  `name` varchar(101) NOT NULL,
  `courseId` int(21) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `divisiontbl`
--

INSERT INTO `divisiontbl` (`id`, `name`, `courseId`) VALUES
(3, 'A', 1),
(4, 'B', 1),
(5, 'C', 1),
(6, 'D', 1),
(7, 'A', 2);

-- --------------------------------------------------------

--
-- Table structure for table `ipaddress`
--

CREATE TABLE `ipaddress` (
  `id` int(21) NOT NULL,
  `studId` int(21) NOT NULL,
  `classId` int(21) NOT NULL,
  `ipAddress` varchar(101) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `semestertbl`
--

CREATE TABLE `semestertbl` (
  `id` int(21) NOT NULL,
  `name` varchar(101) NOT NULL,
  `courseId` int(21) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `semestertbl`
--

INSERT INTO `semestertbl` (`id`, `name`, `courseId`) VALUES
(3, 'Semester 1 ', 1),
(4, 'Semester 2', 1),
(5, 'Semester 3', 1),
(6, 'Semester 4', 1),
(7, 'Semester 5', 1),
(8, 'Semester 6', 1),
(9, 'Semester 7', 1),
(10, 'Semester 8', 1),
(11, 'Semester 9', 1),
(12, 'Semester 10', 1),
(13, 'Semester 1', 2),
(14, 'Semester 2', 2),
(15, 'Semester 3', 2),
(16, 'Semester 4', 2);

-- --------------------------------------------------------

--
-- Table structure for table `studenttbl`
--

CREATE TABLE `studenttbl` (
  `spid` int(21) NOT NULL,
  `name` varchar(101) NOT NULL,
  `semId` int(21) NOT NULL,
  `dateOfBirth` varchar(101) NOT NULL,
  `gender` varchar(101) NOT NULL,
  `contactNo` int(21) NOT NULL,
  `email` varchar(101) NOT NULL,
  `image` varchar(101) NOT NULL,
  `divId` int(21) NOT NULL,
  `depId` int(21) NOT NULL,
  `classId` int(21) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `studenttbl`
--

INSERT INTO `studenttbl` (`spid`, `name`, `semId`, `dateOfBirth`, `gender`, `contactNo`, `email`, `image`, `divId`, `depId`, `classId`) VALUES
(1, 'Bhagyashree', 1, '19/05/2003', 'female', 2121212121, 'bhagyashree@gmail.com', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNNxWhw7WD3ozSZUg6xe58p_jp_thDIVmm2Q&usqp=CAU', 1, 1, 1),
(2, 'Meet', 1, '23/09/2003', 'male', 12345678, 'meet@gmail.com', 'https://www.freeiconspng.com/thumbs/person-icon/clipart--person-icon--cliparts-15.png', 1, 1, 1),
(3, 'Sujeet', 13, '19-05-2003', 'Male', 2147483647, 'sujeet@gmail.com', 'Screenshot (4).png', 7, 0, 13);

-- --------------------------------------------------------

--
-- Table structure for table `subjecttbl`
--

CREATE TABLE `subjecttbl` (
  `id` int(21) NOT NULL,
  `name` varchar(101) NOT NULL,
  `courseId` int(21) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subjecttbl`
--

INSERT INTO `subjecttbl` (`id`, `name`, `courseId`) VALUES
(3, 'Front-End Development With React JS', 2),
(4, 'Enterprise Java', 2),
(5, 'Information Security and Application', 2),
(6, 'Advanced Computer network', 2),
(7, 'Practical 1 ', 2),
(8, 'Practical 2', 2);

-- --------------------------------------------------------

--
-- Table structure for table `teachertbl`
--

CREATE TABLE `teachertbl` (
  `id` int(21) NOT NULL,
  `username` varchar(101) NOT NULL,
  `password` varchar(101) NOT NULL,
  `email` varchar(101) NOT NULL,
  `contactNo` int(21) NOT NULL,
  `deptId` int(21) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teachertbl`
--

INSERT INTO `teachertbl` (`id`, `username`, `password`, `email`, `contactNo`, `deptId`) VALUES
(1, 'Dr.Kamlendu Pandey', 'ompandey', 'kp@gmail.com', 123456633, 1),
(2, 'Maitri Hingu', 'mhingu', 'maitrihingu@gmail.com', 123456487, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tectimetbl`
--

CREATE TABLE `tectimetbl` (
  `id` int(21) NOT NULL,
  `teacherId` int(21) NOT NULL,
  `divId` int(21) NOT NULL,
  `courseId` int(21) NOT NULL,
  `subId` int(21) NOT NULL,
  `weekday` varchar(101) NOT NULL DEFAULT 'Monday, Tuesday, Wednesday, Thrusday, Friday, Saturday',
  `date` date NOT NULL,
  `fromtime` time NOT NULL,
  `totime` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tectimetbl`
--

INSERT INTO `tectimetbl` (`id`, `teacherId`, `divId`, `courseId`, `subId`, `weekday`, `date`, `fromtime`, `totime`) VALUES
(1, 1, 3, 2, 4, 'Monday', '2023-11-02', '12:00:01', '13:20:01'),
(2, 2, 3, 2, 5, 'Monday', '2023-11-02', '13:00:00', '14:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendencetbl`
--
ALTER TABLE `attendencetbl`
  ADD PRIMARY KEY (`id`),
  ADD KEY `classId` (`classId`),
  ADD KEY `deptId` (`deptId`),
  ADD KEY `divId` (`divId`),
  ADD KEY `studId` (`studId`),
  ADD KEY `subId` (`subId`),
  ADD KEY `teacherId` (`teacherId`),
  ADD KEY `semId` (`semId`),
  ADD KEY `courseId` (`courseId`);

--
-- Indexes for table `classmastertbl`
--
ALTER TABLE `classmastertbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `coursetbl`
--
ALTER TABLE `coursetbl`
  ADD PRIMARY KEY (`id`),
  ADD KEY `depId` (`depId`);

--
-- Indexes for table `departmenttable`
--
ALTER TABLE `departmenttable`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `divisiontbl`
--
ALTER TABLE `divisiontbl`
  ADD PRIMARY KEY (`id`),
  ADD KEY `classId` (`courseId`);

--
-- Indexes for table `ipaddress`
--
ALTER TABLE `ipaddress`
  ADD PRIMARY KEY (`id`),
  ADD KEY `classId` (`classId`),
  ADD KEY `studId` (`studId`);

--
-- Indexes for table `semestertbl`
--
ALTER TABLE `semestertbl`
  ADD PRIMARY KEY (`id`),
  ADD KEY `classId` (`courseId`);

--
-- Indexes for table `studenttbl`
--
ALTER TABLE `studenttbl`
  ADD PRIMARY KEY (`spid`);

--
-- Indexes for table `subjecttbl`
--
ALTER TABLE `subjecttbl`
  ADD PRIMARY KEY (`id`),
  ADD KEY `courseId` (`courseId`);

--
-- Indexes for table `teachertbl`
--
ALTER TABLE `teachertbl`
  ADD PRIMARY KEY (`id`),
  ADD KEY `deptId` (`deptId`);

--
-- Indexes for table `tectimetbl`
--
ALTER TABLE `tectimetbl`
  ADD PRIMARY KEY (`id`),
  ADD KEY `classId` (`courseId`),
  ADD KEY `divId` (`divId`),
  ADD KEY `subId` (`subId`),
  ADD KEY `teacherId` (`teacherId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendencetbl`
--
ALTER TABLE `attendencetbl`
  MODIFY `id` int(21) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `classmastertbl`
--
ALTER TABLE `classmastertbl`
  MODIFY `id` int(21) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `coursetbl`
--
ALTER TABLE `coursetbl`
  MODIFY `id` int(21) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `departmenttable`
--
ALTER TABLE `departmenttable`
  MODIFY `id` int(21) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `divisiontbl`
--
ALTER TABLE `divisiontbl`
  MODIFY `id` int(21) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `ipaddress`
--
ALTER TABLE `ipaddress`
  MODIFY `id` int(21) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `semestertbl`
--
ALTER TABLE `semestertbl`
  MODIFY `id` int(21) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `studenttbl`
--
ALTER TABLE `studenttbl`
  MODIFY `spid` int(21) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `subjecttbl`
--
ALTER TABLE `subjecttbl`
  MODIFY `id` int(21) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `teachertbl`
--
ALTER TABLE `teachertbl`
  MODIFY `id` int(21) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tectimetbl`
--
ALTER TABLE `tectimetbl`
  MODIFY `id` int(21) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendencetbl`
--
ALTER TABLE `attendencetbl`
  ADD CONSTRAINT `attendencetbl_ibfk_1` FOREIGN KEY (`classId`) REFERENCES `classmastertbl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `attendencetbl_ibfk_2` FOREIGN KEY (`deptId`) REFERENCES `departmenttable` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `attendencetbl_ibfk_3` FOREIGN KEY (`divId`) REFERENCES `divisiontbl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `attendencetbl_ibfk_4` FOREIGN KEY (`studId`) REFERENCES `studenttbl` (`spid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `attendencetbl_ibfk_5` FOREIGN KEY (`subId`) REFERENCES `subjecttbl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `attendencetbl_ibfk_6` FOREIGN KEY (`teacherId`) REFERENCES `teachertbl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `attendencetbl_ibfk_7` FOREIGN KEY (`semId`) REFERENCES `semestertbl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `attendencetbl_ibfk_8` FOREIGN KEY (`courseId`) REFERENCES `coursetbl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `coursetbl`
--
ALTER TABLE `coursetbl`
  ADD CONSTRAINT `coursetbl_ibfk_1` FOREIGN KEY (`depId`) REFERENCES `departmenttable` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `divisiontbl`
--
ALTER TABLE `divisiontbl`
  ADD CONSTRAINT `divisiontbl_ibfk_1` FOREIGN KEY (`courseId`) REFERENCES `coursetbl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ipaddress`
--
ALTER TABLE `ipaddress`
  ADD CONSTRAINT `ipaddress_ibfk_1` FOREIGN KEY (`classId`) REFERENCES `classmastertbl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ipaddress_ibfk_2` FOREIGN KEY (`studId`) REFERENCES `studenttbl` (`spid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `semestertbl`
--
ALTER TABLE `semestertbl`
  ADD CONSTRAINT `semestertbl_ibfk_1` FOREIGN KEY (`courseId`) REFERENCES `coursetbl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `subjecttbl`
--
ALTER TABLE `subjecttbl`
  ADD CONSTRAINT `subjecttbl_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `coursetbl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `teachertbl`
--
ALTER TABLE `teachertbl`
  ADD CONSTRAINT `teachertbl_ibfk_1` FOREIGN KEY (`deptId`) REFERENCES `departmenttable` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tectimetbl`
--
ALTER TABLE `tectimetbl`
  ADD CONSTRAINT `tectimetbl_ibfk_1` FOREIGN KEY (`courseId`) REFERENCES `coursetbl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tectimetbl_ibfk_2` FOREIGN KEY (`divId`) REFERENCES `divisiontbl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tectimetbl_ibfk_3` FOREIGN KEY (`subId`) REFERENCES `subjecttbl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tectimetbl_ibfk_4` FOREIGN KEY (`teacherId`) REFERENCES `teachertbl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
