--###################################################################################
--###################################################################################
--###################################################################################

--Inserto informacion de equipos(manual) MSQL
create Database Campeonato
GO

use Campeonato
GO

CREATE TABLE EQUIPO
(
	CodPais			char(3),
	NombrePais		varchar(40),
	GrupoInicial	char(1),
	CodConf			varchar(8),
	check(CodConf in ('Concacaf','UEFA','Conmebol','CAF','AFC','OFC')),
	primary key(CodPais)
)
GO

INSERT INTO EQUIPO VALUES
('USA','Estados Unidos','G','Concacaf'),
('MEX','Mexico','A','Concacaf'),
('HON','Honduras','E','Concacaf'),
('CRC','Costa Rica','D','Concacaf'),
('COL','Colombia','C','Conmebol'),
('ECU','Ecuador','E','Conmebol'),
('BRA','Brasil','A','Conmebol'),
('CHI','Chile','B','Conmebol'),
('URU','Uruguay','D','Conmebol'),
('ARG','Argentina','F','Conmebol'),
('ENG','Inglaterra','D','UEFA'),
('BEL','Belgica','H','UEFA'),
('FRA','Francia','E','UEFA'),
('ESP','España','B','UEFA'),
('POR','Portugal','G','UEFA'),
('NED','Paises Bajos','B','UEFA'),
('GER','Alemania','G','UEFA'),
('SUI','Suiza','E','UEFA'),
('CRO','Croacia','A','UEFA'),
('BIH','Bosnia y Herzegovina','F','UEFA'),
('ITA','Italia','D','UEFA'),
('GRE','Grecia','C','UEFA'),
('ALG','Argelia','H','CAF'),
('GHA','Ghana','G','CAF'),
('CIV','Costa de Marfil','C','CAF'),
('NGA','Nigeria','F','CAF'),
('CMR','Camerun','A','CAF'),
('RUS','Rusia','H','UEFA'),
('IRN','Iran','F','AFC'),
('JPN','Japon','C','AFC'),
('KOR','Republica de Korea','H','AFC'),
('AUS','Australia','B','AFC')

--Inserto informacion de jugadores(manual) Excel
INSERT INTO jugadores
VALUES()

--Inserto informacion de Condederacion
INSERT INTO confederacionesFutbol VALUES
('Concacaf', 'Confederación Centroamericana y del Caribe de Fútbol'),
('UEFA', 'Unión Europea de Fútbol Asociado'),
('Conmebol', 'Confederación Sudamericana de Fútbol'),
('CAF', 'Confederación de fútbol de Africa'),
('AFC', 'Confederación de fútbol de Asia'),
('OFC', 'Confederación de fútbol de Oceanía')

