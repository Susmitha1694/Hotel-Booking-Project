<div ng-controller="viewHotelsController"><br/>
	<label><h3>city :</h3></label>
	<select class="form-control cityInBookRoom" ng-model="cityName" ng-change="changeCity()">
			<option ng-repeat="city in cityData">{{city}}</option>		
	</select><br/>
	<table class="table tableInBookRoom">
		<tr>
			<th scope="row">Hotel Name</th>
			<th scope="row">Star Rating</th>
			<th scope="row">tariff per room</th>
			<th scope="row">total Number of Rooms</th>
		</tr>
		<tr ng-repeat="hotel in changedData | limitTo:5 | orderBy:'trariffPerRoom'" >
			<td>{{hotel.hotelName}}</td>
			<td>{{hotel.hotelStarRating}}</td>
			<td>{{hotel.trariffPerRoom}}</td>
			<td>{{hotel.hotelNoOfRooms}}</td>
		</tr>		
	</table>
</div>