<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <form class="signup-form" action="../../DriversCRUD" method="post">

            <!-- form header -->
            <div class="form-header">
              <h1>Select Driver</h1>
            </div>
      
            <!-- form body -->
            <div class="form-body">
      
              <!-- Firstname and Lastname -->
                <div class="formitems">
              
                  <label class="label-title" >Select Drivers ID To Update</label>
                  <select class="form-input" id="level" name="DriverIdsToUpdate">
                    <c:forEach var="selectidToUpdate" items="${DriverIdsToDelete}"><option >${selectidToUpdate}</option></c:forEach>
                  </select>
                  
                </div>
               
            </div>
            <!-- form-footer -->
            <div class="form-footer">
              <span>* required</span>
              <button type="submit" class="btn" value="selectedToUpdateDriver" name="FormButton">Select</button>
            </div>
      
          </form>