CREATE TABLE `t_branch`
(
    `pk_branch_id`   int(11)     NOT NULL AUTO_INCREMENT,
    `location`       varchar(20) NOT NULL,
    `fk_hospital_id` int(11)     NOT NULL,
    `is_active`      tinyint(4)  NOT NULL DEFAULT '' 1 '',
    `created_time`   timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time`   timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`pk_branch_id`),
    UNIQUE KEY `branchid_UNIQUE` (`pk_branch_id`),
    KEY `hospitalid_idx` (`fk_hospital_id`),
    CONSTRAINT `hospitalid` FOREIGN KEY (`fk_hospital_id`) REFERENCES `t_hospital` (`hospital_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `t_branch_has_admin`
(
    `pk_key`       int(11)    NOT NULL AUTO_INCREMENT,
    `fk_branch_id` int(11)    NOT NULL,
    `fk_admin_id`  int(11)    NOT NULL,
    `is_active`    tinyint(4) NOT NULL DEFAULT '' 1 '',
    `created_time` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`pk_key`),
    UNIQUE KEY `pk_key_UNIQUE` (`pk_key`),
    KEY `pk_branch_id_idx` (`fk_branch_id`),
    KEY `pk_user_id_idx` (`fk_admin_id`),
    CONSTRAINT `admin_branch_id` FOREIGN KEY (`fk_branch_id`) REFERENCES `t_branch` (`pk_branch_id`),
    CONSTRAINT `admin_id` FOREIGN KEY (`fk_admin_id`) REFERENCES `t_user` (`pk_user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `t_branch_has_patient_doctor`
(
    `pk_key`       int(11)    NOT NULL AUTO_INCREMENT,
    `fk_branch_id` int(11)    NOT NULL,
    `fk_user_id`   int(11)    NOT NULL,
    `is_active`    tinyint(4) NOT NULL DEFAULT '' 1 '',
    `created_time` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`pk_key`),
    UNIQUE KEY `pk_key_UNIQUE` (`pk_key`),
    KEY `pk_branch_id_idx` (`fk_branch_id`),
    KEY `pk_user_id_idx` (`fk_user_id`),
    CONSTRAINT `user_branch_id` FOREIGN KEY (`fk_branch_id`) REFERENCES `t_branch` (`pk_branch_id`),
    CONSTRAINT `user_id` FOREIGN KEY (`fk_user_id`) REFERENCES `t_user` (`pk_user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `t_doctor`
(
    `pk_doctor_id` int(11)     NOT NULL AUTO_INCREMENT,
    `specialist`   varchar(30) NOT NULL,
    `fk_user_id`   int(11)     NOT NULL,
    `is_active`    tinyint(4)  NOT NULL DEFAULT '' 1 '',
    `created_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`pk_doctor_id`),
    UNIQUE KEY `pk_doctor_id_UNIQUE` (`pk_doctor_id`),
    KEY `pk_user_id_idx` (`fk_user_id`),
    CONSTRAINT `doctor_user_id` FOREIGN KEY (`fk_user_id`) REFERENCES `t_user` (`pk_user_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 19
  DEFAULT CHARSET = utf8;

CREATE TABLE `t_hospital`
(
    `hospital_id`   int(11)     NOT NULL AUTO_INCREMENT,
    `hospital_name` varchar(16) NOT NULL,
    `is_active`     tinyint(4)  NOT NULL DEFAULT '' 1 '',
    `created_time`  timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time`  timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`hospital_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `t_patient`
(
    `pk_patient_id` int(11)     NOT NULL AUTO_INCREMENT,
    `age`           int(11)     NOT NULL,
    `area`          varchar(16) NOT NULL,
    `city`          varchar(16) NOT NULL,
    `state`         varchar(16) NOT NULL,
    `fk_user_id`    int(11)     NOT NULL,
    `is_active`     tinyint(4)  NOT NULL DEFAULT '' 1 '',
    `created_time`  timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time`  timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`pk_patient_id`),
    UNIQUE KEY `pk_patient_id_UNIQUE` (`pk_patient_id`),
    KEY `pk_user_id_idx` (`fk_user_id`),
    CONSTRAINT `patient_user_id` FOREIGN KEY (`fk_user_id`) REFERENCES `t_user` (`pk_user_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = utf8;

CREATE TABLE `t_patient_has_doctor`
(
    `pk_key`        int(11)    NOT NULL AUTO_INCREMENT,
    `fk_patient_id` int(11)    NOT NULL,
    `fk_doctor_id`  int(11)    NOT NULL,
    `is_active`     tinyint(4) NOT NULL DEFAULT '' 1 '',
    `created_time`  timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time`  timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`pk_key`),
    UNIQUE KEY `pk_key_UNIQUE` (`pk_key`),
    KEY `fk_user_id_idx` (`fk_doctor_id`),
    KEY `fk_user_id_idx1` (`fk_patient_id`),
    CONSTRAINT `fk_doctor_id` FOREIGN KEY (`fk_doctor_id`) REFERENCES `t_doctor` (`fk_user_id`),
    CONSTRAINT `fk_patient_id` FOREIGN KEY (`fk_patient_id`) REFERENCES `t_patient` (`fk_user_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8;

CREATE TABLE `t_role`
(
    `pk_role_id`   int(11)      NOT NULL AUTO_INCREMENT,
    `name`         varchar(255) NOT NULL,
    `is_active`    tinyint(4)   NOT NULL DEFAULT '' 1 '',
    `created_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`pk_role_id`),
    UNIQUE KEY `roleid_UNIQUE` (`pk_role_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;

CREATE TABLE `t_user`
(
    `pk_user_id`   int(11)      NOT NULL AUTO_INCREMENT,
    `username`     varchar(16)  NOT NULL,
    `email`        varchar(255) NOT NULL,
    `password`     varchar(32)  NOT NULL,
    `fk_role_id`   int(11)      NOT NULL,
    `is_active`    tinyint(4)   NOT NULL DEFAULT '' 1 '',
    `created_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`pk_user_id`),
    UNIQUE KEY `userid_UNIQUE` (`pk_user_id`),
    UNIQUE KEY `email_UNIQUE` (`email`),
    KEY `roleid_idx` (`fk_role_id`),
    CONSTRAINT `roleid` FOREIGN KEY (`fk_role_id`) REFERENCES `t_role` (`pk_role_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 47
  DEFAULT CHARSET = utf8;
