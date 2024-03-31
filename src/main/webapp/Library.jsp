<%@ page import="com.example.testjakartatomcat.Model.Library" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Library> arrayList = (ArrayList<Library>) request.getAttribute("library");
%>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <meta charset="UTF-8"/>
    <title>Library</title>
</head>
<body>
<a href="home.jsp" class="subBtn">
    <button type="submit"><img src="home.png" alt=""></button>
</a>
<div class="wrapp">
    <table style="margin-bottom: 15px;" class="table table-bordered border border-5 border-danger">
        <tr>
            <th>User_id</th>
            <th>Game_id</th>
            <th>Activity</th>
            <th>Purchase date</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
        <% for(Library library : arrayList) { %>
        <tr>
            <td class="unredact"><%= library.getUser_id() %></td>
            <td class="redact"><%= library.getGame_id() %></td>
            <td class="redact"><%= library.getActivity() %></td>
            <td class="redact"><%= library.getPurchare_date() %></td>
            <td>
                <form action="libraryDelete" method="post">
                    <input type="hidden" name="user_id" value="<%= library.getUser_id() %>">
                    <input type="hidden" name="game_id" value="<%= library.getGame_id() %>">
                    <button type="submit"><img src="bucket.png" alt=""></button>
                </form>
            </td>
            <td>
                <form action="libraryRedact" method="get">
                    <input type="hidden" name="user_id" value="<%= library.getUser_id() %>">
                    <input type="hidden" name="game_id" value="<%= library.getGame_id() %>">
                    <button type="submit"><img src="pen.png" alt=""></button>
                </form>
            </td>
        </tr>
        <% } %>
    </table>
    <div class="flexx">
    <form class = "formBr" action="library" method="post">
        <div class="texxxt">Insert</div>
            <table>
                <tr>
                    <td>User id:</td>
                    <td><input type="text" class="form-control" name="user_id"></td>
                </tr>
                <tr>
                    <td>Game id:</td>
                    <td><input type="text" class="form-control" name="game_id"></td>
                </tr>
                <tr>
                    <td>Activity:</td>
                    <td><input type="text" class="form-control" name="activity"></td>
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
