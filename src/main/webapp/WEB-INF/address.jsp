<%@ page import="com.lillink.parsefourtype.model.Address" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>


<head>

    <title>Address</title>

    <section>
        <h3>Address info</h3>
        <table border="1" cellpadding="10" cellspacing="0">
            <td>ID</td>
            <td>Country</td>
            <td>City</td>
            <td>Street</td>
                <%for(Address address : (List<Address>)request.getAttribute("address")) {
                String str = "<tr>";

                str += "<td>" + address.getId() + "</td>";
                str += "<td>" + address.getCountry() + "</td>";
                str += "<td>" + address.getCity() + "</td>";
                str += "<td>" + address.getStreet() + "</td>";

                str += "</tr>";
                out.println(str);
                }%>

        </table>
    </section>
    <li><a href="/">Back</a></li>
</head>
</html>