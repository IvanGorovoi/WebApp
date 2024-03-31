<%@ page import="com.example.testjakartatomcat.DBSQL.DBConnect" %>
<%@ page import="com.example.testjakartatomcat.DAO.LibraryDAO" %>
<%@ page import="com.example.testjakartatomcat.Model.Library" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 23.10.2022
  Time: 16:35
  To change this template use File | Settings | File Templates.
  <%@include file="home.jsp" %>
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Library library = (Library) request.getAttribute("lib");
%>

<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>Title</title>
</head>
<body>
<a href="home.jsp" class="subBtn">
    <button type="submit"><img src="home.png" alt=""></button>
</a>
<div>
    <div class="wrapp">
        <form style="width: 450px;" class="formBr" action="libraryRedact" method="post">
            <table>
                <tr>
                    <td>User id:</td>
                    <td><%= library.getUser_id() %></td>
                </tr>
                <tr>
                    <td>Game id:</td>
                    <td><%= library.getGame_id() %></td>
                </tr>
                <tr>
                    <td>Activity:</td>
                    <td><input type="text" class="form-control" name="activity" value="<%= library.getActivity() %>"></td>
                </tr>
                <tr>
                    <td>Purchase date:</td>
                    <td><input type="text" class="form-control" name="purchase_date" value="<%= library.getPurchare_date() %>"></td>
                </tr>
                <tr>
                    <td><button class="subBtn" type="submit">Submit</button></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
