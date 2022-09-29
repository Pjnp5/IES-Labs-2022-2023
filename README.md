# IES_103234
**2022/2023 IES Labs**

To create a maven project IntelliJ IDEA we open the IDE, go to File -> New -> Project -> Maven Archetype <br>
We select the name we want for the project and its location (option to create a git repository) <br>
The catalog should be "Maven Central" <br>
Archetype should be "org.apache.maven.archetypes:maven-archetype-quickstart"<br>
On "Advanced Settings"  we can write the "groupId" and the "ArtifactId"<br>
Press create and it's done. <br>

**Ex 1.2**<br>

To select the main class we use -Dexec.mainClass="directory.MainClass"<br> 
To use args when running a maven project use "-Dexec.args="arg0 arg1 arg2"<br>
Use "-Dexec.cleanupDaemonThreads=false" to stop showing the thread warning when running the project<br>

**Ex 1.3**<br>

logger.info() -> INFO log type <br>
logger.error() -> ERROR log type <br>
logger.debug() -> DEBUG log type <br>

To create a log4j2 config file right-click "main" -> New -> Directory -> Resources
This will create the "resources" directory, then create a new file named "log2j2.xml" in there and write the config you want inside <br>

**Ex 1,4**<br>

To install docker "brew install docker"
To update docker "brew upgrade docker"

To create a docker group "sudo groupadd docker" <br>
Add user to docker group "sudo usermod -aG docker $username" <br>
*Can't use this commands on macOS, they are not supported* <br>

*Docker Tutorial Notes* <br>

In "docker run -d -p 80:80 docker/getting-started" <br>
*-d* -> Run the container in detached mode (in the background). <br>
*-p 80:80* -> Map port 80 of the host to port 80 in the container. To access the tutorial, open a web browser and navigate to **http://localhost:80**. <br>
If you already have a service listening on port 80 on your host machine, you can specify another port. <br>
For example, specify *-p 3000:80* and then access the tutorial via a web browser at **http://localhost:3000**. <br>
*docker/getting-started* -> Specify the image to use. <br>

"docker run -dp 80:80 docker/getting-started" works the same way as the first. <br>

*Container Image* -> When running a container, it uses an isolated filesystem. This custom filesystem is provided by a container image. Since the image contains the container’s filesystem, it must contain everything needed to run an application - all dependencies, configurations, scripts, binaries, etc. The image also contains other configuration for the container, such as environment variables, a default command to run, and other metadata. <br>

*Info* -> We should think that a Container is something like an extended version of "chroot", having additional isolation. <br>

*To build app's container image*<br>

Create a file name "Dockerfile", not .txt, then in the terminal write "docker build -t getting-started" <br>


