-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 10, 2020 at 04:05 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ca2`
--

-- --------------------------------------------------------

--
-- Table structure for table `athleticsclubmember`
--

CREATE TABLE `athleticsclubmember` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `age` int(11) NOT NULL,
  `salary` decimal(10,0) NOT NULL,
  `tId` int(11) NOT NULL,
  `sportType` varchar(100) NOT NULL,
  `team` varchar(150) DEFAULT NULL,
  `position` varchar(150) DEFAULT NULL,
  `goals` int(11) DEFAULT NULL,
  `assists` int(11) DEFAULT NULL,
  `skill` varchar(255) DEFAULT NULL,
  `raceType` varchar(150) DEFAULT NULL,
  `longestDistance` varchar(100) DEFAULT NULL,
  `wins` int(11) DEFAULT NULL,
  `bestTime` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `athleticsclubmember`
--

INSERT INTO `athleticsclubmember` (`id`, `name`, `gender`, `age`, `salary`, `tId`, `sportType`, `team`, `position`, `goals`, `assists`, `skill`, `raceType`, `longestDistance`, `wins`, `bestTime`) VALUES
(1, 'Gavin', 'Male', 24, '2050', 1, 'footballer', 'Manchester United', 'Center Midfield', 3, 7, 'Corners', NULL, NULL, NULL, NULL),
(2, 'Luthor', 'Male', 19, '450', 2, 'runner', NULL, NULL, NULL, NULL, NULL, 'Maraton', '12km', 5, '11 Minutes 27 Seconds'),
(3, 'Tom', 'Male', 27, '3002', 1, 'footballer', 'Liverpool', 'Goalkeeper', 1, 2, 'saves', NULL, NULL, NULL, NULL),
(4, 'Tara', 'Female', 31, '2500', 2, 'runner', NULL, NULL, NULL, NULL, NULL, 'Rounders', '3km', 6, '2 minutes 20 seconds');

-- --------------------------------------------------------

--
-- Table structure for table `trainer`
--

CREATE TABLE `trainer` (
  `tId` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sportsType` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trainer`
--

INSERT INTO `trainer` (`tId`, `name`, `sportsType`) VALUES
(1, 'William', 'football'),
(2, 'Jesse', 'runner'),
(3, 'Martin', 'runner'),
(4, 'Lauren', 'football'),
(5, 'Kelly', 'football');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `athleticsclubmember`
--
ALTER TABLE `athleticsclubmember`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tId` (`tId`);

--
-- Indexes for table `trainer`
--
ALTER TABLE `trainer`
  ADD PRIMARY KEY (`tId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `athleticsclubmember`
--
ALTER TABLE `athleticsclubmember`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `trainer`
--
ALTER TABLE `trainer`
  MODIFY `tId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `athleticsclubmember`
--
ALTER TABLE `athleticsclubmember`
  ADD CONSTRAINT `tId` FOREIGN KEY (`tId`) REFERENCES `trainer` (`tid`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
