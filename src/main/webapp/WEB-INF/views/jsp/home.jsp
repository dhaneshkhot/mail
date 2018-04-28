<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <div>
        <div>
            <h4>Click below button to compose email:</h4>
            <form method="get" style="width: 200px;">
                <fieldset style="border: none; padding-left: 0px; padding-top: 0px">
                    <table>
                        <tr>
                        	<td>
                             	<input type="submit" formaction="/send/mail" value="Compose Email">
                        	</td>
                        </tr>
                        <tr>
                        	<td>
                             	<input type="submit" formaction="/sentmails" value="Sent Mails">
                        	</td>
                        </tr>
                    </table>
                </fieldset>
            </form>
        </div>
    </div>
</body>
</html>