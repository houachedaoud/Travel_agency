<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
 <head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Dashboard</title>
   <link rel="stylesheet" href="AdminMain.css">
   
  <link rel="stylesheet" href="TripsCRUD/createTrip.css">
  
  
</head>
 <body>
    <div class="sidebar">
        <center><img src="../Others/pic.jpg" alt="Logo" class="Logo"></center>
        <ul>
          <li>
            <a href="#" class="sub-menu-opener"><button class="MainButton"> Trip </button></a>
            <ul><form action="../../TripsCRUD" method="post">
                <li><button class="subButton" name="TripCRUDButton" value="Create Trip">Create Trip<div class="arrow-wrapper"><div class="arrow"></div></div></button></li>
                <li><button class="subButton" name="TripCRUDButton" value="SelectIDToUpdate">Update Trip<div class="arrow-wrapper"><div class="arrow"></div></div></button></li>
                <li><button class="subButton" name="TripCRUDButton" value="Delete Trip">Delete Trip<div class="arrow-wrapper"><div class="arrow"></div></div></button></li>
           </form></ul> 
          </li>
          <li>
            <a href="#" class="sub-menu-opener"><button class="MainButton"> Driver </button></a>
            <ul><form action="../../DriversCRUD" method="post">
                <li><button class="subButton" name="DriverCRUDButton" value="Create Driver">Create Driver<div class="arrow-wrapper"><div class="arrow"></div></div></button></li>
                <li><button class="subButton" name="DriverCRUDButton" value="Select Driver">Update Driver<div class="arrow-wrapper"><div class="arrow"></div></div></button></li>
                <li><button class="subButton" name="DriverCRUDButton" value="Delete Driver">Delete Driver<div class="arrow-wrapper"><div class="arrow"></div></div></button></li>
              </form></ul>
          </li>
          <li>
            <a href="#" class="sub-menu-opener"><button class="MainButton"> Bus </button></a>
            <ul><form action="../../BusesCRUD" method="post">
                <li><button class="subButton" name="BusCRUDButton" value="Create Bus">Create Bus<div class="arrow-wrapper"><div class="arrow"></div></div></button></li>
                <li><button class="subButton" name="BusCRUDButton" value="Update Bus">Update Bus<div class="arrow-wrapper"><div class="arrow"></div></div></button></li>
                <li><button class="subButton" name="BusCRUDButton" value="Delete Bus">Delete Bus<div class="arrow-wrapper"><div class="arrow"></div></div></button></li>
              </form></ul>
          </li>
          <li>
            <a href="#" class="sub-menu-opener"><button class="MainButton"> Destination </button></a>
            <ul><form action="../../DestinationsCRUD" method="post">
                <li><button class="subButton" name="DestinationCRUDButton" value="Create Destination">Create Destination<div class="arrow-wrapper"><div class="arrow"></div></div></button></li>
                <li><button class="subButton" name="DestinationCRUDButton" value="Update Destination">Update Destination<div class="arrow-wrapper"><div class="arrow"></div></div></button></li>
                <li><button class="subButton" name="DestinationCRUDButton" value="Delete Destination">Delete Destination<div class="arrow-wrapper"><div class="arrow"></div></div></button></li>
              </form></ul>
          </li>
        </ul>
      </div>

      <div class="main" id="main">
      
       <% String Content = (String)session.getAttribute("includeForm"); %>
       <%if("create".equals(Content)){ %>
		<%@ include file="TripsCRUD/createTrip.jsp" %>
		<%}else if("delete".equals(Content)){ %>
		<%@ include file="TripsCRUD/deleteTrip.jsp" %>
		<%}else if("selectidtoupdate".equals(Content)){ %>
		<%@ include file="TripsCRUD/selectIDToUpdate.jsp" %>
		<%}else if("Update".equals(Content)){ %>
		<%@ include file="TripsCRUD/updateTrip.jsp" %>
		<%}else if("createDriver".equals(Content)){ %>
		<%@ include file="DriversCRUD/createDriver.jsp" %>
		<%}else if("selectDriver".equals(Content)){ %>
		<%@ include file="DriversCRUD/selectDriverIdToUpdate.jsp" %>
		<%}else if("UpdateDriver".equals(Content)){ %>
		<%@ include file="DriversCRUD/updateDriver.jsp" %>
		<%}else if("deleteDriver".equals(Content)){ %>
		<%@ include file="DriversCRUD/deleteDriver.jsp" %>
		<%}else if("createBus".equals(Content)){ %>
		<%@ include file="BusesCRUD/createBus.jsp" %>
		<%}else if("selectBus".equals(Content)){ %>
		<%@ include file="BusesCRUD/selectBusToUpdate.jsp" %>
		<%}else if("updateBus".equals(Content)){ %>
		<%@ include file="BusesCRUD/updateBus.jsp" %>
		<%}else if("deleteBus".equals(Content)){ %>
		<%@ include file="BusesCRUD/deleteBus.jsp" %>
		<%}else if("createDestination".equals(Content)){ %>
		<%@ include file="DestinationsCRUD/createDestination.jsp" %>
		<%}else if("selectUpdateDestination".equals(Content)){ %>
		<%@ include file="DestinationsCRUD/selectDestinationToUpdate.jsp" %>
		<%}else if("updateDestination".equals(Content)){ %>
		<%@ include file="DestinationsCRUD/updateDestination.jsp" %>
		<%}else if("deleteDestination".equals(Content)){ %>
		<%@ include file="DestinationsCRUD/deleteDestination.jsp" %>
		<%} %>
		
		
		
		
		
      
      </div>
      
      
<script src="AdminMain.js"></script>

 </body>
</html>
