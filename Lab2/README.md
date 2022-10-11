**Lab 2**

* Lab 2.1
  * 1)
    * To get the Apache Tomcat we should go to *https://tomcat.apache.org/download-10.cgi* and the select the tar.gz version on binary distributions
    * "Unzip" what we downloaded and using the terminal enter the *apache-tomcat-xx.x.xx* folder and inside we enter *bin*
    * Run the *Startup.sh* file to start the server, might have to give permissions, use **chmod u+x filename**
    * To test if it's working correctly use:
      1) ```curl -I 127.0.0.1:8080```
      2) Access the default page in the browser: http://localhost:8080
      3) ```tail logs/catalina.out``` , to see the server logs
  * 2)
    * To create roles to sign in to the server go to **conf/tomcat-users.xml.**
    * Write the line ```  <user username="USERNAME" password="PASSWORD" roles="ROLE"/>```, remember to change the username, password and role accordingly
  * 3) 
    * When creating a web app project with maven choose the following options
      * The catalog should be "Maven Central"
        Archetype should be "org.codehaus.mojo.archetypes:webapp-javaee7"
      * Version: 1.1
  * 7)
      * First check if tomcat server is online and use ````shutdown.sh```` to make it stop
      * Then check if the tomcat plugin is well installed on the maven project
      * Go to "Run" -> "Edit Configurations"
      * Add a Local Tomcat server and configure it as the following site says: https://mkyong.com/intellij/intellij-idea-run-debug-web-application-on-tomcat/
    8)
      * Unable to get

* Lab 2.2
  * 1)
    * Not much to say about, quite simple

* Lab 2.3
  *  1) 



