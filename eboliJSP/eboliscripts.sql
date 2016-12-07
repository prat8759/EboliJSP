CREATE  TABLE `ebolidb`.`login` (
  `userid` INT NOT NULL AUTO_INCREMENT ,
  `uname` VARCHAR(20) NOT NULL ,
  `upwd` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`userid`) );
  
ALTER TABLE `ebolidb`.`login` DROP COLUMN `utype` ; 

CREATE  TABLE `ebolidb`.`userdetails` (
  `uid` INT NOT NULL ,
  `fname` VARCHAR(20) NOT NULL ,
  `lname` VARCHAR(20) NULL ,
  `mname` VARCHAR(20) NULL ,
  `acctype` INT NOT NULL DEFAULT 2 ,
  `addr1` VARCHAR(45) NULL ,
  `addr2` VARCHAR(45) NULL ,
  `city` VARCHAR(20) NULL ,
  `state` VARCHAR(20) NULL ,
  `pincode` VARCHAR(20) NULL ,
  `email` VARCHAR(45) NULL ,
  PRIMARY KEY (`uid`) ,
  INDEX `userid_fk` (`uid` ASC) ,
  CONSTRAINT `userid_fk`
    FOREIGN KEY (`uid` )
    REFERENCES `ebolidb`.`login` (`userid` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
 CREATE  TABLE `ebolidb`.`productdetails` (
  `pid` INT NOT NULL AUTO_INCREMENT ,
  `pcode` VARCHAR(20) NULL ,
  `pname` VARCHAR(20) NOT NULL ,
  `pdesc` VARCHAR(200) NULL ,
  `pcat` VARCHAR(45) NOT NULL ,
  `pminbid` DECIMAL NULL DEFAULT 0.00 ,
  PRIMARY KEY (`pid`) );
 
  ALTER TABLE `ebolidb`.`productdetails` 
  ADD COLUMN `pcurbid` DECIMAL(10,2) NULL DEFAULT 0.00  
  AFTER `pminbid` , 
  CHANGE COLUMN `pminbid` `pminbid` DECIMAL(10,2) NULL DEFAULT 0.00 ;
  
  ALTER TABLE `ebolidb`.`productdetails` ADD COLUMN `pbuynow` DECIMAL(10,2) NULL DEFAULT 0.00  AFTER `pcurbid` ;
  
  CREATE TABLE `productdetails` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pcode` varchar(20) DEFAULT NULL,
  `pname` varchar(20) NOT NULL,
  `pdesc` varchar(200) DEFAULT NULL,
  `pcat` varchar(45) NOT NULL,
  `pminbid` decimal(10,2) DEFAULT '0.00',
  `pcurbid` decimal(10,2) DEFAULT '0.00',
  `pbuynow` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`pid`));
  
  ALTER TABLE `ebolidb`.`productdetails` ADD COLUMN `pstatus` INT(2) NULL DEFAULT 1  AFTER `pbuynow` ;
  ALTER TABLE `ebolidb`.`productdetails` ADD COLUMN `pchbidder` VARCHAR(30) NULL  AFTER `pstatus` ;

  
  CREATE  TABLE `ebolidb`.`transactiondetails` (
  `trnid` INT NOT NULL AUTO_INCREMENT ,
  `uid` INT NOT NULL ,
  `pid` INT NOT NULL ,
  `soldamt` DECIMAL(10,2) NULL ,
  `soldtime` DATETIME NULL ,
  PRIMARY KEY (`trnid`) ,
  INDEX `t_uid_fk` (`uid` ASC) ,
  INDEX `t_pid_fk` (`pid` ASC) ,
  CONSTRAINT `t_uid_fk`
    FOREIGN KEY (`uid` )
    REFERENCES `ebolidb`.`login` (`userid` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `t_pid_fk`
    FOREIGN KEY (`pid` )
    REFERENCES `ebolidb`.`productdetails` (`pid` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

    ALTER TABLE `ebolidb`.`transactiondetails` CHANGE COLUMN `soldamt` `tamt` DECIMAL(10,2) NULL DEFAULT NULL  , CHANGE COLUMN `soldtime` `ttime` DATETIME NULL DEFAULT NULL  , ADD COLUMN `tstatus` INT(2) NULL DEFAULT 1  AFTER `ttime` ;

    CREATE TABLE `transactiondetails` (
  `trnid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `tamt` decimal(10,2) DEFAULT NULL,
  `ttime` datetime DEFAULT NULL,
  `tstatus` int(2) DEFAULT '1',
  PRIMARY KEY (`trnid`),
  KEY `t_uid_fk` (`uid`),
  KEY `t_pid_fk` (`pid`),
  CONSTRAINT `t_pid_fk` FOREIGN KEY (`pid`) REFERENCES `productdetails` (`pid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `t_uid_fk` FOREIGN KEY (`uid`) REFERENCES `login` (`userid`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

ALTER TABLE `ebolidb`.`transactiondetails` ADD COLUMN `ttype` INT(2) NULL  AFTER `tstatus` ;
  