<!-- USER TABLE -->
CREATE  TABLE `nbaCommunity`.`user` (
  `idUser` INT NOT NULL ,
  `type` INT(1) NOT NULL ,
  `username` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `salt` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `avatar` VARCHAR(45) NULL ,
  `firstName` VARCHAR(45) NULL ,
  `lastName` VARCHAR(45) NULL ,
  `birthday` DATE NULL ,
  `gender` INT(1) NULL ,
  `street` VARCHAR(45) NULL DEFAULT NULL  ,
  `postalCode` VARCHAR(45) NULL , 
  `province` VARCHAR(45) NULL , 
  `country` VARCHAR(45) NULL  ;
  PRIMARY KEY (`idUser`) );
  
  
<!-- LEAGUE TABLE -->
CREATE  TABLE `nbaCommunity`.`league` (
  `idLeague` INT NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `logo` LONGBLOB NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `maxTeams` INT NOT NULL ,
  `salaryPerTeam` DOUBLE NOT NULL ,
  `idUser` INT NOT NULL ,
  PRIMARY KEY (`idUser`) ,
  INDEX `idUser_idx` (`idUser` ASC) ,
  CONSTRAINT `idUser`
    FOREIGN KEY (`idUser` )
    REFERENCES `nbaCommunity`.`user` (`idUser` )
    ON DELETE CASCADE
    ON UPDATE CASCADE);

<!-- TEAM TABLE -->
  CREATE  TABLE `nbaCommunity`.`team` (
  `idTeam` INT NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `salary` DOUBLE NOT NULL ,
  `maxPlayers` INT NOT NULL ,
  `teamScoring` FLOAT NULL,
  `idUser` INT NOT NULL ,
  `idLeague` INT NOT NULL ,
  PRIMARY KEY (`idTeam`) ,
  INDEX `idLeague_idx` (`idLeague` ASC) ,
  CONSTRAINT `idLeague`
    FOREIGN KEY (`idLeague` )
    REFERENCES `nbaCommunity`.`league` (`idLeague` )
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    


<!-- PLAYER TABLE -->
CREATE  TABLE `nbaCommunity`.`player` (
  `idPlayer` INT NOT NULL ,
  `scoring` FLOAT NOT NULL ,
  `averageScoring` FLOAT NULL ,
  `idTeam` INT NULL ,
  `idNbaPlayer` INT NULL ,
  PRIMARY KEY (`idPlayer`) ,
  INDEX `idTeam_idx` (`idTeam` ASC) ,
  CONSTRAINT `idTeam`
    FOREIGN KEY (`idTeam` )
    REFERENCES `nbaCommunity`.`team` (`idTeam` )
    ON DELETE CASCADE
    ON UPDATE CASCADE);


<!-- NBA TEAM TABLE --> 
CREATE  TABLE `nbaCommunity`.`nbaTeam` (
  `idNbaTeam` INT NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `logo` LONGBLOB NULL ,
  PRIMARY KEY (`idNbaTeam`) );

 <!-- NBA PLAYER TABLE --> 
  CREATE  TABLE `nbaCommunity`.`nbaPlayer` (
  `idNbaPlayer` INT(11) NOT NULL ,
  `fullName` VARCHAR(45) NOT NULL ,
  `position` VARCHAR(45) NULL ,
  `salary` FLOAT NULL ,
  `idNbaTeam` INT(11) NOT NULL ,
  PRIMARY KEY (`idNbaPlayer`) ,
  INDEX `idNbaTeam_idx` (`idNbaTeam` ASC) ,
  CONSTRAINT `idNbaTeam`
    FOREIGN KEY (`idNbaTeam` )
    REFERENCES `nbaCommunity`.`nbaTeam` (`idNbaTeam` )
    ON DELETE CASCADE
    ON UPDATE CASCADE);

<!-- MATCH TABLE -->
 CREATE  TABLE `nbaCommunity`.`match` (
  `idMatch` INT NOT NULL ,
  `place` VARCHAR(45) NULL ,
  `homeTeam` VARCHAR(45) NOT NULL ,
  `visitingTeam` VARCHAR(45) NOT NULL ,
  `dateHourMatch` DATETIME NULL 
  PRIMARY KEY (`idMatch`) );

 <!-- SCORING TABLE --> 
CREATE  TABLE `nbaCommunity`.`scoring` (
  `idMatch` INT(11) NOT NULL ,
  `idPlayer` INT(11) NOT NULL ,
  `type` INT(1) NOT NULL ,
  `assists` INT(2) NULL ,
  `offRebounds` INT(2) NULL ,
  `defRebounds` INT(2) NULL ,
  `blocks` INT(2) NULL ,
  `steals` INT(2) NULL ,
  `freeThrows` INT(2) NULL ,
  `freeThrowMakes` INT(2) NULL ,
  `twoPointShots` INT(2) NULL ,
  `twoPointMakes` INT(2) NULL ,
  `threePointShots` INT(2) NULL ,
  `threePointMakes` INT(2) NULL ,
  `turnovers` INT(2) NULL ,
  `personalFoul` INT(2) NULL ,
  `technicalFoul` INT(2) NULL ,
  `teamWin` INT(2) NULL ,
  `teamLose` INT(2) NULL ,
  INDEX `idPlayer_idx` (`idPlayer` ASC) ,
  CONSTRAINT `idPlayer`
    FOREIGN KEY (`idPlayer` )
    REFERENCES `nbaCommunity`.`player` (`idPlayer` )
    ON DELETE CASCADE
    ON UPDATE CASCADE);

<!-- hibernate_sequence TABLE --> 
 CREATE  TABLE `nbaCommunity`.`hibernate_sequence` (
  `SEQ_NAME` VARCHAR(50) NOT NULL ,
  `NEXT_VAL` DECIMAL(38,0) NULL ,
  PRIMARY KEY (`SEQ_NAME`) );

INSERT INTO `nbaCommunity`.`hibernate_sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES ('SEQ_NAME', '0');
