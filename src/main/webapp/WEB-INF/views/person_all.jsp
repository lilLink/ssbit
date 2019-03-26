<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Person</title>
</head>
<body>
    <section>
        <h1>All Person info</h1>
        <table border="1" cellpadding="10" cellspacing="0" class="table" style="width: 50%; height: 10%">
            <thead>
            <th class="col" style="width: 30%">First Name</th>
            <th class="col" style="width: 30%">Last Name</th>
            <th class="col" style="width: 25%">Birth Date</th>
            <th class="col" style="width: 25%">Country</th>
            <th class="col" style="width: 25%">City</th>
            <th class="col" style="width: 30%">Street</th>
            <th class="col" style="width: 45%">Email</th>
            <th class="col" style="width: 40%">Number</th>
            <th class="col" style="width: 15%">Begin Work</th>
            <th class="col" style="width: 15%">Company Name</th>
            <th class="col" style="width: 15%">Skill</th>
            <th class="col" style="width: 15%">Position</th>
            <th class="col" style="width: 15%">End Work</th>
            </thead>
            <tbody>
            <%= request.getAttribute("person").toString() %>
            <%= request.getAttribute("address").toString() %>
            <%= request.getAttribute("contacts").toString() %>
            <%= request.getAttribute("jobs").toString() %>
            </tbody>
        </table>
    </section>
</body>
</html>
