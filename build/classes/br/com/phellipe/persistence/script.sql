create database seguros2;
use seguros2;

CREATE TABLE segurados (
	id_segurado INT PRIMARY KEY AUTO_INCREMENT,
	cpf varchar(11) not null,
	dataAlteracao date not null,
	dataCadastro date not null,
	diasVisita varchar(255) not null,
	nome varchar (50) not null,
	rg varchar (9) not null,
	sexo varchar (10) not null,
	tipoSegurado varchar (255) not null
);

CREATE TABLE seguros (
	id_seguro INT PRIMARY KEY AUTO_INCREMENT,
	nomeSeguro varchar(50) not null,
	valorSeguro decimal(19,2) not null
);

CREATE TABLE `segurados_seguros` (
  `id_segurado` int(11) NOT NULL,
  `id_seguro` int(11) NOT NULL,
  KEY `seguroxsegurado` (`id_seguro`),
  KEY `seguradoxseguro` (`id_segurado`),
  CONSTRAINT `seguradoxseguro` FOREIGN KEY (`id_segurado`) REFERENCES `segurados` (`id_segurado`),
  CONSTRAINT `seguroxsegurado` FOREIGN KEY (`id_seguro`) REFERENCES `seguros` (`id_seguro`)
);


CREATE TABLE `usuarios` (
	id_usuario INT PRIMARY KEY AUTO_INCREMENT,
	username varchar(50) not null unique,
	password varchar(25) not null
);

insert into usuarios values (null, "admin", "123");






