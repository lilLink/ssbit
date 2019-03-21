<%@ page import="com.lillink.parsefourtype.model.Person" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 20.03.2019
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person</title>
</head>
<body>
<section>
    <h3>Person info</h3>
    <table border="1" cellpadding="10" cellspacing="0">
        <td>ID</td>
        <td>Country</td>
        <td>City</td>
        <td>Street</td>
        <%for(Person person : (List<Person>)request.getAttribute("person")) {
            String str = "<tr>";

            str += "<td>" + person.getId() + "</td>";
            str += "<td>" + person.getFirstName() + "</td>";
            str += "<td>" + person.getLastName() + "</td>";
            str += "<td>" + person.getBirthDate() + "</td>";

            str += "</tr>";
            out.println(str);
        }%>

    </table>
</section>
<li><a href="/">Back</a></li>
</body>
</html>
