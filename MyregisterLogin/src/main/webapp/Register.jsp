<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<style>
body{

width: 100vw;
height: 100vh;
display: flex;
align-items: center;
justify-content: center;
}

form{
width:500px;
height: 500px;
display: flex;
align-items: center;
justify-content: center;
flex-direction: column;
background-color: #f0f04545;
gap:20px;
}
div{
display: flex;
width: 100%;
margin-left: 50%;
}



</style>
<body>



<form action="reg" method="post">
  <div>
     Name : <input type="text" name="name1"/>
  </div>
  
  <div>
     Email : <input type="text" name="email"/>
  </div>
  
  <div>
     Password: <input type="text" name="pass"/>
  </div>
    
   <div>
     Gender : <input type="radio" name="gender1" value="male"/>Male <input type="radio" name="gender1" value="female"/>Female
   </div>
      
    <div>
     City: <select name="citys">
               <option>Select city</option>
              <option>Delhi</option>
              <option>Mumbai</option>
              <option>Kolkata</option>
              <option>Chennai</option>
          </select>
    </div>
    <input type="submit" value="Register">
</form>

</body>
</html>