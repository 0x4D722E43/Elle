INSERT INTO `registrazionevotidb`.`facolta` (`ID`, `FACOLTA`) VALUES ('1', 'Ingegneria');
INSERT INTO `registrazionevotidb`.`facolta` (`ID`, `FACOLTA`) VALUES ('2', 'Economia');

INSERT INTO `registrazionevotidb`.`corsi_di_laurea` (`ID`, `NOME`, `FACOLTA`) VALUES ('1', 'Ingegneria Elettronica e Informatica', '1');
INSERT INTO `registrazionevotidb`.`corsi_di_laurea` (`ID`, `NOME`, `FACOLTA`) VALUES ('2', 'Bioingegneria', '1');
INSERT INTO `registrazionevotidb`.`corsi_di_laurea` (`ID`, `NOME`, `FACOLTA`) VALUES ('3', 'Ingegneria civile e ambientale', '1');
INSERT INTO `registrazionevotidb`.`corsi_di_laurea` (`ID`, `NOME`, `FACOLTA`) VALUES ('4', 'Ingegneria industriale', '1');
INSERT INTO `registrazionevotidb`.`corsi_di_laurea` (`ID`, `NOME`, `FACOLTA`) VALUES ('5', 'Ingegneria edile-architettura ', '1');

INSERT INTO `registrazionevotidb`.`corsi_di_laurea` (`ID`, `NOME`, `FACOLTA`) VALUES ('6', 'Amministrazione, controllo e finanza aziendale', '2');
INSERT INTO `registrazionevotidb`.`corsi_di_laurea` (`ID`, `NOME`, `FACOLTA`) VALUES ('7', 'Economia', '2');
INSERT INTO `registrazionevotidb`.`corsi_di_laurea` (`ID`, `NOME`, `FACOLTA`) VALUES ('8', 'Management', '2');

INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('PROFESSORE', '1', 'albert.einstein@unipv.it', 'Albert', '5f4dcc3b5aa765d61d8327deb882cf99', 'Einstein');
INSERT INTO `registrazionevotidb`.`professori` (`ORE_RICEVIMENTO`, `POSIZIONE_UFFICIO`, `ID`, `FACOLTA`) VALUES ('14 - 16 Martedì', 'Piano C', '1', '1');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('PROFESSORE', '2', 'thomas.edison@unipv.it', 'Thomas', '5f4dcc3b5aa765d61d8327deb882cf99', 'Edison');
INSERT INTO `registrazionevotidb`.`professori` (`ORE_RICEVIMENTO`, `POSIZIONE_UFFICIO`, `ID`, `FACOLTA`) VALUES ('9 - 11 Mercoledì', 'Piano C', '2', '1');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('PROFESSORE', '3', 'george.boole@unipv.it', 'George', '5f4dcc3b5aa765d61d8327deb882cf99', 'Boole');
INSERT INTO `registrazionevotidb`.`professori` (`ORE_RICEVIMENTO`, `POSIZIONE_UFFICIO`, `ID`, `FACOLTA`) VALUES ('Su prenotazione', 'Piano E', '3', '1');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('PROFESSORE', '4', 'john.nash@unipv.it', 'John', '5f4dcc3b5aa765d61d8327deb882cf99', 'Nash');
INSERT INTO `registrazionevotidb`.`professori` (`ORE_RICEVIMENTO`, `ID`, `FACOLTA`) VALUES ('16 - 18 Venerdì', '4', '2');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('STUDENTE', '5', 'alessandro.delpiero01@universitadipavia.it', 'Alessandro', '5f4dcc3b5aa765d61d8327deb882cf99', 'Del Piero');
INSERT INTO `registrazionevotidb`.`studenti` (`MATRICOLA`, `ID`, `CORSO_DI_LAUREA`) VALUES ('412345', '5', '1');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('STUDENTE', '6', 'francesco.totti01@universitadipavia.it', 'Francesco', '5f4dcc3b5aa765d61d8327deb882cf99', 'Totti');
INSERT INTO `registrazionevotidb`.`studenti` (`MATRICOLA`, `ID`, `CORSO_DI_LAUREA`) VALUES ('416754', '6', '1');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('STUDENTE', '7', 'filippo.inzaghi01@universitadipavia.it', 'Filippo', '5f4dcc3b5aa765d61d8327deb882cf99', 'Inzaghi');
INSERT INTO `registrazionevotidb`.`studenti` (`MATRICOLA`, `ID`, `CORSO_DI_LAUREA`) VALUES ('456789', '7', '1');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('STUDENTE', '8', 'gianluca.vialli01@universitadipavia.it', 'Gianluca', '5f4dcc3b5aa765d61d8327deb882cf99', 'Vialli');
INSERT INTO `registrazionevotidb`.`studenti` (`MATRICOLA`, `ID`, `CORSO_DI_LAUREA`) VALUES ('422390', '8', '1');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('STUDENTE', '9', 'bobo.vieri01@universitadipavia.it', 'Bobo', '5f4dcc3b5aa765d61d8327deb882cf99', 'Vieri');
INSERT INTO `registrazionevotidb`.`studenti` (`MATRICOLA`, `ID`, `CORSO_DI_LAUREA`) VALUES ('516754', '9', '1');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('STUDENTE', '10', 'dino.zoff01@universitadipavia.it', 'Dino', '5f4dcc3b5aa765d61d8327deb882cf99', 'Zoff');
INSERT INTO `registrazionevotidb`.`studenti` (`MATRICOLA`, `ID`, `CORSO_DI_LAUREA`) VALUES ('483589', '10', '1');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('STUDENTE', '11', 'gianluigi.buffon01@universitadipavia.it', 'Gianluigi', '5f4dcc3b5aa765d61d8327deb882cf99', 'Buffon');
INSERT INTO `registrazionevotidb`.`studenti` (`MATRICOLA`, `ID`, `CORSO_DI_LAUREA`) VALUES ('511145', '11', '1');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('STUDENTE', '12', 'ivan.zamorano01@universitadipavia.it', 'Ivan', '5f4dcc3b5aa765d61d8327deb882cf99', 'Zamorano');
INSERT INTO `registrazionevotidb`.`studenti` (`MATRICOLA`, `ID`, `CORSO_DI_LAUREA`) VALUES ('345234', '12', '1');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('STUDENTE', '13', 'javier.zanetti01@universitadipavia.it', 'Javier', '5f4dcc3b5aa765d61d8327deb882cf99', 'Zanetti');
INSERT INTO `registrazionevotidb`.`studenti` (`MATRICOLA`, `ID`, `CORSO_DI_LAUREA`) VALUES ('564231', '13', '1');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('STUDENTE', '14', 'gianluca.zambrotta01@universitadipavia.it', 'Gianluca', '5f4dcc3b5aa765d61d8327deb882cf99', 'Zambrotta');
INSERT INTO `registrazionevotidb`.`studenti` (`MATRICOLA`, `ID`, `CORSO_DI_LAUREA`) VALUES ('419890', '14', '1');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('STUDENTE', '15', 'francesco.toldo01@universitadipavia.it', 'Francesco', '5f4dcc3b5aa765d61d8327deb882cf99', 'Toldo');
INSERT INTO `registrazionevotidb`.`studenti` (`MATRICOLA`, `ID`, `CORSO_DI_LAUREA`) VALUES ('423765', '15', '1');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('STUDENTE', '16', 'fabio.cannavaro01@universitadipavia.it', 'Fabio', '5f4dcc3b5aa765d61d8327deb882cf99', 'Cannavaro');
INSERT INTO `registrazionevotidb`.`studenti` (`MATRICOLA`, `ID`, `CORSO_DI_LAUREA`) VALUES ('445689', '16', '1');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('STUDENTE', '17', 'vincenzo.iaquinta01@universitadipavia.it', 'Vincenzo', '5f4dcc3b5aa765d61d8327deb882cf99', 'Iaquinta');
INSERT INTO `registrazionevotidb`.`studenti` (`MATRICOLA`, `ID`, `CORSO_DI_LAUREA`) VALUES ('423578', '17', '1');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('STUDENTE', '18', 'zinedine.zidane01@universitadipavia.it', 'Zinedine', '5f4dcc3b5aa765d61d8327deb882cf99', 'Zidane');
INSERT INTO `registrazionevotidb`.`studenti` (`MATRICOLA`, `ID`, `CORSO_DI_LAUREA`) VALUES ('501987', '18', '1');
INSERT INTO `registrazionevotidb`.`utenti` (`RUOLO`, `ID`, `EMAIL`, `NOME`, `PASSWORD`, `COGNOME`) VALUES ('STUDENTE', '19', 'gianluca.pagliuca01@universitadipavia.it', 'Gianluca', '5f4dcc3b5aa765d61d8327deb882cf99', 'Pagliuca');
INSERT INTO `registrazionevotidb`.`studenti` (`MATRICOLA`, `ID`, `CORSO_DI_LAUREA`) VALUES ('401987', '19', '1');

