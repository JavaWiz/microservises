## Eureka Server

Implementing a Eureka Server for service registry:

Adding <i>spring-cloud-starter-netflix-eureka-server</i> to the dependencies.

Enable the Eureka Server in a @SpringBootApplication by annotating it with <i>@EnableEurekaServer</i>.

Configure some properties.

But we’ll go step by step.

Firstly we’ll create a new Maven project and put the dependencies into it. You have notice that we’re importing the spring-cloud-starter-parent to all projects

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-parent</artifactId>
            <version>Greenwich.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
Note: we can check the latest Spring Cloud releases in the <a href="https://spring.io/projects/spring-cloud#learn">Spring’s Projects documentation</a>.

Next, we’re creating the main application class:

```
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
```

Finally, we’re configuring the properties in YAML format; so an application.yml will be our configuration file:

```
server:
  port: 1111
eureka:
  client:
    registerWithEureka: false
    fetchRegistry: false
```

Here we’re configuring an application port – <i>1111</i> is the default one for Eureka servers. We are telling the built-in Eureka Client not to register with itself because our application should be acting as a server.

Now we’ll point our browser to <a href="http://localhost:1111">http://localhost:1111</a> to view the Eureka dashboard, where we will later inspecting the registered instances.