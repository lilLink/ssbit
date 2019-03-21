<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Person</title>
</head>
<body>
    <form action="person" method="post">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputFirstName4">First Name</label>
                <input type="text" class="form-control" id="inputFirstName4" placeholder="FirstName">
            </div>
            <div class="form-group col-md-6">
                <label for="inputLastName4">Last Name</label>
                <input type="text" class="form-control" id="inputLastName4" placeholder="LastName">
            </div>
            <div class="form-group col-md-6">
                <label for="inputBirthDate4">Birth Date</label>
                <input type="date" class="form-control" id="inputBirthDate4" placeholder="BirthDate">
            </div>
        </div>
        <input type="submit" class="btn btn-primary" value="Input">
    </form>
</body>
</html>
