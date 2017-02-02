# Progetto Elle

RegistrazioneVoti è un progetto che mira alla realizzazione di una Applicazione Web fruibile da studenti e professori dell’Università di Pavia, che permetta in modo semplice l'iscrizione agli esami e la registrazione dei voti. Nella Wiki viene esposto il Development Case che contiene la documentazione prodotta in fase di sviluppo del progetto.

L'applicazione implenta implementa i casi d'uso presentati nella wiki. Attualmente si trova nella fase finale di test.

_Da notare_: il MailService che si dovrebbe occupare dell'invio delle mail con la prima password per l'acesso è implementanto utilizzando una MockService che stampa l'ipotetico messaggio contenuto nella mail nel Logger dell'applicazione. 

#### Eseguire il progetto

1. Per lanciare l'applicazione è necessario utilizzare Netbeans configurato con un web server Tomcat 8.5 e Maven come build manager
2. L'applicazione utilizza un database MYQSL remoto localizzato sui server di https://www.freemysqlhosting.net/ . Per poter accedervi bisogna assicurarsi di avere la porte necessaria per la connessione (3306) non bloccata dal firewall

