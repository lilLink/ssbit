<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.lillink.parsefourtype.model.Person" %>
<%@ page import="com.lillink.parsefourtype.model.Address" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Add Person</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/person?action=submit" method="post">
            <div id="inputTable" class="form-group">
                <% Person person = (Person)request.getAttribute("person"); %>
                <input type="hidden" id="id" name="id" value="${person != null ? person.getId() : 0}">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="first">First Name</label>
                    <div class="col-sm-4">
                        <input class="form-control" type="text" id="first" name="first" required value="${person.getFirstName()}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="last">Last Name</label>
                    <div class="col-sm-4">
                        <input class="form-control" type="text" id="last" name="last" required value="${person.getLastName()}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="date">Birthdate</label>
                    <div class="col-sm-4">
                        <input class="form-control" type="date" id="date" name="date" required value="${person.getBirthDate()}">
                    </div>
                </div>
                <% Address address = (Address)request.getAttribute("address"); %>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="country">Country</label>
                    <div class="col-sm-4">
                        <input class="form-control" type="text" id="country" name="country" required value="${address.getCountry()}">
                    </div>
                </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="city">City</label>
                        <div class="col-sm-4">
                            <input class="form-control" type="text" id="city" name="city" required value="${address.getCity()}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="street">Street</label>
                        <div class="col-sm-4">
                            <input class="form-control" type="text" id="street" name="street" required value="${address.getStreet()}">
                        </div>
                    </div>
                <div class="form-group row">
                    <div class="col-sm-4">
                        <input class="form-control" type="button" onclick="addContact()" style="width: 100%" value="Add contact">
                    </div>
                </div>
                <c:forEach items="${contacts}" var="contacts">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="email">Email</label>
                    <div class="col-sm-4">
                        <input class="form-control" type="text" id="email" name="email" required value="${contacts.getEmail()}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="number">Phone number</label>
                    <div class="col-sm-4">
                        <input class="form-control" type="text" id="number" name="number" required value="${contacts.getNumber()}">
                    </div>
                </div>
                </c:forEach>
                <div class="form-group row">
                    <div class="col-sm-4">
                        <input class="form-control" type="button" onclick="addWork()" style="width: 100%" value="Add working place">
                    </div>
                </div>
                <c:forEach items="${job}" var="place">
                    <div class=\"form-group\">Working place</div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="begin">Begin</label>
                        <div class="col-sm-4">
                            <input class="form-control" type="date" id="begin" name="begin" required value="${place.getBeginWork()}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="end">End</label>
                        <div class="col-sm-4">
                            <input class="form-control" type="date" id="end" name="end" required value="${place.getEndWork()}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="company">Name Company</label>
                        <div class="col-sm-4">
                            <input class="form-control" type="text" id="company" name="company" required value="${place.getJobCompany()}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="position">Job position</label>
                        <div class="col-sm-4">
                            <input class="form-control" type="text" id="position" name="position" required value="${place.getPosition()}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="skill">Job position</label>
                        <div class="col-sm-4">
                            <input class="form-control" type="text" id="skill" name="skill" required value="${place.getSkill()}">
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="form-group row">
                <input class="form-control col-sm-4" type="submit" id="submit" name="submit" style="width: 100%" value="Submit">
            </div>

        </form>
</body>
    <script type="text/javascript">
        function addWork() {
            var div = $('<div/>').appendTo($('#inputTable'));
            var tr0 = $('<div/>', {class: 'form-group'}).html('Working place').appendTo(div);

            var div1 = $('<div/>', {class: 'form-group row'}).appendTo($(div));
            var label1 = $('<label/>', {class: 'col-sm-2 col-form-label'}).html('Begin').appendTo(div1);
            var div2 = $('<div/>', {class: 'col-sm-4'}).appendTo(div1);
            var input1 = $('<input/>', {class: 'form-control', type: 'date', name: 'begin', required: true}).appendTo(div2);

            var div3 = $('<div/>', {class: 'form-group row'}).appendTo($(div));
            var label2 = $('<label/>', {class: 'col-sm-2 col-form-label'}).html('End').appendTo(div3);
            var div4 = $('<div/>', {class: 'col-sm-4'}).appendTo(div3);
            var input2 = $('<input/>', {class: 'form-control', type: 'date', name: 'end', required: true}).appendTo(div4);

            var div5 = $('<div/>', {class: 'form-group row'}).appendTo($(div));
            var label3 = $('<label/>', {class: 'col-sm-2 col-form-label'}).html('Company').appendTo(div5);
            var div6 = $('<div/>', {class: 'col-sm-4'}).appendTo(div5);
            var input3 = $('<input/>', {class: 'form-control', type: 'text', name: 'company', required: true}).appendTo(div6);

            var div7 = $('<div/>', {class: 'form-group row'}).appendTo($(div));
            var label4 = $('<label/>', {class: 'col-sm-2 col-form-label'}).html('Position').appendTo(div7);
            var div8 = $('<div/>', {class: 'col-sm-4'}).appendTo(div7);
            var input4 = $('<input />', {class: 'form-control', type:'text', name: 'position', required: true}).appendTo(div8);

            var div9 = $('<div/>', {class: 'form-group row'}).appendTo($(div));
            var label5 = $('<label/>', {class: 'col-sm-2 col-form-label'}).html('Skill').appendTo(div9);
            var div10 = $('<label/>', {class: 'col-sm-4'}).appendTo(div9);
            var input5 = $('<input/>', {class: 'form-control', type:'text', name: 'skill', required: true}).appendTo(div10);

            var div11 = $('<div/>', {class: 'form-group row'}).appendTo($(div));
            var div12 = $('<div/>', {class: 'col-sm-4'}).appendTo(div11);
            var btn = $('<input/>', {class: 'form-control', type: 'button', name: 'btn', id: 'btn', value: 'Delete'}).appendTo(div12);
            btn.click(function () {
                div.remove();
            });
        }
        function addContact() {
            var div = $('<div/>').appendTo($('#inputTable'));
            var tr0 = $('<div/>', {class: 'form-group'}).html('Contact').appendTo(div);

            var div1 = $('<div/>', {class: 'form-group row'}).appendTo($(div));
            var label1 = $('<label/>', {class: 'col-sm-2 col-form-label'}).html('Email').appendTo(div1);
            var div2 = $('<div/>', {class: 'col-sm-4'}).appendTo(div1);
            var input1 = $('<input/>', {class: 'form-control', type: 'text', name: 'email', required: true}).appendTo(div2);

            var div3 = $('<div/>', {class: 'form-group row'}).appendTo($(div));
            var label2 = $('<label/>', {class: 'col-sm-2 col-form-label'}).html('Number').appendTo(div3);
            var div4 = $('<div/>', {class: 'col-sm-4'}).appendTo(div3);
            var input2 = $('<input/>', {class: 'form-control', type: 'text', name: 'number', required: true}).appendTo(div4);

            var btn = $('<input/>', {class: 'form-control', type: 'button', name: 'btn', id: 'btn', value: 'Delete'}).appendTo(div);
            btn.click(function () {
                div.remove();
            });
        }
    </script>
</html>
