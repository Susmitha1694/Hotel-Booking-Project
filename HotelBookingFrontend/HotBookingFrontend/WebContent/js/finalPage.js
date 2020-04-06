App.controller("finalPageController",function($scope,$rootScope,mainService,$http,$filter,$state){

	$scope.mainObject={};
	$scope.mainObject.city=$scope.hotelObject.hotelCity;
	var finalObject ={};
	var roomTariff = $scope.hotelObject.trariffPerRoom;
	var cityData = null;
	$scope.changedData = [];
	var checkinval;
	$scope.hotel;
	console.log($scope.hotelObject.hotelName);
	mainService.getData().success(function(dataResponse) {
		console.log(dataResponse);
		$scope.data = dataResponse;
		var i = 0;
		var k = 0;
		for (i = 0; i < $scope.data.length; i++) {
			if ($scope.data[i].hotelCity == $scope.mainObject.city) {
				
				$scope.changedData[k] = $scope.data[i];
				k++;
			}
		}	   
	}).error(function(dataResponse) {
		alert("sorry!!! no data");
	});
	
	mainService.getCities().success(function(dataResponse) {
		console.log(dataResponse);
		$scope.cityData = dataResponse;
	}).error(function(dataResponse) {
		alert("sorry!!! no data");
	});
	
	$(function(){
		 $("#datepicker" ).datepicker({		      
			dateFormat: "yy-mm-dd",
		    minDate:"0+1",
		    maxDate: "2years",
		    changeMonth:true, 
		    changeYear:true,	 
	    });
	  /*$scope.select=function(date_text,inst){
          var from = new Date(date_text);
          z$scope.mainObject.checkOutDate = from;
          $scope.$apply();
          $( "#datepicker1" ).datepicker( "option", "minDate",from);
         
      }*/
	 })
	 
	 $(function(){
		$("#datepicker1" ).datepicker({
	        dateFormat: "yy-mm-dd",
	        minDate:"0+1",
	        maxDate: "2years",
	        changeMonth:true, 
	        changeYear:true,    
    });
	/*$scope.select=function(date_text,inst){
        var from = new Date(date_text);
        $( "#datepicker" ).datepicker( "option", "minDate",from);
    }   */    

	 })
	
	$scope.changeCity = function() {

		var i = 0;
		var k = 0;
		$scope.changedData = [];
	
		for (i = 0; i < $scope.data.length; i++) {
			if ($scope.data[i].hotelCity == $scope.mainObject.city) {	
				
				$scope.changedData[k] = $scope.data[i];
				k++;
			}
		}
		 console.log("hotel name selected "+$scope.mainObject.city);
	}
	 $scope.clear=function()
	 {
		 $scope.hotelObject.hotelName="";
		   $scope.mainObject.city="";
		    $scope.mainObject.checkInDate=null;
		    $scope.mainObject.checkOutDate=null;
		    $scope.mainObject.noOfRoomsBooked="";
	 }
	 
	$scope.submit= function()
	{	
		var pickIndate = new Date($scope.mainObject.checkInDate);   
	    var pickUpDate = new Date($scope.mainObject.checkOutDate);
	    
		if(typeof $scope.mainObject.checkInDate == 'undefined')
    	{
    	alert("please fill the check in date field");
    	}
		else if(typeof $scope.mainObject.checkOutDate == 'undefined')
	    	{
	    	alert("please fill the check out date field");
	    	}
		 else if($scope.mainObject.noOfRoomsBooked<1 || typeof $scope.mainObject.noOfRoomsBooked == 'undefined')
	    		alert("enter a valid room number");
		
	   
		 else if(pickUpDate<pickIndate)
	    	{
	    	alert("checkout date should be greater than the checkin date");	    	
	    	}
	   
	    else 
	    	{
	    	   var noOfDays = Math.ceil((pickUpDate - pickIndate) / (1000 * 60 * 60 * 24));
	    	   var finalAmount =  $scope.mainObject.noOfRoomsBooked *roomTariff *noOfDays;
	    	   console.log(finalAmount);
	    	   $scope.mainObject.hotelName = $scope.hotelObject.hotelName;
	    	   $scope.mainObject.totalAmount = finalAmount;	    	   
			   finalObject = $scope.mainObject;		
			   console.log(finalObject);
			    $http({
					method : 'POST',
					url : 'http://localhost:8080/hotelbooking/booking/saveReservation',
					data : finalObject,
					headers: {'Content-Type': 'application/json'}
					
				}).success(function(response) {
					if(response.result=="fail")
						alert("Sorry! No Rooms Available in "+finalObject.hotelName);
					else if(response.result=="success"){
						/*var finalAmount =  finalObject.noOfRoomsBooked *roomTariff *noOfDays;*/
						alert("Rooms booked Successfully. Amount to be Paid would " +
								"be "+finalAmount+" the unique id is "+response.id+" please remeber the id.");
					}
				}).error(function(response) {
					console.log(response)
				});			 
			    $state.go('firstPage');
	    	}
		/*$state.go('firstPage');*/
	}	
})