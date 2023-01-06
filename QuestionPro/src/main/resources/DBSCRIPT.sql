CREATE TABLE item (
`id` BIGINT,
`by_user` VARCHAR(255),
`descendants` BIGINT,
`parent` BIGINT,
`poll` BIGINT,
`kids` JSON,
`parts` JSON,
`score` BIGINT,
`input_text` VARCHAR(2000),
`sync_time` DATETIME,
`title` VARCHAR(255),
`item_type` VARCHAR(255),
`url` VARCHAR(255),
  PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=latin1;
