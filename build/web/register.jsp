<%-- 
    Document   : register
    Created on : Jun 9, 2024, 10:27:06 PM
    Author     : LENOVO
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='./css/register.css'>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Josefin+Sans:ital,wght@0,100..700;1,100..700&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');
        </style>
        <title>SIGN UP</title>
    </head>
    <body>
        <div class="wrapper-register">
        <h1>Sign Up</h1>
        <form action="MainController" method="POST">
            
            <div class="input-box">
                <input type="text" required name="txtUserName"> 
                <label>User Name</label>
                <i class='bx bxs-user'></i>
            </div>
            <div class="input-box">
            <input type="password" required name="txtPassword"> 
                <label>Password</label>
                <i class='bx bxs-lock-alt'></i>
            </div>
            <div class="input-box">
                <input type="text" required name="txtFirstName"> 
                <label>First Name</label>
                <i class='bx bxs-user'></i>
            </div>
            <div class="input-box">
                <input type="text" required name="txtLastName"> 
                <label>Last Name</label>
                <i class='bx bxs-user'></i>
            </div>
            
            <div class='input-box'>
                <input type="text" required name="phoneNumber"> 
                <label>Phone Number</label>
                <i class='bx bxs-phone' ></i>
                </div>
                
            <button type="submit" class="btn" name="btAction" value="Register">Sign Up</button>
            
            <div class="longin-link">
                p>Already have an account? 
                <a href="login.html">Login</a></p>
            </div>
        </form>
        </div>
    </body>
</html>
