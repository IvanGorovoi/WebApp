
<%@ page import="com.example.testjakartatomcat.Model.Games" %>
<%@ page import="com.example.testjakartatomcat.Model.Users" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  Users user = (Users) request.getAttribute("user");
%>
<html>
<head>
  <title>UserRedact</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
<a href="home.jsp" class="subBtn">
  <button type="submit"><img src="home.png" alt=""></button>
</a>
<div>
  <div class="wrapp">
    <form style="width: 450px;" class="formBr" action="usersRedact" method="post">
      <table>
        <tr>
          <td>Id:</td>
          <td><%= user.getId() %></td>
        </tr>
        <tr>
          <td>Nickname:</td>
          <td><input type="text" class="form-control" name="nickname" value="<%= user.getNickname() %>"></td>
        </tr>
        <tr>
          <td>Balance:</td>
          <td><input type="text" class="form-control" name="balance" value="<%= user.getBalance() %>"></td>
        </tr>
        <tr>
          <td>Extra guard:</td>
          <td><input type="checkbox" class="form-check" name="extra_guard" <% if(user.getExtra_guard()) out.print("checked"); %>></td>
        </tr>
        <tr>
          <td>Registration date:</td>
          <td><input type="text" class="form-control" name="registration_date" value="<%= user.getRegistration_date() %>"></td>
        </tr>
        <tr>
          <td>Native country:</td>
          <td><input type="text" class="form-control" name="native_country" value="<%= user.getNative_country() %>"></td>
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
