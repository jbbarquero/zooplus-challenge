<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="style/site.css">
        <link rel="shortcut icon" href="/favicon.ico" />
        <title>Signup for Zooplus Challenge</title>
    </head>
    <body>
        <h1>Zooplus Challenge</h1>
        <div id="form_container"class="pure-g">
            <div class="pure-u-1-8"></div>
            <div class="pure-u-3-8">
                <h3>Log In</h3>
                <form name="signin" action="signin" method="post" class="pure-form">
                    <fieldset class="pure-group">
                        <input type="text" name="username" placeholder="Email">
                        <input type="password" name="password" placeholder="Password">
                    </fieldset>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <button type="submit" class="pure-button">Log In</button>
                </form>
            </div>
            <div class="pure-u-3-8">
                <h3>Sign Up</h3>
                <form name="signup" action="signup" method="post" class="pure-form">
                    <fieldset class="pure-group">
                        <input type="text"  name="firstname"  placeholder="First name">
                        <input type="text"  name="lastname"   placeholder="Last name">
                        <input type="email" name="email"      placeholder="Email">
                        <input type="date"  name="bday"       placeholder="Birth day">
                    </fieldset>
                    <fieldset class="pure-group">
                        <input type="password" name="password"   placeholder="Password">
                        <input type="password" name="repassword" placeholder="Re-enter password">
                        <!-- Address (street, zip, city & country)  -->
                    </fieldset>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <button type="submit" class="pure-button pure-button-primary">Sign Up</button>
                </form>
            </div>
            <div class="pure-u-1-8"></div>
        </div>
    </body>
</html>
