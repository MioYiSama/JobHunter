# 题目要求

## 基础要求

需要你开发一套javaweb程序，实现你能想到的增删改查功能并部署在云服务器环境中。

我们为你提供了demo版的backup.sql脚本，在跟据你的想法添加其他表后和插入数据后，请在环境中进行部署MySQL。

你需要实现的功能包括：

- 简易登录注册
- 管理员账户对职位的增删改查
- 用户对目标职位的搜索
- 用户对心仪职位的收藏（需创建新的关联表）
- 以及体现你创意点的功能哈哈哈哈（在比赛中后端的idea还是蛮重要）

## 权限校验

请尝试在你的程序中体现对登陆状态的校验流程，你可以参考Java Web中Cookies / Session / 令牌校验的流程，分配与过期机制，实现以下功能：

我们需要你理解这些技术在用户端与服务器端中的存储位置，以及可能的问题。

## 微服务

查询、修改等操作涉及对关系型数据库中大量数据的操作，因此需要你想办法减少耗时和计算消耗。

你可以使用Redis、消息队列、Spring Cloud编程，甚至在你的虚拟机集群中配置k8s或引入serverless部署架构来想办法解决问题。

## 最终交付

最终请交付你的项目源文件、以及一份简明扼要的接口文档，对你暴露在公网内的接口进行说明。