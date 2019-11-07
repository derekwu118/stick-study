CREATE TABLE `weibo_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `card_type` INTEGER ,
  `item_id` VARCHAR(64),
  `mblog_id` VARCHAR(64),
  `mid` VARCHAR(64),
  `source` VARCHAR(24) COMMENT '来源',
  `text` TEXT COMMENT '微博内容',
  `text_len` INTEGER,
  `pic_urls` TEXT COMMENT '图片链接',
  `repost_count` bigint COMMENT '转发次数',
  `comments_count` bigint COMMENT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;