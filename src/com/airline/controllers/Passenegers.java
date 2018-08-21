package com.airline.controllers;




import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.passenger;
import com.airline.models.Gender;



/**
 * Servlet implementation class Passenegers
 */
@WebServlet("/Passenegers")
public class Passenegers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Passenegers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
	RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/Passengeerform.jsp");
		
    view.forward(request, response); 
    
	
	
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  passenger p = new passenger();
      request.setAttribute("errors", false);
	  String firstname = request.getParameter("first-name");
	  System.out.println("firstname :" +firstname); 
	  
	  if(firstname.length()== 0){
		  System.out.println("empty first name error");
		  request.setAttribute("errors", true);
		  request.setAttribute("first name error", true);
		  
		  
		  
	  }else{
		  p.setFirstName(firstname);
	  }
	  
	  String lastname = request.getParameter("Last-name");
	  System.out.println("lastname :" +lastname);
	  
	  if(lastname.length()== 0){
		  System.out.println("empty last name error");
		  request.setAttribute("errors", true);
		  request.setAttribute("last name error", true);
		  
	  }else{
		  p.setLastName(lastname);
	  }
	  
	  String dob = request.getParameter("dob");
	  
	  String dobarr[]= dob.split("\\/");
	  
	  String pattern ="^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
	  
	  Pattern r = Pattern.compile(pattern);
	  Matcher m = r.matcher(dob);
	  
	  String month = dobarr[0];
	  String day = dobarr[1];
	  String year = dobarr[2]; 
	  
	  if(m.find()){

		  
		  Calendar cal = Calendar.getInstance();
		  
		  cal.set(Calendar.YEAR, Integer.parseInt(year));
		  cal.set(Calendar.MONTH, Integer.parseInt(month));
		  cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
		  
		  Date dob1 = cal.getTime(); 
		  
		  System.out.println(dob1);
		  p.setDob(dob1);
		  
		  
	  }else{
		 System.out.println("Invalid date of birth");
		 request.setAttribute("errors", true);
		 request.setAttribute("date format error", true);
		 
	  }
	  
	  
	  

	  
	  String age = request.getParameter("age"); 
	  
	  int age1 = Integer.parseInt(age);
	  
	  if(age1 == 0){
		  System.out.println("empty age error");
		  request.setAttribute("errors", true);
		  request.setAttribute("age error", true);
		  
	  }else{
		  System.out.println(age1);
		  p.setAge(age1);
	  }
	   
	  String gender = request.getParameter("gender");
	  System.out.println("Gender :" +gender);
	  p.setGender(Gender.valueOf(gender)); 
	  
	  if((Boolean)request.getAttribute("errors")){
		  RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/Passengeerform.jsp");
		  view.forward(request, response);
		  
	  }else{
		  ServletContext sc = this.getServletContext(); 
		  
		 //only one thread can acess at time one servlet one menthod.
		   synchronized(this){
		  ArrayList <passenger> plist = (ArrayList<passenger>) sc.getAttribute("passenger");
		  
		  plist.add(p);
		  
		  sc.setAttribute("passenger", plist); 

		  
		   }
		  response.sendRedirect(""); 
		  	 
	  }

	}

}
