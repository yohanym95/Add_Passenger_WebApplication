<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Resources/css/stylejsp.css">

<title>Sri Lankan AirLines</title>

</head>
<body>
   <div class="header">
   <center><h2>|Welcome to Sri Lankan AirLines|</h2></center>
   <br>
   </div>
   <hr> 
   
   <div class="container">
   
   <div class="Tittle" ><center><b>Add a Passenger</b></center></div>
   <br>
   
   <%
   if(request.getAttribute("errors")!= null){
  %>
   <fieldset>
   <legend style="text-align:center">Errors</legend>
   <ul>
   <%
    if(request.getAttribute("first name error")!= null){
   %> 	
    
    <li class="error">First Name Error</li>
    
    <%	
    }
   %>
   
      <%
    if(request.getAttribute("last name error")!= null){
   %> 	
    
    <li class="error">Last Name Error</li>
    
    <%	
    }
   %>
   
    <%
    if(request.getAttribute("date format error")!= null){
   %> 	
    
    <li class="error">Date Format Error</li>
    
    <%	
    }
   %>
   
    <%
    if(request.getAttribute("age error")!= null){
   %> 	
    
    <li class="error">age error</li>
    
    <%	
    }
   %>
   </ul>

   </fieldset>
  
	<%   
   }
   %>

   <div class="formstyle">
   <fieldset>
   
   <legend style="text-align:center" >Passenger Deatils</legend>
   <form action="Passenegers" method="post">
   
   <div class="inputfield">
   <label for="first-name" class="inputlabel">First Name :</label>
   <input name="first-name" type="text" >
  
   </div> 
   
   <div class="inputfield">
   <label for="Last-name" class="inputlabel">Last Name   :</label>
   <input name="Last-name" type="text" >
   
   </div> 
   
   <div class="inputfield">
   <label for="dob" class="inputlabel">Date Of Birth :</label>
   <input name="dob" type="text" >
  
   </div> 
   
   <div class="inputfield">
   <label for="age" class="inputlabel">Age   :</label>
   <input name="age" type="text" >
   
   </div> 
   
   <div class="inputfield">
   <label for="Gender" class="inputlabel">Gender   :</label>
   <select name="gender">
   <option value="Male">Male</option>
   <option value="Female">Female</option>
   </select>
   </div> 
     
   <center>
   <div class="inputfield" id="submitfield">
   <input id="submitbutton" type="submit" value="Add new Passenger" onclick="alert('Are you sure')"></input>
   </div>
  
   </center>
   </form>
   </fieldset>
   </div>
   
   
   </div>
</body>
</html>