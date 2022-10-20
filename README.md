# **Servlet**

## *目录结构*

**servlet——demo**
```
|
|——— src
|			 |
|			 |——— java(io.sunjinxu)
|			 |	 |
|		 	 |	 |——— entity(实体类)
|		 	 |	 |
|		 	 |	 |——— servlet(servlet类)
|		 	 |
|		 	 |——— webapp
|			     |
|			     |——— download(servlet下载文件夹)
|		 	     |
|		 	     |——— form(servlet表单文件夹)
|		 	     |
|		 	     |——— login(servlet登陆文件夹)
|		 	     |
|		 	     |——— WEB——INF(配置文件文件夹)
|
|——— pom.xml
|——— README.md
```


## **一 Servlet是什么**

servlet本质上是一个Java程序，它装在在Web服务器中运行，Web服务器监听计算机端口，当有消息传到Web服务器监听的端口时，Web服务器根据配置文件中的路径将请求转发至不同的Servlet中，这些请求消息被Servlet中定义的方法处理，并且Servlet将消息通过Web服务器返回请求用户。



## 二 Servlet配置

* 本项目基于JDK1.8与MAVEN3.8.4

* 下载Tomcat，并安装至本地

* 基于IDEA新建MAVEN WEB项目，项目结构即入本项目结构所示

* IDEA安装smart tomcat插件，并新增Tomcat配置

  * Tomcat Server 安装的Tomcat文件夹路径

  * Deployment directory 默认当前项目的路径

  * Context Path 项目的总路径

  * Server port 服务端口，监听浏览器发送的请求

  * Admin port 默认8005，用于监听关闭Tomcat请求

    还有8009端口，8443端口。前者用于接收其他服务器转发的请求，后者用于接受服务端口转发过来的https请求。

* 在Java包中编写Servlet，在WEB——INF包中的web.xml中添加Servlet配置，主要包含以下几个。根据该配置文件中url——pattern中的路径在运行时访问不同的servlet，如本项目中的`localhost:9090/MyServlet`

  ```xml
  <!————全局参数————>
  <context——param>
    <param——name>param——name</param——name>
    <param——value>param——value</param——value>
  </context——param>
  
  <!————servlet名称与类对应————>
  <servlet>
    <servlet——name>MyServlet</servlet——name>
    <servlet——class>io.sunjinxu.servlet.MyServlet</servlet——class>
    <init——param>	<!————servlet内部param————>
      <param——name>name</param——name>
      <param——value>SunJinxu</param——value>
    </init——param>
    <load——on——startup>1</load——on——startup>	<!————是否随Tomcat一起初始化————>
  </servlet>
  
  <!————servlet名称与路径对应————>
  <servlet——mapping>
    <servlet——name>MyServlet</servlet——name>
    <url——pattern>/MyServlet</url——pattern>
  </servlet——mapping>
  ```



## **三 Servlet详解**

### **2.1 Servlet体系通用方法**

* *`init(ServletConfig servletConfig )`*

  初始化servlet时执行一次的方法

* *`service(ServletRequest servletRequest, ServletResponse servletResponse)`*

  servlet每次处理请求时执行的方法

* *`destroy()`*

  servlet被销毁时执行一次的方法

#### 2.1.1 MyServlet——基础Servlet

#### 2.1.2 MyLoadOnStartupServlet——测试自启动Servlet



### **2.2 HttpServlet**

#### 2.2.1 MyHttpServlet与MyHttpRevServlet——基础HttpServlet演示

#### 2.2.2 MyRequestServlet和MyResponseServlet——Request和Reponse对象功能

#### 2.2.3 MyJumpServlet与MyRedirectServlet——Servlet重定向

#### 2.2.4 MyForwardSendServlet与MyForwardRevServlet——转发Servlet

#### 2.2.5 MyReferServlet——判断请求来源

#### 2.2.6 MyImageServlet——Servlet显示图片

#### 2.2.7 MyFormServlet——Servlet获取表单信息

#### 2.2.8 MyFileDownloadServlet——Servlet提供下载

#### 2.2.9 MyGzipServlet——Servlet传输压缩文本数据

#### 2.2.10 MyCookieServlet——Servlet发送与接收cookie

#### 2.2.11 MySessionSetServlet与MySessionGetServlet——Servlet通过Session传递信息

#### 2.2.12 MyBookShelfSevlet与MyBookDetailServlet——Servlet的Cookie功能测试

#### 2.2.13 MyLoginServlet与MyHiddenServlet——Servlet的Session功能测试







