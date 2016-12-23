DROP DATABASE IF EXISTS `bankwebdb`;

CREATE DATABASE IF NOT EXISTS `bankwebdb`;

USE `bankwebdb`;

CREATE TABLE IF NOT EXISTS `tblusers` (
  `userid` INT(11) NOT NULL AUTO_INCREMENT,
  `ufname` VARCHAR(25) NOT NULL,
  `ulname` VARCHAR(25) NOT NULL,
  `uemail` VARCHAR(25) NOT NULL,
  `ugender` VARCHAR(10) NOT NULL,
  `udob` DATE NOT NULL,
  `uaddress1` VARCHAR(25) NOT NULL,
  `uphone` VARCHAR(12) NOT NULL,
  `upass` VARCHAR(25) NOT NULL,
  `ucreatedOn` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT `tblusersPK` PRIMARY KEY(`userid`)
);

INSERT INTO `tblusers` 
(`ufname`,`ulname`,`uemail`,`ugender`,`udob`,`upass`,`uphone`,`uaddress1`)
VALUES 
('Arun','Singh','arunsingpra2@yahoo.com','Male','1989-03-05','arun123','8097816244','Seawoods Darave');

INSERT INTO `tblusers` 
(`ufname`,`ulname`,`uemail`,`ugender`,`udob`,`upass`,`uphone`,`uaddress1`)
VALUES 
('Bhupesh','Sahu','bhupeshsahu1991@gmail.com','Male','1991-09-16','bhupesh456','7208645667','KoperKhairane');

INSERT INTO `tblusers` 
(`ufname`,`ulname`,`uemail`,`ugender`,`udob`,`upass`,`uphone`,`uaddress1`)
VALUES 
('Manoj','Chavan','manojchavan.22@gmail.com','Male','1989-11-11','manoj789','9004320525','Mankhurd');

INSERT INTO `tblusers` 
(`ufname`,`ulname`,`uemail`,`ugender`,`udob`,`upass`,`uphone`,`uaddress1`)
VALUES 
('Sreerag','S','friendsofsree@yahoo.com','Male','1989-04-19','srees','8976289639','KoperKhairane');

CREATE TABLE IF NOT EXISTS `tblaccounts` (
  `accountId` INT(11) NOT NULL AUTO_INCREMENT,
  `auser` INT(11) NOT NULL,
  `aType` VARCHAR(9) NOT NULL DEFAULT 'SAVINGS',
  `balance` DECIMAL(9,2) NOT NULL DEFAULT '0000000.00',
  `acreatedOn` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` TINYINT NOT NULL DEFAULT '1',
  CONSTRAINT `tblaccountsFK1` FOREIGN KEY (`auser`) REFERENCES `tblusers`(`userid`),
  CONSTRAINT `tblaccountsPK` PRIMARY KEY(`accountId`)
);

INSERT INTO `tblaccounts` (`auser`,`balance`) VALUES (1,'5000.00');
INSERT INTO `tblaccounts` (`auser`,`balance`) VALUES (2,'5000.00');
INSERT INTO `tblaccounts` (`auser`,`balance`) VALUES (3,'5000.00');
INSERT INTO `tblaccounts` (`auser`,`balance`) VALUES (4,'5000.00');


CREATE TABLE IF NOT EXISTS `tbltransfers` (
  `transferid` INT(11) NOT NULL AUTO_INCREMENT,
  `tFromAcc` INT(11) NOT NULL,
  `toAcc` INT(11) NOT NULL,
  `tamount` DECIMAL(9,2) NOT NULL, 
  `transferDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT `tbltransfersFK1` FOREIGN KEY (`tFromAcc`) REFERENCES `tblaccounts`(`accountId`),
  CONSTRAINT `tbltransfersFK2` FOREIGN KEY (`toAcc`) REFERENCES `tblaccounts`(`accountId`),
  CONSTRAINT `tbltransfersPK` PRIMARY KEY(`transferid`)
);
