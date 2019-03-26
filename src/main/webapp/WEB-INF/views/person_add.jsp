<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Add Person</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/person" method="post">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputFirstName4">First Name</label>
                <input type="text" class="form-control" id="inputFirstName4" name="inputFirstName4" placeholder="FirstName">
            </div>
            <div class="form-group col-md-6">
                <label for="inputLastName4">Last Name</label>
                <input type="text" class="form-control" id="inputLastName4" name="inputLastName4" placeholder="LastName">
            </div>
            <div class="form-group col-md-6">
                <label for="inputBirthDate4">Birth Date</label>
                <input type="date" class="form-control" id="inputBirthDate4" name="inputBirthDate4" placeholder="BirthDate">
            </div>
            <div class="form-group col-md-6">
                <label for="inputEmail4">Email</label>
                <input type="email" class="form-control" id="inputEmail4" name="inputEmail4" placeholder="Email">
            </div>
            <div class="form-group col-md-6">
                <label for="inputNumber4">Number</label>
                <input type="text" class="form-control" id="inputNumber4" name="inputNumber4" placeholder="Number">
            </div>
            <div class="form-group col-md-6">
                <label for="inputCountry4">Country</label>
                <input type="text" class="form-control" id="inputCountry4" name="inputCountry4" placeholder="Country">
            </div>
            <div class="form-group col-md-6">
                <label for="inputCity4">City</label>
                <input type="text" class="form-control" id="inputCity4" name="inputCity4" placeholder="City">
            </div>
            <div class="form-group col-md-6">
                <label for="inputStreet4">Street</label>
                <input type="text" class="form-control" id="inputStreet4" name="inputStreet4" placeholder="Street">
            </div>
            <div class="form-group col-md-6">
                <label for="inputBeginWork4">Begin Work</label>
                <input type="date" class="form-control" id="inputBeginWork4" name="inputBeginWork4" placeholder="BeginWork">
            </div>
            <div class="form-group col-md-6">
                <label for="inputJobCompany4">Job Company</label>
                <input type="text" class="form-control" id="inputJobCompany4" name="inputJobCompany4" placeholder="JobCompany">
            </div>
            <div class="form-group col-md-6">
                <label for="inputSkill4">Skill</label>
                <input type="text" class="form-control" id="inputSkill4" name="inputSkill4" placeholder="Skill">
            </div>
            <div class="form-group col-md-6">
                <label for="inputPosition4">Position</label>
                <input type="text" class="form-control" id="inputPosition4" name="inputPosition4" placeholder="Position">
            </div>
            <div class="form-group col-md-6">
                <label for="inputEndWork4">End Work</label>
                <input type="date" class="form-control" id="inputEndWork4" name="inputEndWork4" placeholder="EndWork">
            </div>
        </div>
        <input type="submit" class="btn btn-primary" value="Input">
    </form>
</body>


</html>
