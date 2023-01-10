## Lab 3

### Ex 3.1
* As a specification, the Jakarta Persistence API (formerly Java Persistence API) is concerned with persistence, which loosely means any mechanism by which Java objects outlive the application process that created them.
* By itself, JPA is not a tool or framework; rather, it defines a set of concepts that guide implementers. While JPA's object-relational mapping (ORM) model was originally based on Hibernate, it has since evolved. 
* Likewise, while JPA was originally intended for use with relational databases, some JPA implementations have been extended for use with NoSQL datastores.
* Spring Data JPA is a key component of Spring Boot, which makes it easy to add functionalities through a layer of abstraction placed on top of the JPA implementation. 
* This layer allows us to access the persistent layer without having to make our DAO implementations from the beginning.
* To give the application basic CRUD functionality, in the User object, we have to extend the CrudRepository interface, and that's it. With this Spring Data JPA will give us implementations for the CRUD methods of the repository, for our project.
<br>
* a)
  * The tutorial was pretty easy to understand, used ```https://start.spring.io/``` with the following dependencies: <br>
    ** Spring Web **, ** Thymeleaf **, ** Spring Data JPA **, ** H2 database ** and ** Validation **.
  * On the *User* class, we use the notation ```@Entity``` to  specify that the class is an entity and is mapped to a database table.
  * ```@NotBlank``` makes this fields mandatory, they always have to be not * null *
  * The ```@Id``` annotation specifies the primary key of an entity and the ```@GeneratedValue``` provides for the specification of generation strategies for the values of primary keys.
  * In the *UserRepository* interface, we use ```@Repository``` to identify it as the repository, and then we extend it to *CrudRepository* to give it the CRUD functionalities.
  * The methods *addUser()* and  *showSignUpForm()* are some of the methods we implemented that the controller is going to use
  * **"Notice how we've used the @{/adduser} URL expression to specify the form's action attribute and the ${} variable expressions for embedding dynamic content in the template, such as the values of the name and email fields and the post-validation errors."**
  * To run just start the *Lab31Application* class and the access the site where the app is running, in this case ```http://localhost:8080/```

* b)
  * 1º Question Response:
    * In the *UserController* class in the constructor we put the ```@Autowired``` annotation,
    * The autowiring feature of the spring framework enables you to inject the object dependency implicitly. It internally uses setter or constructor injection.
  * 2º Question Response:
    * The methods are defined in the CrudRepository class, which is extended by userRepository and the methods are *save()*, *findAll()*, *findById()* and *delete()*.
  * 3º Question Response:
    * *H2database*, data is being saved in this database. Which by default is an "in-memory" database.
  * 4º Question Response:
    * The rule that says "email field cannot be empty" is defined in *User* class, where we put
      ```@NotBlank``` in the attribute declaration and so it can't be empty.
* c)
  * To add the phone number quite simple, just in the user class put one more attribute that will be a String with the mobile number and then change the gets sets and constructor and in the templates put the code that existed for mail and name for phone too.
  * Added a phone as asked and an age attributes just for fun.
### Ex 3.2

* a)
  * To run mysql in docker I used the command given in lab3:
    * ```docker run --name mysql5 -e MYSQL_ROOT_PASSWORD=secret1-e MYSQL_DATABASE=demo-e MYSQL_USER=demo-e MYSQL_PASSWORD=secret2-p 33060:3306-d mysql/mysql-server:5.7```
