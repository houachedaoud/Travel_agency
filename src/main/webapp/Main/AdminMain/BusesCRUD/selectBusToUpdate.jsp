<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <form class="signup-form" action="../../BusesCRUD" method="post">

            <!-- form header -->
            <div class="form-header">
              <h1>Select Bus</h1>
            </div>
      
            <!-- form body -->
            <div class="form-body">
      
              <!-- Firstname and Lastname -->
                <div class="formitems">
              
                  <label class="label-title" >Select Bus Registration Number To Update</label>
                  <select class="form-input" id="level" name="busRegistrationNumber">
                    <c:forEach var="selectidToUpdate" items="${BRNAL}"><option >${selectidToUpdate}</option></c:forEach>
                  </select>
                  
                </div>
               
            </div>
            <!-- form-footer -->
            <div class="form-footer">
              <span>* required</span>
              <button type="submit" class="btn" value="selectedToUpdateBus" name="FormButton">Select</button>
            </div>
      
          </form>