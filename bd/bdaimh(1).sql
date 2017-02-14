-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-02-2017 a las 12:31:10
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

INSERT INTO `asignations` VALUES(5, '2017-02-23 09:20:53', 1);
INSERT INTO `asignations` VALUES(52, '2017-02-13 13:32:22', 2);
INSERT INTO `asignations` VALUES(53, '2017-02-13 13:33:10', 1);

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

INSERT INTO `breakdowns` VALUES(1, '2017-02-04 00:00:00', 'CF 1', '1dfm', 'mechanical', 'aarggg', 'a', 'subject');
INSERT INTO `breakdowns` VALUES(2, '2017-02-03 12:10:40', 'CF 1', '1dfm', 'Mechanical', 'The main screw is broken', 'R', 'Broken screw');
INSERT INTO `breakdowns` VALUES(5, '2017-02-06 14:48:32', 'CF 1', '1dfm', 'Mechanical', 'The main screw is broken', 'R', 'Broken screw');
INSERT INTO `breakdowns` VALUES(8, '2017-02-08 12:14:09', 'CF 1', 'unaisainz', 'Electrical', 'rcurxit', 'A', 'tudtux');
INSERT INTO `breakdowns` VALUES(9, '2017-02-09 10:35:18', 'CF 1', 'unaisainz', 'Electrical', 'Descripcion', 'A', 'Asunto');
INSERT INTO `breakdowns` VALUES(10, '2017-02-09 11:53:42', 'CF 11', 'unaisainz', 'Electrical', '', 'V', 'a');
INSERT INTO `breakdowns` VALUES(11, '2017-02-09 11:57:42', 'CF 13', 'unaisainz', 'Mechanical', '', 'R', 'qqw');
INSERT INTO `breakdowns` VALUES(12, '2017-02-09 12:02:40', 'TL1', '1me', 'Electrical', '', 'R', '231');
INSERT INTO `breakdowns` VALUES(13, '2017-02-15 00:00:00', 'CF 11', '1me', 'Mechanical', 'aaaaaa', 'R', 'bombilla');
INSERT INTO `breakdowns` VALUES(14, '2017-02-14 00:00:00', 'CF 11', '1pfa', 'Mechanical', '1', 'R', 'bombilla');
INSERT INTO `breakdowns` VALUES(15, '2017-02-01 00:00:00', 'CF 10', '1pfa', 'Mechanical', 'ssfsa', 'R', 'aaaa');
INSERT INTO `breakdowns` VALUES(16, '2017-02-16 00:00:00', 'CF 2', '1mi', 'Mechanical', 'aaa', 'R', 'aaa');
INSERT INTO `breakdowns` VALUES(17, '2017-02-10 09:16:58', 'CF 10', 'unaisainz', 'Mechanical', 'asdasdsdadf', 'A', 'Screw broken');
INSERT INTO `breakdowns` VALUES(18, '2017-02-10 09:17:34', 'CF 12', 'unaisainz', 'Electrical', 'asdsad', 'R', 'Main axis broken');
INSERT INTO `breakdowns` VALUES(19, '2017-02-10 09:21:43', 'CRP 4', 'unaisainz', 'Others', 'dafdfdf', 'A', 'SCREW');
INSERT INTO `breakdowns` VALUES(20, '2017-02-10 09:39:31', 'CF 10', '1me', 'Electrical', 'ftufu', 'V', 'ftu');
INSERT INTO `breakdowns` VALUES(21, '2017-02-10 09:44:58', 'CF 10', '1me', 'Mechanical', '', 'R', 'buruak ez du jiratzen');
INSERT INTO `breakdowns` VALUES(22, '2017-02-10 09:46:50', 'CRC1', '2mi', 'Others', '', 'A', 'Taladrinak ez du funtzionatzen');
INSERT INTO `breakdowns` VALUES(24, '2017-02-10 09:55:23', 'CRP 4', 'user', 'Mechanical', '', 'R', 'motorrak ez du giratzen');
INSERT INTO `breakdowns` VALUES(25, '2017-02-10 09:58:08', 'CF 10', 'user', 'Electrical', '', 'R', 'martxa zartzean motorra itzali egiten da');
INSERT INTO `breakdowns` VALUES(27, '2017-02-10 10:01:11', 'CRP 4', 'user', 'Others', '', 'R', 'x ardatza ez dabil');
INSERT INTO `breakdowns` VALUES(29, '2017-02-10 10:04:16', 'CF 1', '2mi', 'Mechanical', '', 'R', 'y ardatzeko automatikoa ez doa');
INSERT INTO `breakdowns` VALUES(30, '2017-02-10 10:05:33', 'CF 11', '2mi', 'Mechanical', 'Bariadorea igo eta zarata entzuten da', 'A', 'Abiadura haundietan zarata');
INSERT INTO `breakdowns` VALUES(31, '2017-02-10 10:05:33', 'TL1', 'user', 'Electrical', '', 'R', 'Ez da pizten makina, tentsioa falta du');
INSERT INTO `breakdowns` VALUES(32, '2017-02-10 10:08:02', 'CF 1', 'user', 'Mechanical', '', 'R', 'usiloa bere lekutik irten da');
INSERT INTO `breakdowns` VALUES(33, '2017-02-10 10:10:17', 'CRC1', 'user', 'Electrical', '', 'R', 'Atzeko kontaktorea apurtu egin da');
INSERT INTO `breakdowns` VALUES(34, '2017-02-10 10:14:19', 'CF 1', 'unaisainz', 'Mechanical', '', 'V', 'tapa apurtuta');
INSERT INTO `breakdowns` VALUES(35, '2017-02-10 10:21:09', 'CF 10', 'unaisainz', 'Mechanical', '', 'V', 'balentxi');
INSERT INTO `breakdowns` VALUES(36, '2017-02-10 10:30:21', 'CRP 4', '1me', 'Mechanical', 'ccffffff', 'R', 'rr');
INSERT INTO `breakdowns` VALUES(37, '2017-02-10 10:32:21', 'CF 12', '1me', 'Electrical', 'esaaaa', 'R', 'esa peñita');
INSERT INTO `breakdowns` VALUES(39, '2017-02-10 10:36:17', 'PX-0', '1me', 'Mechanical', 'IEPA GAZTIAK', 'A', 'LOIDIIIIIIIIIIIIIIIIIII. EGUNON!');
INSERT INTO `breakdowns` VALUES(40, '2017-02-10 10:43:30', 'TL1', 'unaisainz', 'Mechanical', 'Grave', 'R', 'Grave');
INSERT INTO `breakdowns` VALUES(41, '2017-02-10 11:37:02', 'PX-0', 'unaisainz', 'Others', '', 'R', 'seugridadeko atea apurtuta dago');
INSERT INTO `breakdowns` VALUES(42, '2017-02-10 11:39:17', 'tl4', 'user', 'Mechanical', '', 'R', 'kaña ez da jeisten');
INSERT INTO `breakdowns` VALUES(43, '2017-02-10 11:40:47', 'CF 10', 'unaisainz', 'Mechanical', '', 'R', 'korrea bere lekutik irten da');
INSERT INTO `breakdowns` VALUES(44, '2017-02-10 11:49:04', 'CF 13', 'user', 'Mechanical', '', 'R', 'balentxi');
INSERT INTO `breakdowns` VALUES(46, '2017-02-10 11:50:52', 'tl4', 'unaisainz', 'Others', '\n', 'R', 'Seguritateko pantaila falta.');
INSERT INTO `breakdowns` VALUES(47, '2017-02-10 12:14:44', 'CF 1', 'unaisainz', 'Mechanical', 'sadas', 'R', 'ASDA');
INSERT INTO `breakdowns` VALUES(49, '2017-02-13 08:38:30', 'PX-0', 'unaisainz', 'Security', '', 'V', 'aeiou');
INSERT INTO `breakdowns` VALUES(50, '2017-02-13 08:38:30', 'PX-0', 'unaisainz', 'Security', '', 'V', 'aeiou');
INSERT INTO `breakdowns` VALUES(51, '2017-02-08 00:00:00', 'CF 2', '1me', 'Electrical', 'ss', 'V', 'bombilla');
INSERT INTO `breakdowns` VALUES(52, '2017-02-15 00:00:00', 'CF 10', '1me', 'Electrical', 'ff', 'V', 'ff');
INSERT INTO `breakdowns` VALUES(53, '2017-02-17 00:00:00', 'CF 2', '1mi', 'Mecanical', 'aaaa', 'R', 'ss');
INSERT INTO `breakdowns` VALUES(54, '2017-02-10 00:00:00', 'CF 10', '1me', 'Mechanical', 'SSS', 'R', 'SSS');

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

