<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>


<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Hello</title>
</head>
    <body>
        <div class="align-middle">
            <a href="${pageContext.request.contextPath}/person" class="badge badge-success" role="button">Persons</a>
            <a href="${pageContext.request.contextPath}/address" class="badge badge-success" role="button">Address</a>
            <a href="${pageContext.request.contextPath}/contacts" class="badge badge-success" role="button">Contacts</a>
            <a href="${pageContext.request.contextPath}/job" class="badge badge-success" role="button">Jobs</a>
        </div>
</body>
</html>