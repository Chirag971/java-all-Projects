<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/signup-style.css">
        <title>Login</title>
    </head>
    <body>
        <div id='container'>
            <div class='signup'>
                <form action="loginAction.jsp" method="POST">
                    <h2>Login</h2>
                    <input type="text"
                           placeholder="Enter email"
                           name="email"
                           id="email"
                           required style="width: 90%">

                    <input type="password"
                           placeholder="Enter Password"
                           name="pwd"
                           id="pwd"
                           required style="width: 90%">

                    <div class="subcontainer">
                        <label style="float: left">
                            <input type="checkbox"  checked="checked" name="remember"> Remember me
                        </label>
                        <a href="forgotPassword.jsp" style="float: right">Forgot Password?</a>
                    </div>

                <input type="submit" value="Login">
                </form>

                <p>Not a member?  <a href="signup.jsp">SignUp here!</a></p>

            </div>
            <div class='whysignLogin'>
                <%
                    String msg = request.getParameter("msg");
                    if ("notexists".equals(msg)) {
                %>
                <h1>Incorrect Username or Password</h1>
                <% }%>
                <%
                    if ("invalid".equals(msg)) {
                %>
                <h1>Some thing Went Wrong! Try Again !</h1>
                <% }%>
                <h2>Online Shopping</h2>
                <p>The Online Shopping System is the application that allows the users to shop online without going to the shops to buy them.</p>
            </div>
        </div>

    </body>
</html>