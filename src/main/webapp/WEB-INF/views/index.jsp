<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>


<head>
    <style>
        * {
            box-sizing: border-box;
        }

        .wrapper {
            width: 100%;
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .autho__wrapper {
            display: flex;
            flex-direction: column;
            width: 300px;
        }

        .autho__caption {
            text-align: center;
            font-family: sans-serif;
            font-size: 24px;
            margin-bottom: 15px;
        }

        .autho__input-wrapper {
            display: flex;
            flex-direction: column;
            margin-bottom: 10px;
        }

        .autho__input {
            width: 100%;
            padding: 5px 15px;
            outline: none;
            border-radius: 3px;
            border: 1px solid #D3D3D3;
            font-size: 17px;
        }

        .autho__input--login {
            margin-bottom: 10px;
        }

        .autho__btn-wrapper {
            display: flex;
            flex-direction: column;
        }

        .autho__btn {
            width: 100%;
            padding: 5px;
            background: #32CD32;
            border-radius: 3px;
            border: 0;
            font-size: 17px;
            color: #fff;
            transition: 300ms;
        }
        
        .autho__btn:hover {
            background: #228B22;
        }

        .autho__btn--login {
            margin-bottom: 10px;
        }
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <%--<link rel="stylesheet" href="css/main.css">--%>
    <title>Hello</title>
</head>
    <body>
        <div class="wrapper">
            <form action="" class="autho">
                <div class="autho__wrapper">
                    <h2 class="autho__caption">Caption</h2>
                    <div class="autho__input-wrapper">
                        <input type="text" name="mainLogin" class="autho__input autho__input--login" placeholder="Username">
                        <input type="password" name="mainPassword" class="autho__input autho__input--password" placeholder="Password">
                    </div>
                    <div class="autho__btn-wrapper">
                        <button class="autho__btn autho__btn--login">Login</button>
                        <button class="autho__btn autho__btn--register">Register</button>
                    </div>
                </div>
            </form>
            <li><a href="${pageContext.request.contextPath}/person">Persons</a></li>
            <li><a href="${pageContext.request.contextPath}/address">Address</a></li>
            <li><a href="${pageContext.request.contextPath}/contacts">Contacts</a></li>
            <li><a href="${pageContext.request.contextPath}/job">Jobs</a></li>
        </div>
</body>
</html>