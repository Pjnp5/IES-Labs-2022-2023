# **2022/2023 IES Lab 2**

### Lab 2.1

#### 1)

* To get the Apache Tomcat we should go to *https://tomcat.apache.org/download-10.cgi* and the select the **tar.gz** version on binary distributions
* **"Unzip"** what we downloaded and using the terminal enter the ***apache-tomcat-xx.x.xx*** folder and inside we enter *bin*
* Run the ***Startup.sh*** file to start the server, might have to give permissions, use **chmod u+x filename**
* To test if it's working correctly use:
  1) ``curl -I 127.0.0.1:8080``
  2) Access the default page in the browser: http://localhost:8080
  3) ``tail logs/catalina.out`` , to see the server logs

#### 2)

* To create roles to sign in to the server go to **conf/tomcat-users.xml.**
* Write the line:

  ```
  <user username="USERNAME" password="PASSWORD" roles="ROLE"/>
  ```

  Remember to change the username, password and role accordingly
* The manager space, is used to control the server and install/uninstall apps we develop.

#### 3)

* When creating a web app project with maven choose the following options
  * The catalog should be "Maven Central"
    Archetype should be "org.codehaus.mojo.archetypes:webapp-javaee7"
  * Version: 1.1

#### 4)

* Everything went as it was supposed to go, no hard problems.

#### **7)**

* First check if tomcat server is online and use ``shutdown.sh`` to make it stop
* Then check if the tomcat plugin is well installed on the maven project
* Go to "Run" -> "Edit Configurations"
* Add a Local Tomcat server and configure it as the following site says: https://mkyong.com/intellij/intellij-idea-run-debug-web-application-on-tomcat/

**8)**

* I tried to make this servlet work but no mather how I tried it never worked as it should, so I decided to search on the internet what happens when it works and learn that way.

### Lab 2.2

#### 1)

* Not much to say about, quite simple
* Dependencies:
  * ```<dependency>
    <groupId>org.eclipse.jetty</groupId>
    <artifactId>jetty-server</artifactId>
    <version>9.2.15.v20160210</version>
    ```
  * ```<dependency>
    <groupId>org.eclipse.jetty</groupId>
    <artifactId>jetty-servlet</artifactId>
    <version>9.2.15.v20160210</version>
    ```
  * Choose server port:
    * ``Server server = new Server(8680);``
  * To run :
  * ```
    mvn package
    mvexec:java -Dexec.mainClass="xxxxxxxxxx" -D exec.cleanupDaemonThreads=false
    ```
  * ``http://localhost:XXXX/`` -> Error, must insert username
  * ``http://localhost:XXXX/?username=Nome`` -> Display with username

### Lab 2.3

* #### SpringBoot Features:

```
  - Create stand-alone Spring applications
  - Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files)
  - Provide opinionated 'starter' dependencies to simplify your build configuration
  - Automatically configure Spring and 3rd party libraries whenever possible
  - Provide production-ready features such as metrics, health checks, and externalized configuration
  - Absolutely no code generation and no requirement for XML configuration
```

#### 1)

* ``https://start.spring.io/`` ->  Site to create a Maven project with SpringBoot with everything you need, Spring Web dependency adds everything you need to quickstart.
* Change to artifact_ID and group_ID as you wish
* After downloading the starter pack made by Spring Initializr, we should be able to use the app
* How to run on terminal:

  ```
  $ mvn install -DskipTests && java -jar target\webapp1-0.0.1-SNAPSHOT.jar
  ```

  or

  ```
  $ ./mvnw spring-boot:run
  ```
* To change the port we want to use go to **src/main/resources/application.properties** ``server.port=9000``

#### 2)

* https://spring.io/guides/gs/serving-web-content/ -> Create our first SpringBoot app based on this.
* Good things to do on a Spring boot project:

  1) - Use package on all classes
  2) - The main class must be on a root directory and the rest on side directories.
* **Spring Boot Tools** provides fast application restarts, LiveReload, and configurations for enhanced development experience.
* **Thymeleaf** is a modern server-side Java template engine for both web and standalone environments. Allows HTML to be correctly displayed in browsers and as static prototypes.
* Using a **@Controller** we can define who is the controller and the VIEW is responsible for rendering the HTML content
* In the controller class:

  * **@GetMapping** annotation ensures that HTTP GET requests to /XXXX are mapped to the XXXX() method.
    * **@RequestParam** connects the value of the query parameter YYYY to the parameter YYYY of the XXXX() method. These parameters are not mandatory in a necessary way, they can have a default value.
* The **Templates** directory is used to place our HTML code.
* How to run:

  * ./mvnw spring-boot:run
* http://localhost:XXXX/greeting -> return Hello,World
* http://localhost:XXXX/greeting?name=XXXX -> return Hello, XXXX!

#### 3)

