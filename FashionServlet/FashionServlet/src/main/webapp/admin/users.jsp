<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="common/head.jsp" %>
<div>
    <h2>Welcome Admin</h2>
    <div class="table-responsive">
        <table id="user-tbl" class="table table-hover">
            <thead>
                <tr>
                    <th>User Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Registering Date</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from user_master where phone != '1000000000'");
                    while(rs.next())
                    {%>
                    <tr>
                        <td><%= rs.getString("username") %></td>
                        <td><%= rs.getString("phone") %></td>
                        <td><%= rs.getString("email") %></td>
                        <td><%= rs.getString("created_at") %></td>
                    </tr>  
                    <%}
                %>
            </tbody>
        </table>
    </div>
</div>
<%@include file="common/foot.jsp" %>
<script>
    $("#user-tbl").DataTable();
</script>
</body>
</html>