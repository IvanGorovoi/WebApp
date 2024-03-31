<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.testjakartatomcat.Model.Games" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Games> arrayList = (ArrayList<Games>) request.getAttribute("games");
%>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <meta charset="UTF-8"/>
    <title>Games</title>
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
            <th>Price</th>
            <th>Developer</th>
            <th>Category_id</th>
            <th>Publisher</th>
            <th>About_game</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
        <% for(Games game : arrayList) { %>
        <tr>
            <td class="unredact"><%= game.getId() %></td>
            <td class="redact"><%= game.getTitle() %></td>
            <td class="redact"><%= game.getPrice() %></td>
            <td class="redact"><%= game.getDeveloper() %></td>
            <td class="redact"><%= game.getCategory_id() %></td>
            <td class="redact"><%= game.getPublisher() %></td>
            <td class="redact"><%= game.getAbout_game() %></td>
            <td>
                <form action="gameDelete" method="post">
                    <input type="hidden" name="id" value="<%= game.getId() %>">
                    <button type="submit"><img src="bucket.png" alt=""></button>
                </form>
            </td>
            <td>
                <form action="gameRedact" method="get">
                    <input type="hidden" name="id" value="<%= game.getId() %>">
                    <button type="submit"><img src="pen.png" alt=""></button>
                </form>
            </td>
        </tr>
        <% } %>
    </table>
    <div class="flexx">
    <form class="formBr" action="games" method="post">
        <div class="texxxt">Insert</div>
        <table>
            <tr>
                <td>Title:</td>
                <td><input type="text" class="form-control" name="title"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" class="form-control" name="price"></td>
            </tr>
            <tr>
                <td>Publisher:</td>
                <td><input type="text" class="form-control" name="publisher"></td>
            </tr>
            <tr>
                <td>Developer</td>
                <td><input type="text" class="form-control" name="developer"></td>
            </tr>
            <tr>
                <td>Category Id:</td>
                <td><input type="text" class="form-control" name="category_id"></td>
            </tr>
            <tr>
                <td>About Game:</td>
                <td><input type="text" class="form-control" name="about_game"></td>
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