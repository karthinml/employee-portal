# Employee portal application
Employee portal application allow users to register employees to employee portal and let users to see list of employees registered in employee portal.

**Prerequisites:** [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [Node.js](https://nodejs.org/).

* [Getting Started](#getting-started)
* [App Navigation](#app-navigation)
* [API Documentation](#api-documentation)

## Getting Started
To install this example application, run the following commands:

```bash
git clone https://github.com/karthinml/employee-portal.git
cd employee-portal
```

This will get a copy of the project installed locally. 
To install all of its dependencies and start the app, follow the instructions below.

```bash
mvn clean install
cd employee-portal-service
mvn spring-boot:run
```

This will start the application(ui+service combined). Application will be accessed by using the url "http://localhost:8080/"


## App Navigation

* The home page of the application displays list of employees registered in employee portal.
* Above the table there will be button to register new employee. By clicking on that button registration form will get open.
* User can fill the form and hit register to register in portal. Incase no registration required hitting cancel button will return the user to home page.
* Incase of successful registration user will be redirected to home page and the employee list in the table will be refreshed to get updated data.
* Incase of failure registration user will be presented the error message as the notification in the bottom of the app and remains in registration page. (Eg: Duplicate
employee id registration)

## API Documentation

Api documentaion can be accessed using the url "http://localhost:8080/swagger-ui"


