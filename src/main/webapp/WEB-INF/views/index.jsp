<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="favicon.ico" />
        <link rel="stylesheet" href="style/pure/0.6.0/pure-min.css">
        <title>Zooplus Challenge</title>
    </head>
    <body>
        <h1>Zooplus Challenge</h1>
        <%-- Display username --%>
        <span>${httpServletRequest.remoteUser}</span>
        <form th:action="logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Log out" />
        </form>        
        <form action="rate">
            <select name="target">
                <c:forEach var="currency" items="${currencies}"><option value="${currency.currencyCode}"> ${currency.currencyCode} ${currency.displayName}</option>
                </c:forEach>
            </select>
            <button>Submit</button>
            <div>Exchange: <strong>${rate.rate}</strong> ${rate.target}</div>
        </form>
        <div>
            <table>
                <caption>Last searchs....</caption>
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
                        <td>${exchange.rateDate}</td>
                        <td>${exchange.source}</td>
                        <td>${exchange.target}</td>
                        <td>${exchange.rate}</td>
                    </tr>
                </c:forEach>
              </thead>
        </div>
    </body>
</html>
