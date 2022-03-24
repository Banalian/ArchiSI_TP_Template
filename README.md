# LocationApp01 Web Application
This project is a web application that is divided into multiple modules to have full system.

- LocationApp01_ClientLourd is a client that is used to fill the database with data and could be used to test the system.

- LocationApp01_EAR is a EAR module that is used to deploy the system (EJB and Web modules).

- LocationApp01_EJB is a EJB module that is used to contain the model, business logic and the persistence logic.

- LocationApp01_Web is a Web module that is used to contain the website/presentation logic.

## Installation/Configuration

Before building the project, you need to install the maven dependencies. You will also need a few manual steps to configure the project.
- for the client:
    - you need to add the jboss-client.jar dependency
- for the EAR:
    - When reloading the maven project, you will see an application.xml file. You can change the context-root to change the URL of the application.
- for the EJB:
    - you need add the correct datasource/jndi on your jboss server
- for the web module:
    - you need to add the javax.servlet.jstl


## Deployment

To deploy the project, you need to build it and the artifacts. You can add the EAR(exploded or not) artifact to the server.
When using IntelliJ, the configuration might produce a bug which we haven't been able to fix, which produces an error :
- WFLYEE0042: Failed to construct component instance

A possible step to fix it is to restart the server (and potentially wait a few second before restarting)

When first deploying this project, you will need to set the persistence.xml (in the EJB module) property to "drop-and-create". You can then start the Client Lourd to fill the database.

After this first deployment, you can change the persistence.xml property to "none" or "default" for the next restarts of the server.

### Using the default configuration, the website is available at http://localhost:8080/LocationApp01_Web/

## More information

For the scope and time given for this project, we had to make a few restrictions :
- We hardcoded the only user who can access the web service (user with login : 42)
  - only this login will make the servlet redirect to the web page
  - this login is also hardcoded for all the reservations made using this web service

- The reservation table hold a lot of temporary data (like the reductions or cost of services)
  - this was a choice made, but we know there were other ways to do it like sending individual parameters

- We tried to have the business handle as many operations as possible, while the servlets tries to just gather data from forms and format them before sending them to the views or the business.