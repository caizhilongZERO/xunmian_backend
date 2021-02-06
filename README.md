# xunmian_backend
# 项目架构
│   │        └── xxxx (项目根路径)
│   │            ├── controller (控制器)
│   │            ├── domain (对象类)
│   │            │   ├── response (请求返回给调用方的对象类)
│   │            │   └── entity (数据库实体类)
│   │            ├── mapper (数据访问层，与底层MySQL、Oracle、Hbase、OB等进行数据交互)
│   │            ├── service (服务层：接口定义，相对具体的业务逻辑服务层。)
│   │            │   └── impl (服务层：实现类)
│   │            └── util (工具类)
