<html>
    <head>
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>

        <form name="loginForm" action="perform_login" method="POST">
            <table>
                <tr>
                    <td>User:</td>
                    <td><input type="text" name="username" value="" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" /></td>
                </tr>
                <tr>
                    <td><input name="submit" type="submit" value="submit" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>