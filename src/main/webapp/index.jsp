<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <body>
  
    <h1>REST from the Browser</h1>
    
    <div style="color:green">${message}</div>
    
    <p>
      <a href="employee/1">GET employee</a>
      <a href="employee/">GET employees</a>
      <br/>
    </p>
        
    <form:form action="/rest/app/browser/resource" method="POST">
      <button type="submit">Post</button> 
      <input type="text" name="id" value="abc">
    </form:form>
   
    <form:form action="employee/1" method="POST">
      <button type="submit">Put</button> 
      <input type="text" name="formfield" value="">
      <input type="hidden" name="_method" value="PUT">
    </form:form>
    
    <form action="employee/1" method="POST">
      <button type="submit">Delete</button>
      <input type="hidden" name="_method" value="DELETE">
    </form>
    
  </body>
</html>
