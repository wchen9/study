# Spring Cloud Alibaba

## nacos

nacos 在 Spring Cloud 生态中扮演的角色是服务发现、服务配置、服务元数据及流量管理。

关键特性：
* 服务发现与服务健康监测
* 动态配置服务
* 动态 DNS 服务
* 服务及其元数据管理

### 服务注册与发现

#### 配置要点
1. 添加nacos 客户端依赖
``` xml
<properties>
    <spring.cloudalibaba-version>2.2.1.RELEASE</spring.cloudalibaba-version>
</properties>
<dependencies>
    <!--nacos注册中心-->
    <dependency>
        <groupId>com.alibaba.cloud</groupId>
        <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
    </dependency>
</dependencies>
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-alibaba-dependencies</artifactId>
            <version>${spring.cloudalibaba-version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

2. 在 Spring Boot 启动类上添加注解 `@EnableDiscoveryClient`。

3. application.yml 中配置 nacos 的服务端节点。

## 参考
- [1] [Spring Cloud Alibaba 教程 | Nacos（一）](https://segmentfault.com/a/1190000021497996)
- [2] [Spring Cloud Alibaba 教程 | Nacos（二）](https://segmentfault.com/a/1190000021501996)
- [3] [Spring Cloud Alibaba 教程 | Nacos（三）](https://segmentfault.com/a/1190000021508691)
