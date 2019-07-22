This examples will help you to learn the basics of microservices and microservices architectures with Spring Boot.

#Introduction to Spring Cloud Netflix – Eureka

##Overview

we’ll introduce client-side service discovery via "Spring Cloud Netflix Eureka".

Client-side service discovery allows services to find and communicate with each other without hard-coding hostname and port. The only ‘fixed point’ in such an architecture consists of a service registry with which each service has to register.

A drawback is that all clients must implement a certain logic to interact with this fixed point. This assumes an additional network round trip before the actual request.

With Netflix Eureka each client can simultaneously act as a server, to replicate its status to a connected peer. In other words, a client retrieves a list of all connected peers of a service registry and makes all further requests to any other services through a load-balancing algorithm.

To be informed about the presence of a client, they have to send a heartbeat signal to the registry.

To achieve the goal of this write-up, we’ll implement three microservices:

A service registry (Eureka Server),
A REST service which registers itself at the registry (Eureka Client) and
A web application, which is consuming the REST service as a registry-aware client.

## Using an IDE

You can run the system in your IDE by running the three servers in order: eureka_server, accounts_service and accounts_web_service.

After running all three application, open the Eureka dashboard [http://localhost:1111] in your browser to see that the `accounts_service` and `accounts_web_service` applications have registered.  
Next open the account_web Home Page [http://localhost:3333] and click one of the links.

## Command Line

You may find it easier to view the different applications by running them from a command line since you can place the three windows side-by-side and watch their log output

To do this, open three CMD windows (Windows) or three Terminal windows (MacOS, Linux) and arrange so you can view them conveniently.

1. In each window, change to the directory where you can start your application.

2. In the first window, run eureka_server using command:
   
   > mvn exec:java

   and wait for it to start up.
   
3. Switch to the second window and run accounts_service using command:
    
   > mvn exec:java
   
   and again wait for it to start up.
   
4. In the third window run accounts_web_service using command:
   
   > mvn exec:java
   
   and again wait for it to start up.
   
5. In your favorite browser open the same two links: [http://localhost:1111] and [http://localhost:3333]

You should see servers being registered in the log output of the first (registration) window.

As you interact with the web-application ([http://localhost:3333] you should logging appear in the second and third windows.

