<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>


<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Hello</title>
</head>
    <body>
        <div class="wrapper">
            <li><a href="${pageContext.request.contextPath}/parser-resume/person">Persons</a></li>
            <li><a href="${pageContext.request.contextPath}/parser-resume/address">Address</a></li>
            <li><a href="${pageContext.request.contextPath}/parser-resume/contacts">Contacts</a></li>
            <li><a href="${pageContext.request.contextPath}/parser-resume/job">Jobs</a></li>
        </div>
</body>
</html>