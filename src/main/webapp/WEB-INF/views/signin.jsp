<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="style/pure/0.6.0/pure-min.css">
        <link rel="shortcut icon" href="/favicon.ico" />
        <title>Signup for Zooplus Challenge</title>
    </head>
    <body>
        <h1>Zooplus Challenge</h1>
        <h2>Log In</h2>
        <form name="login" action="signin" method="post" class="pure-form">
            <fieldset class="pure-group">
                <input type="text"     name="username" placeholder="Email">
                <input type="password" name="password" placeholder="Password">
                <button type="submit" class="pure-button">Log In</button>
            </fieldset>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        </form>

        <h2>Sign Up</h2>
        <form name="signup" action="signup" method="post" class="pure-form">
            <fieldset class="pure-group">
                <input type="firstname" name="firstname" placeholder="First name">
                <input type="lastname"  name="lastname"  placeholder="Last name">
                <input type="email"     name="email"     placeholder="Email">
                <input type="date"      name="bday"      placeholder="Birth day">
                <!-- Address (street, zip, city & country)  -->
            </fieldset>
            <fieldset class="pure-group">
                <input type="password"   name="password"   placeholder="Password">
                <input type="repassword" name="repassword" placeholder="Re-enter password">
            </fieldset>
            <button class="pure-button pure-button-primary">Sign Up</button>
        </form>
    </body>
</html>
