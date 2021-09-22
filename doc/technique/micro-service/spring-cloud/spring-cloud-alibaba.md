# Spring Cloud Alibaba

## nacos

nacos 在 Spring Cloud 生态中扮演的角色是服务发现、服务配置、服务元数据及流量管理。

关键特性：
* 服务发现与服务健康监测
* 动态配置服务
* 动态 DNS 服务
* 服务及其元数据管理

### 服务注册与发现

#### 服务注册与发现原理解析

![nacos服务注册与发现](https://tvax4.sinaimg.cn/large/0088W2NMgy1guku7yzpwsj60qo0c8gq202.jpg)

nacos 会监听 ApplicationStartedEvent 事件，在 spring boot 启动完成后会触发事件，然后事件会触发注册的动作。

#### 配置要点

略

### 作为动态配置服务

操作指引略。

#### 作为配置中心的架构流程

![配置中心架构流程](https://tva4.sinaimg.cn/large/0088W2NMgy1gukmtc3efqj61kk11245302.jpg)

#### 遇到的坑
1. 配置了远程配置文件之后，在`bootstrap.yml`文件中指定了配置中心与发现中心，然而启动时未获取到配置。

   观察日志与 nacos 控制台可以看出，nacos的相关配置移动到 bootstrap.yml 后，启动的springboot应用未在nacos上注册成功，即启动时未加载 bootstrap.yml 文件。添加如下依赖后可解决问题，原因是spring cloud 才会加载 bootstrap.yml 文件。

   ``` xml
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-bootstrap</artifactId>
   </dependency>
   ```

#### 环境隔离

nacos 可分为三个维度进行环境隔离 namespace 级，group级，data-id 级。data-id 级可根据启动的 profile 与 data-id 的文件特征来确定具体选用哪个配置文件。

### 常见问题？
#### 1. 如何使用 nacos 实现灰度发布？

待续，实现灰度发布需要多个组件配合实现。


## ribbon

ribbon 在 spring cloud alibaba 体系中扮演的角色为负载均衡器。类似的负载均衡器有 nginx ，不过 nginx 是服务器端负载均衡，而 ribbon 是客户端负载均衡。ribbon 可以与 RestTemplate 结合使用，或与 OpenFeign 一起使用。

nacos 中已经有依赖了 ribbon，所以若已经依赖了 nacos，则直接使用即可。

### 与 RestTemplate 整合的运行流程

![ribbon与RestTemplate整合的流程](https://tvax1.sinaimg.cn/large/0088W2NMgy1gulw805xlsj60l60880tf02.jpg)

### ribbon 常见的负载均衡策略



## 参考链接
- [1] [Spring Cloud Alibaba 教程 | Nacos（一）](https://segmentfault.com/a/1190000021497996)
- [2] [Spring Cloud Alibaba 教程 | Nacos（二）](https://segmentfault.com/a/1190000021501996)
- [3] [SpringCloud项目中使用Nacos作为配置中心](https://www.cnblogs.com/cailijuan/p/12018083.html)
- [4] [bootstrap.yml not loading in Spring Boot 2](https://stackoverflow.com/questions/50821110/bootstrap-yml-not-loading-in-spring-boot-2)
- [5] [Nacos配置中心交互模型是 push 还是 pull ？（原理+源码分析）](https://toutiao.io/posts/11z0yzz/preview)
- [6] [Nacos 服务注册的原理](https://www.cnblogs.com/wuzhenzhao/p/13625491.html)

