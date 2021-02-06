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

create table `xunmiao_db`.`tbl_block_info`
(
  `id`  int (8) NOT NULL COMMENT 'block_id',
  `total` int (3) NOT NULL COMMENT '座位总数',
  `floor` int (3) NOT NULL COMMENT '楼层号'
)

# 初始化楼层信息表
INSERT  into xunmiao_db.tbl_block_info (`id`,total ,floor )
values
(1,6,30),
(2,8,30),
(3,8,30),
(4,8,30),
(5,8,30),
(6,4,30),
(13,6,30),
(14,6,30),
(15,6,30),
(16,6,30),
(17,6,30),
(18,3,30),
(24,8,30),
(25,10,30),
(26,10,30),
(27,10,30),
(28,10,30),
(29,4,30);