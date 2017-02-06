-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-02-2017 a las 14:00:43
-- Versión del servidor: 5.5.39
-- Versión de PHP: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `bdaimh`
--
CREATE DATABASE IF NOT EXISTS `bdaimh` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci;
USE `bdaimh`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `breakdowns`
--

CREATE TABLE IF NOT EXISTS `breakdowns` (
`codBreakdown` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `codMachine` varchar(15) COLLATE utf8mb4_spanish_ci NOT NULL,
  `reporter` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `failureType` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `description` varchar(400) COLLATE utf8mb4_spanish_ci NOT NULL,
  `equipmentAvailable` varchar(1) COLLATE utf8mb4_spanish_ci NOT NULL,
  `subject` varchar(40) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `breakdowns`
--

INSERT INTO `breakdowns` (`codBreakdown`, `date`, `codMachine`, `reporter`, `failureType`, `description`, `equipmentAvailable`, `subject`) VALUES
(1, '2017-02-04 00:00:00', 'CF 1', '1dfm', 'mechanical', 'aarggg', 'a', 'subject'),
(2, '2017-02-03 12:10:40', 'CF 1', '1dfm', 'Mechanical', 'The main screw is broken', 'R', 'Broken screw'),
(3, '2016-11-20 06:16:18', 'CF 12', '1tm', 'Mechanical', 'taladrina ez dabil (ponpa)', 's', 'no va'),
(4, '2017-02-01 12:00:00', 'CRC1', '1me', 'others', '\r\ntaladrima argia ez da pizten eta ez dauka taladrina\r\n', 's', 'no va');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `id` tinyint(4) NOT NULL,
  `role` char(1) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `groups`
--

INSERT INTO `groups` (`id`, `role`) VALUES
(1, 'T'),
(2, 'T'),
(3, 'T'),
(4, 'T'),
(5, 'T'),
(6, 'T'),
(7, 'T'),
(8, 'T'),
(9, 'T'),
(10, 'T');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localizations`
--

CREATE TABLE IF NOT EXISTS `localizations` (
  `idLocalization` int(11) NOT NULL,
  `nameLocalization` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `localizations`
--

INSERT INTO `localizations` (`idLocalization`, `nameLocalization`) VALUES
(1, 'gear box'),
(2, 'feed'),
(3, 'measurement'),
(4, 'transmission'),
(5, 'safety'),
(6, 'lubrication system'),
(7, 'electric panel'),
(8, 'hydraulic group'),
(9, 'pneumatic');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `machines`
--

CREATE TABLE IF NOT EXISTS `machines` (
  `codMachine` varchar(15) COLLATE utf8mb4_spanish_ci NOT NULL,
  `model` varchar(60) COLLATE utf8mb4_spanish_ci NOT NULL,
  `serialNumber` varchar(15) COLLATE utf8mb4_spanish_ci NOT NULL,
  `status` varchar(1) COLLATE utf8mb4_spanish_ci NOT NULL,
  `idSection` varchar(2) COLLATE utf8mb4_spanish_ci NOT NULL,
  `year` varchar(4) COLLATE utf8mb4_spanish_ci NOT NULL,
  `importance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `machines`
--

INSERT INTO `machines` (`codMachine`, `model`, `serialNumber`, `status`, `idSection`, `year`, `importance`) VALUES
('CF 1', 'FTV 4-SP ', '48307', 'V', '1', '2007', 10),
('CF 10', 'FTV 4-SP ', '48477', 'R', '1', '2007', 1),
('CF 11', 'FV-1', 'AD-10', 'V', '1', '2002', 20),
('CF 12', 'I2UA', '5100063', 'V', '1', '', 10),
('CF 13', 'FV-1', 'AC-608', 'V', '1', '2002', 20),
('CRC1', 'Danobat 50', '', 'A', '1', '', 15),
('CRP 4', 'S-40/20', '03/0930', 'V', '1', '2003', 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maintenance`
--

CREATE TABLE IF NOT EXISTS `maintenance` (
  `username` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `idGroup` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `maintenance`
--

INSERT INTO `maintenance` (`username`, `idGroup`) VALUES
('unaisainz', 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `manufacturers`
--

CREATE TABLE IF NOT EXISTS `manufacturers` (
  `id` varchar(60) COLLATE utf8mb4_spanish_ci NOT NULL,
  `telephone` varchar(18) COLLATE utf8mb4_spanish_ci NOT NULL,
  `responsable` varchar(60) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `manufacturers`
--

INSERT INTO `manufacturers` (`id`, `telephone`, `responsable`) VALUES
('Correa', '', ''),
('Danobat', '', ''),
('GER', '94360625', 'Mayor Hermanos S.A'),
('Kondia', '', ''),
('Lagun', '(+34) 945 264 600', ''),
('Letag', '', ''),
('Metosa/Pinacho', '(+34) 744 016 50', 'Metosa'),
('Rodicort', '943711655', ''),
('Sabi', '943850306', ''),
('Txurtxil', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `models`
--

CREATE TABLE IF NOT EXISTS `models` (
  `model` varchar(60) COLLATE utf8mb4_spanish_ci NOT NULL,
  `manufacturer` varchar(60) COLLATE utf8mb4_spanish_ci NOT NULL,
  `hydraulicSystem` varchar(120) COLLATE utf8mb4_spanish_ci NOT NULL,
  `pneumaticConnection` varchar(120) COLLATE utf8mb4_spanish_ci NOT NULL,
  `dimensions` varchar(120) COLLATE utf8mb4_spanish_ci NOT NULL,
  `powerSource` varchar(120) COLLATE utf8mb4_spanish_ci NOT NULL,
  `electricConnection` varchar(120) COLLATE utf8mb4_spanish_ci NOT NULL,
  `workingPressure` varchar(60) COLLATE utf8mb4_spanish_ci NOT NULL,
  `typeOil` varchar(120) COLLATE utf8mb4_spanish_ci NOT NULL,
  `weight` varchar(60) COLLATE utf8mb4_spanish_ci NOT NULL,
  `machine` varchar(60) COLLATE utf8mb4_spanish_ci NOT NULL,
  `fileSearch` varchar(80) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `models`
--

INSERT INTO `models` (`model`, `manufacturer`, `hydraulicSystem`, `pneumaticConnection`, `dimensions`, `powerSource`, `electricConnection`, `workingPressure`, `typeOil`, `weight`, `machine`, `fileSearch`) VALUES
('Danobat 50', 'Danobat', '', '', '', '', '', '', 'Renolin MR3', '', '', ''),
('FTV 4-SP', 'Lagun', 'Ez dauka', 'Bai', '', '4cv (3kw) 5cv (3,7kw) Motoponpa 0,08cv (0,06kw)', '380V', '6 bar minimo', '', '1450kg + itsas bilgarria 1710kg', 'Fresagailu Konbentzionala', ''),
('FV-1', 'Kondia', 'Ez dauka', 'Bai', '', '1,5-2,5 cabezal refrigeracion 0,1', '380V', '', '', '', 'Fresagailu Konbentzionala', ''),
('I2UA', 'Correa', 'Ez dauka', 'Bai', '', 'Motor nagusia 5,5v 1400rpm - Bomba refrigeracion 0,10cv 2800rpm', '380V', '', '', '2100kg', 'Fresagailu Konbentzionala', ''),
('nb-200', 'Txurtxil', '1500 rpm', '', '', '5,5cv', '220v 50hz hiru fase', '', '', '', 'Rectificadora Plana', ''),
('OHX 450', 'Txurtxil', '', '', '', '5 cv 3,75kw', '220v (3 fase PH) 50hz', '', 'Renolin MR15', '', 'Artezgailu Zilindrikoa', ''),
('RHL-450', 'GER', '', '', '', '', '220v 50hz', '', 'Renolin MR15', '', 'Artezgailu Zilindrikoa', ''),
('S-40/20', 'GER', '', '', '', '70Kw', '380V 50hz', '', '', '1100kg', 'Rectificadora Plana', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `others`
--

CREATE TABLE IF NOT EXISTS `others` (
  `username` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `name` varchar(15) COLLATE utf8mb4_spanish_ci NOT NULL,
  `surname` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `email` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `course` varchar(5) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `others`
--

INSERT INTO `others` (`username`, `name`, `surname`, `email`, `course`) VALUES
('unaisainz', 'unai', 'sainz', 'unai@unai.com', '1ma');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `repairs`
--

CREATE TABLE IF NOT EXISTS `repairs` (
  `codBreakdown` int(11) NOT NULL,
  `idGroup` tinyint(4) NOT NULL,
  `repairDate` datetime NOT NULL DEFAULT '1990-01-01 00:00:00',
  `time` float DEFAULT NULL,
  `availabilityAfter` int(11) DEFAULT NULL,
  `repairProcess` varchar(400) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `idLocalization` int(11) DEFAULT NULL,
  `isRepaired` tinyint(1) DEFAULT NULL,
  `replacements` varchar(60) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `repairs`
--

INSERT INTO `repairs` (`codBreakdown`, `idGroup`, `repairDate`, `time`, `availabilityAfter`, `repairProcess`, `idLocalization`, `isRepaired`, `replacements`) VALUES
(1, 1, '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL),
(1, 8, '2017-02-06 08:47:54', 4, 2, 'xDDDD', 1, 1, 'eee'),
(2, 1, '1990-01-01 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL),
(2, 1, '1990-01-01 06:22:24', 2, 1, 'PROZESUA EGIN!!!!!!!!!!!!!!!!!! mesedez', 3, 1, 'Ez edo bai'),
(2, 2, '1990-01-01 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `repairtools`
--

CREATE TABLE IF NOT EXISTS `repairtools` (
  `codBreakdown` int(11) NOT NULL,
  `idGroup` tinyint(4) NOT NULL,
  `idTool` bigint(20) unsigned NOT NULL,
  `repairDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `repairtools`
--

INSERT INTO `repairtools` (`codBreakdown`, `idGroup`, `idTool`, `repairDate`) VALUES
(1, 8, 3, '2017-02-06 08:47:54'),
(1, 8, 6, '2017-02-06 08:47:54');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sections`
--

CREATE TABLE IF NOT EXISTS `sections` (
  `idSection` varchar(2) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nameSection` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `sections`
--

INSERT INTO `sections` (`idSection`, `nameSection`) VALUES
('1', 'convencional');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tools`
--

CREATE TABLE IF NOT EXISTS `tools` (
`idTools` bigint(20) unsigned NOT NULL,
  `name` varchar(60) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `tools`
--

INSERT INTO `tools` (`idTools`, `name`) VALUES
(1, '22giltz finkoa'),
(2, 'destornilladora plana'),
(3, 'allen key 5'),
(4, 'allen '),
(5, 'giltza finkoa'),
(6, 'silicona'),
(7, 'matxo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `typeofmaintenance`
--

CREATE TABLE IF NOT EXISTS `typeofmaintenance` (
`id` bigint(20) unsigned NOT NULL,
  `name` varchar(60) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `typeofmaintenance`
--

INSERT INTO `typeofmaintenance` (`id`, `name`) VALUES
(1, 'Correctivo'),
(2, 'Preventivo'),
(3, 'Otros');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `password` varchar(15) COLLATE utf8mb4_spanish_ci NOT NULL,
  `type` char(1) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`username`, `password`, `type`) VALUES
('1dfm', '1dfm', 'G'),
('1me', '1me', 'G'),
('1mi', '1mi', 'G'),
('1pfa', '1pfa', 'G'),
('1pfm', '1pfm', 'G'),
('1tm', '1tm', 'G'),
('2dfm', '2dfm', 'G'),
('2me', '2me', 'G'),
('2mi', '2mi', 'G'),
('2pfm', '2pfm', 'G'),
('2tm', '2tm', 'G'),
('admin', 'admin', 'A'),
('irakaslea', 'irakaslea', 'G'),
('iraunkorra', 'iraunkorra', 'G'),
('ulhi', 'ulhi', 'G'),
('unaisainz', 'unaisainz', 'M');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `workorders`
--

CREATE TABLE IF NOT EXISTS `workorders` (
  `idBreakdown` int(11) NOT NULL,
  `severity` tinyint(4) NOT NULL,
  `others` varchar(200) COLLATE utf8mb4_spanish_ci NOT NULL,
  `typeMaintenance` bigint(20) unsigned NOT NULL,
  `creationDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `workorders`
--

INSERT INTO `workorders` (`idBreakdown`, `severity`, `others`, `typeMaintenance`, `creationDate`) VALUES
(1, 0, 'Dani equals Trani', 1, '2017-02-05 00:00:00'),
(2, 2, 'Dani es jodida mugre, es roña asquerosa y chabacana', 2, '2017-02-06 10:33:16');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `breakdowns`
--
ALTER TABLE `breakdowns`
 ADD PRIMARY KEY (`codBreakdown`), ADD KEY `codMachine` (`codMachine`), ADD KEY `reporter` (`reporter`);

--
-- Indices de la tabla `groups`
--
ALTER TABLE `groups`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `localizations`
--
ALTER TABLE `localizations`
 ADD PRIMARY KEY (`idLocalization`);

--
-- Indices de la tabla `machines`
--
ALTER TABLE `machines`
 ADD PRIMARY KEY (`codMachine`), ADD KEY `machines_fk0` (`idSection`), ADD KEY `model` (`model`);

--
-- Indices de la tabla `maintenance`
--
ALTER TABLE `maintenance`
 ADD PRIMARY KEY (`username`), ADD KEY `maintenance_fk1` (`idGroup`);

--
-- Indices de la tabla `manufacturers`
--
ALTER TABLE `manufacturers`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `models`
--
ALTER TABLE `models`
 ADD PRIMARY KEY (`model`), ADD KEY `fabricante` (`manufacturer`);

--
-- Indices de la tabla `others`
--
ALTER TABLE `others`
 ADD PRIMARY KEY (`username`);

--
-- Indices de la tabla `repairs`
--
ALTER TABLE `repairs`
 ADD PRIMARY KEY (`codBreakdown`,`idGroup`,`repairDate`), ADD KEY `idLocalization` (`idLocalization`), ADD KEY `idGroup` (`idGroup`), ADD KEY `codBreakdown` (`codBreakdown`), ADD KEY `repairDate` (`repairDate`);

--
-- Indices de la tabla `repairtools`
--
ALTER TABLE `repairtools`
 ADD PRIMARY KEY (`codBreakdown`,`idGroup`,`idTool`,`repairDate`), ADD KEY `FK_1` (`codBreakdown`,`idGroup`,`repairDate`), ADD KEY `idTool` (`idTool`);

--
-- Indices de la tabla `sections`
--
ALTER TABLE `sections`
 ADD PRIMARY KEY (`idSection`);

--
-- Indices de la tabla `tools`
--
ALTER TABLE `tools`
 ADD UNIQUE KEY `idTools` (`idTools`);

--
-- Indices de la tabla `typeofmaintenance`
--
ALTER TABLE `typeofmaintenance`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `id` (`id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`username`);

--
-- Indices de la tabla `workorders`
--
ALTER TABLE `workorders`
 ADD PRIMARY KEY (`idBreakdown`), ADD KEY `typeMaintenance` (`typeMaintenance`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `breakdowns`
--
ALTER TABLE `breakdowns`
MODIFY `codBreakdown` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `tools`
--
ALTER TABLE `tools`
MODIFY `idTools` bigint(20) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `typeofmaintenance`
--
ALTER TABLE `typeofmaintenance`
MODIFY `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `breakdowns`
--
ALTER TABLE `breakdowns`
ADD CONSTRAINT `breakdowns_ibfk_1` FOREIGN KEY (`codMachine`) REFERENCES `machines` (`codMachine`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `breakdowns_ibfk_2` FOREIGN KEY (`reporter`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `machines`
--
ALTER TABLE `machines`
ADD CONSTRAINT `machines_fk0` FOREIGN KEY (`idSection`) REFERENCES `sections` (`idSection`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `machines_ibfk_1` FOREIGN KEY (`model`) REFERENCES `models` (`Model`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `maintenance`
--
ALTER TABLE `maintenance`
ADD CONSTRAINT `maintenance_ibfk_1` FOREIGN KEY (`username`) REFERENCES `others` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `maintenance_ibfk_2` FOREIGN KEY (`idGroup`) REFERENCES `groups` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `models`
--
ALTER TABLE `models`
ADD CONSTRAINT `models_ibfk_1` FOREIGN KEY (`manufacturer`) REFERENCES `manufacturers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `others`
--
ALTER TABLE `others`
ADD CONSTRAINT `FK_others_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `repairs`
--
ALTER TABLE `repairs`
ADD CONSTRAINT `repairs_ibfk_1` FOREIGN KEY (`codBreakdown`) REFERENCES `workorders` (`idBreakdown`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `repairs_ibfk_2` FOREIGN KEY (`idGroup`) REFERENCES `groups` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `repairs_ibfk_3` FOREIGN KEY (`idLocalization`) REFERENCES `localizations` (`idLocalization`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `repairtools`
--
ALTER TABLE `repairtools`
ADD CONSTRAINT `FK_1` FOREIGN KEY (`codBreakdown`, `idGroup`, `repairDate`) REFERENCES `repairs` (`codBreakdown`, `idGroup`, `repairDate`),
ADD CONSTRAINT `repairtools_ibfk_6` FOREIGN KEY (`idTool`) REFERENCES `tools` (`idTools`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `workorders`
--
ALTER TABLE `workorders`
ADD CONSTRAINT `workorders_ibfk_1` FOREIGN KEY (`idBreakdown`) REFERENCES `breakdowns` (`codBreakdown`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `workorders_ibfk_2` FOREIGN KEY (`typeMaintenance`) REFERENCES `typeofmaintenance` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
