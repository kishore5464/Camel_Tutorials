DROP TABLE IF EXISTS books;

CREATE TABLE IF NOT EXISTS `books` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(50) NOT NULL,
  `authorName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
);
