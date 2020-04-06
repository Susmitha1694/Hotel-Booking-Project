<div class="container mainDivInBookRoom">
<div ng-controller="bookRoomController">

	<br/>
	<label><h3>city :</h3></label> 
	<select class="form-control cityInBookRoom" ng-model="cityName" ng-change="changeCity()">
		<option value="" disabled selected>----Please Select---</option>
		<option ng-repeat="city in cityData">{{city}}</option>		
	</select><br/>
	
	<table class="table tableInBookRoom">
	
		<tr>
			<th scope="row">Hotel Name</th>
			<th scope="row">Star Rating</th>
			<th scope="row">tariff per room</th>
			<th scope="row">Book Room</th>
		</tr>		
		<tr ng-repeat="hotel in changedData" >
			<td>{{hotel.hotelName}}</td>
			<td>{{hotel.hotelStarRating}}</td>
			<td>{{hotel.trariffPerRoom}}</td>
			<td><a ng-click="goToBooking(hotel)">click here to book</a></td>
			<td>{{hello}}</td>
		</tr>	
		
	</table>
	
</div>
</div>