<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Person</title>
</head>
<body>
<section>
    <h3>Person info</h3>
    <table border="1" cellpadding="10" cellspacing="0">
        <thead>
        <th class="col" style="width: 15%">ID</th>
        <th class="col" style="width: 30%">First Name</th>
        <th class="col" style="width: 30%">Last Name</th>
        <th class="col" style="width: 25%">Birth Date</th>
        </thead>
        <tbody>
        <%= request.getAttribute("person").toString() %>
        </tbody>

    </table>
</section>
<li><a href="/">Back</a></li>
</body>
</html>
