# Notesharing

## Requisiti
* XAMPP v3.2.2
* Node.js v6.9.5
* Apache Tomcat v9.0.0.M17
* MySQL Workbench v5.7
	
## Configurazione

### Front End

Dopo aver creato la cartella "notesharing" al percorso: 

	C:\xampp\htdocs
	
Copiare l'intero contenuto della cartella "frontend" all'interno di questa cartella, poi da linea di comando eseguire il comando

	npm install
	
### Backend

Copiare il file "notesharing.war" all'interno della cartella apache: 

	C:\apache-tomcat-9.0.0.M17\webapps
	
Avviare il tomcat da linea di comando eseguendo il comando "startup.bat" all'interno della cartella

	C:\apache-tomcat-9.0.0.M17\bin
	
### DB

Dopo aver create il seguente utente: 

	username = "notesharingDB"
	password = "Notesharing.db"

Runnare lo script "notesharing_script.sql"

	File -> Run SQL Script..
	
## Test

Per testare l'aplicativo, dopo aver lanciato XAMPP ed aver verificato che sia Apache, Tomcat ed il server MySQL siano attivi, andare al seguente indirizzo:

	http://localhost/notesharing/#!/home
	
Un utente è già stato registrato nel caso si voglia provare l'applicativo senza registrarsi:

	username = "JD"
	password = "notesharing"

## Note
Notesharing consente di aggiungere delle note inerenti ad alcuni corsi/materie e di visualizzare quelli degli altri utenti.

L'applicativo è stato realizzando secondo una architettura three-tier per dare maggiore scalabilità all'applicazione, in modo da poter modificare i diversi moduli in modo indipendente.
L'interfaccia utente è stata realizzata usando il framework AngularJS, insieme a Firebase che è servito a gestire l'autenticazione degli utenti, mentre le sessioni sono state gestite dal'oggetto JavaScript "$window.localStorage".
La bussiness logic è stata realizzata usando Spring ed Hibernate, mentre i dati sono stati gestiti usando MySQL come DBMS.

Per diversi problemi di tempistiche alcune funzioni non sono state implementate, come la modifica e l'eliminazione dei dati. Nonostante ciò, simili funzioni non richiederebbero un ridisegno dell'architettura del codice, ma sarebbero facilmente implementabili.
Anche la configurazione sarebbe dovuta essere differente, potendo implementarla all'interno di una macchina virtuale consentendo così una maggiore semplicità nel testare l'applicativo, ciò però non è stato possibile per i motivi sopracitati.

**Ps:** *Si consiglia di testare l'applicativo su Chrome, poichè in altri browser, sopratutto su Firefox, potrebbe avere dei problemi nella lettura degli stili e quindi dal punto di vista grafico.*
