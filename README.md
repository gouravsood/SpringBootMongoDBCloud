# SpringBootMongoDBCloud

### What is this repository for? ###

* Quick summary -
  * This repository code explains how to work with SpringBoot and MongoDB locally and in cloud without any code change.
  * While working with JHipster code (https://github.com/jhipster/generator-jhipster), whenever application is deployed in Cloud Foundry it was causing the Circular Reference error with MongoDB (https://github.com/jhipster/generator-jhipster/issues/2521)
  * This repository code help to understand how application code can be setup to make used of SpringBoot with MongoDB following JHipster standard and avoid this issue (https://github.com/jhipster/generator-jhipster/issues/2521)

* Version: 0.0.1

### How do I get set up? ###

* Summary of set up
    * List of software to be installed:
        * Install Java (JDK 1.8)
        * Install Maven
        * Install GIT
    * Steps to setup the project:
      * Clone the repo
      ```sh
      $ git clone https://github.com/gouravsood/SpringBootMongoDBCloud.git
      ```
      * Go into the project folder
      ```sh
      $ cd SpringBootMongoDBCloud
      ```
      * build the project (which will build the application in dev profile)
      ```sh
      $ mvn clean package
      ```

* Database configuration
  * Database configuration is done using application.yml file under '\src\main\resources\config\application.yml'
  * For local database configuration, connections details are mentioned in:
  ``
  /src/main/resources/config/application.yml
  ``
  * For cloud database configuration, connections details are mentioned in:
  ``
  /src/main/resources/config/application-cloud.yml
  ``  
  * Refer to below class to understand how local DB configurations are done:
  ``/src/main/java/sood/gourav/config/DatabaseConfiguration.java``  
  * Refer to below class to understand how Cloud DB configurations are done:
  ``/src/main/java/sood/gourav/config/CloudDatabaseConfiguration.java`` and
  ``/src/main/java/sood/gourav/config/CloudMongoDbConfiguration.java``  

### Who do I talk to? ###

* Repo owner or admin - Gourav Sood
* Please feel free contact me at GitHub or my mail ``gouravsood@gmail.com``
