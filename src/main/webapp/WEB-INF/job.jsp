<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Job</title>
</head>
<body>
<section>
    <h3>Job info</h3>
    <table border="1" cellpadding="10" cellspacing="0" class="table" style=" width: 50%; height: 10%">
       <thead>
       <th class="col" style="width: 10% ">ID</th>
       <th class="col" style="width: 15%">Begin Work</th>
       <th class="col" style="width: 15%">Company Name</th>
       <th class="col" style="width: 15%">Skill</th>
       <th class="col" style="width: 15%">Position</th>
       <th class="col" style="width: 15%">End Work</th>
       </thead>
        <tbody>
        <%= request.getAttribute("jobs").toString()%>
        </tbody>

    </table>
</section>
<li><a href="/">Back</a></li>
</body>
</html>
