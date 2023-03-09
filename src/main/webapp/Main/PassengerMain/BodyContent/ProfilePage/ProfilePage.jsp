<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<div class="profile">
            <img src="../Others/picture.jpg" alt="" width="150" height="150" id="profilePicture">

            <div class="name" id="fullname">
                <%= (String)session.getAttribute("firstname") %> <%= (String)session.getAttribute("lastname") %> 
            </div>
            <div class="id" id="id">
                <%= session.getAttribute("Passenger_ID") %>
            </div>
        </div>


    <div class="main">
        <h2>IDENTITY</h2>
        <div class="cardy">
            <div class="card-body">
                <table>

                        <tr>
                            <td>ID</td>
                            <td>:</td>
                            <td id="id"><%= session.getAttribute("Passenger_ID") %></td>
                        </tr>

                        <tr>
                            <td>Firstname</td>
                            <td>:</td>
                            <td id="firstname"><%= (String)session.getAttribute("firstname") %></td>
                        </tr>
                        <tr>
                            <td>Lastname</td>
                            <td>:</td>
                            <td id="lastname"><%= (String)session.getAttribute("lastname") %> </td>
                        </tr>

                        <tr>
                            <td>Email</td>
                            <td>:</td>
                            <td id="email"><%= (String)session.getAttribute("email") %></td>
                        </tr>
                        <tr>
                            <td>Phone Number</td>
                            <td>:</td>
                            <td id="phoneNumber"><%= (String)session.getAttribute("phoneNumber") %></td>
                        </tr>
                    
                </table>
            </div>
        </div>


    </div>