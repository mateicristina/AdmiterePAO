CREATE TABLE `facultati` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(45) DEFAULT NULL,
  `adresa` varchar(45) DEFAULT NULL,
  `numar_total_locuri` int(11) DEFAULT NULL,
  `nr_specializari` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--- insert facultate

INSERT INTO `admitere`.`facultati`
(
`nume`,
`adresa`,
`numar_total_locuri`,
`nr_specializari`)
VALUES
(
'administratie si afaceri',
'academiei',
'200',
'3');

