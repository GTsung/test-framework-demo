# test-framework
    
本项目为测试框架调研demo，列举了常用的测试框架基础用法。

~~~ 
   工程所用sql在sql目录下。
~~~

### 工程结构
* common-demo: 公共依赖
* junit5-demo: 基于JUnit5的测试
* mockito-demo: 基于Mockito 4.6.1的测试
* power-mockito-demo: 基于PowerMockito2 2.0.0及Junit 4.13.2 的测试
* testng-demo: 基于TestNG的测试

### JUnit5
* [官方文档](https://junit.org/junit5/docs/current/user-guide/)

~~~~
    JUnit5每次的测试运行都会真正操作数据库中的数据，可以用来测试工具类，但不适合模拟service测试
~~~~

### Mockito
* [官方文档1](https://site.mockito.org/)
* [官方文档2](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
* [官方文档3](https://github.com/mockito/mockito/wiki)

~~~~
    Mockito框架意在模拟(Mock)，非常适用service的测试，也适合测试依赖注入的程序;
    无法mock private methods
~~~~

~~~~
    spring-boot-starter-test集成了JUnit5与Mockito
~~~~

### PowerMockito
* [官方文档1](https://powermock.github.io/)
* [官方文档2](https://github.com/powermock/powermock/wiki)

~~~~
    扩展了Mockito，因为项目采用2.7.1的springboot，因此默认使用junit5，fucking junit5不支持powermock 
    故在此替换junit为4，mockito版本降低
~~~~

### TestNG
* [官方文档](https://testng.org/doc/documentation-main.html)