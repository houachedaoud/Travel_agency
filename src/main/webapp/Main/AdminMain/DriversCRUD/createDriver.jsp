<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <form class="signup-form" action="../../DriversCRUD" method="post">

            <!-- form header -->
            <div class="form-header">
              <h1>Create Driver</h1>
            </div>
      
            <!-- form body -->
            <div class="form-body">
      
              <!-- Firstname and Lastname -->
                <div class="formitems">
                  <label for="driversecuritynumber" class="label-title">Driver Security Number</label>
                  <input type="number" id="firstname" class="form-input" placeholder="enter security number" required="required" name="driverSecurityNumber" />
                 
                  <label for="firstname" class="label-title">First name</label>
                  <input type="text" id="lastname" class="form-input" placeholder="firstname" name="driverFirstname"/>
                 
                  <label for="lastname" class="label-title">Last name</label>
                  <input type="text" id="lastname" class="form-input" placeholder="lastname" name="driverLastname"/>
                 
                  <label for="address" class="label-title">Address</label>
                  <input type="text" id="lastname" class="form-input" placeholder="address" name="driverAddress"/>

                </div>
               
            </div>
            <!-- form-footer -->
            <div class="form-footer">
              <span>* required</span>
              <button type="submit" class="btn" name="FormButton" value="createDriver">Create</button>
            </div>
      
          </form>