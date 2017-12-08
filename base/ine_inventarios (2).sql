-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-12-2017 a las 16:48:13
-- Versión del servidor: 10.1.28-MariaDB
-- Versión de PHP: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ine_inventarios`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen`
--

CREATE TABLE `almacen` (
  `idAlmacen` int(11) NOT NULL,
  `Nombre_Alm` varchar(45) DEFAULT NULL,
  `Capacidad_Alm` varchar(45) DEFAULT NULL,
  `Disponibilidad_Alm` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `almacen`
--

INSERT INTO `almacen` (`idAlmacen`, `Nombre_Alm`, `Capacidad_Alm`, `Disponibilidad_Alm`) VALUES
(1, 'na', 'na', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `area`
--

CREATE TABLE `area` (
  `idArea` int(10) UNSIGNED ZEROFILL NOT NULL,
  `Nombre_Area` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `area`
--

INSERT INTO `area` (`idArea`, `Nombre_Area`) VALUES
(0000000001, 'Informatica'),
(0000000002, 'Administracion'),
(0000000003, 'Organizacion'),
(0000000004, 'Presidencia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignacion_usr`
--

CREATE TABLE `asignacion_usr` (
  `idAsignacion` int(11) NOT NULL,
  `Fecha_Asig` date DEFAULT NULL,
  `Status_Asig` varchar(45) DEFAULT NULL,
  `Obsr_Asig` varchar(180) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `asignacion_usr`
--

INSERT INTO `asignacion_usr` (`idAsignacion`, `Fecha_Asig`, `Status_Asig`, `Obsr_Asig`) VALUES
(1, '2017-12-19', 'na', 'na');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `car_esp`
--

CREATE TABLE `car_esp` (
  `idCar_Esp` int(11) NOT NULL,
  `Nombre_CarEsp` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `car_esp`
--

INSERT INTO `car_esp` (`idCar_Esp`, `Nombre_CarEsp`) VALUES
(1, NULL),
(2, 'automovil');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clasificacion`
--

CREATE TABLE `clasificacion` (
  `idClasificacion` int(11) NOT NULL,
  `Folio_Clas` varchar(45) DEFAULT NULL,
  `Nom_Clas` varchar(45) DEFAULT NULL,
  `Stock_Clas` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clasificacion`
--

INSERT INTO `clasificacion` (`idClasificacion`, `Folio_Clas`, `Nom_Clas`, `Stock_Clas`) VALUES
(1, 'na', 'Equipo de transporte', 'na');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contenido`
--

CREATE TABLE `contenido` (
  `idContenido` int(11) NOT NULL,
  `Contenido_Cont` varchar(250) DEFAULT NULL,
  `FolioClas_Cont` varchar(45) DEFAULT NULL,
  `Datos_Esp_idDatos_Esp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos_esp`
--

CREATE TABLE `datos_esp` (
  `idDatos_Esp` int(11) NOT NULL,
  `Nombre_Dat` varchar(45) DEFAULT NULL,
  `Car_Esp_idCar_Esp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos_vehiculo`
--

CREATE TABLE `datos_vehiculo` (
  `IdDatos` int(11) NOT NULL,
  `KmInicial` varchar(45) NOT NULL,
  `KmFinal` varchar(45) DEFAULT NULL,
  `Descripcion` varchar(400) NOT NULL,
  `IdProducto` int(11) DEFAULT NULL,
  `IdViaticos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `datos_vehiculo`
--

INSERT INTO `datos_vehiculo` (`IdDatos`, `KmInicial`, `KmFinal`, `Descripcion`, `IdProducto`, `IdViaticos`) VALUES
(9, '50000', '50000', 'medio tanque', 1, 16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `RFC_Emp` varchar(20) NOT NULL,
  `Puestos_idPuesto` int(11) NOT NULL,
  `Persona_idPersona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`RFC_Emp`, `Puestos_idPuesto`, `Persona_idPersona`) VALUES
('brcamarenavi', 4, 8),
('dalopeznu', 3, 3),
('frcardenasra', 5, 4),
('isgarciaga', 4, 9),
('JDMC', 1, 1),
('JGMC', 2, 2),
('maramosgo', 4, 6),
('omnajarme', 4, 7),
('sacardenasra', 6, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `idEstado` int(11) NOT NULL,
  `Nombre_Est` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`idEstado`, `Nombre_Est`) VALUES
(1, 'na');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fotos`
--

CREATE TABLE `fotos` (
  `idFotos` int(11) NOT NULL,
  `FotoA_Fot` longblob,
  `FotoB_Fot` longblob,
  `FotoC_Fot` longblob,
  `FotoD_Fot` longblob,
  `FolioClas_Fot` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `fotos`
--

INSERT INTO `fotos` (`idFotos`, `FotoA_Fot`, `FotoB_Fot`, `FotoC_Fot`, `FotoD_Fot`, `FolioClas_Fot`) VALUES
(1, NULL, NULL, NULL, NULL, 'na');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informes`
--

CREATE TABLE `informes` (
  `idInformes` int(11) NOT NULL,
  `Viaticos_idViaticos` int(11) NOT NULL,
  `Actividad_Infor` varchar(45) DEFAULT NULL,
  `Status_Infor` varchar(45) DEFAULT NULL,
  `Fecha_Infor` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `informes`
--

INSERT INTO `informes` (`idInformes`, `Viaticos_idViaticos`, `Actividad_Infor`, `Status_Infor`, `Fecha_Infor`) VALUES
(5, 16, 'modificado', 'Disponible', '2017-12-06');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulo`
--

CREATE TABLE `modulo` (
  `idModulo` int(11) NOT NULL,
  `Nombre_Mod` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulos`
--

CREATE TABLE `modulos` (
  `idModulos` int(11) NOT NULL,
  `Nombre_Mod` varchar(45) DEFAULT NULL,
  `Caract_Mod` varchar(45) DEFAULT NULL,
  `Descrip_Mod` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos`
--

CREATE TABLE `movimientos` (
  `idMovimientos` int(11) NOT NULL,
  `Fecha_Mov` date DEFAULT NULL,
  `Status_Mov` varchar(45) DEFAULT NULL,
  `Obsr_Mov` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisos`
--

CREATE TABLE `permisos` (
  `idPermisos` int(11) NOT NULL,
  `Modulos_idModulos` int(11) NOT NULL,
  `Nom_Per` varchar(45) DEFAULT NULL,
  `Fecha_Per` date DEFAULT NULL,
  `Autoridad_Per` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL,
  `Nombre_Per` varchar(45) DEFAULT NULL,
  `Ape_Pat_Per` varchar(45) DEFAULT NULL,
  `Ape_Mat_Per` varchar(45) DEFAULT NULL,
  `Curp_Per` varchar(20) DEFAULT NULL,
  `Fecha_Nac_Per` date DEFAULT NULL,
  `Calle_Per` varchar(45) DEFAULT NULL,
  `Colonia_Per` varchar(45) DEFAULT NULL,
  `CP_Per` int(11) DEFAULT NULL,
  `Tel_Per` char(12) DEFAULT NULL,
  `NoLic_Per` varchar(20) DEFAULT NULL,
  `NoCred_Per` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idPersona`, `Nombre_Per`, `Ape_Pat_Per`, `Ape_Mat_Per`, `Curp_Per`, `Fecha_Nac_Per`, `Calle_Per`, `Colonia_Per`, `CP_Per`, `Tel_Per`, `NoLic_Per`, `NoCred_Per`) VALUES
(1, 'Jose Diego', 'Marin', 'Contreras', 'MACD951116HNTRNG02', '0000-00-00', 'Mauricio Cervante', 'Puerta de la Laguna', 63039, '3118471047', '1212j', '32jnnj3'),
(2, 'Jose Gustavo', 'Marin', 'Contreras', 'MACD970105HNTRNG03', '0000-00-00', 'Mauricio Cervante', 'Puerta de la Laguna', 63039, '3111047000', '1212j', '32jnnj3'),
(3, 'David López Nungaray', 'Marin', 'Contreras', 'DAVID51116HNTRNG00', '0000-00-00', 'Mauricio Cervante', 'Puerta de la Laguna', 63039, '3118471047', '1212j', '32jnnj3'),
(4, 'Francisco', 'Cardenas', 'Ramos', 'FRANCISCO5HNTRNG00', '0000-00-00', 'Mauricio Cervante', 'Puerta de la Laguna', 63039, '3111047000', '1212j', '32jnnj3'),
(5, 'Sara', 'Cardenas', 'Ramos', 'SARA951116HNTRNG00', '0000-00-00', 'Mauricio Cervante', 'Puerta de la Laguna', 63039, '3118471047', '1212j', '32jnnj3'),
(6, 'Maria', 'Ramos', 'Gonzales', 'MARIA70105HNTRNG00', '0000-00-00', 'Mauricio Cervante', 'Puerta de la Laguna', 63039, '3111047000', '1212j', '32jnnj3'),
(7, 'Omar', 'Najar', 'Mendez', 'OMAR951116HNTRNG00', '0000-00-00', 'Mauricio Cervante', 'Puerta de la Laguna', 63039, '3118471047', '1212j', '32jnnj3'),
(8, 'Brandon', 'Camarena', 'Virgen', 'BRANDON105HNTRNG00', '0000-00-00', 'Mauricio Cervante', 'Puerta de la Laguna', 63039, '3111047000', '1212j', '32jnnj3'),
(9, 'Issac', 'Garcia', 'Garcia', 'ISSAC51116HNTRNG00', '0000-00-00', 'Mauricio Cervante', 'Puerta de la Laguna', 63039, '3118471047', '1212j', '32jnnj3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `privilegios`
--

CREATE TABLE `privilegios` (
  `idPrivilegios` int(11) NOT NULL,
  `Agregar_Priv` char(1) DEFAULT NULL,
  `Borrar_Priv` char(1) DEFAULT NULL,
  `Actualizar_Priv` char(1) DEFAULT NULL,
  `Visualizar_Priv` char(1) DEFAULT NULL,
  `Tipo_Usr_idTipo_Usr` int(11) NOT NULL,
  `Modulo_idModulo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProductos` int(11) NOT NULL,
  `Clasificacion_idClasificacion` int(11) NOT NULL,
  `Estado_idEstado` int(11) NOT NULL,
  `Fotos_idFotos` int(11) NOT NULL,
  `Car_Esp_idCar_Esp` int(11) NOT NULL,
  `TipoStock_idTipoStock` int(11) NOT NULL,
  `Almacen_idAlmacen` int(11) NOT NULL,
  `Asignacion_Usr_idAsignacion` int(11) NOT NULL,
  `Nom_Prod` varchar(45) DEFAULT NULL,
  `FolioClas_Prod` varchar(45) DEFAULT NULL,
  `Des_Prod` varchar(255) DEFAULT NULL,
  `FechaComp_Prod` date DEFAULT NULL,
  `Stoc_Prod` int(11) DEFAULT NULL,
  `StockMin_Prod` int(11) DEFAULT NULL,
  `Obs_Prod` varchar(255) DEFAULT NULL,
  `NoFact_Prod` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProductos`, `Clasificacion_idClasificacion`, `Estado_idEstado`, `Fotos_idFotos`, `Car_Esp_idCar_Esp`, `TipoStock_idTipoStock`, `Almacen_idAlmacen`, `Asignacion_Usr_idAsignacion`, `Nom_Prod`, `FolioClas_Prod`, `Des_Prod`, `FechaComp_Prod`, `Stoc_Prod`, `StockMin_Prod`, `Obs_Prod`, `NoFact_Prod`) VALUES
(1, 1, 1, 1, 2, 1, 1, 1, 'Jetta ', 'aaass2333', 'automovil', '2017-12-26', 1, 1, 'na', 'na');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `produc_viaticos`
--

CREATE TABLE `produc_viaticos` (
  `Productos_idProductos` int(11) NOT NULL,
  `Solicitud_Viaticos_idViaticos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puestos`
--

CREATE TABLE `puestos` (
  `idPuesto` int(11) NOT NULL,
  `Nom_Pues` varchar(45) DEFAULT NULL,
  `Salario_Pues` double DEFAULT NULL,
  `Area_idArea` int(10) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `puestos`
--

INSERT INTO `puestos` (`idPuesto`, `Nom_Pues`, `Salario_Pues`, `Area_idArea`) VALUES
(1, 'Encargado de area', 10000, 0000000001),
(2, 'Administrador', 20000, 0000000002),
(3, 'Presidente', 10000, 0000000001),
(4, 'Empleado', 20000, 0000000002),
(5, 'Secretario(a)', 20000, 0000000002),
(6, 'Jefe de Informatica', 20000, 0000000002);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

CREATE TABLE `respuesta` (
  `idRespuesta` int(11) NOT NULL,
  `Fecha_Res` date DEFAULT NULL,
  `Status_Res` varchar(45) DEFAULT NULL,
  `Tipo_Res` varchar(45) DEFAULT NULL,
  `idUsuario_Res` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitudes`
--

CREATE TABLE `solicitudes` (
  `idSolicitudes` int(11) NOT NULL,
  `Status_Sol` varchar(45) DEFAULT NULL,
  `Fecha_Sol` datetime DEFAULT NULL,
  `Tipo_Sol` varchar(45) DEFAULT NULL,
  `idUsuario_Sol` int(11) DEFAULT NULL,
  `Descripcion_Sol` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `solicitudes`
--

INSERT INTO `solicitudes` (`idSolicitudes`, `Status_Sol`, `Fecha_Sol`, `Tipo_Sol`, `idUsuario_Sol`, `Descripcion_Sol`) VALUES
(6, 'Solicitada', '2017-12-02 07:44:49', 'Viatico', 1, 'Comala Nose'),
(7, 'Solicitada', '2017-12-02 07:45:24', 'Viatico', 1, 'aqui jajaajaj'),
(8, 'Solicitada', '2017-12-02 11:58:01', 'Viatico', 1, 'Cuidad de Mexico Compra de insumos'),
(9, 'Solicitada', '2017-12-03 00:19:49', 'Viatico', 1, 'nayarit capacitacion'),
(10, 'Solicitada', '2017-12-03 00:22:50', 'Viatico', 1, 'puga na'),
(11, 'Solicitada', '2017-12-05 03:11:20', 'Viatico', 0, 'null null'),
(12, 'Solicitada', '2017-12-05 03:11:41', 'Viatico', 0, 'null null'),
(13, 'Solicitada', '2017-12-05 03:13:25', 'Viatico', 0, 'null null'),
(14, 'Solicitada', '2017-12-05 03:15:44', 'Viatico', 0, 'null null'),
(15, 'Solicitada', '2017-12-05 03:15:56', 'Viatico', 0, 'null null'),
(16, 'Solicitada', '2017-12-05 03:22:08', 'Viatico', 0, 'null null'),
(17, 'Solicitada', '2017-12-05 03:22:16', 'Viatico', 0, 'null null'),
(18, 'Solicitada', '2017-12-05 03:25:06', 'Viatico', 0, 'null null');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud_viaticos`
--

CREATE TABLE `solicitud_viaticos` (
  `idViaticos` int(11) NOT NULL,
  `Fol_Viat` varchar(45) DEFAULT NULL,
  `fol_viatico_int` int(11) NOT NULL,
  `FehaSol_Viat` datetime DEFAULT NULL,
  `FechaAprov_Viat` date DEFAULT NULL,
  `FechaSal_Viat` date DEFAULT NULL,
  `Personal_Viat` varchar(45) DEFAULT NULL,
  `Dias_Viat` varchar(45) DEFAULT NULL,
  `monto` float NOT NULL,
  `Lugar_Viat` varchar(45) DEFAULT NULL,
  `Act_Viat` varchar(45) DEFAULT NULL,
  `Status_Viat` varchar(45) DEFAULT NULL,
  `idVehiculo_Viat` int(11) NOT NULL,
  `Permotado_Viat` varchar(5) DEFAULT NULL,
  `FechaRet_Viat` date DEFAULT NULL,
  `realizada` varchar(2) DEFAULT 'no'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `solicitud_viaticos`
--

INSERT INTO `solicitud_viaticos` (`idViaticos`, `Fol_Viat`, `fol_viatico_int`, `FehaSol_Viat`, `FechaAprov_Viat`, `FechaSal_Viat`, `Personal_Viat`, `Dias_Viat`, `monto`, `Lugar_Viat`, `Act_Viat`, `Status_Viat`, `idVehiculo_Viat`, `Permotado_Viat`, `FechaRet_Viat`, `realizada`) VALUES
(12, '0009', 9, '2017-12-02 07:44:48', NULL, '2017-12-13', 'David López Nungaray Marin Contreras ', '4', 0, 'tepic', 'Reunion comitiva', 'Cancelada', 1, 'si', NULL, 'no'),
(13, '00010', 10, '2017-12-02 07:45:24', NULL, '2017-12-20', 'David López Nungaray Marin Contreras ', '1', 0, 'Xalisco', 'Curso antes de elecciones', 'Cancelada', 1, 'si', NULL, 'no'),
(14, '0011', 11, '2017-12-02 11:58:01', NULL, '2017-12-13', 'Jose Gustavo Marin Contreras ', '2', 0, 'puga', 'Compra de insumos', 'Cancelada', 1, 'si', NULL, 'no'),
(15, '0012', 12, '2017-12-03 00:19:49', NULL, '2017-12-05', 'Jose Gustavo Marin Contreras ', '5', 0, 'nayarit', 'capacitacion', 'No Aprobada', 1, 'si', NULL, 'no'),
(16, '0013', 13, '2017-12-03 00:22:49', NULL, '2017-12-04', 'Jose Gustavo Marin Contreras ', '5', 600, 'puga', 'na', 'Aprobada', 1, 'si', NULL, 'si'),
(17, '0014', 14, '2017-12-08 08:41:35', NULL, '2017-12-13', 'Jose Diego Marin Contreras ', '4', 1000, 'Tonala', 'capacitacion a companeros ', 'Solicitada', 1, 'si', NULL, 'no');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipousuarioviatico`
--

CREATE TABLE `tipousuarioviatico` (
  `idTipoUsuario` int(11) NOT NULL,
  `tipoUsuario` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipousuarioviatico`
--

INSERT INTO `tipousuarioviatico` (`idTipoUsuario`, `tipoUsuario`) VALUES
(1, 'JefeDepartamentoViatico'),
(2, 'SecretariaViatico'),
(3, 'PresidenciaViatico'),
(4, 'EmpleadoViatico'),
(5, 'AdministradorViatico'),
(6, 'JefeInformaticoViatico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_stock`
--

CREATE TABLE `tipo_stock` (
  `idTipoStock` int(11) NOT NULL,
  `Nombre_TipStock` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_stock`
--

INSERT INTO `tipo_stock` (`idTipoStock`, `Nombre_TipStock`) VALUES
(1, 'na');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usr`
--

CREATE TABLE `tipo_usr` (
  `idTipo_Usr` int(11) NOT NULL,
  `Nombre_TipoUsr` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_usr`
--

INSERT INTO `tipo_usr` (`idTipo_Usr`, `Nombre_TipoUsr`) VALUES
(1, 'Super Administrador'),
(2, 'Administrador'),
(3, 'Encargado'),
(4, 'Normal');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usr_perm`
--

CREATE TABLE `usr_perm` (
  `Usuario_idUsuario` int(11) NOT NULL,
  `Permisos_idPermisos` int(11) NOT NULL,
  `Permisos_Modulos_idModulos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usr_resp`
--

CREATE TABLE `usr_resp` (
  `Usuario_idUsuario` int(11) NOT NULL,
  `Respuesta_idRespuesta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usr_solc`
--

CREATE TABLE `usr_solc` (
  `Solicitudes_idSolicitudes` int(11) NOT NULL,
  `Usuario_idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usr_solc`
--

INSERT INTO `usr_solc` (`Solicitudes_idSolicitudes`, `Usuario_idUsuario`) VALUES
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usr_viaticos`
--

CREATE TABLE `usr_viaticos` (
  `Usuario_idUsuario` int(11) NOT NULL,
  `Solicitud_Viaticos_idViaticos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usr_viaticos`
--

INSERT INTO `usr_viaticos` (`Usuario_idUsuario`, `Solicitud_Viaticos_idViaticos`) VALUES
(1, 12),
(1, 13),
(1, 14),
(1, 15),
(1, 16),
(1, 17);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `Password_Usr` varchar(45) DEFAULT NULL,
  `Empleado_RFC_Emp` varchar(20) NOT NULL,
  `Tipo_Usr_idTipo_Usr` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `Password_Usr`, `Empleado_RFC_Emp`, `Tipo_Usr_idTipo_Usr`) VALUES
(1, '123456', 'JDMC', 2),
(2, '123456', 'JGMC', 2),
(3, '123456', 'dalopeznu', 1),
(4, '123456', 'frcardenasra', 4),
(5, '123456', 'sacardenasra', 1),
(6, '123456', 'maramosgo', 4),
(7, '123456', 'omnajarme', 4),
(8, '123456', 'brcamarenavi', 4),
(9, '123456', 'isgarciaga', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuariosviatico`
--

CREATE TABLE `usuariosviatico` (
  `idUsuario` int(11) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `idEmpleado` varchar(20) DEFAULT NULL,
  `tipousuarioviatico` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuariosviatico`
--

INSERT INTO `usuariosviatico` (`idUsuario`, `usuario`, `password`, `idEmpleado`, `tipousuarioviatico`) VALUES
(1, 'Vbrcamarenavi', '12345', 'brcamarenavi', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuar_product`
--

CREATE TABLE `usuar_product` (
  `Usuario_idUsuario` int(11) NOT NULL,
  `Asignacion_Usr_idAsignacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD PRIMARY KEY (`idAlmacen`);

--
-- Indices de la tabla `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`idArea`);

--
-- Indices de la tabla `asignacion_usr`
--
ALTER TABLE `asignacion_usr`
  ADD PRIMARY KEY (`idAsignacion`);

--
-- Indices de la tabla `car_esp`
--
ALTER TABLE `car_esp`
  ADD PRIMARY KEY (`idCar_Esp`);

--
-- Indices de la tabla `clasificacion`
--
ALTER TABLE `clasificacion`
  ADD PRIMARY KEY (`idClasificacion`);

--
-- Indices de la tabla `contenido`
--
ALTER TABLE `contenido`
  ADD PRIMARY KEY (`idContenido`,`Datos_Esp_idDatos_Esp`),
  ADD KEY `fk_Contenido_Datos_Esp1_idx` (`Datos_Esp_idDatos_Esp`);

--
-- Indices de la tabla `datos_esp`
--
ALTER TABLE `datos_esp`
  ADD PRIMARY KEY (`idDatos_Esp`,`Car_Esp_idCar_Esp`),
  ADD KEY `fk_Datos_Esp_Car_Esp1_idx` (`Car_Esp_idCar_Esp`);

--
-- Indices de la tabla `datos_vehiculo`
--
ALTER TABLE `datos_vehiculo`
  ADD PRIMARY KEY (`IdDatos`),
  ADD KEY `idProducto` (`IdProducto`),
  ADD KEY `IdViaticos` (`IdViaticos`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`RFC_Emp`,`Puestos_idPuesto`,`Persona_idPersona`),
  ADD KEY `fk_Empleado_Puestos_idx` (`Puestos_idPuesto`),
  ADD KEY `fk_Empleado_Persona1_idx` (`Persona_idPersona`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`idEstado`);

--
-- Indices de la tabla `fotos`
--
ALTER TABLE `fotos`
  ADD PRIMARY KEY (`idFotos`);

--
-- Indices de la tabla `informes`
--
ALTER TABLE `informes`
  ADD PRIMARY KEY (`idInformes`,`Viaticos_idViaticos`),
  ADD KEY `fk_Informes_Viaticos1_idx` (`Viaticos_idViaticos`);

--
-- Indices de la tabla `modulo`
--
ALTER TABLE `modulo`
  ADD PRIMARY KEY (`idModulo`);

--
-- Indices de la tabla `modulos`
--
ALTER TABLE `modulos`
  ADD PRIMARY KEY (`idModulos`);

--
-- Indices de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD PRIMARY KEY (`idMovimientos`);

--
-- Indices de la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD PRIMARY KEY (`idPermisos`,`Modulos_idModulos`),
  ADD KEY `fk_Permisos_Modulos1_idx` (`Modulos_idModulos`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idPersona`);

--
-- Indices de la tabla `privilegios`
--
ALTER TABLE `privilegios`
  ADD PRIMARY KEY (`idPrivilegios`,`Tipo_Usr_idTipo_Usr`,`Modulo_idModulo`),
  ADD KEY `fk_Privilegios_Tipo_Usr1_idx` (`Tipo_Usr_idTipo_Usr`),
  ADD KEY `fk_Privilegios_Modulo1_idx` (`Modulo_idModulo`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProductos`,`Clasificacion_idClasificacion`,`Estado_idEstado`,`Fotos_idFotos`,`Car_Esp_idCar_Esp`,`TipoStock_idTipoStock`,`Almacen_idAlmacen`),
  ADD KEY `fk_Productos_Clasificacion1_idx` (`Clasificacion_idClasificacion`),
  ADD KEY `fk_Productos_Estado1_idx` (`Estado_idEstado`),
  ADD KEY `fk_Productos_Fotos1_idx` (`Fotos_idFotos`),
  ADD KEY `fk_Productos_Asignacion_Usr1_idx` (`Asignacion_Usr_idAsignacion`),
  ADD KEY `fk_Productos_Almacen1_idx` (`Almacen_idAlmacen`),
  ADD KEY `fk_Productos_Car_Esp1_idx` (`Car_Esp_idCar_Esp`),
  ADD KEY `fk_Productos_TipoStock1_idx` (`TipoStock_idTipoStock`);

--
-- Indices de la tabla `produc_viaticos`
--
ALTER TABLE `produc_viaticos`
  ADD PRIMARY KEY (`Productos_idProductos`,`Solicitud_Viaticos_idViaticos`),
  ADD KEY `fk_Produc_Viaticos_Solicitud_Viaticos1_idx` (`Solicitud_Viaticos_idViaticos`);

--
-- Indices de la tabla `puestos`
--
ALTER TABLE `puestos`
  ADD PRIMARY KEY (`idPuesto`,`Area_idArea`),
  ADD KEY `fk_Puestos_Area1_idx` (`Area_idArea`);

--
-- Indices de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD PRIMARY KEY (`idRespuesta`);

--
-- Indices de la tabla `solicitudes`
--
ALTER TABLE `solicitudes`
  ADD PRIMARY KEY (`idSolicitudes`);

--
-- Indices de la tabla `solicitud_viaticos`
--
ALTER TABLE `solicitud_viaticos`
  ADD PRIMARY KEY (`idViaticos`,`idVehiculo_Viat`);

--
-- Indices de la tabla `tipousuarioviatico`
--
ALTER TABLE `tipousuarioviatico`
  ADD PRIMARY KEY (`idTipoUsuario`);

--
-- Indices de la tabla `tipo_stock`
--
ALTER TABLE `tipo_stock`
  ADD PRIMARY KEY (`idTipoStock`);

--
-- Indices de la tabla `tipo_usr`
--
ALTER TABLE `tipo_usr`
  ADD PRIMARY KEY (`idTipo_Usr`);

--
-- Indices de la tabla `usr_perm`
--
ALTER TABLE `usr_perm`
  ADD PRIMARY KEY (`Usuario_idUsuario`,`Permisos_idPermisos`,`Permisos_Modulos_idModulos`),
  ADD KEY `fk_Usr_Perm_Permisos1_idx` (`Permisos_idPermisos`,`Permisos_Modulos_idModulos`);

--
-- Indices de la tabla `usr_resp`
--
ALTER TABLE `usr_resp`
  ADD PRIMARY KEY (`Usuario_idUsuario`,`Respuesta_idRespuesta`),
  ADD KEY `fk_Usr_Resp_Respuesta1_idx` (`Respuesta_idRespuesta`);

--
-- Indices de la tabla `usr_solc`
--
ALTER TABLE `usr_solc`
  ADD PRIMARY KEY (`Solicitudes_idSolicitudes`,`Usuario_idUsuario`),
  ADD KEY `fk_Control_Solicitudes1_idx` (`Solicitudes_idSolicitudes`),
  ADD KEY `fk_Usr_Solc_Usuario1_idx` (`Usuario_idUsuario`);

--
-- Indices de la tabla `usr_viaticos`
--
ALTER TABLE `usr_viaticos`
  ADD PRIMARY KEY (`Usuario_idUsuario`,`Solicitud_Viaticos_idViaticos`),
  ADD KEY `fk_Usr_Viaticos_Solicitud_Viaticos1_idx` (`Solicitud_Viaticos_idViaticos`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`,`Empleado_RFC_Emp`,`Tipo_Usr_idTipo_Usr`),
  ADD KEY `fk_Usuario_Empleado1_idx` (`Empleado_RFC_Emp`),
  ADD KEY `fk_Usuario_Tipo_Usr1_idx` (`Tipo_Usr_idTipo_Usr`);

--
-- Indices de la tabla `usuariosviatico`
--
ALTER TABLE `usuariosviatico`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `usuarioEmpleadoViaticos` (`idEmpleado`),
  ADD KEY `tipoUsuarioViaticos` (`tipousuarioviatico`);

--
-- Indices de la tabla `usuar_product`
--
ALTER TABLE `usuar_product`
  ADD PRIMARY KEY (`Usuario_idUsuario`,`Asignacion_Usr_idAsignacion`),
  ADD KEY `fk_Usuar_Product_Asignacion_Usr1_idx` (`Asignacion_Usr_idAsignacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `almacen`
--
ALTER TABLE `almacen`
  MODIFY `idAlmacen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `area`
--
ALTER TABLE `area`
  MODIFY `idArea` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `asignacion_usr`
--
ALTER TABLE `asignacion_usr`
  MODIFY `idAsignacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `car_esp`
--
ALTER TABLE `car_esp`
  MODIFY `idCar_Esp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `clasificacion`
--
ALTER TABLE `clasificacion`
  MODIFY `idClasificacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `contenido`
--
ALTER TABLE `contenido`
  MODIFY `idContenido` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `datos_esp`
--
ALTER TABLE `datos_esp`
  MODIFY `idDatos_Esp` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `datos_vehiculo`
--
ALTER TABLE `datos_vehiculo`
  MODIFY `IdDatos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `idEstado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `fotos`
--
ALTER TABLE `fotos`
  MODIFY `idFotos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `informes`
--
ALTER TABLE `informes`
  MODIFY `idInformes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `modulo`
--
ALTER TABLE `modulo`
  MODIFY `idModulo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `modulos`
--
ALTER TABLE `modulos`
  MODIFY `idModulos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  MODIFY `idMovimientos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `permisos`
--
ALTER TABLE `permisos`
  MODIFY `idPermisos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `privilegios`
--
ALTER TABLE `privilegios`
  MODIFY `idPrivilegios` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProductos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `puestos`
--
ALTER TABLE `puestos`
  MODIFY `idPuesto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  MODIFY `idRespuesta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `solicitudes`
--
ALTER TABLE `solicitudes`
  MODIFY `idSolicitudes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `solicitud_viaticos`
--
ALTER TABLE `solicitud_viaticos`
  MODIFY `idViaticos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `tipo_stock`
--
ALTER TABLE `tipo_stock`
  MODIFY `idTipoStock` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tipo_usr`
--
ALTER TABLE `tipo_usr`
  MODIFY `idTipo_Usr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `usuariosviatico`
--
ALTER TABLE `usuariosviatico`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `contenido`
--
ALTER TABLE `contenido`
  ADD CONSTRAINT `fk_Contenido_Datos_Esp1` FOREIGN KEY (`Datos_Esp_idDatos_Esp`) REFERENCES `datos_esp` (`idDatos_Esp`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `datos_esp`
--
ALTER TABLE `datos_esp`
  ADD CONSTRAINT `fk_Datos_Esp_Car_Esp1` FOREIGN KEY (`Car_Esp_idCar_Esp`) REFERENCES `car_esp` (`idCar_Esp`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `datos_vehiculo`
--
ALTER TABLE `datos_vehiculo`
  ADD CONSTRAINT `idProdDatosV` FOREIGN KEY (`IdProducto`) REFERENCES `productos` (`idProductos`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `idViaticosDatosV` FOREIGN KEY (`IdViaticos`) REFERENCES `solicitud_viaticos` (`idViaticos`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `fk_Empleado_Persona1` FOREIGN KEY (`Persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Empleado_Puestos` FOREIGN KEY (`Puestos_idPuesto`) REFERENCES `puestos` (`idPuesto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `informes`
--
ALTER TABLE `informes`
  ADD CONSTRAINT `fk_Informes_Viaticos1` FOREIGN KEY (`Viaticos_idViaticos`) REFERENCES `solicitud_viaticos` (`idViaticos`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD CONSTRAINT `fk_Permisos_Modulos1` FOREIGN KEY (`Modulos_idModulos`) REFERENCES `modulos` (`idModulos`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `privilegios`
--
ALTER TABLE `privilegios`
  ADD CONSTRAINT `fk_Privilegios_Modulo1` FOREIGN KEY (`Modulo_idModulo`) REFERENCES `modulo` (`idModulo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Privilegios_Tipo_Usr1` FOREIGN KEY (`Tipo_Usr_idTipo_Usr`) REFERENCES `tipo_usr` (`idTipo_Usr`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `fk_Productos_Almacen1` FOREIGN KEY (`Almacen_idAlmacen`) REFERENCES `almacen` (`idAlmacen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Productos_Asignacion_Usr1` FOREIGN KEY (`Asignacion_Usr_idAsignacion`) REFERENCES `asignacion_usr` (`idAsignacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Productos_Car_Esp1` FOREIGN KEY (`Car_Esp_idCar_Esp`) REFERENCES `car_esp` (`idCar_Esp`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Productos_Clasificacion1` FOREIGN KEY (`Clasificacion_idClasificacion`) REFERENCES `clasificacion` (`idClasificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Productos_Estado1` FOREIGN KEY (`Estado_idEstado`) REFERENCES `estado` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Productos_Fotos1` FOREIGN KEY (`Fotos_idFotos`) REFERENCES `fotos` (`idFotos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Productos_TipoStock1` FOREIGN KEY (`TipoStock_idTipoStock`) REFERENCES `tipo_stock` (`idTipoStock`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `produc_viaticos`
--
ALTER TABLE `produc_viaticos`
  ADD CONSTRAINT `fk_Produc_Viaticos_Productos1` FOREIGN KEY (`Productos_idProductos`) REFERENCES `productos` (`idProductos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Produc_Viaticos_Solicitud_Viaticos1` FOREIGN KEY (`Solicitud_Viaticos_idViaticos`) REFERENCES `solicitud_viaticos` (`idViaticos`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `puestos`
--
ALTER TABLE `puestos`
  ADD CONSTRAINT `fk_Puestos_Area1` FOREIGN KEY (`Area_idArea`) REFERENCES `area` (`idArea`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usr_perm`
--
ALTER TABLE `usr_perm`
  ADD CONSTRAINT `fk_Usr_Perm_Permisos1` FOREIGN KEY (`Permisos_idPermisos`,`Permisos_Modulos_idModulos`) REFERENCES `permisos` (`idPermisos`, `Modulos_idModulos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Usr_Perm_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usr_resp`
--
ALTER TABLE `usr_resp`
  ADD CONSTRAINT `fk_Usr_Resp_Respuesta1` FOREIGN KEY (`Respuesta_idRespuesta`) REFERENCES `respuesta` (`idRespuesta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_table1_Usuario2` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usr_solc`
--
ALTER TABLE `usr_solc`
  ADD CONSTRAINT `fk_Control_Solicitudes1` FOREIGN KEY (`Solicitudes_idSolicitudes`) REFERENCES `solicitudes` (`idSolicitudes`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Usr_Solc_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usr_viaticos`
--
ALTER TABLE `usr_viaticos`
  ADD CONSTRAINT `fk_Usr_Viaticos_Solicitud_Viaticos1` FOREIGN KEY (`Solicitud_Viaticos_idViaticos`) REFERENCES `solicitud_viaticos` (`idViaticos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Usr_Viaticos_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_Usuario_Empleado1` FOREIGN KEY (`Empleado_RFC_Emp`) REFERENCES `empleado` (`RFC_Emp`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Usuario_Tipo_Usr1` FOREIGN KEY (`Tipo_Usr_idTipo_Usr`) REFERENCES `tipo_usr` (`idTipo_Usr`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuariosviatico`
--
ALTER TABLE `usuariosviatico`
  ADD CONSTRAINT `tipoUsuarioViaticos` FOREIGN KEY (`tipousuarioviatico`) REFERENCES `tipousuarioviatico` (`idTipoUsuario`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `usuarioEmpleadoViaticos` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`RFC_Emp`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuar_product`
--
ALTER TABLE `usuar_product`
  ADD CONSTRAINT `fk_Usuar_Product_Asignacion_Usr1` FOREIGN KEY (`Asignacion_Usr_idAsignacion`) REFERENCES `asignacion_usr` (`idAsignacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_table1_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
