# Job Hunter

## 简介

基于Spring Cloud开发的完整后端项目

## 特点

- 使用了Spring Cloud实现微服务架构
- 使用了GitHub Actions实现CI/CD
- 使用了Docker实现服务部署

## 模块介绍

- commons: 通用代码库
  - 包含MyBatis，MySQL，Lombok依赖
- eureka-server: 微服务注册与发现
- config-server: 配置中心
- gateway-server: 路由
  - 会根据请求所携带的Token分析用户身份，进行权限控制
- auth-service: 认证服务
  - 使用JWT进行认证
  - 使用Redis保存签发的Token
- user-service: 用户服务
  - 使用Redis缓存
- bruno-api: API调试