* To used Restful app we utilize **@RestController**, a different type of controller.
* When we have answers we get posts, we use the **@RequestBody**
* Results:

  * ``http://localhost:XXXX/greeting->{"id":1,"content":"Hello, World!"}``
  * ``http://localhost:XXXX/greeting?name=XXXX ->  {"id":2,"content":"Hello, XXXX!"}``
* Com o ``curl -v http://localhost:XXXX/greeting``, do a get that varies the page information
* Lab 2.4

  * how to run:
  * ``./mvnw spring-boot:run  and open the browser in http://localhost:XXXX``
  * API:
  * index.html -> Starting web page with not much to see.
  * ``http://localhost:XXXX/api/quote`` -> Page that shows a random quote from a film.

    * Example : ``{"ID": 2, "Random_Quote": "Stupid is as stupid does."}``
      * Implemented on the class MoviesController on the function RandomQuotes().
  * ``http://localhost:XXXX/api/shows`` -> Page that shows all the titles in their database and the id

    * Example : `<br>```{"ID": 0, "Movie": "Star Wars"}```<br>`
      ``{"ID": 1, "Movie": "Forrest Gump"}```<br>`
      ``{"ID": 2, "Movie": "Jaws"}```<br>`
      ``{"ID": 3, "Movie": "Casablanca"}```<br>`
      ``{"ID": 4, "Movie": "Frankenstein"}```<br>`
      ``{"ID": 5, "Movie": "Dead Poets Society"}```<br>`
      ``{"ID": 6, "Movie": "The Wizard of Oz"}```<br>`
      ``{"ID": 7, "Movie": "The Adventures of Sherlock Holmes"}```<br>`
      ``{"ID": 8, "Movie": "Titanic"}```<br>`
      * Implemented on the class MoviesController on the function getShows().
  * ``http://localhost:XXXX/api/quotes`` or ``http://localhost:XXXX/api/quotes?show=X`` -> Page that shows all the titles in their database and the id

    * Example: ``{"Movie_ID": 4, "Movie": "Frankenstein", "Quote": "Beware; for I am fearless, and therefore powerful."}``
      * Implemented on the class MoviesController on the function getMovies().

### **Review Questions**

#### A

* A Servlet Container is responsible for managing the servlets, map a URL for a servlet and make sure their users have permissions to use.
* Um Servlet Container implements Web components of the Java EE architecture contract, specifying a runtime environment for web components that includes security, concurrency, lifecycle management, transaction, deployment, and other services.
* A web Container handles requests from servlets, Jakarta Server Pages (JSP) files and other file types that include server-side code. The Web container creates servlet instances, loads and unloads servlets, creates and generates request and response objects, and performs other tasks to manage servlets.

#### B

* The Spring Web model-view-controller (MVC) framework is designed around a DispatcherServlet that passes requests to handle, with configurable handler mappings, view resolution, theme location and resolution, as well as support for file uploads.
* The default handler is based on the **@Controller** and **@RequestMapping** annotations, which offers a wide range of flexible handling methods.
* With the introduction of Spring 3.0, the **@Controller** engine also allows you to create Restful websites and applications, via the **@PathVariable** annotation and other features.
* Which was what I did in the greeting exercise where it was possible by changing the name field, changing the display of the Web application, making the Web application flexible.

#### C

* *Starters* allow us to add jars to the classpath and with this we can make develop code in a faster and easier way, *starters* are the dependency descriptors.

#### D

* @Configuration
* @EnableAutoConfiguration
* @ComponentScan

#### E

* *Use logical nesting on endpoints:*

  * When designing endpoints we should group related topics, both to be easier to understand and to avoid giving attackers unnecessary information.
  * Example of this would be to append the /tables path to the end of the /furniture path in an online store.
* *Handle errors gracefully and return standard error codes:*

  * We should do this to every type of application we develop, but it's very important in API's so that we provide clarity to the clients.
  * It also helps maintainers understand more quickly the problem that's occurred.
* *Some examples of this would be:*

  * 403 Forbidden - The user is authenticated but has no permission to access a resource.
  * 404 Not Found - When a resource can't be located.
* *Cache data to improve performance:*

  * We can add caching to return data from local memory instead of querying the database everytime we want to retrieve data.
  * It also provides users with a more responsive application.
  * Although we should be carefully because caching may give users outdated information.
* *Maintain good security practices:*

  * Pretty much all information between client and server should be private, as people shouldn't be access more information than they requested.
  * We can enforce this privacy by giving users roles that provided them permissions to all the information they need and nothing more.
* *Use nouns instead of verbs in endpoint paths:*

  * Http requests already include verbs like POST, GET, DELETE, so we should give our endpoint paths, nouns that represent the entity that we are retrieving or manipulating.
  * Also, verbs are often similar and mean the same thing as get and retrieve providing no new information.
* *Documentation*

  * The fact that our API is documented greatly facilitates the work of the consumer who needs to use it, since by reading the documentation you will be able to know the API's features and how to use those same features.
  * Since we never know who will read the documentation, it should be as simple and clear as possible.
  * This document should have complete examples of the request and response cycles.
