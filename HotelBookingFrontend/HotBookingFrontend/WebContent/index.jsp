<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="mainApp">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		
		<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
		<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script> 
		<script src="js/angular.min.js"></script>	
		<script src="js/angular-ui-router.js"></script>	
		
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">
		
		<script src="js/route.js"></script>
		<script src="js/index.js"></script>	
		<script src="js/services.js"></script>	
		<script src="js/bookRoom.js"></script>	
		<script src="js/finalPage.js"></script>	
		<script src="js/viewHotels.js"></script>	
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		  	<link rel="stylesheet" href="css/index.css"/>
		<link rel="stylesheet" href="css/firstPage.css"/>
		<link rel="stylesheet" href="css/bookRoom.css"/>
		<link rel="stylesheet" href="css/finalPage.css"/>
	
	</head>
	<body ng-controller="mainController" class="mainBody">
	
		<div class="container-fluid" ui-view>	</div>
					
	</body>
</html>