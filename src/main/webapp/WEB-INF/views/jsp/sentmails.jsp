<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home Page</title>
    <style>
		<%@include file="../css/sentmails.css"%>
	</style>
</head>
<body>
    <div>
        <div>
            <h4>Click below button to compose email:</h4>
            <form method="get" style="width: 100%;">
                <fieldset style="border: none; padding-left: 0px; padding-top: 0px">
                    <ul>
                        <li>                   
                            <input type="submit" formaction="/send/mail" value="Compose Email">
                        </li>
                        <li>                       
                 			<input type="submit" formaction="/" value="Back To Home">
                        </li>
                    </ul>
                </fieldset>
            </form>
            <h2>Sent Mails:</h2>
            <table id="sentmails_table">
            <tr>
           		<th>TO</th>
		        <th>SUBJECT</th> 
		        <th>MESSAGE</th> 
           	</tr>
            <c:forEach items="${sentmails}" var="sentmail">
			    <tr>
			        <td><c:out value="${sentmail.to}"/></td>
			        <td><c:out value="${sentmail.subject}"/></td> 
			        <td><c:out value="${sentmail.content}"/></td> 
			    </tr>
			</c:forEach>
			</table>
        </div>
    </div>
</body>
</html>