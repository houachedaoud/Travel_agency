<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <form class="signup-form" action="../../DestinationsCRUD" method="post">

            <!-- form header -->
            <div class="form-header">
              <h1>Select Destination</h1>
            </div>
      
            <!-- form body -->
            <div class="form-body">
      
              <!-- Firstname and Lastname -->
                <div class="formitems">
              
                  <label class="label-title" >Select Destination City To Delete</label>
                  <select class="form-input" id="level" name="DestinationCityToDelete">
                    <c:forEach var="selectCity" items="${DC}"><option >${selectCity}</option></c:forEach>
                  </select>
                  
                </div>
               
            </div>
            <!-- form-footer -->
            <div class="form-footer">
              <span>* required</span>
              <button type="submit" class="btn" value="selectedToDeleteDestination" name="FormButton">Select</button>
            </div>
      
          </form>