INSERT INTO `registrazionevotidb`.`corsi` (`ID`, `CFU`, `NOME`, `CORSO_DI_LAUREA`, `PROFESSORE`) VALUES ('1', '9', 'Analisi I', '1', '1');
INSERT INTO `registrazionevotidb`.`corsi` (`ID`, `CFU`, `NOME`, `CORSO_DI_LAUREA`, `PROFESSORE`) VALUES ('2', '9', 'Analisi II', '1', '3');
INSERT INTO `registrazionevotidb`.`corsi` (`ID`, `CFU`, `NOME`, `CORSO_DI_LAUREA`, `PROFESSORE`) VALUES ('3', '9', 'Fisica I', '1', '1');
INSERT INTO `registrazionevotidb`.`corsi` (`ID`, `CFU`, `NOME`, `CORSO_DI_LAUREA`, `PROFESSORE`) VALUES ('4', '9', 'Fisica II', '1', '2');
INSERT INTO `registrazionevotidb`.`corsi` (`ID`, `CFU`, `NOME`, `CORSO_DI_LAUREA`, `PROFESSORE`) VALUES ('5', '6', 'Algebra e Geometria', '1', '1');
INSERT INTO `registrazionevotidb`.`corsi` (`ID`, `CFU`, `NOME`, `CORSO_DI_LAUREA`, `PROFESSORE`) VALUES ('6', '6', 'Economia', '1', '4');
INSERT INTO `registrazionevotidb`.`corsi` (`ID`, `CFU`, `NOME`, `CORSO_DI_LAUREA`, `PROFESSORE`) VALUES ('7', '9', 'Campi e Circuiti I', '1', '2');
INSERT INTO `registrazionevotidb`.`corsi` (`ID`, `CFU`, `NOME`, `CORSO_DI_LAUREA`, `PROFESSORE`) VALUES ('8', '12', 'Campi e Circuiti II', '1', '2');
INSERT INTO `registrazionevotidb`.`corsi` (`ID`, `CFU`, `NOME`, `CORSO_DI_LAUREA`, `PROFESSORE`) VALUES ('9', '12', 'Fondamenti di informatica', '1', '3');

INSERT INTO `registrazionevotidb`.`iscrizioni_corsi` (`ID`, `SUPERATO`, `CORSO`, `STUDENTE`) VALUES ('1', b'0', '1', '5');
INSERT INTO `registrazionevotidb`.`iscrizioni_corsi` (`ID`, `SUPERATO`, `CORSO`, `STUDENTE`) VALUES ('2', b'0', '1', '6');
INSERT INTO `registrazionevotidb`.`iscrizioni_corsi` (`ID`, `SUPERATO`, `CORSO`, `STUDENTE`) VALUES ('3', b'0', '1', '7');
INSERT INTO `registrazionevotidb`.`iscrizioni_corsi` (`ID`, `SUPERATO`, `CORSO`, `STUDENTE`) VALUES ('4', b'0', '1', '8');
INSERT INTO `registrazionevotidb`.`iscrizioni_corsi` (`ID`, `SUPERATO`, `CORSO`, `STUDENTE`) VALUES ('5', b'0', '1', '9');
INSERT INTO `registrazionevotidb`.`iscrizioni_corsi` (`ID`, `SUPERATO`, `CORSO`, `STUDENTE`) VALUES ('6', b'0', '1', '10');

