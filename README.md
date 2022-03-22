# ArchiSI_TP_Template
A template project to create a wildfly server project with different modules

To make it work, you will still need to refactor/rename a few folder and file like all the modules. You will also need to create the datasource in the wildfly server and use the name and jndi in the `persistance.xml` file

You will also need to manually rename the parent artefact ID and the main pom file artifactId name since maven doesn't allow for variables in the `<parent>` tag
