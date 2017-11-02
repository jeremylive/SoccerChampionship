--PRIMER PROYECTO PROGRAMADO BASES DE DATOS 1 - INTERPRETE DE ALGEBRA RELACIONAL

--Creo login administrador
CREATE LOGIN loglive
WITH PASSWORD='111'
--
CREATE LOGIN loglive2
WITH PASSWORD='222'

--Creo la base de datos
CREATE DATABASE bdproy1
GO
--Trabajo sobre esta DB
USE bdproy1
GO

--Creo usuario dbaproy1
CREATE USER dbaproy1
FOR LOGIN loglive
--Tiene todos los privilegios como DBA, se van a crear los objetos de la DBm con este usuario
GRANT CREATE PROC, EXECUTE, CREATE TABLE, CREATE ROLE, SELECT, INSERT, UPDATE, DELETE TO dbaproy1
GO
--Creo usuario usproy1
CREATE USER usproy1
FOR LOGIN loglive2
--Tiene lectura para los datos de las tablas permanentes y CRUD para las tablas temporales
GRANT SELECT TO usproy1
GO

--Creo esquema
CREATE SCHEMA proy2 authorization dbaproy1
GO
--Le doy permisos al usproy1 de autorizar el esquema PROY1 por medio de la interfaz
--
CREATE TABLE proy2.confederacionesFutbol
	(
	codigo_confederacionFutbol	char(3),
	nombre_confederacionFutbol	char(40),
	primary key(codigo_confederacionFutbol)
	)
GO
CREATE TABLE proy2.equipos
	(
	codigo_equipo	char(3),
	nombre_pais_del_equipo char(40),
	condigo_confederacionFut char(3),
	nombres_jugadores varray(12) of char(15),		--insert into table values(, nombres_jugadores('',''))
	nombre_entrenador char(15),
	nombre_asistentes char(100),		--s
	nombre_federativo char(15),			--
	grupo_inicial int,	--8 grupos de 4 equipos
	primary key(codigo_equipo)
	)
GO
CREATE TABLE proy2.jugadores
	(
	numero_pasaporte_jugador char(10),
	nombre_jugador	char(15),
	apellido_1_jugador char(15),
	apellido_2_jugador char(15),
	puesto_jugador char(15), --Portero, Defensa, Mediocampista, Delantero
	fecha_nacimiento_jugador date,
	numero_camiseta int,	--0 a 99
	primary key(numero_pasaporte_jugador)
	)
GO
CREATE TABLE proy2.entrenadores
	(
	numero_pasaporte_entrenador char(10),
	nombre_entrenador char(15),
	apellido_1_entrenador char(15),
	apellido_2_entrenador char(15),
	pais_nacionalidad_entrenador char(40),
	fecha_nacimiento_entrenador date,
	fecha_inicio_entrenador date,
	primary key(numero_pasaporte_entrenador)
	)
GO
CREATE TABLE proy2.asistentes
	(
	numero_pasaporte_asistente char(10),
	nombre_asistente char(15),
	apellido_1_asistente char(15),
	apellido_2_asistente char(15),
	pais_nacionalidad_asistente char(40),
	tipo_asistente char(20), --Técnico, Preparador Físico, Médico, Psicólogo, Nutricionista,administrativo, delegado de equipo
	fecha_nacimiento_asistente date,
	fecha_inicio_asistente date,
	primary key(numero_pasaporte_asistente)
	)
GO
CREATE TABLE proy2.federativos
	(
	numero_pasaporte_federativo char(10),
	nombre_federativo char(15),
	apellido_1_federativo char(15),
	apellido_2_federativo char(15),
	pais_nacionalidad_federativo char(40),
	puesto_federativo char(20), --Presidente, Vicepresidente, Secretario, Tesorero, Fiscal, Vocal
	fecha_nacimiento_federativo date,
	fecha_inicio_federativo date,
	primary key(numero_pasaporte_federativo)
	)
GO
CREATE TABLE proy2.sedes
	(
	lugar_game char(20),
	nombre_sede char(40), --unico
	nombre_estadio char(40),  --unico
	capacidad_estadio int, --de 25.000 a 150.000
	primary key(lugar_game)
	)
GO
CREATE TABLE proy2.partidos
	(
	numero_partido int,		--es unico de 1 a 64
	etapa_clasificatoria char(20), --Fase de grupos, Octavos de final, Cuartos de final, Semifinales, Tercer Puesto, Final.
	nombre_equipo_1 char(15),
	nombre_equipo_2 char(15),
	nombre_estadio char(40),
	fecha_partido date,
	hora_partido time,
	cantidad_aficionados int,
	jugadores_titulares_equipo_1 char(100),
	jugadores_titulares_equipo_2 char(100),
	cuerpo_arbitral char(100),
	goles_equipo_1 int,
	goles_equipo_2 int,
	tarjetas_amarillas char(30), --min y seg, jugador tarjeteado
	tarjetas_rojas char(30),
	minuto_reposicion_primer_tiempo int,
	minuto_repsicion_segundo_tiempo int,
	se_jugo_tiempo_extra char(5),--SI/no
	se_tiraron_penales char(5),--SI/no
	detalle_penales char(100), --#Penal, jugadorQueLohizo, Anoto? SI/no
	primary key(numero_partido)
	)
GO
CREATE TABLE proy2.arbitros
	(
	numero_pasaporte char(10),
	nombre_arbitro char(15),
	apellido_1_arbitro char(15),
	apellido_2_arbitro char(15),
	pais_nacionalidad_arbitro char(40),
	fecha_nacimiento_arbitro date,
	fecha_inicio_arbitro date,
	primary key(numero_pasaporte)
	)
----
INSERT INTO proy2.confederacionesFutbol
VALUES('Concacaf', 'Confederación Centroamericana y del Caribe de Fútbol'),
('UEFA', 'Unión Europea de Fútbol Asociado'),
('Conmebol', 'Confederación Sudamericana de Fútbol'),
('CAF', 'Confederación de fútbol de Africa'),
('AFC', 'Confederación de fútbol de Asia'),
('OFC', 'Confederación de fútbol de Oceanía')
INSERT INTO proy2.jugadores
VALUES(12, nombres_jugadores('','','',''))

