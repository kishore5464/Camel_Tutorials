DROP TABLE IF EXISTS carbrands;

CREATE TABLE IF NOT EXISTS `carbrands` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `brand` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
);
