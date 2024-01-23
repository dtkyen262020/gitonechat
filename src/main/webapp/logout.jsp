<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>

    <title>::Sign out::</title>
	<link rel="stylesheet" type="text/css" href="styles.css">
	
    <style media="screen">
      *,
*:before,
*:after{
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}
body{
    background-color: #080710;
}
.background{
    width: 430px;
    height: 520px;
    position: absolute;
    transform: translate(-50%,-50%);
    left: 50%;
    top: 50%;
}
.background .shape{
    height: 200px;
    width: 200px;
    position: absolute;
    border-radius: 50%;
}
.shape:first-child{
    background: linear-gradient(
        #1845ad,
        #23a2f6
    );
    left: -80px;
    top: -80px;
}
.shape:last-child{
    background: linear-gradient(
        to right,
        #ff512f,
        #f09819
    );
    right: -30px;
    bottom: -80px;
}




::placeholder{
    color: #e5e5e5;
}



    </style>
  </head>

  <body>
<% session.invalidate();%>
<center>
<h1 style="color:white">You are currently Signed out<br>
<a href="http://localhost:8090/OneChat" style="color:white">Login</a> to continue..
</h1>
</center>
  </body>
</html>