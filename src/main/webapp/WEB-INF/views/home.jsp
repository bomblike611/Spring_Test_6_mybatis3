<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<form action="./fileUpload" method="post" enctype="multipart/form-data">
	<input type="file" name="f1">
	<input type="file" name="f1">
	<button>FileUpload</button>
</form>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
