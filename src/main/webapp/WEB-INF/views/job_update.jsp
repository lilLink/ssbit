<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Job</title>
</head>
<body>
    <%= request.getAttribute("job").toString() %>

</body>
<script type="text/javascript">
    function handleUpdate(clickedId) {
        var url = new URL("http://localhost:8080/job?id=" + clickedId);
        url.searchParams.append("begin", document.getElementById("begin_"+clickedId).value);
        url.searchParams.append("company", document.getElementById("company_"+clickedId).value);
        url.searchParams.append("skill", document.getElementById("skill_"+clickedId).value);
        url.searchParams.append("position", document.getElementById("position_"+clickedId).value);
        url.searchParams.append("end", document.getElementById("end_"+clickedId).value);
        var xhr = new XMLHttpRequest();
        xhr.open("PUT", url.toString(), true);
        xhr.onload = function () {
            alert('Job ' + clickedId + ' was successfully updated');
            document.location.assign(document.referrer);
        };
        xhr.send(null);
    }
</script>
</html>
