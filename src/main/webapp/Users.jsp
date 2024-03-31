<%@ page import="com.example.testjakartatomcat.Model.Users" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.testjakartatomcat.Model.Category" %>
<%@ page import="com.sun.source.tree.UsesTree" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Users> arrayList = (ArrayList<Users>) request.getAttribute("users");
%>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<a href="home.jsp" class="subBtn">
    <button type="submit"><img src="home.png" alt=""></button>
</a>
<div class="wrapp">
    <table style="margin-bottom: 15px;" class="table table-bordered border border-5 border-danger">
        <tr>
            <th>Id</th>
            <th>Nickname</th>
            <th>Balance</th>
            <th>Registration date</th>
            <th>Native country</th>
            <th>Extra guard</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
        <% for(Users user : arrayList) { %>
        <tr>
            <td class="unredact"><%= user.getId() %></td>
            <td class="redact"><%= user.getNickname() %></td>
            <td class="redact"><%= user.getBalance() %></td>
            <td class="redact"><%= user.getRegistration_date() %></td>
            <td class="redact"><%= user.getNative_country() %></td>
            <td class="redact"><%= user.getExtra_guard() %></td>
            <td>
                <form action="usersDelete" method="post">
                    <input type="hidden" name="id" value="<%= user.getId() %>">
                    <button type="submit"><img src="bucket.png" alt=""></button>
                </form>
            </td>
            <td>
                <form action="usersRedact" method="get">
                    <input type="hidden" name="id" value="<%= user.getId() %>">
                    <button type="submit"><img src="pen.png" alt=""></button>
                </form>
            </td>
        </tr>
        <% } %>
    </table>
    <div class="flexx">
        <form class="formBr" action="users" method="post">
            <div class="texxxt">Insert</div>
            <table>
                <tr>
                    <td>Nickname:</td>
                    <td><input type="text" class="form-control" name="nickname"></td>
                </tr>
                <tr>
                    <td>Native country:</td>
                    <td><input type="text" class="form-control" name="native_country"></td>
                </tr>
                <tr>
                    <td>Balance:</td>
                    <td><input type="text"class="form-control" name="balance"></td>
                </tr>
                <tr>
                    <td>Extra guard:</td>
                    <td><input type="checkbox" class="form-check" name="extra_guard"></td>
                </tr>
                <tr>
                    <td><button class="subBtn"  type="submit">Submit</button></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
