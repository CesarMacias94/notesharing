-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema notesharingdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema notesharingdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `notesharingdb` DEFAULT CHARACTER SET utf8 ;
USE `notesharingdb` ;

-- -----------------------------------------------------
-- Table `notesharingdb`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `notesharingdb`.`course` (
  `cod_course` INT(11) NOT NULL AUTO_INCREMENT,
  `description` LONGTEXT NULL DEFAULT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`cod_course`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `notesharingdb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `notesharingdb`.`user` (
  `cod_user` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `surname` VARCHAR(45) NULL DEFAULT NULL,
  `date_of_birth` DATETIME NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cod_user`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `notesharingdb`.`note`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `notesharingdb`.`note` (
  `cod_note` INT(11) NOT NULL AUTO_INCREMENT,
  `text` LONGTEXT NULL DEFAULT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `cod_course` INT(11) NOT NULL,
  `cod_user` INT(11) NOT NULL,
  PRIMARY KEY (`cod_note`),
  INDEX `cod_course_idx` (`cod_course` ASC),
  INDEX `cod_user_idx` (`cod_user` ASC),
  CONSTRAINT `cod_course`
    FOREIGN KEY (`cod_course`)
    REFERENCES `notesharingdb`.`course` (`cod_course`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cod_user`
    FOREIGN KEY (`cod_user`)
    REFERENCES `notesharingdb`.`user` (`cod_user`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Insert Data in `notesharingdb`
-- -----------------------------------------------------
INSERT INTO `notesharingdb`.`note` VALUES (1,'Il Model-View-Controller (MVC, talvolta tradotto in italiano con la dicitura Modello-Vista-Controllo), in informatica, è un pattern architetturale molto diffuso nello sviluppo di sistemi software, in particolare nell\'ambito della programmazione orientata agli oggetti, in grado di separare la logica di presentazione dei dati dalla logica di business. Questo pattern si posiziona nel livello di presentazione in una Architettura multi-tier. Componenti: Il componente centrale del MVC, il modello, cattura il comportamento dell\'applicazione in termini di dominio del problema, indipendentemente dall\'interfaccia utente. Il modello gestisce direttamente i dati, la logica e le regole dell\'applicazione. Una vista può essere una qualsiasi rappresentazione in output di informazioni, come un grafico o un diagramma. Sono possibili viste multiple delle stesse informazioni, come ad esempio un grafico a barre per la gestione e la vista tabellare per l\'amministrazione. La terza parte, il controller, accetta l\'input e lo converte in comandi per il modello e/o la vista. Utilizzo: Storicamente il pattern MVC è stato implementato lato server. Recentemente, con lo sviluppo e la parziale standardizzazione di JavaScript sono nate le prime implementazioni lato client. Lato server: Originariamente impiegato dal linguaggio Smalltalk, il pattern è stato esplicitamente o implicitamente sposato da numerose tecnologie moderne, come framework basati su PHP (Symfony, Laravel, Zend Framework, CakePHP, Yii framework, CodeIgniter), su Ruby (Ruby on Rails), su Python (Django, TurboGears, Pylons, Web2py, Zope), su Java (Spring, JSF e Struts), su Objective C o su .NET. A causa della crescente diffusione di tecnologie basate su MVC nel contesto di framework o piattaforma middleware per applicazioni Web, l\'espressione framework MVC o sistema MVC sta entrando nell\'uso anche per indicare specificamente questa categoria di sistemi (che comprende per esempio Ruby on Rails, Struts, Spring, Tapestry e Catalyst). Lato client: Negli ultimi anni è aumentata la richiesta di Rich Internet application che facciano chiamate asincrone al server (AJAX), senza fare redirect per visualizzare i risultati delle elaborazioni. Col crescere della quantità di codice JavaScript eseguito sul client, si è sentita l\'esigenza di creare i primi framework che implementassero MVC in puro JavaScript. Uno dei primi è stato Backbone.js, seguito da una serie interminabile di altri framework, tra cui JavascriptMVC, Ember ed AngularJS. Struttura: Il pattern è basato sulla separazione dei compiti fra i componenti software che interpretano tre ruoli principali: il model fornisce i metodi per accedere ai dati utili all\'applicazione; il view visualizza i dati contenuti nel model e si occupa dell\'interazione con utenti e agenti; il controller riceve i comandi dell\'utente (in genere attraverso il view) e li attua modificando lo stato degli altri due componenti. Questo schema, fra l\'altro, implica anche la tradizionale separazione fra la logica applicativa (in questo contesto spesso chiamata \"logica di business\"), a carico del controller e del model, e l\'interfaccia utente a carico del view. I dettagli delle interazioni fra questi tre oggetti software dipendono molto dalle tecnologie usate (linguaggio di programmazione, eventuali librerie, middleware e via dicendo) e dal tipo di applicazione (per esempio se si tratta di un\'applicazione web, o di un\'applicazione desktop). Quasi sempre la relazione fra view e model è descrivibile anche come istanza del pattern Observer. A volte, quando è necessario cambiare il comportamento standard dell\'applicazione a seconda delle circostanze, il controller implementa anche il pattern Strategy. ','MVC',1,1);

INSERT INTO `notesharingdb`.`course` VALUES (1,'Il corso presenta metodi, tecniche e tecnologie per la gestione di progetti complessi. Il corso si compone di tre parti: La prima parte è dedicata ai processi di sviluppo agili, alla stima dei costi e all’analisi dei rischi. La seconda parte è dedicata all’analisi e alla specifica dei requisiti. La terza parte è dedicata al progetto e sviluppo di applicazioni usando framework Java di ultima generazione e tecnologia J2EE.','Processo E Sviluppo Del Software'),(2,'Rappresenta un insieme di metodi sviluppati a partire dagli ultimi decenni del \'900 in varie comunità scientifiche con diversi nomi come: statistica computazionale, riconoscimento di pattern, reti neurali artificiali, filtraggio adattivo, teoria dei sistemi dinamici, elaborazione delle immagini, data mining, algoritmi adattivi, ecc; che \"fornisce ai computer l\'abilità di apprendere senza essere stati esplicitamente programmati\". ','Machine Learning'),(3,'Termine adoperato per descrivere l\'insieme delle tecnologie e delle metodologie di analisi di dati massivi, e non. Il termine indica la capacità di estrapolare, analizzare e mettere in relazione un\'enorme mole di dati eterogenei, strutturati e non strutturati, per scoprire i legami tra fenomeni diversi e prevedere quelli futuri. ','Data Technology'),(4,'Introduce tecniche e metodi per specificare, modellare e analizzare sistemi concorrenti, cioè sistemi formati da più componenti che operano in parallelo e interagiscono fra di loro. La prima parte del corso introduce una tecnica, basata sulla logica di Hoare, per dimostrare la correttezza di programmi sequenziali; in seguito, si presentano due famiglie di modelli formali di sistemi concorrenti: il CCS (Calculus of Concurrent Systems) e le reti di Petri. Si presentano poi diverse logiche temporali, fra le quali LTL e CTL, come strumenti per specificare proprietà dei sistemi concorrenti, e alcuni algoritmi per verificare se un sistema dato soddisfa una proprietà.','Modelli Della Concorrenza'),(5,'La teoria della computazione è quella branca della matematica che si preoccupa di definire quali proprietà possiede uno specifico linguaggio formale. Le principali proprietà ricercate da un linguaggio formale sono: La correttezza, la completezza e la terminazione. Non tutte le proprietà sono necessarie: spesso i linguaggi formali hanno solo la prima e la seconda proprietà. In alcune applicazioni ci si accontenta di avere anche solo la prima proprietà che chiaramente è irrinunciabile: senza la prima proprietà si potrebbero avere enunciati chiaramente falsi ma che vengono dichiarati veri dal linguaggio formale, generando contraddizioni. Nel caso si abbiano tutte le tre proprietà è conveniente cercare di definire la complessità degli algoritmi definiti del linguaggio formale. La complessità è una funzione che stima il numero di passi necessari ad eseguire uno specifico algoritmo. ','Teoria Della Computazione');

INSERT INTO `notesharingdb`.`user` VALUES (1,'John','Doe','1993-06-05 00:00:00','john.doe@gmail.com','JD','notesharing');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;