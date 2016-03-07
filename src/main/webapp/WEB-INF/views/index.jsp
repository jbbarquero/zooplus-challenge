<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Zooplus Challenge - The solution</title>
    <meta name="description" content="Zooplus Challenge solution">
    <meta name="author" content="github.com/jomoespe">

    <link rel="stylesheet" href="style/site.css">
    <link rel="shortcut icon" href="/favicon.ico" />
</head>
<body>
    <header class="pure-g">
        <div class="pure-u-3-4">
            <h1>Zooplus Challenge</h1>
            <h2>the solution to the challenge</h2>
        </div>
        <div class="pure-u-1-4">
            <span>{the name here}</span>
            <form id="logout" action="logout" method="post" >
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <button>logout</button>
            </form>
            <%-- Display username >
            <span>${httpServletRequest.remoteUser}</span>
            <form th:action="logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" value="Log out" />
            </form>
            --%>
        </div>
    </header>

    <section id="form_container" class="pure-g">
        <div class="pure-u-1-8"></div>
        <div class="pure-u">
            <h3>get a current exchange rate</h3>
            <form action="rate" class="pure-form">
                <fieldset>
                <select name="target">
                    <c:forEach var="currency" items="${currencies}"><option value="${currency.currencyCode}"> ${currency.currencyCode} ${currency.displayName}</option>
                    </c:forEach>
                </select>
                <button class="pure-button button-main">Get rate</button>
                <fieldset>
                <label>1 USD = <strong>${rate.rate}</strong> ${rate.target}</label>

                <%-- Para mostras los errores
                <c:if test="${not empty error}"><div>${error}</div></c:if>
                <c:if test="${not empty message}"><div>${message}</div></c:if>
                --%>
            </form>
        </div>
        <div class="pure-u-1-8"></div>                
    </section>
                
    <section id="searchs_container" class="pure-g">
        <div class="pure-u-3-24"></div>
        <div class="pure-u">
            <h3>the last queries</h3>
            <table class="pure-table pure-table-horizontal pure-table-striped">
                <%--caption>Last searchs....</caption--%>
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
    </section>
</body>
</html>
