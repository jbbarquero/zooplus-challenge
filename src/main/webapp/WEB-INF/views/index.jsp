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
            <form id="logout" action="logout" method="post" >
                <label>Hi ${pageContext.request.userPrincipal.name}!</label>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <button id="logout">logout</button>
            </form>
        </div>
    </header>
    <main>
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
                    <c:if test="${empty error}"><label>1 USD = <strong>${rate.rate}</strong> ${rate.target}</label></c:if>
                    <%--c:if test="${not empty error}"><div>${error}</div></c:if--%>
                    
                    
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
    </main>
    <footer>
        <ul>
            <li>&copy;2016 github.com/jomoespe&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li><a href="https://github.com/jomoespe/zooplus-challenge"    target="_new">GitHub</a></li>
            <li><a href="https://travis-ci.org/jomoespe/zooplus-challenge" target="_new">Travis IC</a></li>
            <li><strong>Monitoring and management:</strong></li>
            <li><a href="/health"   target="_new">health</a></li>
            <li><a href="/beans"    target="_new">beans</a></li>
            <li><a href="/env"      target="_new">env</a></li>
            <li><a href="/trace"    target="_new">trace</a></li>
            <%--li><a href="/info"     target="_new">info</a></li--%>
            <li><a href="/dump"     target="_new">dump</a></li>
            <li><a href="/mappings" target="_new">mappings</a></li>
            <li><a href="/metrics"  target="_new">metrics</a></li>
        </ul>
    </footer>
</body>
</html>
