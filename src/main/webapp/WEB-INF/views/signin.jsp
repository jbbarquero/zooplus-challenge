<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="style/pure/0.6.0/pure-min.css">
        <link rel="shortcut icon" href="favicon.ico" />
        <title>Signup for Zooplus Challenge</title>
    </head>
    <body>
        <h1>Zooplus Challenge</h1>
        <%--div>
            <h2>Sign Up</h2>
            <form>
                <div><input type="firstname" name="firstname" placeholder="First name"></div>
                <div><input type="lastname" name="lastname" placeholder="Last name"></div>
                <div><input type="email" name="email" placeholder="Email"></div>
                <div><input type="date" name="bday" placeholder="Birth day"></div>
                <div><input type="password" name="password" placeholder="Password"></div>
                <div><input type="repassword" name="repassword" placeholder="Re-enter password"></div>
                <!-- Address (street, zip, city & country)  -->
                <button>Sign Up</button>
            </form>
        </div--%>

        <h2>Log In</h2>
        <form name="f" action="signin" method="post" class="pure-form">
            <fieldset class="pure-group">
                <input type="text" name="username" placeholder="Email">
                <input type="password" name="password" placeholder="Password">
            </fieldset>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <button type="submit" class="pure-button pure-button-primary">Log In</button>
        </form>
                
            <%--form name='f' action='login' method='POST'>
                <table>
                    <tr><td>User:</td><td><input type='text' name='username' value=''></td></tr>
                    <tr><td>Password:</td><td><input type='password' name='password'/></td></tr>
                    <tr><td colspan='2'><input name="submit" type="submit" value="Login"/></td></tr>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </table>
            </form--%>
                
                
    </body>
</html>
