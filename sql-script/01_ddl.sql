CREATE TABLE `flink_dependency`(
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `source` varchar(64) not null comment '',
  `target` varchar(64) not null comment '',
  PRIMARY KEY(`id`),
  UNIQUE KEY `FLINK_DEP_UK`(`source`, `target`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '';