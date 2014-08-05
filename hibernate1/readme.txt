1. Hibernate简介
   (1) Hibernate是一款ORM框架. Object Relation Mapping
   (2) ORM是指对象关系映射.可以将DB映射成Object,这样程序员可以通过
    对Object操作完成对DB的操作.将JDBC封装在ORM框架底层
   (3)主流ORM框架有Hibernate,iBatis,JPA
2. Hibernate框架体系结构
	(1)主配置文件:用于描述数据库连接信息.
	    hibernate.cfg.xml或者hibernate.properties
	(2)映射描述文件:用于描述映射类及属性与DB表和字段之间的对应关系
	     User.hbm.xml
	(3)映射类文件:User.java
	(4)主要API组件
		a. Configuration:用于加载主配置文件,获取数据库连接信息
	    b. SessionFactory:用于创建Session对象,封装了映射信息以及与定义的SQL
        c. Session:用于对象操作.完成增加,删除,修改,查询操作.
        d.Transaction:用于事务处理.进行增加,删除,修改时需要使用.
      因为Hibernate中自动提交功能是关闭的.
        e.Query:用于执行HQL查询语句.
          HQL属于面向对象查询语句,语句中没有表名和字段名







