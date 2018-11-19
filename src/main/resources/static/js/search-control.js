
var pawmdApp = angular.module('pawmdApp', []);

pawmdApp.controller('SearchPageCtrl', function ($scope, $http, $window) {

	$scope.loadBreedList = function() {
	  	$http.get("/search")
	  		.success(function(data){
		  		$scope.breedList = data;
	  	});
	}

	$scope.clickIn = function(breed_name){
	    
	    $http.get("/breedImageURL/" + breed_name)
	  		.success(function(data){
		  		$scope.breedNameAndURL = data;
	  	});
	};
	
	
	$scope.loadBreedList();
	
});
