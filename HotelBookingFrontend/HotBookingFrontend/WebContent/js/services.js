App.service('mainService', function($http) {
	this.getData = function() {
		var hotelname=null;
		return $http({
			method : 'GET',
			url : 'http://localhost:8080/hotelbooking/viewHotels',
		})
	}
	
	this.getCities = function() {
		return $http({
			method : 'GET',
			url : 'http://localhost:8080/hotelbooking/viewHotels/cities',
		})
	}
});