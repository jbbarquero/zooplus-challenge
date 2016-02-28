<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="favicon.ico" />
        <title>Zooplus Challenge</title>
    </head>
    <body>
        <%-- Display username 
        <span>${httpServletRequest.remoteUser}</span>
        
        
        <form th:action="/logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Log out" />
        </form>        
        --%>
        <form action="/rate">
            <select name="source">
                <c:forEach var="currency" items="${currencies}"><option value="${currency.currencyCode}">${currency.currencyCode} ${currency.displayName}</option>
                </c:forEach>
            </select>
            <select name="target">
                <c:forEach var="currency" items="${currencies}"><option value="${currency.currencyCode}">${currency.currencyCode} ${currency.displayName}</option>
                </c:forEach>
            </select>
            <button>Submit</button>
        </form>
        <div>Rate: <strong>${rate.currency}</strong> (${rate.exchange})</div>
        
        <h1>Zooplus Challenge</h1>
        <ul>
            <li><a href="<c:url value="?currency=EUR" />">Get Euro!</a></li>
            <li><a href="<c:url value="?currency=USD" />">Get Dollar!</a></li>
            <li><a href="<c:url value="?currency=GBP" />">Get Pound!</a></li>
        </ul>
        
    </body>
</html>
