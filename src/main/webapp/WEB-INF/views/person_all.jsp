<%@ page import="com.lillink.parsefourtype.model.Address" %>
<%@ page import="com.lillink.parsefourtype.model.Contact" %>
<%@ page import="com.lillink.parsefourtype.model.Job" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>All Person</title>
</head>
<body>
<div class="generic-container">
    <jsp:useBean id="person" scope="request" type="com.lillink.parsefourtype.model.Person"/>
    <div class="well lead">All info about employee</div>
    <form method="post" action="${pageContext.request.contextPath}/person_all?action=submit" class="form-horizontal">
        <input type="hidden" path="id" id="id"/>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="first">First Name</label>
                <div class="col-md-7">
                    <input type="text" path="first"  id="first" disabled name="first" value="${person.firstName}"
                           placeholder="${person.firstName}" class="form-control input-sm"/>
                    <div class="has-error">
                        <errors path="first" class="help-inline"></errors>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="last">Last Name</label>
                <div class="col-md-7">
                    <input type="text" path="last"  id="last" disabled name="last"
                           value="${person.lastName}" placeholder="${person.lastName}"
                           class="form-control input-sm"/>
                    <div class="has-error">
                        <errors path="last" class="help-inline"></errors>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="date">Date of Birth</label>
                <div class="col-md-7">
                    <input type="date" path="date"  id="date" disabled name="date"
                           value="${person.birthDate}" placeholder="${person.birthDate}"
                           class="form-control input-sm"/>
                    <div class="has-error">
                        <errors path="date" class="help-inline"></errors>
                    </div>
                </div>
            </div>
        </div>
        <% Contact contacts = (Contact)request.getAttribute("contacts");%>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="number">Phone Number</label>
                <div class="col-md-7">
                    <input type="text" path="number" id="number" disabled name="number"
                           value="${contacts.getNumber()}" placeholder="${contacts.getNumber()}"
                           class="form-control input-sm"/>
                    <div class="has-error">
                        <errors path="number" class="help-inline"></errors>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="email">Email</label>
                <div class="col-md-7">
                    <input type="email" path="email"  id="email" disabled name="email" value="${contacts.getEmail()}"
                           placeholder="${contacts.getEmail()}" class="form-control input-sm"/>
                    <div class="has-error">
                        <errors path="email" class="help-inline"></errors>
                    </div>
                </div>
            </div>
        </div>
        <% Address address = (Address)request.getAttribute("address");%>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="country">Country</label>
                <div class="col-md-7">
                    <input type="text" path="country"  id="country" disabled name="country" required value="${address.getCountry()}"
                           class="form-control input-sm"/>
                    <div class="has-error">
                        <errors path="country" class="help-inline"></errors>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="city">City</label>
                <div class="col-md-7">
                    <input type="text" path="city"  id="city" disabled name="city" required value="${address.getCity()}"
                           class="form-control input-sm"/>
                    <div class="has-error">
                        <errors path="city" class="help-inline"></errors>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="street">Country</label>
                <div class="col-md-7">
                    <input type="text" path="street"  id="street" disabled name="street" required value="${address.getStreet()}"
                           class="form-control input-sm"/>
                    <div class="has-error">
                        <errors path="street" class="help-inline"></errors>
                    </div>
                </div>
            </div>
        </div>
        <div class=\"form-group\">Working places</div>
        <% Job job = (Job) request.getAttribute("jobs");%>
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="begin">Begin Work</label>
                    <div class="col-md-7">
                        <input type="text" path="begin"  id="begin" disabled name="begin"
                               value="${job.getBeginWork()}" placeholder="${job.getBeginWork()}"
                               class="form-control input-sm"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="company">Company Name</label>
                    <div class="col-md-7">
                        <input type="text" path="company"  id="company" disabled name="company"
                               value="${job.getJobCompany()}" placeholder="${job.getJobCompany()}"
                               class="form-control input-sm"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="skill">Skill</label>
                    <div class="col-md-7">
                        <input type="text" path="skill"  id="skill" disabled name="skill"
                               value="${job.getSkill()}" placeholder="${job.getSkill()}"
                               class="form-control input-sm"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="position">Position</label>
                    <div class="col-md-7">
                        <input type="text" path="position"  id="position" disabled name="position"
                               value="${job.getPosition()}" placeholder="${job.getPosition()}"
                               class="form-control input-sm"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="end">End Work</label>
                    <div class="col-md-7">
                        <input type="text" path="end"  id="end" disabled name="end"
                               value="${job.getEndWork()}" placeholder="${job.getEndWork()}"
                               class="form-control input-sm"/>
                    </div>
                </div>
            </div>
        <div class="row">
            <div class="form-actions floatLeft">
                <input type="submit" value="Convert to pdf" class="btn btn-success custom-width"/>
                <a href="<c:url value='/convertToYaml?id=${person.id}' />"
                   class="btn btn-success custom-width">Convert to Yaml</a>
            </div>
            <div class="form-actions floatRight">
                <a href="<c:url value='/person' />" class="btn btn-success custom-width">Go Back</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>
