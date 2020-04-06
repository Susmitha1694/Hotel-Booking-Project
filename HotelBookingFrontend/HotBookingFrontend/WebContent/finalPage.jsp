<div ng-controller="finalPageController">
	<center>
	<form class="form-group formInFinalPage">
		<label>city : </label>
		<select class="form-control boxInFinalPage" ng-model="mainObject.city" ng-change="changeCity()">
				<option ng-repeat="city in cityData" >{{city}}</option>		
		</select><br/>
	
		
		<label>Hotel : </label>
        <select class="form-control boxInFinalPage" ng-model="hotelObject.hotelName" ng-options="hotel.hotelName as hotel.hotelName for hotel in changedData" ng-change="getTariff()">
        </select><br/>
		   
	    <label>check In Date : </label>
	    <input type="text" id="datepicker" class="form-control boxInFinalPage" ng-model="mainObject.checkInDate" ng-change="getCInDate()"><br/>
	   	   	    	   
	    <label>check out Date : </label>
	    <input type="text" id="datepicker1" class="form-control boxInFinalPage" ng-model="mainObject.checkOutDate" ng-change="getCOutDate()"><br/>
	   	   
	    <label>No Of Rooms :</label>
	    <input type="number" class="form-control boxInFinalPage" ng-model="mainObject.noOfRoomsBooked" min="1"><br/>
	    </form>
	    </center>
	<div class="row" id="buttonsDiv">
	    <input type="button" class="col-sm-1 btn btn-primary buttonInFinalPage" ui-sref="firstPage" value="cancel"> 
	    <input type="submit" class="col-sm-1 btn btn-success buttonInFinalPage" ng-click="submit()" value="submit">
	    <input type="button" class="col-sm-1 btn btn-danger buttonInFinalPage" ng-click="clear()" value="Resest">
	    </div>
	
	
</div>
