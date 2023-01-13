# **2022/2023 IES Lab 1**

To create a **maven project IntelliJ IDEA** we open the IDE, go to **File -> New -> Project -> Maven Archetype**

We select the name we want for the project and its location (option to create a git repository)
The catalog should be **"Maven Central"**

Archetype should be **"org.apache.maven.archetypes:maven-archetype-quickstart"**

On **"Advanced Settings"**  we can write the **"groupId"** and the **"ArtifactId"**

Press create and it's done.

### **Ex 1.2**

To select the main class we use:

```
-Dexec.mainClass="directory.MainClass"
```

To use args when running a maven project use:

```
-Dexec.args="arg0 arg1 arg2"
```

To stop showing the thread warning when running the project use:

```
-Dexec.cleanupDaemonThreads=false
```

### **Ex 1.3**

```
logger.info() -> INFO log type

logger.error() -> ERROR log type

logger.debug() -> DEBUG log type
```

To create a log4j2 config file right-click **"main" -> New -> Directory -> Resources**

This will create the **"resources"** directory, then create a new file named **"log2j2.xml"** in there and write the config you want inside

### **Ex 1,4**

To install docker (on macOS):

```
brew install docker
```

To update docker :

```
brew upgrade docker
```

To create a docker group:

```
sudo groupadd docker
```

Add user to docker group:

```
 sudo usermod -aG docker $username
```

*Can't use this commands on macOS, they are not supported*

#### **Docker Tutorial Notes**

```
docker run -d -p 80:80 docker/getting-started
```

***-d*** -> Run the container in detached mode (in the background).

***-p 80:80*** -> Map port 80 of the host to port 80 in the container. To access the tutorial, open a web browser and navigate to **http://localhost:80**.

If you already have a service listening on port 80 on your host machine, you can specify another port.

For example, specify *-p 3000:80* and then access the tutorial via a web browser at **http://localhost:3000**.

 Specify the image to use:

```
docker/getting-started
```

 Works the same way as the first:

```
docker run -dp 80:80 docker/getting-started
```

#### **Container Image**

When running a container, it uses an isolated filesystem.

 This custom filesystem is provided by a container image.

Since the image contains the container’s filesystem, it must contain everything needed to run an application - all dependencies, configurations, scripts, binaries, etc. The image also contains other configuration for the container, such as environment variables, a default command to run, and other metadata.

#### **Info**

We should think that a Container is something like an extended version of "chroot", having additional isolation.

#### **To build app's container image**

Create a file name **"Dockerfile"**, not .txt, then on the terminal write

```
docker build -t getting-started
```

### **Review Questions**

#### **A)**

```
Maven main phases no ciclo default:

**validate** - Verifica se o projeto está correto e se a sua informção está disponivel

**compile** - Compila o codigo fonte

**test** -Testa o codigo fonte depois de compilar compilado

**package** - Transforma o codigo compilado num package, p.e. "jar"

**verify** -Corre os unit tests, garantindo qualidade

**install** - instala o package no repositorio local

**deploy** - Copia o package final para o repositório remoto para ser possivel partilha-lo
```

#### **B)**

```
Sim, o maven pode ser util para correr o nosso projeto , como utilizamos na pergunta 1.2 para o correr ou em  uma aplicação web e pode fazer muitas outras tarefas através de plug-ins

O Maven pode ativar diferentes plug-ins, incluindo plug-ins para executar uma classe específica
```

#### **C)**

```
nova funcionalidade
git pull
git add .
git commit -m "nova funcionalidade"
git push
```

#### **D)**

```
Em alturas que estamos a fazer debug de vários bugs é preferivel fazer commits a cada bug resolvido do que só no fim ou a cada alteração.

A mensagem deve ser clara e para quem a lê saiba as alterções

Fazer commits regulares e mais pequenos, para ajudar a voltar atrás para o momento que queremos

Não dar commit de trabalhos a meio, só vai trazer problemas a outros trabalhadores

Usar uma linguagem que toda gente entenda

Não dar commit diretamente no master, fazer branch primeiro, para termos segurança que se alguem da nossa equipa mexeu no trabalho não vamos estar a dar overwrite no dele.
```

#### **E)**

```
Ao configurar volumes  vamos fazer com que exista persistencia dos dados na base de dados e assim no caso do container desaparecer, for apagado ou o sistema sofrer um reboot os dados ainda estão disponíveis.
```
