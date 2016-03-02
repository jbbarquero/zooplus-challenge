<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="style/pure/0.6.0/pure-min.css">
        <link rel="shortcut icon" href="favicon.ico" />
        <title>Zooplus Challenge</title>
    </head>
    <body>
        <h1>Zooplus Challenge</h1>
        <%-- Display username >
        <span>${httpServletRequest.remoteUser}</span>
        <form th:action="logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Log out" />
        </form>
        --%>
        <div id="form_
             container"class="pure-g">
            <div class="pure-u-1-8"></div>
            <div class="pure-u">
                <form action="rate" class="pure-form">
                    <fieldset>
                    <select name="target">
                        <c:forEach var="currency" items="${currencies}"><option value="${currency.currencyCode}"> ${currency.currencyCode} ${currency.displayName}</option>
                        </c:forEach>
                    </select>
                    <button class="pure-button pure-button-primary">Submit</button>
                    <fieldset>
                    <label>Exchange rate: <strong>${rate.rate}</strong> ${rate.target}</label>
                </form>
            </div>
            <div class="pure-u-1-8"></div>                
        </div>            

        <div class="pure-g">
            <div class="pure-u-3-24"></div>
            <div class="pure-u">
                <table class="pure-table pure-table-horizontal pure-table-striped">
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
                </table>
            </div>
            <div class="pure-u-2-24"></div>                
        </div>            
    </body>
</html>