INSERT INTO `groups` VALUES(1, 'T');
INSERT INTO `groups` VALUES(2, 'T');
INSERT INTO `groups` VALUES(3, 'T');
INSERT INTO `groups` VALUES(4, 'D');
INSERT INTO `groups` VALUES(5, 'T');
INSERT INTO `groups` VALUES(6, 'T');
INSERT INTO `groups` VALUES(7, 'T');
INSERT INTO `groups` VALUES(8, 'T');
INSERT INTO `groups` VALUES(9, 'T');
INSERT INTO `groups` VALUES(10, 'D');
INSERT INTO `groups` VALUES(11, 'T');
INSERT INTO `groups` VALUES(12, 'D');

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

INSERT INTO `localizations` VALUES(1, 'gear box');
INSERT INTO `localizations` VALUES(2, 'feed');
INSERT INTO `localizations` VALUES(3, 'measurement');
INSERT INTO `localizations` VALUES(4, 'transmission');
INSERT INTO `localizations` VALUES(5, 'safety');
INSERT INTO `localizations` VALUES(6, 'lubrication system');
INSERT INTO `localizations` VALUES(7, 'electric panel');
INSERT INTO `localizations` VALUES(8, 'hydraulic group');
INSERT INTO `localizations` VALUES(9, 'pneumatic');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `machinefamilies`
--

