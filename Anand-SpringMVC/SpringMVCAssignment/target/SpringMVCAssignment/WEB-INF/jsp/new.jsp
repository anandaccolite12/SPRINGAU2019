<html>
   <head>
      <title>Student Form</title>
   </head>

   <body>
      <h2>Student Information</h2>
      <form method = "POST" action = "/SpringMVCAssignment/addStudent" name="student" modelAttribute="student">
         <table>
            <tr>
               <td><form:label path = "name">Student Name : </form:label></td>
               <td><input name = "studentName" /></td>
            </tr>
            <tr>
               <td><form:label path = "id">Student ID : </form:label></td>
                <td><input name = "studentId" /></td>
            </tr>
            <tr>
               <td><form:label path = "status">Attendence status : </form:label></td>
                <td><input name = "studentStatus" /></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form>
   </body>
   
</html>