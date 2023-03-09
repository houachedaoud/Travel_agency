<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <form class="signup-form" action="../../BusesCRUD" method="post">

            <!-- form header -->
            <div class="form-header">
              <h1>Create Driver</h1>
            </div>
      
            <!-- form body -->
            <div class="form-body">
      
              <!-- Firstname and Lastname -->
                <div class="formitems">
                  <label for="BUS REGISTRATION NUMBER" class="label-title">Bus Registration Number</label>
                  <input type="number" id="firstname" class="form-input" placeholder="BUS REGISTRATION NUMBER" required="required" name="busRegistrationNumber" />
                 
                  <label for="BUS BRAND" class="label-title">First name</label>
                  <input type="text" id="lastname" class="form-input" placeholder="BUS BRAND" name="busBrand"/>
                 
                  <label for="BUS MODEL" class="label-title">Last name</label>
                  <input type="text" id="lastname" class="form-input" placeholder="BUS MODEL" name="busModel"/>
                 
                  <label for="BUS PLACESNUMBER" class="label-title">Address</label>
                  <input type="number" id="lastname" class="form-input" placeholder="BUS PLACESNUMBER" name="busPlacesNumber"/>

                </div>
               
            </div>
            <!-- form-footer -->
            <div class="form-footer">
              <span>* required</span>
              <button type="submit" class="btn" name="FormButton" value="createBus">Create</button>
            </div>
      
          </form>