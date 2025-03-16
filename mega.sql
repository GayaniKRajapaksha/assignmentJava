-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 16, 2025 at 11:05 AM
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
-- Database: `mega`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `billID` int(11) NOT NULL,
  `contactNo` int(11) NOT NULL,
  `pickupLocation` varchar(255) NOT NULL,
  `dropLocation` varchar(255) NOT NULL,
  `distance` decimal(10,2) NOT NULL,
  `total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`billID`, `contactNo`, `pickupLocation`, `dropLocation`, `distance`, `total`) VALUES
(1, 776655443, 'Nugegoda', 'Colombo', 100.00, 1200.00),
(2, 776655443, 'Homagama', 'Colombo', 100.00, 10000.00),
(3, 776655443, 'Homagama', 'Colombo', 100.00, 10000.00),
(4, 717986012, 'homagama ', 'godagama', 1.00, 100.00),
(5, 717986012, 'homagama ', 'godagama', 1.00, 100.00),
(6, 717986012, 'homagama', 'godagama', 1.50, 100.00),
(7, 717986012, 'homagama', 'godagama', 1.50, 100.00),
(8, 717986012, 'homagama', 'godagama', 1.50, 100.00),
(9, 717986012, 'homagama', 'godagama', 1.50, 100.00),
(10, 717986012, 'homagama', 'godagama', 1.50, 100.00),
(11, 717986012, 'homagama', 'godagama', 1.50, 100.00),
(12, 717986012, 'homagama', 'godagama', 1.50, 100.00),
(13, 717986012, 'homagama', 'godagama', 1.50, 100.00),
(14, 717986012, 'homagama', 'godagama', 1.50, 100.00),
(15, 717986012, 'homagama', 'godagama', 1.50, 100.00),
(16, 717986012, 'homagama', 'godagama', 1.50, 100.00),
(17, 717986012, 'homagama', 'godagama', 1.50, 100.00),
(18, 717986012, 'homagama', 'godagama', 1.50, 100.00),
(19, 717986012, 'homagama', 'godagama', 1.50, 100.00),
(20, 776655443, 'Nugegoda', 'Colombo', 2.00, 100.00),
(21, 2659, 'Nugegoda', 'Colombo', 2.00, 200.00);

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `bookingID` int(11) NOT NULL,
  `vehicleType` varchar(50) DEFAULT NULL,
  `pickup` varchar(50) NOT NULL,
  `dropOff` varchar(50) NOT NULL,
  `contactNo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`bookingID`, `vehicleType`, `pickup`, `dropOff`, `contactNo`) VALUES
(1, 'car', 'Homagama', 'Horana', 776655443),
(2, 'car', 'Homagama', 'Horana', 776655443),
(3, '1', 'Homagama', 'Horana', 776655443),
(4, '2', 'Homagama', 'Horana', 776655443),
(5, '1', 'nugegoda', 'homagama', 716785645),
(6, '1', 'homagama', 'godagama', 717986012),
(7, '1', 'Nugegoda', 'Horana', 776655443),
(8, '1', 'Nugegoda', 'Horana', 776655443),
(9, '1', 'Nugegoda', 'Horana', 776655443),
(10, '2', 'Homagama', 'Horana', 776655443),
(11, '1', 'homagama', 'godagama', 717986012),
(12, '1', 'homagama', 'godagama', 717986012),
(13, '1', 'kottawa', 'godagama', 717986012),
(14, '1', 'homagama', 'safhgs', 717986012),
(15, '1', 'homagama', 'safhgs', 717986012);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `UserID` int(11) NOT NULL,
  `nic` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `userType` varchar(100) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `password` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserID`, `nic`, `name`, `userType`, `Username`, `password`) VALUES
(1, 1234567, 'customer', 'customer', 'abc', 1234),
(2, 1234567, 'customer', 'customer', 'abc', 1234),
(3, 1234567, 'customer', 'customer', 'abc', 1234),
(4, 23324, 'abc', 'admin', 'dfdfd', 123),
(5, 4234235, 'Gayani Kaushalya', 'customer', 'gayani', 1234),
(6, 23424, 'admin', 'admin', 'admin', 1234),
(7, 23424456, 'driver', 'driver', 'driver', 1234),
(8, 732443, 'shanu', 'customer', 'shanu', 1234),
(9, 42335, 'shani', 'customer', 'shani', 1234),
(10, 1123, 'amasha', 'customer', 'amasha', 1234),
(11, 968284010, 'hasara', 'customer', 'hasara', 1234),
(12, 968284010, 'hasara', 'customer', 'hasara', 1234),
(13, 968284010, 'hasara', 'customer', 'hasara', 1234),
(14, 467523, 'shalani', 'customer', 'shalani', 123),
(15, 34566, 'abc', 'customer', 'abc', 123);

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `vehicleID` int(11) NOT NULL,
  `vehicleType` varchar(50) NOT NULL,
  `plateNo` varchar(20) NOT NULL,
  `seats` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`vehicleID`, `vehicleType`, `plateNo`, `seats`) VALUES
(1, 'car', 'KA-1213', 4),
(2, 'car', 'KA-1213', 4),
(3, 'van', 'AB1234', 9),
(4, 'car', 'CA765', 4),
(5, 'mini bus', 'AC5645', 19),
(6, 'bus', 'cv1223', 50),
(7, '2', 'fsu5526', 3),
(8, 'car', 'gf2612', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`billID`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`bookingID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UserID`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`vehicleID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `billID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `bookingID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `vehicleID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
