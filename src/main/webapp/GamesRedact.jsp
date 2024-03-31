<%@ page import="com.example.testjakartatomcat.Model.Games" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Games game = (Games) request.getAttribute("game");
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
        <form style="width: 450px;" class="formBr" action="gameRedact" method="post">
            <table>
                <tr>
                    <td>Id:</td>
                    <td><%= game.getId() %></td>
                </tr>
                <tr>
                    <td>Title:</td>
                    <td><input type="text" class="form-control" name="title" value="<%= game.getTitle() %>"></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="text" class="form-control" name="price" value="<%= game.getPrice() %>"></td>
                </tr>
                <tr>
                    <td>Category id:</td>
                    <td><input type="text" class="form-control" name="category_id" value="<%= game.getCategory_id() %>"></td>
                </tr>
                <tr>
                    <td>Publisher:</td>
                    <td><input type="text" class="form-control" name="publisher" value="<%= game.getPublisher() %>"></td>
                </tr>
                <tr>
                    <td>Developer:</td>
                    <td><input type="text" class="form-control" name="developer" value="<%= game.getDeveloper() %>"></td>
                </tr>
                <tr>
                    <td>About Game:</td>
                    <td><input type="text" class="form-control" name="about_game" value="<%= game.getAbout_game() %>"></td>
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
