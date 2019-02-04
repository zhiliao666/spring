注：本组件主要解决项目发布中重启时中断已经进入请求问题，做到无影响平滑启动,项目中默认有spring cloud 以及spring boot Actuator依赖


### 1，应用接入方式

	只需要pom文件中引入以下jar包即可

```
<dependency>
    <groupId>com.zhiliao.health</groupId>
    <artifactId>spring-cloud-health-check</artifactId>
    <version>1.0.0</version>
</dependency>
```

	
	
### 2,运维发布流程

	2.1 发布前调用如下请求让应用下线
```
post http://ip:port/actuator/ufotosbin/operation?c=offline
```	
	2.2 执行完以上请求后等待一会，等待的目的就是等已经进来的请求执行完，再发布重启
	
	2.3 发布重启完默认不会接收流量（这个也是保证上线后研发有时间查看应用状态），启动验证ok之后执行如下命令上线：
```
post http://ip:port/actuator/ufotosbin/operation?c=online
```

注意：
正常发布的的时候是不会以正常状态加入到注册中心上去的，但是发布成功之后如果业务中有动态扩容的服务，那之后加的节点是需要以正常的状态注册到注册中心，这个时候需要在启动脚本中加入如下配置：
```
	--ufoto.tomcat.health.status=true
```


