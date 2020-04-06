App.controller("viewHotelsController", function($scope, mainService,$state,$rootScope) {
	var data = null;
	var cityData = null;
	$scope.changedData = [];
	
	mainService.getData().success(function(dataResponse) {
		
		$scope.data = dataResponse;
	}).error(function(dataResponse) {
		alert("sorry!!! no data");
	});

	mainService.getCities().success(function(dataResponse) {
		
		$scope.cityData = dataResponse;
	}).error(function(dataResponse) {
		alert("sorry!!! no data");
	});
	
	$scope.changeCity = function() {
		
		var i = 0;
		var k = 0;
		$scope.changedData = [];
		for (i = 0; i < $scope.data.length; i++) {
			if ($scope.data[i].hotelCity == $scope.cityName) {
		
				$scope.changedData[k] = $scope.data[i];
				k++;
			}
		}
	}
});