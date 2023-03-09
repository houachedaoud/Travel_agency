<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@page import="java.util.ArrayList"%>
	<%@page import="com.Trip"%>

    
    <%  String Content =  (String)session.getAttribute("Content"); %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="PassengerMain.css">
    	<% if("About".equals(Content)){%>
		    <link rel="stylesheet" type="text/css" href="BodyContent/AboutUsPage/AboutUsStyle.css">
		    <title>About Us</title>
		<%}else if("Profile".equals(Content)){ %>
		<link rel="stylesheet" type="text/css" href="BodyContent/ProfilePage/ProfilePageStyle.css">
		<title>Profile</title>
		<%}else if("Trips".equals(Content) || "My Trips".equals(Content)){ %>
		<link rel="stylesheet" type="text/css" href="BodyContent/TripsPage/TripsPageStyle.css">
		<title><%= Content%></title>
		<%}else if("Home".equals(Content) || Content == null){ %>
		<link rel="stylesheet" type="text/css" href="BodyContent/HomePage/HomePageStyle.css">
		<title>Home</title>
		<%} %>
    

    
</head>
<body>




<header class="header">
		  <h1 style="float: left; margin:0;">Travel Agency</h1>
		  <div class="header-right">
		  <form action="../../ContentChanger" method="post">
			<% if("Home".equals(Content) || Content == null){%><input type="submit" value="Home" name="btn"  class="btn active"> 
			<%}else{ %> <input type="submit" value="Home" name="btn"  class="btn"> <%} %>
			<% if("Profile".equals(Content)){%><input type="submit" value="Profile" name="btn" class="btn active">
			<%}else{ %> <input type="submit" value="Profile" name="btn"  class="btn"> <%} %>
			<% if("Trips".equals(Content)){%><input type="submit" value="Trips" name="btn" class="btn active">
			<%}else{ %> <input type="submit" value="Trips" name="btn"  class="btn"> <%} %>
			<% if("My Trips".equals(Content)){%><input type="submit" value="My Trips" name="btn" class="btn active">
			<%}else{ %> <input type="submit" value="My Trips" name="btn"  class="btn"> <%} %>
			<% if("About".equals(Content)){%><input type="submit" value="About" name="btn" class="btn active">
			<%}else{ %> <input type="submit" value="About" name="btn" class="btn "> <%} %>
			<% if("Logout".equals(Content)){%><input type="submit" value="Logout" name="btn" class="btn active">
			<%}else{ %> <input type="submit" value="Logout" name="btn" class="btn "> <%} %>
		  </form>
		  </div>
		</header>
		
		
		
		
		<% if("About".equals(Content)){%>
		<%@ include file="/Main/PassengerMain/BodyContent/AboutUsPage/AboutUs.jsp" %>
		<%}else if("Profile".equals(Content)){ %>
		<%@ include file="/Main/PassengerMain/BodyContent/ProfilePage/ProfilePage.jsp" %>
		<%}else if("Trips".equals(Content) || "My Trips".equals(Content)){ %>
		<%@ include file="/Main/PassengerMain/BodyContent/TripsPage/TripsPage.jsp" %>
		<%}else if("Home".equals(Content) || Content == null){ %>
		<%@ include file="/Main/PassengerMain/BodyContent/HomePage/HomePage.jsp" %>
		<%} %>
		
		
		


		
		

		<footer class="footer-distributed">

			<div class="footer-right">

				<a href="https://www.linkedin.com/" target="_blank"> <img src="../Others/linkedin.png" alt="" class="icons"> </a>
                <a href="https://telegram.org/" target="_blank"> <img src="../Others/telegram.png" alt="" class="icons"> </a>
                <a href="https://twitter.com/" target="_blank"> <img src="../Others/twitter.png" alt="" class="icons"> </a>
                <a href="https://www.facebook.com/" target="_blank"> <img src="../Others/facebook.png" alt="" class="icons"> </a>

			</div>



			<div class="footer-left">

				<p class="footer-links">
					<a class="link-1" href="#">Home</a>

					<a href="#">Blog</a>

					<a href="#">Pricing</a>

					<a href="#">About</a>

					<a href="#">Faq</a>

					<a href="#">Contact</a>
				</p>

				<p>Travel Agency  &copy; 2023</p>
			</div>

		</footer>
		
<script type="text/javascript" src="PassengerMainScript.js"></script>
<script type="text/javascript" src="BodyContent/HomePage/HomePageScript.js"></script>

</body>
</html>