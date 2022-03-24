# LocationApp01 Web Application
This project is a web application that is divided into multiple modules to have full system.

- LocationApp01_ClientLourd is a client that is used to fill the database with data and could be used to test the system.

- LocationApp01_EAR is a EAR module that is used to deploy the system (EJB and Web modules).

- LocationApp01_EJB is a EJB module that is used to contain the model, business logic and the persistence logic.

- LocationApp01_Web is a Web module that is used to contain the website/presentation logic.

## Installation/Configuration/Deployment

Before building the project, you need to install the maven dependencies. You will also need a few manual steps to configure the project.
- for the client:
    - you need to add the jboss-client.jar dependency
- for the EAR:
    - When reloading the maven project, you will see an application.xml file. You can change the context-root to change the URL of the application.
- for the EJB:
    - you need add the correct datasource/jndi on your jboss server
- for the web module:
    - you need to add the javax.servlet.jstl

To deploy the project, you need to build it and the artifacts. You can add the EAR(exploded or not) artifact to the server.
When using IntelliJ, the configuration might produce a bug which we haven't been able to fix, which produces an error :
- WFLYEE0042: Failed to construct component instance

A possible step to fix it is to restart the server (and potentially wait a few second before restarting)