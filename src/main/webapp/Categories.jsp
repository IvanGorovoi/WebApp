<%@ page import="com.example.testjakartatomcat.Model.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  ArrayList<Category> arrayList = (ArrayList<Category>) request.getAttribute("category");
%>
<html>
<head>
  <title>Categories</title>
  <meta charset="UTF-8"/>
  <link rel="stylesheet" href="style.css">
  <title>Categories</title>
</head>
<body>
<a href="home.jsp" class="subBtn">
  <button type="submit"><img src="home.png" alt=""></button>
</a>
<div class="wrapp">
  <table style="margin-bottom: 15px;" class="table table-bordered border border-5 border-danger">
    <tr>
      <th>Id</th>
      <th>Title</th>
      <th>Multiplayer</th>
      <th>Single-player</th>
      <th>Not for all</th>
      <th>Delete</th>
      <th>Update</th>
    </tr>
    <% for(Category category : arrayList) { %>
    <tr>
      <td class="unredact"><%= category.getId() %></td>
      <td class="redact"><%= category.getTitle() %></td>
      <td class="redact"><%= category.getMultiplayer() %></td>
      <td class="redact"><%= category.getSingleplayer() %></td>
      <td class="redact"><%= category.getNot_for_all() %></td>
      <td>
        <form action="categoryDelete" method="post">
          <input type="hidden" name="id" value="<%= category.getId() %>">
          <button type="submit"><img src="bucket.png" alt=""></button>
        </form>
      </td>
      <td>
        <form action="categoryRedact" method="get">
          <input type="hidden" name="id" value="<%= category.getId() %>">
          <button type="submit"><img src="pen.png" alt=""></button>
        </form>
      </td>
    </tr>
    <% } %>
  </table>
  <div class="flexx">
    <form class="formBr" action="category" method="post">
      <div class="texxxt">Insert</div>
    <table>
      <tr>
        <td>Title:</td>
        <td><input type="text" class="form-control" name="title"></td>
      </tr>
      <tr>
        <td>Multiplayer:</td>
        <td><input type="checkbox" class="form-check" name="multiplayer"></td>
      </tr>
      <tr>
        <td>Singleplayer:</td>
        <td><input type="checkbox" class="form-check" name="singleplayer"></td>
      </tr>
      <tr>
        <td>Not for all:</td>
        <td><input type="checkbox" class="form-check" name="not_for_all"></td>
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