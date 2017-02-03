# Progetto Elle

RegistrazioneVoti è un progetto che mira alla realizzazione di una Applicazione Web fruibile da studenti e professori dell’Università di Pavia, che permetta in modo semplice l'iscrizione agli esami e la registrazione dei voti. 

Nella Wiki viene esposto il Development Case che contiene la documentazione prodotta in fase di sviluppo del progetto.

L'applicazione implementa i casi d'uso presentati nella wiki e si trova nella fase finale di verifca e convalida.

#### Note per l'esecuzione del progetto

1. Per lanciare l'applicazione è necessario utilizzare Netbeans configurato con un web server Tomcat 8.5 e Maven come build manager
2. L'applicazione utilizza un database MYQSL remoto localizzato sui server di https://www.freemysqlhosting.net/ . Per poter accedervi bisogna assicurarsi di avere la porte necessaria per la connessione (3306) non bloccata dal firewall
3. Il MailService che si dovrebbe occupare dell'invio delle mail (come per esempio la mail contente la prima password per l'accesso) è implementato utilizzando un MockMailService che stampa l'ipotetico messaggio contenuto nel Logger dell'applicazione. 

More info per testare l'applicazione [qui](https://github.com/claudio-unipv/Progetto-L/wiki/Testing)
