<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <form class="signup-form" action="../../TripsCRUD" method="post">

            <!-- form header -->
            <div class="form-header">
              <h1>Update Trip</h1>
            </div>
      
            <!-- form body -->
            <div class="form-body">
      
              <!-- Firstname and Lastname -->
                <div class="formitems">
                
                  <label for="firstname" class="label-title">Departure Date </label>
                  <input type="date" id="firstname" class="form-input" placeholder="enter your first name" required="required" name="departureDateInput" value="${departureDate}"/>
                  <label for="lastname" class="label-title">Period</label>
                  <input type="text" id="lastname" class="form-input" placeholder="by hours" name="periodInput" value="${period}"/>
    
              <!-- Destination bus Driver -->
             
                  <label class="label-title" >Destinations</label>
                  <select class="form-input" id="level" name="destinationInput">
                    <c:forEach var="Destinations" items="${destinationArrayList}"><option>${Destinations}</option></c:forEach>
                  </select>
                  <label class="label-title">Bus</label>
                  <select class="form-input" id="level" name="busInput">
                    <c:forEach var="Buses" items="${BusesArrayList}"><option>${Buses}</option></c:forEach>
                  </select>
				  <label class="label-title">Driver</label>
                  <select class="form-input" id="level" name="driverInput">
                    <c:forEach var="Drivers" items="${DriversArrayList}"><option>${Drivers}</option></c:forEach>
                  </select>


                </div>
               
            </div>
            <!-- form-footer -->
            <div class="form-footer">
              <span>* required</span>
              <button type="submit" class="btn" value="Update" name="FormButton">Update</button>
            </div>
      
          </form>