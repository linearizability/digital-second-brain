# 数字化第二大脑

## 项目架构

本项目设计思想参考领域驱动设计（Domain-driven design），架构参考六边形架构， 将项目分为七大模块：api、application、boot、common、domain、infrastructure、thirdparty

## 模块介绍

- dsb-api 【包含入参出参定义】
- dsb-application 【应用层】定义软件要完成的任务，并且指挥表达领域概念的对象来解决问题
- dsb-boot 【启动类和环境配置】
- dsb-common 【公共组件】
- dsb-domain 【领域层】负责表达业务概念，业务状态信息以及业务规则。
- dsb-infrastructure 【基础实施层】向其他层提供通用的技术能力
- dsb-thirdparty 【三方组件】

## api文档

接口文档地址: [http://localhost:9826/dsb/doc.html](http://localhost:9826/sbs/doc.html)




