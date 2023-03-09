<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style type="text/css"><%@ include file="PassengerSignup.css" %></style>
    <title>Passenger Sign up</title>
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
      
      <div class="signup">Passenger Sign Up</div>
      
       <div class="signup-form">
       <form action="../../../PassengerSignup" method="post">
          <input type="text" placeholder="Firstname" class="input" name="fname"><br />
          <input type="text" placeholder="Lastname" class="input" name="lname"><br />
          <input type="email" placeholder="email" class="input" name="email"><br />
          <p Style="color: red; font-size: 11px;">${EmailError}</p>
          <input type="text" placeholder="Phone Number" class="input" name="phoneNumber"><br />
          <p Style="color: red; font-size: 11px;">${PhoneNumberError}</p>
          <input type="password" placeholder="Choose a Password" class="input" name="password"><br />
          <input type="submit" class="btn" value="Create account">
          <span><a href="http://localhost:81/TravelAgency/LoginAndSignupForms/Passenger/Login/PassengerLogin.jsp">Login</a></span>
       </form>
       </div>
      
      
    </div>
  </div>


<script type="text/javascript" src="PassengerSignupScript.js" ></script>
</body>
</html>