CREATE TABLE IF NOT EXISTS `machinefamilies` (
`id` bigint(20) NOT NULL,
  `name` varchar(60) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci AUTO_INCREMENT=19 ;

--
-- Volcado de datos para la tabla `machinefamilies`
--

INSERT INTO `machinefamilies` VALUES(1, 'Sharpener');
INSERT INTO `machinefamilies` VALUES(2, 'Grinding Machines');
INSERT INTO `machinefamilies` VALUES(3, 'Bench Grinders');
INSERT INTO `machinefamilies` VALUES(4, 'Conventional Lathes');
INSERT INTO `machinefamilies` VALUES(5, 'Conventional Milling Machines');
INSERT INTO `machinefamilies` VALUES(6, 'Production');
INSERT INTO `machinefamilies` VALUES(7, 'Drilling Machines');
INSERT INTO `machinefamilies` VALUES(8, 'Band Shaws');
INSERT INTO `machinefamilies` VALUES(14, 'OeMenPilas');
INSERT INTO `machinefamilies` VALUES(15, 'Others');

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

INSERT INTO `machines` VALUES('CF 1', 'I2UA', '48307', 'V', '1', '2007', 10);
INSERT INTO `machines` VALUES('CF 10', 'FV-1', '8J57G-9GJ9-GJ84', '', '1', '2007', 1);
INSERT INTO `machines` VALUES('CF 11', 'FV-1', 'AD-10', 'A', '1', '2002', 20);
INSERT INTO `machines` VALUES('CF 12', 'I2UA', '5100063', 'R', '1', '2094', 10);
INSERT INTO `machines` VALUES('CF 13', 'FV-1', 'AC-608', '', '1', '4545', 0);
INSERT INTO `machines` VALUES('CF 2', 'FV-1', '23546', 'R', '1', '2001', 0);
INSERT INTO `machines` VALUES('CRC1', 'Danobat 50', '3434', 'R', '1', '2017', 0);
INSERT INTO `machines` VALUES('CRP 4', 'S-40/20', '03/0930', 'R', '1', '2003', 1);
INSERT INTO `machines` VALUES('P - X1', 'YT / 09 - 21', '456-K8FK4-FJ84F', 'V', 'P', '2014', 0);
INSERT INTO `machines` VALUES('P-01', 'S-40/20', '5576', 'v', '1', '2017', 3);
INSERT INTO `machines` VALUES('pruebatres', 'AX-34A', '432424', 'V', '2', '4332', 44);
INSERT INTO `machines` VALUES('PX-0', 'I2UA', '75483', 'R', '1', '2020', 10);
INSERT INTO `machines` VALUES('TL1', 'Ara-mon 601', '399106', 'R', '1', '2017', 0);
INSERT INTO `machines` VALUES('tl2', 'S-40/20', '6565', '', '2', '2007', 1);
INSERT INTO `machines` VALUES('tl3', 'Ara-mon 601', 'u87987987', '', '2', '2007', 0);
INSERT INTO `machines` VALUES('tl4', 'Ara-mon 601', '978989', '', '1', '2007', 1);
INSERT INTO `machines` VALUES('tl5', 'Ara-mon 601', '87687687', 'R', '1', '2008', 1);

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

INSERT INTO `maintenance` VALUES('14457245C', 1);
INSERT INTO `maintenance` VALUES('32578874H', 5);
INSERT INTO `maintenance` VALUES('44205436B', 5);
INSERT INTO `maintenance` VALUES('50906025X', 5);
INSERT INTO `maintenance` VALUES('unaisainz', 8);
INSERT INTO `maintenance` VALUES('user', 8);
INSERT INTO `maintenance` VALUES('x7198470e', 9);
INSERT INTO `maintenance` VALUES('44163328Q', 10);
INSERT INTO `maintenance` VALUES('Ik', 11);
INSERT INTO `maintenance` VALUES('15400564V', 12);

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

INSERT INTO `manufacturers` VALUES('Ara-mon', '+34 78677685', 'Ramon');
INSERT INTO `manufacturers` VALUES('Correa', '', '');
INSERT INTO `manufacturers` VALUES('Correados', '+57 43857348', 'uno');
INSERT INTO `manufacturers` VALUES('Danobat', '+54 33543543', 'DFGVE5RVf4f4f4f4');
INSERT INTO `manufacturers` VALUES('GER', '94360625', 'Mayor Hermanos S.A');
INSERT INTO `manufacturers` VALUES('Ibarmia', '+39 43761460', 'Alberto');
INSERT INTO `manufacturers` VALUES('Kondia', '', '');
INSERT INTO `manufacturers` VALUES('Lagun', '(+34) 945 264 600', '');
INSERT INTO `manufacturers` VALUES('Letag', '', '');
INSERT INTO `manufacturers` VALUES('Metosa/Pinacho', '(+34) 744 016 50', 'Metosa');
INSERT INTO `manufacturers` VALUES('Rodicort', '943711655', '');
INSERT INTO `manufacturers` VALUES('Sabi', '943850306', '');
INSERT INTO `manufacturers` VALUES('Txurtxil', '', '');

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

INSERT INTO `models` VALUES('Ara-mon 601', 'Ara-mon', '', '', '', '0,5CV 0,35Kw', '380v 50Hz', '', '380v 50Hz', '', 1, '');
INSERT INTO `models` VALUES('AX-34A', 'Ibarmia', '', '', '', '0,5CV 0,35Kw', '380v 50Hz', '', '380v 50Hz', '', 1, '');
INSERT INTO `models` VALUES('Danobat 50', 'Danobat', '', '', '', '', '', '', '', '', 3, '');
INSERT INTO `models` VALUES('FTV 4-SP', 'Lagun', 'Ez dauka', 'Bai', '', '4cv (3kw) 5cv (3,7kw) Motoponpa 0,08cv (0,06kw)', '380V', '6 bar minimo', '380V', '1450kg + itsas bilgarria 1710kg', 2, '');
INSERT INTO `models` VALUES('FV-1', 'Kondia', 'Ez dauka', 'Bai', '', '1,5-2,5 cabezal refrigeracion 0,1', '380V', '', '380V', '', 4, '');
INSERT INTO `models` VALUES('I2UA', 'Correa', 'Ez dauka', 'Bai', '', 'Motor nagusia 5,5v 1400rpm - Bomba refrigeracion 0,10cv 2800rpm', '380V', '', '380V', '2100kg', 1, '');
INSERT INTO `models` VALUES('Model - Prueba - 1', 'Ara-mon', '', '', '', '0,5CV 0,35Kw', '380v 50Hz', '', '380v 50Hz', '', 1, '');
INSERT INTO `models` VALUES('nb-200', 'Txurtxil', '1500 rpm', '', '', '5,5cv', '220v 50hz hiru fase', '', '220v 50hz hiru fase', '', 8, '');
INSERT INTO `models` VALUES('OHX 450', 'Txurtxil', '', '', '', '5 cv 3,75kw', '220v (3 fase PH) 50hz', '', '220v (3 fase PH) 50hz', '', 3, '');
INSERT INTO `models` VALUES('RHL-450', 'GER', '', '', '', '', '220v 50hz', '', 'Renolin MR15', '', 8, '');
INSERT INTO `models` VALUES('S-40/20', 'GER', '', '', '', '70Kw', '380V 50hz', '', '380V 50hz', '1100kg', 15, '');
INSERT INTO `models` VALUES('YT / 09 - 21', 'GER', '', '', '', '70Kw', '380V 50hz', '', '380V 50hz', '1100kg', 1, '');

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

INSERT INTO `others` VALUES('14457245C', 'd', 'dd', 'd@d.d', 'd');
INSERT INTO `others` VALUES('15400564V', 'Ibai ', 'Moreno', 'ibai@imh.eus', '2MI');
INSERT INTO `others` VALUES('32578874H', 'b', 'b', 'b@b.b', 'b');
INSERT INTO `others` VALUES('44163328Q', 'Iñaki', 'Iraola', 'iraola@imh.eus', '2MI');
INSERT INTO `others` VALUES('44205436B', 'a', 'a', 'a@a.a', 'a');
INSERT INTO `others` VALUES('50906025X', 'c', 'c', 'c@c.c', 'c');
INSERT INTO `others` VALUES('admin', 'admin', 'admin', 'a@gmail.com', '2MAN');
INSERT INTO `others` VALUES('Ik', 'Iker', 'Garces', 'tocatelospies', '2DAM');
INSERT INTO `others` VALUES('unaisainz', 'unai', 'sainz', 'unai@unai.com', '1ma');
INSERT INTO `others` VALUES('user', 'user', 'user', 'user', '2DAM');
INSERT INTO `others` VALUES('x7198470e', 'Oscar', 'Viñan', 'oscar@gmail.com', '2MI');

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

--
-- Volcado de datos para la tabla `repairs`
--

INSERT INTO `repairs` VALUES(5, 1, '1990-01-10 09:18:00', NULL, NULL, NULL, NULL, 0, NULL, '2017-02-23 09:20:53');

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

INSERT INTO `sections` VALUES('1', 'convencional');
INSERT INTO `sections` VALUES('2', 'didactico');
INSERT INTO `sections` VALUES('P', 'Producción');

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

INSERT INTO `tools` VALUES(1, '22giltz finkoa');
INSERT INTO `tools` VALUES(2, 'destornilladora plana');
INSERT INTO `tools` VALUES(3, 'allen key 5');
INSERT INTO `tools` VALUES(4, 'allen ');
INSERT INTO `tools` VALUES(5, 'giltza finkoa');
INSERT INTO `tools` VALUES(6, 'silicona');
INSERT INTO `tools` VALUES(7, 'matxo');

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

INSERT INTO `typeofmaintenance` VALUES(1, 'Correctivo');
INSERT INTO `typeofmaintenance` VALUES(2, 'Preventivo');
INSERT INTO `typeofmaintenance` VALUES(3, 'Otros');

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

INSERT INTO `users` VALUES('14457245C', '1234', 'T');
INSERT INTO `users` VALUES('15400564V', '123', 'T');
INSERT INTO `users` VALUES('1dfm', '1dfm', 'G');
INSERT INTO `users` VALUES('1me', '1me', 'G');
INSERT INTO `users` VALUES('1mi', '1mi', 'G');
INSERT INTO `users` VALUES('1MI_L', '123', 'G');
INSERT INTO `users` VALUES('1pfa', '1pfa', 'G');
INSERT INTO `users` VALUES('1pfm', '1pfm', 'G');
INSERT INTO `users` VALUES('1tm', '1tm', 'G');
INSERT INTO `users` VALUES('2dfm', '2dfm', 'G');
INSERT INTO `users` VALUES('2mi', '123', 'G');
INSERT INTO `users` VALUES('2pfm', '2pfm', 'G');
INSERT INTO `users` VALUES('2tm', '2tm', 'G');
INSERT INTO `users` VALUES('32578874H', '123', 'T');
INSERT INTO `users` VALUES('44163328Q', '123', 'T');
INSERT INTO `users` VALUES('44205436B', '123', 'T');
INSERT INTO `users` VALUES('50906025X', '123', 'T');
INSERT INTO `users` VALUES('admin', 'admin', 'A');
INSERT INTO `users` VALUES('Ik', 'a', 'T');
INSERT INTO `users` VALUES('irakaslea', 'irakaslea', 'G');
INSERT INTO `users` VALUES('iraunkorra', 'iraunkorra', 'G');
INSERT INTO `users` VALUES('unaisainz', 'unaisainz', 'T');
INSERT INTO `users` VALUES('user', 'user', 'T');
INSERT INTO `users` VALUES('x7198470e', '123', 'T');

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

INSERT INTO `workorders` VALUES(1, 0, 'https://www.google.es', 1, '2017-02-05 00:00:00');
INSERT INTO `workorders` VALUES(2, 2, 'Dani es jodida mugre, es roña asquerosa y chabacana', 2, '2017-02-06 10:33:16');
INSERT INTO `workorders` VALUES(5, 0, '', 1, '2017-02-09 12:00:05');
INSERT INTO `workorders` VALUES(8, 0, '', 1, '2017-02-09 12:02:06');
INSERT INTO `workorders` VALUES(9, 0, '', 1, '2017-02-09 12:03:09');
INSERT INTO `workorders` VALUES(10, 0, '', 1, '2017-02-09 12:14:09');
INSERT INTO `workorders` VALUES(11, 0, '', 1, '2017-02-09 12:26:54');
INSERT INTO `workorders` VALUES(12, 1, 'jodete', 1, '2017-02-09 12:23:58');
INSERT INTO `workorders` VALUES(13, 0, '', 1, '2017-02-09 12:28:17');
INSERT INTO `workorders` VALUES(14, 0, '', 1, '2017-02-09 12:30:08');
INSERT INTO `workorders` VALUES(15, 0, '', 1, '2017-02-09 12:31:12');
INSERT INTO `workorders` VALUES(16, 0, '', 1, '2017-02-09 12:46:46');
INSERT INTO `workorders` VALUES(17, 0, '', 1, '2017-02-10 09:19:24');
INSERT INTO `workorders` VALUES(18, 0, '', 1, '2017-02-10 09:22:49');
INSERT INTO `workorders` VALUES(19, 0, '', 1, '2017-02-10 09:45:26');
INSERT INTO `workorders` VALUES(20, 0, '', 1, '2017-02-10 09:50:05');
INSERT INTO `workorders` VALUES(21, 0, '', 1, '2017-02-10 11:36:09');
INSERT INTO `workorders` VALUES(22, 0, '', 1, '2017-02-10 10:31:30');
INSERT INTO `workorders` VALUES(24, 0, '', 1, '2017-02-10 11:44:00');
INSERT INTO `workorders` VALUES(25, 0, '', 1, '2017-02-13 09:34:34');
INSERT INTO `workorders` VALUES(27, 0, 'drrrr', 1, '2017-02-10 10:08:24');
INSERT INTO `workorders` VALUES(29, 0, '', 1, '2017-02-13 13:00:08');
INSERT INTO `workorders` VALUES(30, 0, '', 1, '2017-02-13 13:00:20');
INSERT INTO `workorders` VALUES(31, 0, '', 1, '2017-02-10 10:15:53');
INSERT INTO `workorders` VALUES(32, 0, '', 1, '2017-02-13 13:00:28');
INSERT INTO `workorders` VALUES(33, 0, '', 1, '2017-02-13 13:02:33');
INSERT INTO `workorders` VALUES(34, 0, '', 1, '2017-02-13 13:03:10');
INSERT INTO `workorders` VALUES(35, 0, '', 1, '2017-02-10 10:24:39');
INSERT INTO `workorders` VALUES(36, 0, '', 1, '2017-02-13 13:12:44');
INSERT INTO `workorders` VALUES(37, 0, '', 1, '2017-02-13 12:56:38');
INSERT INTO `workorders` VALUES(39, 0, '', 1, '2017-02-10 10:39:56');
INSERT INTO `workorders` VALUES(40, 1, '', 2, '2017-02-10 12:17:25');
INSERT INTO `workorders` VALUES(41, 0, '', 1, '2017-02-13 13:13:48');
INSERT INTO `workorders` VALUES(42, 0, '', 1, '2017-02-13 13:12:05');
INSERT INTO `workorders` VALUES(43, 0, '', 1, '2017-02-13 12:59:48');
INSERT INTO `workorders` VALUES(44, 0, '', 1, '2017-02-13 13:16:49');
INSERT INTO `workorders` VALUES(46, 0, '', 1, '2017-02-13 12:59:54');
INSERT INTO `workorders` VALUES(47, 0, '', 1, '2017-02-13 13:15:59');
INSERT INTO `workorders` VALUES(49, 0, '', 1, '2017-02-13 09:27:02');
INSERT INTO `workorders` VALUES(50, 0, '', 1, '2017-02-13 09:27:55');
INSERT INTO `workorders` VALUES(51, 0, '', 1, '2017-02-13 13:22:06');
INSERT INTO `workorders` VALUES(52, 0, '', 1, '2017-02-13 13:32:22');
INSERT INTO `workorders` VALUES(53, 0, '', 1, '2017-02-13 13:33:10');

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
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
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
