CREATE TABLE `groups` (
	`id` TINYINT NOT NULL,
	`role` char(1) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `users` (
	`username` varchar(30) NOT NULL,
	`password` varchar(15) NOT NULL,
	PRIMARY KEY (`username`)
);

CREATE TABLE `others` (
	`username` varchar(30) NOT NULL,
	`name` varchar(15) NOT NULL,
	`surname` varchar(20) NOT NULL,
	`email` varchar(30) NOT NULL,
	`course` varchar(5) NOT NULL,
	`type` char(1) NOT NULL,
	PRIMARY KEY (`username`)
);

CREATE TABLE `maintenance` (
	`username` varchar(30) NOT NULL,
	`group` TINYINT NOT NULL,
	PRIMARY KEY (`username`)
);

ALTER TABLE `others` ADD CONSTRAINT `others_fk0` FOREIGN KEY (`username`) REFERENCES `users`(`username`);

ALTER TABLE `maintenance` ADD CONSTRAINT `maintenance_fk0` FOREIGN KEY (`username`) REFERENCES `others`(`username`);

ALTER TABLE `maintenance` ADD CONSTRAINT `maintenance_fk1` FOREIGN KEY (`group`) REFERENCES `groups`(`id`);
