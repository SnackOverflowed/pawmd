
var pawmdApp = angular.module('pawmdApp', []);

pawmdApp.controller('SearchPageCtrl', function ($scope, $http, $window) {

  $scope.loadBreedList = function() {
	  	$http.get("/search")
	  		.success(function(data){
		  		$scope.breedList = data;
	  	});
  }

  $scope.loadBreedList();
});