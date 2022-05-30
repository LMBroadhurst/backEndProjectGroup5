# CONNECT
An Informal Social Media App for networking and connecting professionals by their interests and aspirations.

## PROJECT VISION

Formal networks within organisations offer little room for emotions, feelings or sharing of personal thoughts. By relying on Connect, professionals can enjoy easy conversations and bond, without the pressures of conforming strictly to generic corporate culture. 

Connect aims to do this by creating a network of professionals, ready to support and bond with each other over common career interests. Connect will encourage users to attend networking events and socials with others on the site, allowing for relationships to strengthen and develop further. 

## ENTITY RELATIONSHIPS

![alt text](https://github.com/LMBroadhurst/backEndProjectGroup5/blob/main/ERD%20Final%20-%20BEP%20(3).jpg)
### Figure 1 - ERD diagram representing Connect's database

A Postgres database was used to store all information associated with Connect, such as user information, comments, posts, interests etc. **Figure 1** showcases how entities were related to one another in Connect's database. How each table relates to another is summarised in the following list:

### Users 
- Users to Comments : one to many
- Users to Posts : one to many 
- Users to Message : one to many
### Posts
- Posts to Comments : one to many 
- Posts to Post Types : one to one 
### Comments
- Comments to Replies : one to many 
### Mappers
- Users to Interest Mapper : one to one
- Interest Mapper to Interest Types : one to one 

As can be seen, most of the database extends out of two central tables, these tables being **Users** and **Posts**.   

**Interest Types** and **Post Types** are tables consisting of only enum data types. **Users** has a many to many relationship with **Interest Types**, so, a mapper table named **Interest Mapper** is used to map a user to his/her particular interest(s). 

## CLASS DIAGRAMS

![alt text](https://github.com/LMBroadhurst/backEndProjectGroup5/blob/main/Class%20Diagrams%20-%20BEP.jpg)
### Figure 2 - Class diagram representing Connect's model, repo, service, and controller classes

Diagram displaying how connect's classes come together from model through to repository.


## DEPENDENCIES, DATABASE INITIALISATION AND APPLICATION PROPERTIES

### CONNECTING TO A POSTGRES DATABASE

The dependencies required to connect to, and work with, a postgres database using Spring JDBC and Spring JPA  are as follows:
``` java
<dependency>
        <groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<version>42.3.6</version>
	<scope>runtime</scope>
</dependency>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>		
```

The application properties required to connect to, and work with, a postgres database are as follows:

```java
spring.datasource.url=jdbc:postgresql://localhost:5432/connectdatabase
spring.datasource.username=
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL81Dialect 
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

The name of the postgres database in this project is "connectdatabase". This database is connected to using line 1 of the application properties snippet above. 

Line 4 of the code snippet will influence how the schema tool manipulates the database schema at application startup. Leaving this setting as "create" should allow for the tables in the schema.sql to be properly initialized in our postgres database for now.

Line 5 of the application properties snippet will specify that the type of databse used in hibernate is Postgres, enabling hibernate to generate the appropriate type of SQL statements.

Lines 6 and 7 will log autogenerated SQL statements for debugging purposes.





## Quirky Behaviours
Please note that a lot of the methods produce clean String outputs rather than the expected JSON format, to improve our presentation. This should of course be removed and replaced with the relevant JSON formatting when being used as a 'true' backend API.

We have removed some features, namely spring security/thymeleaf, friends, and replies to simplify the project. If anything refers to these features please delete/comment them out.


