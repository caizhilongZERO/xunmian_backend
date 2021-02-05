create table `xunmiao_db`.`tbl_staff_info`
(
  `id`       varchar (16) NOT NULL COMMENT '工号，主键',
  `name`     varchar (16) NOT NULL COMMENT '员工姓名',
  `floor`    int (3) not NULL COMMENT '楼层',
  `block`    int (3) not NULL COMMENT '所在小组',
  `seat`     int (3) not NULL COMMENT '所在座位号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `ix_name` (`name`)
)