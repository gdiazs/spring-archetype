# spring-archetype

Basic and complete Spring Mvc Application for Beginners. 

## Technologies
* Spring MVC 4 with JPA and Thymeleaf 3. Flyway for DB migration.

## How to use it
* First configure JDK 8 and Maven 3.x
* Compile the archetype `mvn install`
* Generate the project with: `mvn archetype:generate -DarchetypeCatalog=local` (select archetype and then configure groupId and artifactId)
* execute with: `mvn jetty:run -Dspring.profiles.active=dev` (dev, qa and prod)

