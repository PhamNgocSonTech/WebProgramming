<%@page import="vn.baimau.b1.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
      <h3>Registration Page</h3>
      <form action="${pageContext.request.contextPath}/RegistrationForm" method="POST">
         <table border="0">
            <tr>
               <td>First Name</td>
               <td><input type="text" name="fname" value= "${student.fname}" /> </td>
            </tr>
            <tr>
               <td>Last Name</td>
               <td><input type="text" name="lname" value= "${student.lname}" /> </td>
            </tr>
            <tr>
               <td>Date</td>
               <td><input type="date" name="date" value= "${student.date }" /> </td>
            </tr>
            
            <tr>
               <td>Email</td>
               <td><input type="email" name="email" value= "${student.email }" /> </td>
            </tr>
            
            <tr>
               <td>Mobile Number</td>
               <td><input type="number" name="mobileNum" value= "${student.mobilenum }" /> </td>
            </tr>
            
            <tr>
               <td>Gender</td>
               <td> <input type="radio" name="gioitinh" value="nam">Male</td>
               <td><input type="radio" name="gioitinh" value="nu"> Female </td>
            </tr>
            
            <tr>
               <td>Address</td>
               <td><textarea name="address" cols="50" rows="4" ></textarea> </td>
            </tr>
            
            <tr>
               <td>City</td>
               <td><input type="text" name="city"  value= "${student.city }" >  </td>
            </tr>
            
            <tr>
               <td>Pin code</td>
               <td><input type="number" name="pinCode"  value= "${student.pincode }"> </td>
            </tr>
            
            <tr>
               <td>State</td>
               <td><input type="number" name="mobileNum" value= "${student.state }" /> </td>
            </tr>
            
            <tr>
               <td>Hobbies</td>
             </tr>
             
             <tr>
             	<td><input type="checkbox"  name="ck" value="Drawing">Drawing </td>
             	
             </tr>
             
             <tr> 
             	<td><input type="checkbox"  name="ck" value="Singing"> Singing</td>
              
             </tr>
             
             <tr> 
             	<td><input type="checkbox" name="ck" value="Dancing">Dancing </td>
               
             </tr>
             
             <tr> 
             	<td><input type="checkbox"  name="ck" value="Sketching">Sketching </td>
               
             </tr>
             
             <tr> 
             	<td><input type="checkbox"  name="ck" value="Other"> Other </td>
               	<td><input type="text" name="ck"> </td>
             </tr>
             
             
             
               
            <tr>
               <td> Course</td>
               
            </tr>
            
            <tr> 
            	<td><input type="radio" name="course" > B.Com </td>
           </tr>
           
           <tr> 
            	<td><input type="radio" name="course" > B.Sc </td>
           </tr>
           
           <tr> 
            	<td><input type="radio" name="course" > B.A </td>
           </tr>
               
            <tr>
               <td colspan ="2">
                  <input type="submit" value= "Submit" />
                  <input type="reset" value= "Reset" />
                  <a href="${pageContext.request.contextPath}/">Cancel</a>
               </td>
            </tr>
            
         </table>
      </form>


      

</body>
</html>