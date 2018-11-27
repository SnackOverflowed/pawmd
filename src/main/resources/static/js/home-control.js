var pawmdApp = angular.module('pawmdApp', []);

pawmdApp.controller('HomePageCtrl', function ($scope, $http, $window) {

  $scope.getBreedInfo = function() {
	  	$http.get("/home/" + $scope.breed_name)
	  		.success(function(data){
		  		$scope.breedInfo = data;
	  	});
  }

  $scope.breedSearch = function() {
	$window.location.href = './search.html';
  }
  

});