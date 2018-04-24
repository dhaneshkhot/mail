<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Send Email</title>
</head>
<body>
    <div>
        <h3>${headerText}</h3>
        <form:form method="POST" modelAttribute="Mail" >
            <fieldset>
                <div style="float:left;">
                    <table>
                         <tr>
                            <th><label for="input_from">From: </label></th>
                            <td><form:input path="from" id="input_from" type="email" value="dhaneshkhot1@gmail.com"/>
                                <form:errors path="from" cssStyle="color:red;font-size:small"/>
                            </td>
                        </tr>
                        <tr>
                            <th><label for="input_to">To: </label></th>
                            <td><form:input path="to" id="input_to" type="email"/>
                                <form:errors path="to" cssStyle="color:red;font-size:small"/>
                            </td>
                        </tr>
                        <tr>
                            <th><label for="input_subject">Subject: </label></th>
                            <td><form:input path="subject" id="input_subject"/>
                                <form:errors path="subject" cssStyle="color:red;font-size:small"/>
                            </td>
                        </tr>
   						<tr>
                            <th><label for="input_message">Message: </label></th>
                            <td><form:textarea path="content" id="input_message"/>
                                <form:errors path="content" cssStyle="color:red;font-size:small"/>
                            </td>
                        </tr>
                        <tr>
                            <th></th>
                            <td>
                                <input type="submit" value="Send">
                            </td>
                        </tr>
                    </table>
                </div>
                <div style="float:left; word-wrap: break-word; margin-left: 50px; width: 400px; color: grey">
                    ${additionalInfo}
                </div>
            </fieldset>
        </form:form>
    </div>
</body>
</html>