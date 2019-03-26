<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Address</title>
</head>
<body>
    <%= request.getAttribute("address").toString() %>

</body>
<script type="text/javascript">
    function handleUpdate(clickedId) {
        var url = new URL("http://localhost:8080/address?id=" + clickedId);
        url.searchParams.append("country", document.getElementById("country_"+clickedId).value);
        url.searchParams.append("city", document.getElementById("city_"+clickedId).value);
        url.searchParams.append("street", document.getElementById("street_"+clickedId).value);
        var xhr = new XMLHttpRequest();
        xhr.open("PUT", url.toString(), true);
        xhr.onload = function () {
            alert('Address ' + clickedId + ' was successfully updated');
            document.location.assign(document.referrer);
        };
        xhr.send(null);
    }
</script>
</html>
