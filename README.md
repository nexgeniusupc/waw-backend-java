# WAW Backend Application

WAW Backend Application, using Java and Spring Boot.

Currently, this app is being refactored using a microservices architecture.

## Guides

### Sub-project creation

To create a new sub-project for a new microservice, you can use the following command, replacing the values as needed.

```powershell
# Windows

# Create sub-project
& .\mvnw.cmd archetype:generate `
  "-DarchetypeGroupId=org.apache.maven.archetypes" `
  "-DarchetypeArtifactId=maven-archetype-quickstart" `
  "-DgroupId=ga.wawupc" `
  "-DartifactId=api-<service-name>" `
  "-Dpackage=ga.wawupc.api.<service-name>" `
  "-Dversion=0.0.0-SNAPSHOT"

# For example, if you have a service named `weather`:
& .\mvnw.cmd archetype:generate `
  "-DarchetypeGroupId=org.apache.maven.archetypes" `
  "-DarchetypeArtifactId=maven-archetype-quickstart" `
  "-DgroupId=ga.wawupc" `
  "-DartifactId=api-weather" `
  "-Dpackage=ga.wawupc.api.weather" `
  "-Dversion=0.0.0-SNAPSHOT"
```

```bash
# Linux

# Install the archetype to the local repository
./mvnw install -pl api-service-archetype

# Create sub-project
./mvnw archetype:generate \
  -DarchetypeGroupId=org.apache.maven.archetypes \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DgroupId=ga.wawupc \
  -DartifactId=api-<service-name> \
  -Dpackage=ga.wawupc.api.<service-name>
  -Dversion=0.0.0-SNAPSHOT

# For example, if you have a service named `weather`:
./mvnw archetype:generate \
  -DarchetypeGroupId=org.apache.maven.archetypes \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DgroupId=ga.wawupc \
  -DartifactId=api-weather \
  -Dpackage=ga.wawupc.api.weather \
  -Dversion=0.0.0-SNAPSHOT
```

## License

[MIT](LICENSE)
