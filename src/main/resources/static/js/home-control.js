
var pawmdApp = angular.module('pawmdApp', []);

pawmdApp.controller('HomePageCtrl', function ($scope, $http, $window, $rootScope) {

  // $rootScope.$on("CallMy2ControllerMethod", function(event,param1){
  //          $scope.My2ControllerMethod(param1);
  // });
 
  $scope.My2ControllerMethod = function(param1) {
    alert(param1);
  }

  $scope.getBreedInfo = function() {
	  	$http.get("/home/" + $scope.breed_name)
	  		.success(function(data){
		  		$scope.breedInfo = data;
	  	});
  }

  $scope.breedSearch = function() {
	  	$window.location.href = '../search.html';
  }



  function f1(breedName) {
  	alert(breedName);
  }
});