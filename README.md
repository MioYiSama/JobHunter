# Job Hunter

## 简介

> 2024 择栖工作室 二轮招新 第四题

基于Spring Cloud开发的完整后端项目

https://github.com/mioyisama/jobhunter

## 模块介绍

- commons: 通用代码库
  - 包含MyBatis，MySQL，Lombok依赖
- eureka-server: 微服务注册与发现
- config-server: 配置中心
- gateway-server: 路由
  - 会根据请求所携带的 Token 分析用户身份，进行权限控制
  - 为管理员提供 OpenAPI（/v3/api-docs/{service-name}）
- auth-service: 认证服务
  - 使用 JWT 进行认证
  - 使用 Redis 保存签发的 Token
- user-service: 用户服务
  - 使用 Redis 缓存
  - 使用 RabbitMQ 同步创建用户信息
- position-service: 职位服务
  - 使用 Redis 缓存
  - 使用 RabbitMQ 同步ES中的数据
- favorite-service：收藏服务
  - 使用 Redis 缓存
- info-service：用户信息服务
  - 使用 Redis 缓存
- search-service：搜索服务
  - 使用 Elasticsearch
- bruno-api: 使用 [Bruno](https://www.usebruno.com/) 进行API测试

## 运行

### 方法一：Docker Compose

```bash
docker-compose up -d --build
```

### 方法二：本地运行

按以下顺序运行各个服务：
1. eureka-server（端口：8761）
2. config-server（端口：8888）
3. gateway-server（端口：8080）
4. auth-service（端口：8081）
5. user-service（端口：8082）
6. position-service（端口：8083）
7. favorite-service（端口：8084）
8. info-service（端口：8085）
9. search-service（端口：8086）

## 文档

运行项目后，打开 http://localhost:8080/swagger-ui.html