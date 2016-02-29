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
        <h1>Zooplus Challenge</h1>
        <%-- Display username 
        <span>${httpServletRequest.remoteUser}</span>
        <form th:action="/logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Log out" />
        </form>        
        --%>
        <form action="/rate">
            <select name="target">
                <c:forEach var="currency" items="${currencies}"><option value="${currency.currencyCode}"> ${currency.currencyCode} ${currency.displayName}</option>
                </c:forEach>
            </select>
            <button>Submit</button>
            <div>Exchange: <strong>${rate.exchange}</strong> ${rate.currency}</div>
        </form>
        <div>
            <h1>Last searchs</h1>
            <table>
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Base</th>
                        <th>Target</th>
                        <th>Exchange rate</th>
                    </tr>
                </thead>
                <c:forEach var="exchange" items="${searchs}">
                    <tr>
                        <td>${exchange.timestamp}</td>
                        <td>${exchange.base.currencyCode}</td>
                        <td></td>
                        <td>1.1</td>
                    </tr>
                </c:forEach>
              </thead>
        </div>
    </body>
</html>
