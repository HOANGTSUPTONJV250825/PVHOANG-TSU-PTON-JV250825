-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Customer` (
  `Mã khách hàng` INT NOT NULL,
  `Tên` VARCHAR(100) NOT NULL,
  `Địa chỉ` VARCHAR(200) NOT NULL,
  `Email` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`Mã khách hàng`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Order` (
  `Mã đơn hàng` INT NOT NULL,
  `Ngày đặt hàng` DATE NOT NULL,
  `Tổng số tiền` INT NOT NULL,
  `Customer_Mã khách hàng` INT NOT NULL,
  PRIMARY KEY (`Mã đơn hàng`),
  INDEX `fk_Order_Customer1_idx` (`Customer_Mã khách hàng` ASC) VISIBLE,
  CONSTRAINT `fk_Order_Customer1`
    FOREIGN KEY (`Customer_Mã khách hàng`)
    REFERENCES `mydb`.`Customer` (`Mã khách hàng`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Product` (
  `Mã sản phẩm` INT NOT NULL,
  `Tên sản phẩm` VARCHAR(100) NOT NULL,
  `Giá` INT NOT NULL,
  PRIMARY KEY (`Mã sản phẩm`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`OrderDetail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`OrderDetail` (
  `Số lượng` INT NOT NULL,
  `Giá` INT NOT NULL,
  `Order_Mã đơn hàng` INT NOT NULL,
  `Product_Mã sản phẩm` INT NOT NULL,
  INDEX `fk_OrderDetail_Order1_idx` (`Order_Mã đơn hàng` ASC) VISIBLE,
  INDEX `fk_OrderDetail_Product1_idx` (`Product_Mã sản phẩm` ASC) VISIBLE,
  CONSTRAINT `fk_OrderDetail_Order1`
    FOREIGN KEY (`Order_Mã đơn hàng`)
    REFERENCES `mydb`.`Order` (`Mã đơn hàng`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrderDetail_Product1`
    FOREIGN KEY (`Product_Mã sản phẩm`)
    REFERENCES `mydb`.`Product` (`Mã sản phẩm`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
