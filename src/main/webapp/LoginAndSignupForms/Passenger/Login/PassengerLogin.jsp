<%@ page import = " jakarta.servlet.RequestDispatcher" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style type="text/css"><%@ include file="PassengerLogin.css" %></style>
    <title>Passenger Login</title>
</head>
<body>

<a href="http://localhost:81/TravelAgency/LoginAndSignupForms/Admin/AdminLogin.jsp" ><button class="learn-more">
  <span class="circle" aria-hidden="true">
  <span class="icon arrow"></span>
  </span>
  <span class="button-text">Admin Login</span>
</button></a>

    <div class="wrapper">
        <div class="container">

          <div class="login">Passenger Login</div>
        
          
          <div class="login-form">
            <form action="../../../PassengerLogin" method="post">
              <input type="text" placeholder="ID" class="input" name="id"><br />
              <input type="password" placeholder="Password" class="input" name="password"><br />
              <input type="submit" value="log in" class="btn">
              <span><a href="http://localhost:81/TravelAgency/LoginAndSignupForms/Passenger/Signup/PassengerSignup.jsp" >Sign up </a></span>
            </form>
           </div>
         
          
        </div>
      </div>
    


    
</body>
</html>