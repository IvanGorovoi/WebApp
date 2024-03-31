<%@ page import="com.example.testjakartatomcat.DBSQL.DBConnect" %>
<%@ page import="com.example.testjakartatomcat.DAO.LibraryDAO" %>
<%@ page import="com.example.testjakartatomcat.Model.Library" %>
<%@ page import="com.example.testjakartatomcat.Model.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  Category category = (Category) request.getAttribute("category");
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
    <form style="width: 450px;" class="formBr" action="categoryRedact" method="post">
      <table>
        <tr>
          <td>Id:</td>
          <td><%= category.getId() %></td>
        </tr>
        <tr>
          <td>Title:</td>
          <td><input type="text" class="form-control" name="title" value="<%= category.getTitle() %>"></td>
        </tr>
        <tr>
          <td>Multiplayer:</td>
          <td><input type="checkbox" class="form-check" name="multiplayer" <%= category.getMultiplayer() ? "checked" : "" %>></td>
        </tr>
        <tr>
          <td>Singleplayer:</td>
          <td><input type="checkbox" class="form-check" name="singleplayer" <%= category.getSingleplayer() ? "checked" : "" %>></td>
        </tr>
        <tr>
          <td>Not For All:</td>
          <td><input type="checkbox" class="form-check" name="not_for_all" <%= category.getNot_for_all() ? "checked" : "" %>></td>
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
