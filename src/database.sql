CREATE TABLE currency ( idcurrency int (10), currencybuyrate double NOT NULL, currencysellrate double NOT NULL, currencyname varchar (20) NOT NULL, PRIMARY KEY (idcurrency) ); 

INSERT INTO `currency` (`idcurrency`,`currencybuyrate`,`currencysellrate`,`currencyname`) VALUES (1,1,1,'UAH');
INSERT INTO `currency` (`idcurrency`,`currencybuyrate`,`currencysellrate`,`currencyname`) VALUES (2,12,12.2,'USD');
INSERT INTO `currency` (`idcurrency`,`currencybuyrate`,`currencysellrate`,`currencyname`) VALUES (3,16,16.5,'EUR');