--Inserto informacion de Persona
INSERT INTO persona VALUES
(1,'Marco','Rodriguez','Moreno',TO_DATE('10/NOV/1973','DD,MON,YYYY')),
(2,'Joel','Aguilar','Chicas',TO_DATE('02/JUL/1975','DD,MON,YYYY')),
(3,'Mark','Geiger','-',TO_DATE('25/AGO/1974','DD,MON,YYYY')),
(4,'Roberto','Moreno','Salazar',TO_DATE('03/APR/1970','DD,MON,YYYY')),
(5,'Walter','Lopez','Castellanos',TO_DATE('25/SEP/1980','DD,MON,YYYY')),
(6,'Ben','Williams','-',TO_DATE('14/APR/1977','DD,MON,YYYY')),
(7,'Nawaf','Ghayyath','Shukralla',TO_DATE('13/OCT/1976','DD,MON,YYYY')),
(8,'Yuichi','Nishimura','-',TO_DATE('17/APR/1972','DD,MON,YYYY')),
(9,'Ravshan','Irmatov','-',TO_DATE('09/AGO/1977','DD,MON,YYYY')),
(10,'Alireza','Faghani','-',TO_DATE('21/MAR/1978','DD,MON,YYYY')),
(11,'Peter','O Leary','-',TO_DATE('03/MAR/1972','DD,MON,YYYY')),
(12,'Norbert','Hauata','-',TO_DATE('08/JUN/1979','DD,MON,YYYY')),
(13,'Djamel','Haimoudi','-',TO_DATE('10/DEC/1970','DD,MON,YYYY')),
(14,'Bakary','Gassama','-',TO_DATE('10/FEB/1979','DD,MON,YYYY')),
(15,'Noumandiez','Doue','-',TO_DATE('29/SEP/1970','DD,MON,YYYY')),
(16,'Sidi','Alioum','-',TO_DATE('17/JUL/1982','DD,MON,YYYY')),
(17,'Carlos','Vera','Rodríguez',TO_DATE('25/JUN/1976','DD,MON,YYYY')),
(18,'Enrique','Osses','Zencovich',TO_DATE('26/MAY/1974','DD,MON,YYYY')),
(19,'Sandro','Ricci','-',TO_DATE('19/NOV/1974','DD,MON,YYYY')),
(20,'Nestor','Pitana','-',TO_DATE('17/JUN/1975','DD,MON,YYYY')),
(21,'Wilmar','Roldan','Perez',TO_DATE('24/JAN/1980','DD,MON,YYYY')),
(22,'Victor','Carrillo','Casanova',TO_DATE('30/OCT/1975','DD,MON,YYYY')),
(23,'Björn','Kuipers','-',TO_DATE('28/MAR/1973','DD,MON,YYYY')),
(24,'Carlos','Velasco','Carballo',TO_DATE('16/MAR/1971','DD,MON,YYYY')),
(25,'Cüneyt','Çakir','-',TO_DATE('23/NOV/1976','DD,MON,YYYY')),
(26,'Felix','Brych','-',TO_DATE('03/AGO/1975','DD,MON,YYYY')),
(27,'Jonas','Eriksson','-',TO_DATE('28/MAR/1974','DD,MON,YYYY')),
(28,'Milorad','Mažic','-',TO_DATE('23/MAR/1973','DD,MON,YYYY')),
(29,'Nicola','Rizzoli','Perez',TO_DATE('05/OCT/1971','DD,MON,YYYY')),
(30,'Howard','Webb','-',TO_DATE('14/JUL/1971','DD,MON,YYYY')),
(31,'Pedro','Proença','Oliveira',TO_DATE('03/NOV/1970','DD,MON,YYYY')),
(32,'Svein','Oddvar','Moen',TO_DATE('22/JAN/1979','DD,MON,YYYY')),

