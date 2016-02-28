<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <h2>Welcome, to the real world</h2>
        BTW, today is <fmt:formatDate value="${today}" pattern="yyyy-MM-dd" />.
        <p>
            <a href="<c:url value="/" />">Home</a>
        </p>
    </body>
</html>
