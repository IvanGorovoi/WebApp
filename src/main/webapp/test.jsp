<%@ page import="com.example.testjakartatomcat.DBSQL.DBConnect" %>
<%@ page import="com.example.testjakartatomcat.DAO.GamesDAO" %>
<%@ page import="com.example.testjakartatomcat.Model.Games" %>
<%@ page import="java.io.IOException" %>
<%@ page import="com.example.testjakartatomcat.Model.Library" %>
<%
    String header = "Apache Tomcat";
    DBConnect dbConnect = new DBConnect();
    final GamesDAO gamesDAO = new GamesDAO(dbConnect.connect());
    //Library library = new Library();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>First JSP App</title>
</head>
<body>
<h2><%= header %></h2>
<table>
    <tr>
        <th>Id</th>
        <th>Nickname</th>
        <th>Balance</th>
        <th>Registration date</th>
        <th>Native country</th>
        <th>Extra guard</th>
    </tr>
    <tr>
    <% for(Games game : gamesDAO.selectAll()) {
        //<textarea name="textarea" rows="10" cols="50">Write something here</textarea>
        out.println("<tr>");
        out.println("<td><textarea name=\"textarea\" rows=\"1\" cols=\"1\">"+game.getId()+"</textarea></td>");
        out.println("<td>"+game.getTitle()+"</td>");
        out.println("<td>"+game.getPrice()+"</td>");
        out.println("<td>"+game.getDeveloper()+"</td>");
        out.println("<td>"+game.getCategory_id()+"</td>");
        out.println("<td>"+game.getPublisher()+"</td>");
        out.println("<td>"+game.getAbout_game()+"</td>");
        out.println("/<tr>");
    } %>
    </tr>
</table>

</body>
</html>