INSERT INTO `registrazionevotidb`.`iscrizioni_corsi` (`ID`, `SUPERATO`, `CORSO`, `STUDENTE`) VALUES ('7', b'0', '1', '11');
INSERT INTO `registrazionevotidb`.`iscrizioni_corsi` (`ID`, `SUPERATO`, `CORSO`, `STUDENTE`) VALUES ('8', b'0', '1', '12');
INSERT INTO `registrazionevotidb`.`iscrizioni_corsi` (`ID`, `SUPERATO`, `CORSO`, `STUDENTE`) VALUES ('9', b'0', '1', '13');
INSERT INTO `registrazionevotidb`.`iscrizioni_corsi` (`ID`, `SUPERATO`, `CORSO`, `STUDENTE`) VALUES ('10', b'0', '1', '14');
INSERT INTO `registrazionevotidb`.`iscrizioni_corsi` (`ID`, `SUPERATO`, `CORSO`, `STUDENTE`) VALUES ('11', b'0', '1', '15');

INSERT INTO `registrazionevotidb`.`esami` (`ID`, `DATA_APPELLO`, `DESCRIZIONE`, `ISCRIZIONI_APERTE`, `AULA`, `CORSO`) VALUES ('1', '2017-01-19 09:00:00', 'Prova scritta', FALSE, 'EF4', '1');
INSERT INTO `registrazionevotidb`.`esami` (`ID`, `DATA_APPELLO`, `DESCRIZIONE`, `ISCRIZIONI_APERTE`, `AULA`, `CORSO`) VALUES ('2', '2017-02-20 09:00:00', 'Prova scritta', TRUE, 'EF2', '1');

INSERT INTO `registrazionevotidb`.`esiti` (`ID`, `VOTO`, `STATUS`, `APPELLO`, `STUDENTE`) VALUES ('1', '18', 'PASSED_PENDING', '1', '5');
INSERT INTO `registrazionevotidb`.`esiti` (`ID`, `VOTO`, `STATUS`, `APPELLO`, `STUDENTE`) VALUES ('2', '27', 'PASSED_PENDING', '1', '6');
INSERT INTO `registrazionevotidb`.`esiti` (`ID`, `VOTO`, `STATUS`, `APPELLO`, `STUDENTE`) VALUES ('3', '15', 'FAILED_PENDING', '1', '7');
INSERT INTO `registrazionevotidb`.`esiti` (`ID`, `VOTO`, `STATUS`, `APPELLO`, `STUDENTE`) VALUES ('4', '21', 'PASSED_PENDING', '1', '8');
INSERT INTO `registrazionevotidb`.`esiti` (`ID`, `VOTO`, `STATUS`, `APPELLO`, `STUDENTE`) VALUES ('5', '30', 'PASSED_PENDING', '1', '9');
INSERT INTO `registrazionevotidb`.`esiti` (`ID`, `VOTO`, `STATUS`, `APPELLO`, `STUDENTE`) VALUES ('6', '28', 'PASSED_PENDING', '1', '10');

INSERT INTO `registrazionevotidb`.`esiti` (`ID`, `STATUS`, `APPELLO`, `STUDENTE`) VALUES ('7', 'BOOKED', '2', '11');
INSERT INTO `registrazionevotidb`.`esiti` (`ID`, `STATUS`, `APPELLO`, `STUDENTE`) VALUES ('8', 'BOOKED', '2', '12');
INSERT INTO `registrazionevotidb`.`esiti` (`ID`, `STATUS`, `APPELLO`, `STUDENTE`) VALUES ('9', 'BOOKED', '2', '13');
INSERT INTO `registrazionevotidb`.`esiti` (`ID`, `STATUS`, `APPELLO`, `STUDENTE`) VALUES ('10', 'BOOKED', '2', '14');
INSERT INTO `registrazionevotidb`.`esiti` (`ID`, `STATUS`, `APPELLO`, `STUDENTE`) VALUES ('11', 'BOOKED', '2', '15');

