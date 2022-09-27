# IES_103234
2022/2023 IES Labs

To create a maven project IntelliJ IDEA we open the IDE, go to File -> New -> Project -> Maven Archetype
We select the name we want for the project and its location (option to create a git repository)
The catalog should be "Maven Central"
Archetype should be "org.apache.maven.archetypes:maven-archetype-quickstart"
On "Advanced Settings"  we can write the "groupId" and the "ArtifactId"
Press create and it's done :)

Use "-Dexec.cleanupDaemonThreads=false" to stop showing the thread warning when running the project