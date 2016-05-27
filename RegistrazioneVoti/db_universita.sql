create database db_universita;

use db_universita;

create table Corso
(
	id int auto_increment primary key,
    codCorso varchar(10),
    nome varchar(60),
    cfu int,
    professore int
);

create table Appello
(
	id int auto_increment primary key,
    codAppello varchar(10),
    descrizione varchar(45),
    dataAppello datetime,
    aula varchar(5),
	corso int,
    foreign key (corso) references Corso(id)
)
	engine=InnoDB;
    
    
create table User
(
	codFiscale varchar(16) primary key,
    nome varchar(45),
    pw varchar(10)
);



create table Studente
(
	id int auto_increment primary key,
    user varchar(16),
    foreign key (user) references User(codFiscale)
)
	engine=InnoDB;



create table Professore
(
	id int auto_increment primary key,
    user varchar(16),
    foreign key (user) references User(codFiscale)
)
	engine=InnoDB;
    

create table Cattedra
(
	id int auto_increment primary key,
    professore int,
    corso int,
    foreign key (professore) references Professore(id),
    foreign key (corso) references Corso(id)
)
	engine=InnoDB;
    
create table Esame
(
	id int auto_increment primary key,
    studente int,
    appello int,
    voto int,
    foreign key (studente) references Studente(id),
    foreign key (appello) references Appello(id)
)
	engine=InnoDB;

    
    
    
    