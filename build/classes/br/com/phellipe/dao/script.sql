DROP DATABASE seguros2;
create database seguros2;
use seguros2;

CREATE TABLE segurados (
	id_segurado INT PRIMARY KEY AUTO_INCREMENT,
	nome varchar (50) not null,
	rg varchar (9) not null,
	cpf varchar(11) not null,
	sexo varchar (10) not null,
	tipoSegurado varchar (255) not null,
	dataNascimento date not null,
	dataAlteracao timestamp not null,
	dataCadastro timestamp not null
);

CREATE TABLE seguros (
	id_seguro int PRIMARY KEY AUTO_INCREMENT,
	nomeSeguro varchar(50) not null,
	valorSeguro decimal(19,2) not null
);

CREATE TABLE diasvisita (
	id_dia INT PRIMARY KEY AUTO_INCREMENT,
	nomeDia varchar(50) not null
);

CREATE TABLE `segurados_seguros` (
  `segurado` int NOT NULL,
  `seguro` int NOT NULL,
  KEY `seguroxsegurado` (`seguro`),
  KEY `seguradoxseguro` (`segurado`),
  CONSTRAINT `seguradoxseguro` FOREIGN KEY (`segurado`) REFERENCES `segurados` (`id_segurado`),
  CONSTRAINT `seguroxsegurado` FOREIGN KEY (`seguro`) REFERENCES `seguros` (`id_seguro`)
);

CREATE TABLE `segurados_diasvisita` (
  `id_segurado` int(11) NOT NULL,
  `id_dia` int(11) NOT NULL,
  KEY `diaxsegurado` (`id_dia`),
  KEY `seguradoxdia` (`id_segurado`),
  CONSTRAINT `seguradoxdia` FOREIGN KEY (`id_segurado`) REFERENCES `segurados` (`id_segurado`),
  CONSTRAINT `diaxsegurado` FOREIGN KEY (`id_dia`) REFERENCES `diasvisita` (`id_dia`)
);


CREATE TABLE `usuarios` (
	id_usuario INT PRIMARY KEY AUTO_INCREMENT,
	username varchar(50) not null unique,
	password varchar(25) not null
);

insert into usuarios values (null, "admin", "123");
insert into diasvisita values (null, "segunda");
insert into diasvisita values (null, "terca");
insert into diasvisita values (null, "quarta");
insert into diasvisita values (null, "quinta");
insert into diasvisita values (null, "sexta");

insert into seguros values (null, "bradesco", "1000");
insert into seguros values (null, "sulamerica", "500");






