<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@page import="java.util.ArrayList"%>

<div class="all">
       <h1 class="tripsheader">Explore ${title} </h1><br>
       <h4 Style="color: ${NoteColor}; font-family: Arial; position: fixed ; top: 180px; left: 5%;">${Note}</h4>
       <div class="containert">
       	
 <c:forEach var="trip" items="${tripData}">
    <form action="../../Enrollment" method="post" id="enrollmentForm">
        <div class="cardt">
          <div class="card-header">
            <img src="../Others/${trip.TR_destination}.jpg" alt="City Picture" />
          </div>
          <div class="card-body">
            <span class="tag tag-purple">${trip.TR_destination} </span>
            <h4 class="sth">
              Trip Infos:
            </h4>
            <div class="infos">
              <h6>ID: <span class="sp" data-id="${trip.TR_id}">${trip.TR_id}</span></h6>
              <h6>Departure Date: ${trip.TR_departureDate}</h6>
              <h6>Period: ${trip.TR_period} Hours</h6>
              <h6>Destination: ${trip.TR_destination}</h6>
              <h6>Free Sits: ${trip.getFreeSits()} Sit</h6>
            <input type="hidden" name="idInput" value="${trip.TR_id}">
            <input type="submit" value="${ButtonValue}" name="enrollButton" class="enrollButton">
            
          <div class="user">
            <img src="../Others/Driver.jpg" alt="Driver">
            <div class="user-info">
            <h5>Driver:</h5>
            <small>${trip.getDR_lastname()} ${trip.getDR_firstname()}</small>
          </div>
          </div>
          </div>
        </div> 
        </div>
    </form>
</c:forEach>

    </div>
    
</div>



