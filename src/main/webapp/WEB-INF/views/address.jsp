<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Address</title>
</head>
<body>
    <section>
    <h3>Address info</h3>
    <table border="1" cellpadding="10" cellspacing="0" class="table" style="width: 50%; height: 10%">
        <thead>
        <th class="col" style="width: 25%">Country</th>
        <th class="col" style="width: 25%">City</th>
        <th class="col" style="width: 30%">Street</th>
        </thead>
        <tbody>
        <%= request.getAttribute("address").toString() %>
        </tbody>

    </table>
    </section>
    <li><a href="${pageContext.request.contextPath}/person?add=1">Add</a></li>
    <li><a href="${pageContext.request.contextPath}/">Back</a></li>
    <script type="text/javascript">
        function handleDelete(clickedId)
        {
            var url = "http://localhost:8080/address?id=" + clickedId;
            var xhr = new XMLHttpRequest();
            xhr.open("DELETE", url, true);
            xhr.onload = function () {
                alert('Address ' + clickedId + ' was successfully deleted');
                document.location.reload();
            };
            xhr.send(null);
        }
        function handleUpdate(clickedId) {
            window.location.href = "http://localhost:8080/address?updateId="+clickedId;
        }
    </script>
</body>
</html>