<%@ page import="com.lillink.parsefourtype.model.Address" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>


<head>

    <title>Hello</title>
    <body>
        <li><a href="${pageContext.request.contextPath}/person">Persons</a></li>
        <li><a href="${pageContext.request.contextPath}/address">Address</a></li>
        <li><a href="${pageContext.request.contextPath}/contacts">Contacts</a></li>
        <li><a href="${pageContext.request.contextPath}/job">Jobs</a></li>
</body>
</head>
</html>