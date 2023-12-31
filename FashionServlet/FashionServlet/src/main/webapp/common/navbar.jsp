<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String user = (String) session.getAttribute("login");
    int itemCount = 0;
    
    if(user != null)
    {
        itemCount = Integer.parseInt(session.getAttribute("cart").toString());
    }
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
    <div class="container">
        <a class="navbar-brand" href="#">DG Fashion</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link <%
                       if(request.getAttribute("page") == "home")
                       {
                            out.print("active");
                       }
                    %>" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%
                       if(request.getAttribute("page") == "product")
                       {
                            out.print("active");
                       }
                    %>" href="products.jsp">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%
                       if(request.getAttribute("page") == "about")
                       {
                            out.print("active");
                       }
                    %>" href="about.jsp">About Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%
                       if(request.getAttribute("page") == "contact")
                       {
                            out.print("active");
                       }
                    %>" href="contact.jsp">Contact</a>
                </li>
            </ul>
            <ul class="navbar-nav" style="margin-right:0px;">
                <%
                    if(user != null)
                    {%>
                        <li class="nav-item">
                            <a class="nav-link <%
                                if(request.getAttribute("page") == "cart")
                                {
                                     out.print("active");
                                }
                             %>" href="cart.jsp">
                                <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 576 512">
                                    <path d="M0 24C0 10.7 10.7 0 24 0H69.5c22 0 41.5 12.8 50.6 32h411c26.3 0 45.5 25 38.6 50.4l-41 152.3c-8.5 31.4-37 53.3-69.5 53.3H170.7l5.4 28.5c2.2 11.3 12.1 19.5 23.6 19.5H488c13.3 0 24 10.7 24 24s-10.7 24-24 24H199.7c-34.6 0-64.3-24.6-70.7-58.5L77.4 54.5c-.7-3.8-4-6.5-7.9-6.5H24C10.7 48 0 37.3 0 24zM128 464a48 48 0 1 1 96 0 48 48 0 1 1 -96 0zm336-48a48 48 0 1 1 0 96 48 48 0 1 1 0-96z"/>
                                </svg>
                                <sup><span class="text-dark"><%= itemCount %></span></sup>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link <%
                                if(request.getAttribute("page") == "orders")
                                {
                                     out.print("active");
                                }
                             %>" href="allorders.jsp">
                                Orders
                            </a>
                        </li>
                        <li class="nav-item">
                            <span class="nav-link"><% if(user != null) { out.print("Welcome, " + session.getAttribute("username")); } %></span>
                        </li>
                    <%}
                %>
                <li class="nav-item">
                    <a class="nav-link" href="<%
                       if(user != null)
                       {
                            out.print("logout.jsp");
                       }
                       else
                       {
                            out.print("login.jsp");
                        }
                    %>">
                        <%
                            if(user != null)
                            {
                                 out.print("Logout");
                            }
                            else
                            {
                                out.print("Login");
                            }
                         %>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>