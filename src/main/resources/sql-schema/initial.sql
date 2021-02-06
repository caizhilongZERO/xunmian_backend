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
  `floor` int (3) NOT NULL COMMENT '楼层号',
  `rows` int (2) NOT NULL COMMENT '行数',
  `col` int (2) NOT NULL COMMENT '列数'
)

create table `xunmiao_db`.`tbl_floor_info`
(
  `floor` int (8) NOT NULL COMMENT 'block_id',
  `total` int (8) NOT NULL COMMENT 'total',
  PRIMARY KEY (`floor`)
)

# 初始化楼层信息表
INSERT  into xunmiao_db.tbl_block_info (`id`,total ,floor, `rows`, `col`)
values
(1,6,30,3,2),
(2,8,30,4,2),
(3,8,30,4,2),
(4,8,30,4,2),
(5,8,30,4,2),
(6,4,30,4,1),
(13,6,30,3,2),
(14,6,30,3,2),
(15,6,30,3,2),
(16,6,30,3,2),
(17,6,30,3,2),
(18,3,30,3,1),
(24,8,30,2,4),
(25,10,30,2,4),
(26,10,30,2,4),
(27,10,30,2,5),
(28,10,30,2,5),
(29,4,30,1,4);