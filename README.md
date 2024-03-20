# SPRING BOOT APPLICATION

Web service monoltyh application made using SpringBoot.<br>
Connection with database locally (JDBC), functionalities implementation to list, add, delete people from a table's database. Including roles to support security provided by Spring Security, authorization, authentication, roles.

Usage of thymeleaf as template engine to show table information and provide its modification.


Including concepts and proper spring methodologies developing approach,
- Spring MVC 


- Spring Security architecture
  - Authentication Manager
  - Authentication Provider
  - Authentication Filters
  - UserDetailsService
  - PasswordEncoder

 

- Security with users in database JDBC
    - Authentication via form
    - Authorization
    - Roles


---
## Site

### Login
![](/images/login.png)

### User role dashboard.
![](/images/main_user.png)

### Administrator role dashboard.
![](/images/main_admin.png)

### Developer role dashboard.
![](images/main_dev.png)

### Adding people form.
![](images/adding.png)

---
## Database

### Users entity.
![](images/users.png)

### Role entity.
![](images/role.png)

### user_roles entity.
![](images/user_roles.png)



---
## Built with
- [Spring](https://spring.io/) - Frameworks for fast, secure and responsive web applications connected to any data storage.
- [Thymeleaf](https://www.thymeleaf.org/) - modern server-side Java template engine for both web and standalone environments.
- [Bootstrap](http://getbootstrap.com/) - Extensive list of components and  Bundled Javascript plugins.
- [Spring security](https://spring.io/projects/spring-security)- Authorization and control-access framework.
