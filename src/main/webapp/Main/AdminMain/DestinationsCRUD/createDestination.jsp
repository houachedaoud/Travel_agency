<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <form class="signup-form" action="../../DestinationsCRUD" method="post">

            <!-- form header -->
            <div class="form-header">
              <h1>Create Destination</h1>
            </div>
      
            <!-- form body -->
            <div class="form-body">
      
              <!-- Firstname and Lastname -->
                <div class="formitems">
                
	                <label for="destinationPicture" class="label-title">Destination Picture</label>
	                <input type="file" id="myFile" name="destinationPicture">
                
                  <label for="destinationCity" class="label-title">Destination City</label>
                  <input type="text" id="firstname" class="form-input" placeholder="enter City" required="required" name="destinationCity" />
                 
                </div>
               
            </div>
            <!-- form-footer -->
            <div class="form-footer">
              <span>* required</span>
              <button type="submit" class="btn" name="FormButton" value="createDestination">Create</button>
            </div>
      
          </form>