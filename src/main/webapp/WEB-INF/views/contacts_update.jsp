<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact Update</title>
</head>
<body>

 <%= request.getAttribute("contact").toString() %>
</body>
<script type="text/javascript">
    function handleUpdate(clickedId) {
        var url = new URL("http://localhost:8080/parser-resume/contacts?id=" + clickedId);
        url.searchParams.append("email", document.getElementById("email_"+clickedId).value);
        url.searchParams.append("number", document.getElementById("number_"+clickedId).value);
        var xhr = new XMLHttpRequest();
        xhr.open("PUT", url.toString(), true);
        xhr.onload = function () {
            document.location.assign(document.referrer);
        };
        xhr.send(null);
    }
</script>
</html>
