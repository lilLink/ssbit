<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person Update</title>
</head>
<body>

    <%= request.getAttribute("person").toString() %>
</body>
<script type="text/javascript">
    function handleUpdate(clickedId) {
        var url = new URL("http://localhost:8080/parser-resume/person?id=" + clickedId);
        url.searchParams.append("first", document.getElementById("first_"+clickedId).value);
        url.searchParams.append("last", document.getElementById("last_"+clickedId).value);
        url.searchParams.append("date", document.getElementById("date_"+clickedId).value);
        var xhr = new XMLHttpRequest();
        xhr.open("PUT", url.toString(), true);
        xhr.onload = function () {
            alert('Person ' + clickedId + ' was successfully updated');
            document.location.assign(document.referrer);
        };
        xhr.send(null);
    }
</script>
</html>
