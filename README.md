This is Maven Spring Boot project to implement simple send mail functionality and save the sent emails to mysql database.

Assumptions:
1. Java 1.8, Eclipse, Mysql (with user and password as 'root') installed on machine. 
2. Gmail credentials are set in /resources/application.properties
3. mail.sentmails tables is created in mysql with columns id (varchar(255)), mailfrom (varchar(255)), mailto (varchar(255)), mailsubject (varchar(1000)), and content (varchar(4000)).
4. Only a simple UI to send the email and mail sending REST service with gmail smtp to implelement.


Steps:
1. Clone the project and resolve the dependencies
2. Make sure mysql server is running locally
3. Run MailApplication.java as java application which will run application locally on tomcat server
4. Visit http://localhost:8080/
5. There will be UI to send an email when 'Compose Email' button is clicked
