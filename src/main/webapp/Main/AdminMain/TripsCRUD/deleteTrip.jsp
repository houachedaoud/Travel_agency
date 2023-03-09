<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <form class="signup-form" action="../../TripsCRUD" method="post">

            <!-- form header -->
            <div class="form-header">
              <h1>Delete Trip</h1>
            </div>
      
            <!-- form body -->
            <div class="form-body">
      
              <!-- Firstname and Lastname -->
                <div class="formitems">
              
                  <label class="label-title" >Select ID To Delete</label>
                  <select class="form-input" id="level" name="tripidInput">
                    <c:forEach var="idToDelete" items="${idsToDelete}"><option>${idToDelete}</option></c:forEach>
                  </select>
                  
                </div>
               
            </div>
            <!-- form-footer -->
            <div class="form-footer">
              <span>* required</span>
              <button type="submit" class="btn" value="Delete" name="FormButton">Delete</button>
            </div>
      
          </form>