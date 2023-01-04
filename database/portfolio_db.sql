-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema budwzbifttnsbil5yric
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema budwzbifttnsbil5yric
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `budwzbifttnsbil5yric` DEFAULT CHARACTER SET utf8 ;
USE `budwzbifttnsbil5yric` ;

-- -----------------------------------------------------
-- Table `budwzbifttnsbil5yric`.`Persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budwzbifttnsbil5yric`.`Persona` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Sobre_Mi` VARCHAR(255) NOT NULL,
  `Urlfoto` VARCHAR(250) NULL,
  `Githuburl` VARCHAR(250) NOT NULL,
  `Linkedinurl` VARCHAR(250) NOT NULL,
  `Usuario_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `Usuario_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budwzbifttnsbil5yric`.`Experiencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budwzbifttnsbil5yric`.`Experiencia` (
  `idExperiencia` INT NOT NULL,
  `nombreEmpresa` VARCHAR(45) NOT NULL,
  `puesto` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(250) NOT NULL,
  `inicio` DATE NOT NULL,
  `fin` DATE NULL,
  `Persona_id` INT NOT NULL,
  `Persona_Usuario_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idExperiencia`, `Persona_id`, `Persona_Usuario_id`),
  INDEX `fk_Experiencia_Persona1_idx` (`Persona_id` ASC, `Persona_Usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_Experiencia_Persona1`
    FOREIGN KEY (`Persona_id` , `Persona_Usuario_id`)
    REFERENCES `budwzbifttnsbil5yric`.`Persona` (`id` , `Usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budwzbifttnsbil5yric`.`Educacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budwzbifttnsbil5yric`.`Educacion` (
  `idEducacion` INT NOT NULL,
  `institucion` VARCHAR(45) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `inicio` DATE NOT NULL,
  `fin` DATE NULL,
  `Persona_id` INT NOT NULL,
  `Persona_Usuario_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEducacion`, `Persona_id`, `Persona_Usuario_id`),
  INDEX `fk_Educacion_Persona1_idx` (`Persona_id` ASC, `Persona_Usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_Educacion_Persona1`
    FOREIGN KEY (`Persona_id` , `Persona_Usuario_id`)
    REFERENCES `budwzbifttnsbil5yric`.`Persona` (`id` , `Usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budwzbifttnsbil5yric`.`Proyectos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budwzbifttnsbil5yric`.`Proyectos` (
  `idProyectos` INT NOT NULL,
  `tituloProyecto` VARCHAR(45) NOT NULL,
  `fotoProyecto` VARCHAR(255) NOT NULL,
  `urlProyecto` VARCHAR(45) NOT NULL,
  `Persona_id` INT NOT NULL,
  `Persona_Usuario_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProyectos`, `Persona_id`, `Persona_Usuario_id`),
  INDEX `fk_Proyectos_Persona1_idx` (`Persona_id` ASC, `Persona_Usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_Proyectos_Persona1`
    FOREIGN KEY (`Persona_id` , `Persona_Usuario_id`)
    REFERENCES `budwzbifttnsbil5yric`.`Persona` (`id` , `Usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budwzbifttnsbil5yric`.`Skills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budwzbifttnsbil5yric`.`Skills` (
  `idSkills` INT NOT NULL,
  `nombreSkill` VARCHAR(45) NOT NULL,
  `fotoSkill` VARCHAR(255) NOT NULL,
  `Persona_id` INT NOT NULL,
  `Persona_Usuario_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSkills`, `Persona_id`, `Persona_Usuario_id`),
  INDEX `fk_Skills_Persona1_idx` (`Persona_id` ASC, `Persona_Usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_Skills_Persona1`
    FOREIGN KEY (`Persona_id` , `Persona_Usuario_id`)
    REFERENCES `budwzbifttnsbil5yric`.`Persona` (`id` , `Usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budwzbifttnsbil5yric`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budwzbifttnsbil5yric`.`rol` (
  `id` INT NOT NULL,
  `admin-rol` VARCHAR(45) NOT NULL,
  `user-rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budwzbifttnsbil5yric`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budwzbifttnsbil5yric`.`Usuario` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `nombreUsuario` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budwzbifttnsbil5yric`.`Usuario_has_rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budwzbifttnsbil5yric`.`Usuario_has_rol` (
  `Usuario_id` INT NOT NULL,
  `rol_id` INT NOT NULL,
  PRIMARY KEY (`Usuario_id`, `rol_id`),
  INDEX `fk_Usuario_has_rol_rol1_idx` (`rol_id` ASC) VISIBLE,
  INDEX `fk_Usuario_has_rol_Usuario1_idx` (`Usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_has_rol_Usuario1`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `budwzbifttnsbil5yric`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_rol_rol1`
    FOREIGN KEY (`rol_id`)
    REFERENCES `budwzbifttnsbil5yric`.`rol` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;