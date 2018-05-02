# hibernate-reverse 生成 java 和 Ext.js 代码

## 实现方式技术
基于 spring-boot（V2.0） + velocity（V1.4.7）实现。构建工具使用的 gradle

## 如何配置与扩展
- 成代码模板在 vms 目录下可自行修改
- 配置文件 application.properties 中定义了可配置项（有注解）可自行配置

## 使用方法
1. 下载项目使用 gradle 构建
2. 把 lib 下的 oracle 驱动包 add to buile path
3. 配置 application.properties 文件
4. 启动项目访问 http://localhost:8080 会出现数据库中已有表
5. 选中想要生成的表生成代码

## 生成 java 和 Extjs 代码
- java 代码包括 model，dao，daoImpl，service，serviceImpl，controller
- js 代码包括 model，stroe，view，controller
