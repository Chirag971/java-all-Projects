<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/signup-style.css">
        <title>ForgotPassword</title>
    </head>
    <body>
        <div id='container'>
            <div class='signup'>
                <form action="forgotPasswordAction.jsp" method="POST">
                    <input
                        type="text"
                        placeholder="Enter Email"
                        name="email"
                        id="email"
                        required
                        />
                    <input
                        type="text"
                        placeholder="Contact"
                        name="contact"
                        id="contact"
                        required
                        />
                    <select name="pwd_ques" required>
                        <option value="What is your school name?">What's your school name?</option>
                        <option value="What is yours friends name?">What's yours friend's name?</option>
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
                        placeholder="Enter New Password"
                        name="newpwd"
                        id="newpwd"
                        required
                        />
                    <input type="submit" value="Save"/>
                </form>
                <h2><a href="login.jsp">Login</a></h2>
            </div>
            <div class='whyforgotPassword'>
                <%
                    String msg = request.getParameter("msg");
                    if ("done".equals(msg)) {
                %>
                <h1>Password Changed Successfully!</h1>
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