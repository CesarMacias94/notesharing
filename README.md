# Notesharing

## Requisiti
* XAMPP v3.2.2
* Node.js v6.9.5
* Apache Tomcat v9.0.0.M17
* MySQL Workbench v5.7
	
## Configurazione
Mettere il war dentro webb app, il front-end in htdocs e far partire lo screen su mysql dopo aver creato l'utenza, magari ci butto qualche immagine.


## Note
L'applicativo è stato realizzando secondo una architettura three-tier per dare maggiore scalabilità all'applicazione, in modo da poter modificare i diversi moduli in modo indipendente.
L'interfaccia utente è stata realizzata usando il framework AngularJS, insieme a Firebase che è servito a gestire l'autenticazione degli utenti.
La bussiness logic è stata realizzata usando Spring ed Hibernate, mentre i dati sono stati gestiti usando MySQL come DBMS.

