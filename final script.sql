-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cookbook
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cookbook
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cookbook` DEFAULT CHARACTER SET utf8 ;
USE `cookbook` ;

-- -----------------------------------------------------
-- Table `cookbook`.`recipedatabase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cookbook`.`recipedatabase` (
  `idrecipeDatabase` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `recipeFile` VARCHAR(1000) NOT NULL,
  `recipeRating` INT(11) NULL DEFAULT NULL,
  `recipeComment` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`idrecipeDatabase`),
  UNIQUE INDEX `idrecipeDatabase_UNIQUE` (`idrecipeDatabase` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cookbook`.`recipetagrelation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cookbook`.`recipetagrelation` (
  `idrecipetagrelation` INT(11) NOT NULL AUTO_INCREMENT,
  `idtag` INT(11) NOT NULL,
  `idrecipeDatabase` INT(11) NOT NULL,
  PRIMARY KEY (`idrecipetagrelation`),
  UNIQUE INDEX `idrecipetagrelation_UNIQUE` (`idrecipetagrelation` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cookbook`.`tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cookbook`.`tag` (
  `idtag` INT(11) NOT NULL AUTO_INCREMENT,
  `tagethnicity` VARCHAR(45) NOT NULL,
  `tagpreference` VARCHAR(45) NOT NULL,
  `tagmealtype` VARCHAR(45) NOT NULL,
  `tagmealcooktime` INT(11) NOT NULL,
  `tagmealtemp` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtag`),
  UNIQUE INDEX `idtag_UNIQUE` (`idtag` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cookbook`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cookbook`.`user` (
  `iduser` INT(11) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `pWord` VARCHAR(45) NOT NULL,
  `userName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `role` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE INDEX `iduser_UNIQUE` (`iduser` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
