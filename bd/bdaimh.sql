-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-02-2017 a las 14:03:43
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
-- Estructura de tabla para la tabla `asignations`
--

CREATE TABLE IF NOT EXISTS `asignations` (
  `codBreakdown` int(11) NOT NULL,
  `asignationDate` datetime NOT NULL,
  `idGroup` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `asignations`
--

INSERT INTO `asignations` (`codBreakdown`, `asignationDate`, `idGroup`) VALUES
(5, '2017-02-23 09:20:53', 1),
(52, '2017-02-13 13:32:22', 2),
(53, '2017-02-13 13:33:10', 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci AUTO_INCREMENT=55 ;

--
-- Volcado de datos para la tabla `breakdowns`
--

INSERT INTO `breakdowns` (`codBreakdown`, `date`, `codMachine`, `reporter`, `failureType`, `description`, `equipmentAvailable`, `subject`) VALUES
(1, '2017-02-04 00:00:00', 'CF 1', '1dfm', 'mechanical', 'aarggg', 'a', 'subject'),
(2, '2017-02-03 12:10:40', 'CF 1', '1dfm', 'Mechanical', 'The main screw is broken', 'R', 'Broken screw'),
(5, '2017-02-06 14:48:32', 'CF 1', '1dfm', 'Mechanical', 'The main screw is broken', 'R', 'Broken screw'),
(8, '2017-02-08 12:14:09', 'CF 1', 'unaisainz', 'Electrical', 'rcurxit', 'A', 'tudtux'),
(9, '2017-02-09 10:35:18', 'CF 1', 'unaisainz', 'Electrical', 'Descripcion', 'A', 'Asunto'),
(10, '2017-02-09 11:53:42', 'CF 11', 'unaisainz', 'Electrical', '', 'V', 'a'),
(11, '2017-02-09 11:57:42', 'CF 13', 'unaisainz', 'Mechanical', '', 'R', 'qqw'),
(12, '2017-02-09 12:02:40', 'TL1', '1me', 'Electrical', '', 'R', '231'),
(13, '2017-02-15 00:00:00', 'CF 11', '1me', 'Mechanical', 'aaaaaa', 'R', 'bombilla'),
(14, '2017-02-14 00:00:00', 'CF 11', '1pfa', 'Mechanical', '1', 'R', 'bombilla'),
(15, '2017-02-01 00:00:00', 'CF 10', '1pfa', 'Mechanical', 'ssfsa', 'R', 'aaaa'),
(16, '2017-02-16 00:00:00', 'CF 2', '1mi', 'Mechanical', 'aaa', 'R', 'aaa'),
(17, '2017-02-10 09:16:58', 'CF 10', 'unaisainz', 'Mechanical', 'asdasdsdadf', 'A', 'Screw broken'),
(18, '2017-02-10 09:17:34', 'CF 12', 'unaisainz', 'Electrical', 'asdsad', 'R', 'Main axis broken'),
(19, '2017-02-10 09:21:43', 'CRP 4', 'unaisainz', 'Others', 'dafdfdf', 'A', 'SCREW'),
(20, '2017-02-10 09:39:31', 'CF 10', '1me', 'Electrical', 'ftufu', 'V', 'ftu'),
(21, '2017-02-10 09:44:58', 'CF 10', '1me', 'Mechanical', '', 'R', 'buruak ez du jiratzen'),
(22, '2017-02-10 09:46:50', 'CRC1', '2mi', 'Others', '', 'A', 'Taladrinak ez du funtzionatzen'),
(24, '2017-02-10 09:55:23', 'CRP 4', 'user', 'Mechanical', '', 'R', 'motorrak ez du giratzen'),
(25, '2017-02-10 09:58:08', 'CF 10', 'user', 'Electrical', '', 'R', 'martxa zartzean motorra itzali egiten da'),
(27, '2017-02-10 10:01:11', 'CRP 4', 'user', 'Others', '', 'R', 'x ardatza ez dabil'),
(29, '2017-02-10 10:04:16', 'CF 1', '2mi', 'Mechanical', '', 'R', 'y ardatzeko automatikoa ez doa'),
(30, '2017-02-10 10:05:33', 'CF 11', '2mi', 'Mechanical', 'Bariadorea igo eta zarata entzuten da', 'A', 'Abiadura haundietan zarata'),
(31, '2017-02-10 10:05:33', 'TL1', 'user', 'Electrical', '', 'R', 'Ez da pizten makina, tentsioa falta du'),
(32, '2017-02-10 10:08:02', 'CF 1', 'user', 'Mechanical', '', 'R', 'usiloa bere lekutik irten da'),
(33, '2017-02-10 10:10:17', 'CRC1', 'user', 'Electrical', '', 'R', 'Atzeko kontaktorea apurtu egin da'),
(34, '2017-02-10 10:14:19', 'CF 1', 'unaisainz', 'Mechanical', '', 'V', 'tapa apurtuta'),
(35, '2017-02-10 10:21:09', 'CF 10', 'unaisainz', 'Mechanical', '', 'V', 'balentxi'),
(36, '2017-02-10 10:30:21', 'CRP 4', '1me', 'Mechanical', 'ccffffff', 'R', 'rr'),
(37, '2017-02-10 10:32:21', 'CF 12', '1me', 'Electrical', 'esaaaa', 'R', 'esa peñita'),
(39, '2017-02-10 10:36:17', 'PX-0', '1me', 'Mechanical', 'IEPA GAZTIAK', 'A', 'LOIDIIIIIIIIIIIIIIIIIII. EGUNON!'),
(40, '2017-02-10 10:43:30', 'TL1', 'unaisainz', 'Mechanical', 'Grave', 'R', 'Grave'),
(41, '2017-02-10 11:37:02', 'PX-0', 'unaisainz', 'Others', '', 'R', 'seugridadeko atea apurtuta dago'),
(42, '2017-02-10 11:39:17', 'tl4', 'user', 'Mechanical', '', 'R', 'kaña ez da jeisten'),
(43, '2017-02-10 11:40:47', 'CF 10', 'unaisainz', 'Mechanical', '', 'R', 'korrea bere lekutik irten da'),
(44, '2017-02-10 11:49:04', 'CF 13', 'user', 'Mechanical', '', 'R', 'balentxi'),
(46, '2017-02-10 11:50:52', 'tl4', 'unaisainz', 'Others', '\n', 'R', 'Seguritateko pantaila falta.'),
(47, '2017-02-10 12:14:44', 'CF 1', 'unaisainz', 'Mechanical', 'sadas', 'R', 'ASDA'),
(49, '2017-02-13 08:38:30', 'PX-0', 'unaisainz', 'Security', '', 'V', 'aeiou'),
(50, '2017-02-13 08:38:30', 'PX-0', 'unaisainz', 'Security', '', 'V', 'aeiou'),
(51, '2017-02-08 00:00:00', 'CF 2', '1me', 'Electrical', 'ss', 'V', 'bombilla'),
(52, '2017-02-15 00:00:00', 'CF 10', '1me', 'Electrical', 'ff', 'V', 'ff'),
(53, '2017-02-17 00:00:00', 'CF 2', '1mi', 'Mecanical', 'aaaa', 'R', 'ss'),
(54, '2017-02-10 00:00:00', 'CF 10', '1me', 'Mechanical', 'SSS', 'R', 'SSS');

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
(4, 'D'),
(5, 'T'),
(6, 'T'),
(7, 'T'),
(8, 'T'),
(9, 'T'),
(10, 'D'),
(11, 'T'),
(12, 'D');

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
-- Estructura de tabla para la tabla `machinefamilies`
--

CREATE TABLE IF NOT EXISTS `machinefamilies` (
`id` bigint(20) NOT NULL,
  `name` varchar(60) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `machinefamilies`
--

INSERT INTO `machinefamilies` (`id`, `name`) VALUES
(1, 'prueba'),
(2, 'hola'),
(3, 'Torno'),
(4, 'patimicola');

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
  `year` char(4) COLLATE utf8mb4_spanish_ci NOT NULL,
  `importance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `machines`
--

INSERT INTO `machines` (`codMachine`, `model`, `serialNumber`, `status`, `idSection`, `year`, `importance`) VALUES
('CF 1', 'I2UA', '48307', 'V', '1', '2007', 10),
('CF 10', 'FV-1', '48477', 'V', '1', '2007', 1),
('CF 11', 'FV-1', 'AD-10', 'A', '1', '2002', 20),
('CF 12', 'I2UA', '5100063', 'R', '1', '2094', 10),
('CF 13', 'FV-1', 'AC-608', 'R', '1', '2002', 0),
('CF 2', 'FV-1', '23546', 'R', '1', '2001', 0),
('CRC1', 'Danobat 50', '3434', 'R', '1', '2017', 0),
('CRP 4', 'S-40/20', '03/0930', 'R', '1', '2003', 1),
('P - X1', 'YT / 09 - 21', '456-K8FK4-FJ84F', 'V', 'P', '2014', 0),
('P-01', 'S-40/20', '5576', 'v', '1', '2017', 3),
('pruebatres', 'AX-34A', '432424', 'V', '2', '4332', 44),
('PX-0', 'I2UA', '75483', 'R', '1', '2020', 10),
('TL1', 'Ara-mon 601', '399106', 'R', '1', '2017', 0),
('tl2', 'Ara-mon 601', '6565', 'V', '2', '2007', 0),
('tl3', 'Ara-mon 601', 'u87987987', 'R', '2', '2007', 1),
('tl4', 'Ara-mon 601', '978989', 'R', '1', '2007', 0),
('tl5', 'Ara-mon 601', '87687687', 'R', '1', '2008', 1);

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
('14457245C', 1),
('32578874H', 5),
('44205436B', 5),
('50906025X', 5),
('unaisainz', 8),
('user', 8),
('x7198470e', 9),
('44163328Q', 10),
('Ik', 11),
('15400564V', 12);

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
('Ara-mon', '', ''),
('Correa', '', ''),
('Danobat', '', ''),
('GER', '94360625', 'Mayor Hermanos S.A'),
('Ibarmia', '+39 43761460', 'Alberto'),
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
  `machine` bigint(20) NOT NULL,
  `fileSearch` varchar(80) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `models`
--

INSERT INTO `models` (`model`, `manufacturer`, `hydraulicSystem`, `pneumaticConnection`, `dimensions`, `powerSource`, `electricConnection`, `workingPressure`, `typeOil`, `weight`, `machine`, `fileSearch`) VALUES
('Ara-mon 601', 'Ara-mon', '', '', '', '0,5CV 0,35Kw', '380v 50Hz', '', '380v 50Hz', '', 1, ''),
('AX-34A', 'Ibarmia', '', '', '', '0,5CV 0,35Kw', '380v 50Hz', '', '380v 50Hz', '', 1, ''),
('Danobat 50', 'Danobat', '', '', '', '', '', '', '', '', 1, ''),
('FTV 4-SP', 'Lagun', 'Ez dauka', 'Bai', '', '4cv (3kw) 5cv (3,7kw) Motoponpa 0,08cv (0,06kw)', '380V', '6 bar minimo', '380V', '1450kg + itsas bilgarria 1710kg', 1, ''),
('FV-1', 'Kondia', 'Ez dauka', 'Bai', '', '1,5-2,5 cabezal refrigeracion 0,1', '380V', '', '380V', '', 1, ''),
('I2UA', 'Correa', 'Ez dauka', 'Bai', '', 'Motor nagusia 5,5v 1400rpm - Bomba refrigeracion 0,10cv 2800rpm', '380V', '', '380V', '2100kg', 1, ''),
('nb-200', 'Txurtxil', '1500 rpm', '', '', '5,5cv', '220v 50hz hiru fase', '', '220v 50hz hiru fase', '', 1, ''),
('OHX 450', 'Txurtxil', '', '', '', '5 cv 3,75kw', '220v (3 fase PH) 50hz', '', '220v (3 fase PH) 50hz', '', 1, ''),
('RHL-450', 'GER', '', '', '', '', '220v 50hz', '', 'Renolin MR15', '', 1, ''),
('S-40/20', 'GER', '', '', '', '70Kw', '380V 50hz', '', '380V 50hz', '1100kg', 1, ''),
('YT / 09 - 21', 'GER', '', '', '', '70Kw', '380V 50hz', '', '380V 50hz', '1100kg', 1, '');

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
('14457245C', 'd', 'dd', 'd@d.d', 'd'),
('15400564V', 'Ibai ', 'Moreno', 'ibai@imh.eus', '2MI'),
('32578874H', 'b', 'b', 'b@b.b', 'b'),
('44163328Q', 'Iñaki', 'Iraola', 'iraola@imh.eus', '2MI'),
('44205436B', 'a', 'a', 'a@a.a', 'a'),
('50906025X', 'c', 'c', 'c@c.c', 'c'),
('admin', 'admin', 'admin', 'a@gmail.com', '2MAN'),
('Ik', 'Iker', 'Garces', 'tocatelospies', '2DAM'),
('unaisainz', 'unai', 'sainz', 'unai@unai.com', '1ma'),
('user', 'user', 'user', 'user', '2DAM'),
('x7198470e', 'Oscar', 'Viñan', 'oscar@gmail.com', '2MI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `repairs`
--

CREATE TABLE IF NOT EXISTS `repairs` (
  `codBreakdown` int(11) NOT NULL,
  `idGroup` tinyint(4) NOT NULL,
  `repairDate` datetime NOT NULL DEFAULT '1990-01-01 00:00:00',
  `time` float DEFAULT NULL,
  `availabilityAfter` varchar(1) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `repairProcess` varchar(400) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `idLocalization` int(11) DEFAULT NULL,
  `isRepaired` tinyint(1) NOT NULL DEFAULT '0',
  `replacements` varchar(60) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `asignationDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `repairtools`
--

CREATE TABLE IF NOT EXISTS `repairtools` (
  `codBreakdown` int(11) NOT NULL,
  `idGroup` tinyint(4) NOT NULL,
  `idTool` bigint(20) unsigned NOT NULL,
  `asignationDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

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
('1', 'convencional'),
('2', 'didactico'),
('P', 'Producción');

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
  `password` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `type` char(1) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`username`, `password`, `type`) VALUES
('14457245C', '1234', 'T'),
('15400564V', '123', 'T'),
('1dfm', '1dfm', 'G'),
('1me', '1me', 'G'),
('1mi', '1mi', 'G'),
('1MI_L', '123', 'G'),
('1pfa', '1pfa', 'G'),
('1pfm', '1pfm', 'G'),
('1tm', '1tm', 'G'),
('2dfm', '2dfm', 'G'),
('2mi', '123', 'G'),
('2pfm', '2pfm', 'G'),
('2tm', '2tm', 'G'),
('32578874H', '123', 'T'),
('44163328Q', '123', 'T'),
('44205436B', '123', 'T'),
('50906025X', '123', 'T'),
('admin', 'admin', 'A'),
('Ik', 'a', 'T'),
('irakaslea', 'irakaslea', 'G'),
('iraunkorra', 'iraunkorra', 'G'),
('unaisainz', 'unaisainz', 'T'),
('user', 'user', 'T'),
('x7198470e', '123', 'T');

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
(1, 0, 'https://www.google.es', 1, '2017-02-05 00:00:00'),
(2, 2, 'Dani es jodida mugre, es roña asquerosa y chabacana', 2, '2017-02-06 10:33:16'),
(5, 0, '', 1, '2017-02-09 12:00:05'),
(8, 0, '', 1, '2017-02-09 12:02:06'),
(9, 0, '', 1, '2017-02-09 12:03:09'),
(10, 0, '', 1, '2017-02-09 12:14:09'),
(11, 0, '', 1, '2017-02-09 12:26:54'),
(12, 1, 'jodete', 1, '2017-02-09 12:23:58'),
(13, 0, '', 1, '2017-02-09 12:28:17'),
(14, 0, '', 1, '2017-02-09 12:30:08'),
(15, 0, '', 1, '2017-02-09 12:31:12'),
(16, 0, '', 1, '2017-02-09 12:46:46'),
(17, 0, '', 1, '2017-02-10 09:19:24'),
(18, 0, '', 1, '2017-02-10 09:22:49'),
(19, 0, '', 1, '2017-02-10 09:45:26'),
(20, 0, '', 1, '2017-02-10 09:50:05'),
(21, 0, '', 1, '2017-02-10 11:36:09'),
(22, 0, '', 1, '2017-02-10 10:31:30'),
(24, 0, '', 1, '2017-02-10 11:44:00'),
(25, 0, '', 1, '2017-02-13 09:34:34'),
(27, 0, 'drrrr', 1, '2017-02-10 10:08:24'),
(29, 0, '', 1, '2017-02-13 13:00:08'),
(30, 0, '', 1, '2017-02-13 13:00:20'),
(31, 0, '', 1, '2017-02-10 10:15:53'),
(32, 0, '', 1, '2017-02-13 13:00:28'),
(33, 0, '', 1, '2017-02-13 13:02:33'),
(34, 0, '', 1, '2017-02-13 13:03:10'),
(35, 0, '', 1, '2017-02-10 10:24:39'),
(36, 0, '', 1, '2017-02-13 13:12:44'),
(37, 0, '', 1, '2017-02-13 12:56:38'),
(39, 0, '', 1, '2017-02-10 10:39:56'),
(40, 1, '', 2, '2017-02-10 12:17:25'),
(41, 0, '', 1, '2017-02-13 13:13:48'),
(42, 0, '', 1, '2017-02-13 13:12:05'),
(43, 0, '', 1, '2017-02-13 12:59:48'),
(44, 0, '', 1, '2017-02-13 13:16:49'),
(46, 0, '', 1, '2017-02-13 12:59:54'),
(47, 0, '', 1, '2017-02-13 13:15:59'),
(49, 0, '', 1, '2017-02-13 09:27:02'),
(50, 0, '', 1, '2017-02-13 09:27:55'),
(51, 0, '', 1, '2017-02-13 13:22:06'),
(52, 0, '', 1, '2017-02-13 13:32:22'),
(53, 0, '', 1, '2017-02-13 13:33:10');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignations`
--
ALTER TABLE `asignations`
 ADD PRIMARY KEY (`codBreakdown`,`asignationDate`,`idGroup`);

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
-- Indices de la tabla `machinefamilies`
--
ALTER TABLE `machinefamilies`
 ADD PRIMARY KEY (`id`);

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
 ADD PRIMARY KEY (`model`), ADD KEY `fabricante` (`manufacturer`), ADD KEY `FKmodel_1` (`machine`);

--
-- Indices de la tabla `others`
--
ALTER TABLE `others`
 ADD PRIMARY KEY (`username`);

--
-- Indices de la tabla `repairs`
--
ALTER TABLE `repairs`
 ADD PRIMARY KEY (`codBreakdown`,`idGroup`,`asignationDate`), ADD KEY `idLocalization` (`idLocalization`), ADD KEY `idGroup` (`idGroup`), ADD KEY `codBreakdown` (`codBreakdown`), ADD KEY `repairDate` (`repairDate`), ADD KEY `repairs_ibfk_1` (`codBreakdown`,`asignationDate`,`idGroup`);

--
-- Indices de la tabla `repairtools`
--
ALTER TABLE `repairtools`
 ADD PRIMARY KEY (`codBreakdown`,`idGroup`,`idTool`,`asignationDate`), ADD KEY `FK_1` (`codBreakdown`,`idGroup`,`asignationDate`), ADD KEY `idTool` (`idTool`);

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
MODIFY `codBreakdown` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=55;
--
-- AUTO_INCREMENT de la tabla `machinefamilies`
--
ALTER TABLE `machinefamilies`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
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
-- Filtros para la tabla `asignations`
--
ALTER TABLE `asignations`
ADD CONSTRAINT `FKasignations_1` FOREIGN KEY (`codBreakdown`) REFERENCES `workorders` (`idBreakdown`) ON DELETE CASCADE ON UPDATE CASCADE;

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
ADD CONSTRAINT `FKmodel_1` FOREIGN KEY (`machine`) REFERENCES `machinefamilies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
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
ADD CONSTRAINT `FKasignations_2` FOREIGN KEY (`idGroup`) REFERENCES `groups` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `repairs_ibfk_1` FOREIGN KEY (`codBreakdown`, `asignationDate`, `idGroup`) REFERENCES `asignations` (`codBreakdown`, `asignationDate`, `idGroup`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `repairs_ibfk_3` FOREIGN KEY (`idLocalization`) REFERENCES `localizations` (`idLocalization`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `repairtools`
--
ALTER TABLE `repairtools`
ADD CONSTRAINT `FK_1` FOREIGN KEY (`codBreakdown`, `idGroup`, `asignationDate`) REFERENCES `repairs` (`codBreakdown`, `idGroup`, `asignationDate`) ON DELETE CASCADE ON UPDATE CASCADE,
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
