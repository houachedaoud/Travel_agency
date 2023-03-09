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
                  <label for="BUS BRAND" class="label-title">BUS BRAND</label>
                  <input type="text" id="lastname" class="form-input" placeholder="BUS BRAND" name="BB" value="${BusInfos[1]}"/>
                 
                  <label for="BUS MODEL" class="label-title">BUS MODEL</label>
                  <input type="text" id="lastname" class="form-input" placeholder="BUS MODEL" name="BM" value="${BusInfos[2]}"/>
                 
                  <label for="BUS PLACESNUMBER" class="label-title">BUS PLACESNUMBER</label>
                  <input type="number" id="lastname" class="form-input" placeholder="BUS PLACESNUMBER" name="BPN" value="${BusInfos[3]}"/>

                </div>
               
            </div>
            <!-- form-footer -->
            <div class="form-footer">
              <span>* required</span>
              <button type="submit" class="btn" name="FormButton" value="UpdateBus">Update</button>
            </div>
      
          </form>