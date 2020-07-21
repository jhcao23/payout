Demo Payout System Draft
===============================
### A sample and tiny project to demo the idea how to do payout 

## High Level Design Overview
![Overview](overview.svg)

### tech knowledge outline
- JPA 2
    - [DATA MODEL](src/main/java/technology/touchmars/model)
    - [Repository](src/main/java/technology/touchmars/repository)  
- JSF 2
    - [FileUpload Backing Bean](src/main/java/technology/touchmars/jsf/FileUploadBean.java)
    - [validator](src/main/java/technology/touchmars/validator)
- [config](src/main/java/technology/touchmars/config)    
- [Web Service SOAP](src/main/java/technology/touchmars/webservice)
- [REST API](src/main/java/technology/touchmars/api/RestSample.java) 
- [WEB-INF](src/main/webapp/WEB-INF)



### Note
- It only demonstrates the idea how a Payout system prototype works with tech stack (JSF 2, JPA 2, Service Layer, etc). 
- UI part needs more work as time runs out.
- need to download [wildfly](https://www.wildfly.org/downloads/) version `20+` to run it
- run the demo command `$WILDFLY_HOME/bin/standalone.sh && mvn clean install wildfly:deploy`