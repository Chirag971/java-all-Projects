<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/signup-style.css">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Signup</title>
    </head>
    <body>
        <div id='container'>
            <div class='signup'>
                <form method="post" action="signupActivate.jsp">

                    <h1>Register</h1>
                    <!--<p>Kindly fill in this form to register.</p>-->

                    <input
                        type="text"
                        placeholder="Enter username"
                        name="username"
                        id="username"
                        required
                        />

                    <input
                        type="text"
                        placeholder="Enter Email"
                        name="email"
                        id="email"
                        required
                        />

                    <select name="pwd_ques" required>
                        <option value="What's your school name?">What's your school name?</option>
                        <option value="What's yours friend's name?">What's yours friend's name?</option>
                    </select>


                    <input
                        type="text"
                        placeholder="Password Answer"
                        name="pwd_ans"
                        id="pwd_ans"
                        required
                        />

                    <input
                        type="password"
                        placeholder="Enter Password"
                        name="pwd"
                        id="pwd"
                        required
                        />

                    <input
                        type="text"
                        placeholder="Contact"
                        name="contact"
                        id="contact"
                        required
                        />


                    <button class="btn btn-outline-primary mt-2" type="submit">Register</button>

                    <div class="container">
                        <p>Already have an account? <a href="login.jsp">Log in</a>.</p>
                    </div>
                </form>

            </div>
            <div class='whysign'>
                <%
                    String msg = request.getParameter("msg");
                    if ("valid".equals(msg)) {
                %>
                <h1>Successfully Updated</h1>
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
        <script src="bootstrap/js/bootstrap.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>