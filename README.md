# Inventory-Management-System

This project is a simple cli app for management of warehouse inventory.

[![Java][java]](#)

## Description

The application provides CRUD functionality for managing inventory. The features of the app are as follows:

* Create a new container - volume or weight based container with max capacity.

* Edit items in buffer - modifiable catalogue of items to fill containers with.

* Items in container - view breakdown of items or set amount of compatible items from buffer. Requires container id.

* Warehouse contents - list of containers with metadata like id and max capacity.

## Getting Started
For building and running the application you need:

- [JDK 11](https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html) or higher
- [Maven 3](https://maven.apache.org/download.cgi) or higher

### Running the application locally

Execute the `main` method in the `ApplicationStart.java` class from your IDE. 

You can also use maven to run the project from the command line.

```shell
mvn compile exec:java
```

## Author

Daanish Shaikh - [@github](https://github.com/DaanishShk)\
repo link - [Inventory-Management-System](https://github.com/DaanishShk/Inventory-Management-System)


## License

This project is licensed under the MIT License.



[java]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white