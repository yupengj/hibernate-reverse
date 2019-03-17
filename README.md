# hibernate-reverse 生成 java 和 Ext.js 代码

## 实现方式技术
基于 JDBC + velocity（V1.4.7）实现。构建工具 gradle

## 如何配置与扩展
- 成代码模板在 vms 目录下可自行修改
- 配置文件 config.properties 中定义了可配置项

## 配置说明
```
datasource.driverClassName=oracle.jdbc.driver.OracleDriver
datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
datasource.username=core
datasource.password=core

#datasource.driverClassName=oracle.jdbc.driver.OracleDriver
#datasource.url=jdbc:postgresql://localhost:5432/postgres
#datasource.username=core
#datasource.password=core

#允许生成代码的 schema 集合
allowSchema=mstdata,bommgmt,chgmgmt,cfgmgmt,integration,cust

# 多个用逗号分隔,只支持 ,大小写都可以兼容不同数据库
# 如果没有值就用 allowSchema 中定义的 schema集合. 
# 如果值不在 allowSchema 中定义则无效
schema=mstdata

#表名,多个用逗号分隔
#如果表名与 ignoreTable 中配置的表名重复,则以ignoreTable中配置的为准,该表不生成代码
table=

#不生成代码的表名,多个用逗号分隔
ignoreTable=
#上面三个条件用最后会变成 sql 的条件用 and 连接,如果三个配置都没有值,就默认生成支持的所有schema下的表(也就是上面定义的)



#生成代码的人,类上的@author注解的值
author=jyp

#java包的根路径
rootPackage=com.gantang

#js声明根路径
jsRootPackage=gantang

#生成的包路径使用. 在 schema 前的包路径. 支持带有点的路径,如:prd.aa.bb
beforeSchemaName=prd

#生成的包路径使用. 在 schema 后的包路径.支持带有点的路径,如:prd.aa.bb
afterSchemaName=
#如果生成的是 mstdata schema 的表.上面三个参数组成的包路径是 "com.gantang.prd.mstdata.material"

#生成java的代码 model,dao,daoImpl,service,serviceImpl,controller
javaCode=model,dao,daoImpl,service,serviceImpl,controller

#生成js代码 model,store,view,controller
jsTCode=model,store,view,controller

#生成代码存放位置
outPath=D:/generateCode/
```


## 使用方法
1. 下载项目使用 gradle 构建
2. 把 lib 下的 oracle 驱动包 add to buile path
3. 配置 config.properties 文件
4. 运行 GenerateCode 类中的 main 方法 
5. 生成的代码在参数 outPath 指定的路径


## 更新记录
- [x] 修改为不使用 spring-boot ,直接用JDBC连接数据库
- [x] 数据库列的描述生成到代码的model中
```java
private Long id; // 主键
```
- [x] 支持 psotgresSql 数据库反向生成java