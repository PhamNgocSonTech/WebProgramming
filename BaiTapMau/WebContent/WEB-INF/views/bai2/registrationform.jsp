<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Form</title>
</head>
<body>
<h1> Register Form </h1>

    <div class="header">
        <form action="${pageContext.request.contextPath }/dangki" method="POST">

            <div>
                <input type="text" id="fname" name="fname" placeholder="First Name" value="${user.fname }">

            </div>

            <div>
                <input type="text" id="lname" name="lname" placeholder="Last Name" value="${user.lname }">
            </div>

            <div>
                <input type="email" id="email" name="email" placeholder="Your Email" value="${user.email }">
            </div>

            <div>
                <input type="email" id="email" name="email" placeholder="Re-enter Email">
            </div>

            <div>
                <input type="password" id="pwd" name="pwd" placeholder="New Password" value="${user.password }">
            </div>

            <div>
                <label >Birthday</label><br>
                <input type="date" id="date" name="date" value="${user.date }">
            </div>

            <div>
                <input type="radio" name="gioitinh" id=""> Male
                <input type="radio" name="gioitinh" id=""> Female
            </div>
           
                <input type="submit" value="Sign In"> <span class="btn"></span>

        </form>
    </div>
</body>
</html>