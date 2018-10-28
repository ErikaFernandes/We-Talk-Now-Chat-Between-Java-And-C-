# We-Talk-Now-Chat-Between-Java-And-CSharp
This project was developed with Angular, Java and C# with connection based on Sockets. 

I'm using Angular with Bootstrap and the Angular calls Java Controller. <br /> <br />
In Angular I'm using MatProgressBarModule to show a progress bar when I send Message from Angular/Java, ViewChild and ElementRef to get and manipulate DOM elements.
 <br /> <br />
(Angular) It has: 
 - Progress Bar
 - Scroll Down when a new message is listed
 - Ring that plays when a new message arrives from C#
  <br />
In Java I'm using Spring Boot, Spring MVC, JpaRepository and Socket to connect with C#.  <br />
I'm using MySQL to save the messages. <br />
 <br /> 
 
 # Prerequisites
 - For Angular: Node.js, Angular CLI  ([Angular QuickStart](http://angular.io/guide/quickstart))
 - For Java: Java and one IDE that suports Spring Boot (I used STS (Spring Tool Suite)
 - For C#: Windows/Visual Studio
 
 <br />
 
 # Built With
 
 - [Spring Boot](http://spring.io/projects/spring-boot)
 - [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)
 - [Bootstrap](https://getbootstrap.com/)
 - [Angular](https://angular.io/)
 - [MySQL](https://www.mysql.com/)
 - [C#](https://docs.microsoft.com/pt-br/dotnet/csharp/programming-guide/)
 
 <br />
 
 # Running the tests
 
 If you want to test this project you can test at same computer using the ip 127.0.0.1 (localhost) or if you want to test in two computer you can replace the IP.<br />
 
 Replacing the IP: <br />
   - At packege connection - Java Class CSharpSend.java replace the IP with the IP of computer destination with C#.
   - At Class C# SendMsgToJava.cs replace the IP with the IP of computer destination with Java. 
   
  