(33,'Jürgen','Klinsmann','-',TO_DATE('30/JUL/1964','DD,MON,YYYY')),
(34,'Miguel','Herrera','Aguirre',TO_DATE('18/MAR/1968','DD,MON,YYYY')),
(35,'Luis','Suárez','Guzmán',TO_DATE('23/DEC/1959','DD,MON,YYYY')),
(36,'Jorge','Pinto','Afanador',TO_DATE('16/DEC/1952','DD,MON,YYYY')),
(37,'José','Néstor','Pékerman',TO_DATE('03/SEP/1949','DD,MON,YYYY')),
(38,'Reinaldo','Rueda','Rivera',TO_DATE('16/APR/1957','DD,MON,YYYY')),
(39,'Luiz','Scolari','-',TO_DATE('09/NOV/1948','DD,MON,YYYY')),
(40,'Jorge','Sampaoli','Moya',TO_DATE('13/MAR/1960','DD,MON,YYYY')),
(41,'Óscar','Tabárez','Silva',TO_DATE('03/MAR/1947','DD,MON,YYYY')),
(42,'Alejandro','Sabella','-',TO_DATE('05/NOV/1954','DD,MON,YYYY')),
(43,'Roy','Hodgson','-',TO_DATE('09/AGO/1947','DD,MON,YYYY')),
(44,'Marc','Wilmots','-',TO_DATE('22/FEB/1969','DD,MON,YYYY')),
(45,'Didier','Deschamps','-',TO_DATE('15/OCT/1968','DD,MON,YYYY')),
(46,'Vicente','del Bosque','González',TO_DATE('23/DEC/1950','DD,MON,YYYY')),
(47,'Paulo','Gomes','Bento',TO_DATE('20/JUN/1969','DD,MON,YYYY')),
(48,'Louis','van Gaal','-',TO_DATE('08/AGO/1951','DD,MON,YYYY')),
(49,'Joachim','Löw','-',TO_DATE('03/FEB/1960','DD,MON,YYYY')),
(50,'Ottmar','Hitzfeld','-',TO_DATE('12/JAN/1949','DD,MON,YYYY')),
(51,'Niko','Kovac','-',TO_DATE('15/OCT/1971','DD,MON,YYYY')),
(52,'Safet','Sušic','-',TO_DATE('13/APR/1955','DD,MON,YYYY')),
(53,'Claudio','Cesare','Prandelli',TO_DATE('19/AGO/1957','DD,MON,YYYY')),
(54,'Fernando','Costa','Santos',TO_DATE('10/OCT/1954','DD,MON,YYYY')),
(55,'Vahid','Halilhodžic','-',TO_DATE('15/OCT/1952','DD,MON,YYYY')),
(56,'James','Kwesi','Appiah',TO_DATE('30/JUN/1960','DD,MON,YYYY')),
(57,'Sabri','Lamouchi','-',TO_DATE('09/NOV/1971','DD,MON,YYYY')),
(58,'Stephen','Okechukwu','Keshi',TO_DATE('23/JAN/1962','DD,MON,YYYY')),
(59,'Volker','Finke','-',TO_DATE('24/MAR/1948','DD,MON,YYYY')),
(60,'Fabio','Capello','-',TO_DATE('18/JUN/1946','DD,MON,YYYY')),
(61,'Carlos','Brito Leal','Queiroz',TO_DATE('01/MAR/1953','DD,MON,YYYY')),
(62,'Alberto','Zaccheroni','-',TO_DATE('01/APR/1953','DD,MON,YYYY')),
(63,'Hong','Myung-bo','-',TO_DATE('12/FEB/1969','DD,MON,YYYY')),
(64,'Angelos','Postecoglou','-',TO_DATE('27/AGO/1965','DD,MON,YYYY'))

INSERT INTO entrenadores VALUES
(33,'Alemania',TO_DATE('2008','YYYY'),'USA'),
(34,'Mexico',TO_DATE('2002','YYYY'),'MEX'),
(35,'Colombia',TO_DATE('1999','YYYY'),'HON'),
(36,'Colombia',TO_DATE('1984','YYYY'),'CRC'),
(37,'Argentina',TO_DATE('1981','YYYY'),'COL'),
(38,'Colombia',TO_DATE('1994','YYYY'),'ECU'),
(39,'Brasil',TO_DATE('1982','YYYY'),'BRA'),
(40,'Argentina',TO_DATE('1996','YYYY'),'CHI'),
(41,'Uruguay',TO_DATE('1980','YYYY'),'URU'),
(42,'Argentina',TO_DATE('2009','YYYY'),'ARG'),
(43,'Inglaterra',TO_DATE('1976','YYYY'),'ENG'),
(44,'Belgica',TO_DATE('2003','YYYY'),'BEL'),
(45,'Francia',TO_DATE('2001','YYYY'),'FRA'),
(46,'España',TO_DATE('1987','YYYY'),'ESP'),
(47,'Portugal',TO_DATE('2004','YYYY'),'POR'),
(48,'Paises Bajos',TO_DATE('1991','YYYY'),'NED'),
(49,'Alemania',TO_DATE('1994','YYYY'),'GER'),
(50,'Alemania',TO_DATE('1983','YYYY'),'SUI'),
(51,'Alemania',TO_DATE('2013','YYYY'),'CRO'),
(52,'Bosnia y Herzegovina',TO_DATE('1994','YYYY'),'BIH'),
(53,'Italia',TO_DATE('1990','YYYY'),'ITA'),
(54,'Portugal',TO_DATE('1987','YYYY'),'GRE'),
(55,'Bosnia y Herzegovina',TO_DATE('1990','YYYY'),'ALG'),
(56,'Ghana',TO_DATE('2011','YYYY'),'GHA'),
(57,'Francia',TO_DATE('2012','YYYY'),'CIV'),
(58,'Nigeria',TO_DATE('2008','YYYY'),'NGA'),
(59,'Alemania',TO_DATE('1975','YYYY'),'CMR'),
(60,'Italia',TO_DATE('1991','YYYY'),'RUS'),
(61,'Mozambique',TO_DATE('1994','YYYY'),'IRN'),
(62,'Italia',TO_DATE('1983','YYYY'),'JPN'),
(63,'Corea del Sur',TO_DATE('2013','YYYY'),'KOR'),
(64,'Grecia',TO_DATE('1996','YYYY'),'AUS')