* b) to f)
  * Used the tutorial given in the lab to create the app 
    * ```https://www.javaguides.net/2018/09/spring-boot-2-jpa-mysql-crud-example.html```
  * The maven project was created using the *Spring Web*, *Spring Data JPA*, *MySQLdriver*, *DevTools* and *Validation* dependencies.
  * ```@Entity```, ```@Table```, ```@Id```, ```@GeneratedValue```, ```@Column```, ```@Repository```, ```@AutoWired``` already explained in the first exercise
  * The ```@RestController``` is the one in charge of communicating/using the table on the database.
  * ```@GetMapping("/employees")``` is the GET method that returns all the employees in the database
  * ```@GetMapping("/employes/{id})``` is the same but returns the employee with the id given in the url
  * ```@PostMapping("/employees")``` is the Post method, used to add a new employee to the database
  * ```@PutMapping("/employees/{id}")``` is the Put method, used to change information about an employee that is already on the database
  * ```@DeleteMapping("/employees/{id}")``` is the delete method, using the id given in the url it deletes the employee that has that one id
  * ```@Valid``` ```@RequestBody``` -> checks if is valid and "uses the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object"
  * On the *exception* package are some class that take care of possible errors that can come up, like "Resource not found", letting us customise how we want to response and treat errors
  * Screenshots of Postman while using the application:
    * Post:
      ![](Lab3_2/screenshots_Postman/Screenshot 2022-10-22 at 17.27.17.png)
    * Get:
      ![](Lab3_2/screenshots_Postman/Screenshot 2022-10-22 at 17.27.28.png)
    * Put:
      ![](Lab3_2/screenshots_Postman/Screenshot 2022-10-22 at 17.43.46.png)
    * Put:
      ![](Lab3_2/screenshots_Postman/Screenshot 2022-10-22 at 17.45.10.png)
    * Delete:
      ![](Lab3_2/screenshots_Postman/Screenshot 2022-10-22 at 17.45.42.png)
* g)
  * In *EmployeeRepository* interface List<Employee> findByEmailId(String emailId) to find the users that have the email given
  * In *EmployeeRepository* interface List<Employee> findByFirstName(String firstName) to find the users that have the first name given
  * In *EmployeeRepository* interface List<Employee> findByLastName(String lastName) to find the users that have the last name given
  * ```@RequestParam(required = false) String email)```, the parameter is marked as not mandatory, same goes for firstName and lastName, the search order (first is more important) is email, firstName, lastName 
    * ```http://localhost:8080/api/v1/employees?email=paulopinto@gmail.com```, shows the user with this email, if none returns empty
    * ```http://localhost:8080/api/v1/employees?firstName=Paulo``` , shows the user with this firstName, if none returns empty
    * ```http://localhost:8080/api/v1/employees?lastName=Pinto``` , shows the user with this lastName, if none returns empty

### Ex 3.3


* a) to c)
  * Used the command used in ex2 to create the database using mysql
  * Re-used a lot of code from ex2 also, created one controller, the exception handlers, a model for the Movie and quote, and a service that made the connection between both
  * Once you have everything connected correctly between the 2 entities it becomes relatively simple to do the rest which was just passing the data from one side to the other.
  * The inserts in the database can be seen through the post methods available in the controller, postman helps a lot here.
  * ```http://localhost:8080/shows```
  * ```http://localhost:8080/quote```
  * ```http://localhost:8080/quotes?show=2```
* d)
  * I was able to create a docker image and run it but can't have access to the url content or do anything, it's like it is not working
  * To create the image I add some trouble with openjdk, add to use the command ```docker pull openjdk``` to get openjdk image, and then I was able to create the image of my application
  * ```docker build -t quoteapp .``` to build the image
  * ```docker run --network=host -p 8080:8080 quoteapp``` to run the app

### Review Questions


A) 
* The class that has the ```@RestController``` annotation returns Json Data.
* Classes that have the ```@Controller``` annotation render the Thymeleaf template.
* "The ```@RestController``` annotation in Spring MVC/Spring BOOT is nothing but a combination of ```@Controller``` and ```@ResponseBody``` annotation."
* "The ```@Controller``` annotation indicates that the class is controller like web Controller while ```@RestController``` annotation indicates that the class is controller where ```@RequestMapping``` Method assume ```@ResponseBody``` by Default(i.e REST APIs)."

B)
* On Lab3 package, Lab3.png

C)

* ```@Id``` serves to specify the primary key of an entity
* ```@Column``` is an optional annotation that allows customizing the mapping between the entity attribute and the database column
* ```@Table``` is an annotation thar allows you to specify the details of the table that will be used to store the entity in the database in a persistent way

D)

* "The Spring framework enables automatic dependency injection. In other words, by declaring all the bean dependencies in a Spring configuration file, Spring container can autowire relationships between collaborating beans. This is called Spring bean autowiring."
*  In *UserController* class its used to mark the *UserRepository* instance
