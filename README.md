# test-framework
    
本项目为测试框架调研demo，列举了常用的测试框架基础用法。

~~~ 
   工程所用sql在sql目录下。
~~~

### 工程结构
* common-demo: 公共依赖
* junit5-demo: 基于JUnit5的测试
* mockito-demo: 基于Mockito的测试
* testng-demo: 基于TestNG的测试
* power-mockito-demo: 基于PowerMockito的测试

### JUnit5
* [官方文档](https://junit.org/junit5/docs/current/user-guide/)

~~~~
    JUnit5无法模拟测试，每次的测试运行都会真正操作数据库中的数据
~~~~

### Mockito
* [官方文档1](https://site.mockito.org/)
* [官方文档2](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
* [官方文档3](https://github.com/mockito/mockito/wiki)

~~~~
    Mockito框架意在模拟
~~~~

~~~~
    spring-boot-starter-test集成了JUnit5与Mockito
~~~~

### TestNG
* [官方文档](https://testng.org/doc/documentation-main.html)


### PowerMockito
* [官方文档1](https://powermock.github.io/)
* [官方文档2](https://github.com/powermock/powermock/wiki)

~~~~
    扩展了Mockito
~~~~