INSERT INTO arbitros VALUES
(1,'Mexico',TO_DATE('1995','YYYY')),
(2,'El Salvador',TO_DATE('2001','YYYY')),
(3,'Estados Unidos',TO_DATE('2003','YYYY')),
(4,'Panama',TO_DATE('1989','YYYY')),
(5,'Guatemala',TO_DATE('2006','YYYY')),
(6,'Australia',TO_DATE('2005','YYYY')),
(7,'Barein',TO_DATE('2008','YYYY')),
(8,'Japon',TO_DATE('1999','YYYY')),
(9,'Uzbekistan',TO_DATE('2003','YYYY')),
(10,'Iran',TO_DATE('2008','YYYY')),
(11,'Nueva Zelanda',TO_DATE('1994','YYYY')),
(12,'Polinesia Francesa',TO_DATE('2008','YYYY')),
(13,'Argelia',TO_DATE('2004','YYYY')),
(14,'Gambia',TO_DATE('2007','YYYY')),
(15,'Costa de Marfil',TO_DATE('2004','YYYY')),
(16,'Camerun',TO_DATE('2008','YYYY')),
(17,'Ecuador',TO_DATE('2006','YYYY')),
(18,'Chile',TO_DATE('2005','YYYY')),
(19,'Brasil',TO_DATE('2011','YYYY')),
(20,'Argentina',TO_DATE('2006','YYYY')),
(21,'Colombia',TO_DATE('2003','YYYY')),
(22,'Peru',TO_DATE('2002','YYYY')),
(23,'Paises Bajos',TO_DATE('2006','YYYY')),
(24,'España',TO_DATE('2004','YYYY')),
(25,'Turquia',TO_DATE('2006','YYYY')),
(26,'Alemania',TO_DATE('2004','YYYY')),
(27,'Suecia',TO_DATE('1994','YYYY')),
(28,'Serbia',TO_DATE('2009','YYYY')),
(29,'Italia',TO_DATE('2002','YYYY')),
(30,'Inglaterra',TO_DATE('2003','YYYY')),
(31,'Portugal',TO_DATE('2003','YYYY')),
(32,'Noruega',TO_DATE('2003','YYYY'))

INSERT INTO federativos VALUES

INSERT INTO asistentes VALUES

INSERT INTO sedes VALUES
('Mineirão','Belo Horizonte',58259),
('Mané Garrincha','Brasilia',70807),
('Pantanal','Cuiabá',39859),
('Da Baixada','Curitiba',38533),
('Castelão','Fortaleza',60348),
('Das Dunas','Natal',39971),
('Pernambuco','Recife',46154),
('Maracanã','Río de Janeiro',76525),
('Fonte Nova','Salvador',51708),
('Corinthians','São Paulo',65281),
('Beira-Rio','Porto Alegre',43394),
('Da Amazônia','Manaos',40549)



--###################################################################################
--###################################################################################
--###################################################################################

--Creo procesos 2

--Creo funciones 2

--Creo triggers 2

--Creo transacciones (usando commit rollback) 2

--Creo vistas 2

--Creo índices 2



