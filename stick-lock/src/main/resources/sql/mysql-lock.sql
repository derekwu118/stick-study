
DROP TABLE IF EXISTS `stick_lock`;
CREATE TABLE `stick_lock`(
	`id` bigint not null auto_increment comment '主键，id',
	`gmt_create` datetime not null default now() comment '创建时间',
	`gmt_modified` datetime not null default now() comment '修改时间',
	`lock_obj` varchar(64) not null comment '加锁对象',
	`expire_duration` bigint comment '过期时长，单位：ms',
	`expire_time` datetime comment '过期时间（解锁时间）',
	primary key (`id`),
	unique key `UK_LOCK_OBJ` (`lock_obj`)
) engine = InnoDB default charset=utf8mb4 comment = '锁';