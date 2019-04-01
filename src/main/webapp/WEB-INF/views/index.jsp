<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>


<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Hello</title>
</head>
    <body>
        <div class="wrapper">
            <li><a href="${pageContext.request.contextPath}/person">Persons</a></li>
            <li><a href="${pageContext.request.contextPath}/address">Address</a></li>
            <li><a href="${pageContext.request.contextPath}/contacts">Contacts</a></li>
            <li><a href="${pageContext.request.contextPath}/job">Jobs</a></li>
        </div>
        <div class="details">
            <label class="txt"> Upload cv: </label><br>
            <form action="${pageContext.request.contextPath}/uploadFile" method="post" enctype="multipart/form-data">
                <div style="text-align: center;"><input class="btn btn-success custom-width4" name="data" type="file" value="Chose file" accept=".json, .xml, .txt" ></div>
                <input class="btn btn-success custom-width" type="submit" value="Upload"> <br>
            </form>
        </div>
</body>
</html>