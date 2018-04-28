This is Maven Spring Boot project to implement simple send mail functionality.

Assumptions:
1. Java 1.8, Eclipse, Mysql (with user and password as 'root') installed on machine. 
2. Only mail sending functionality with gmail smtp and save sent mails in mysql database.
3. A simple UI to send the email and view the sent emails.

Steps:
1. Clone the project and resolve the dependencies
2. Make sure mysql server is running locally
3. Run MailApplication.java as java application which will run application locally on tomcat server
4. Visit http://localhost:8080/
5. There will be UI to send an email when 'Compose Email' button is clicked