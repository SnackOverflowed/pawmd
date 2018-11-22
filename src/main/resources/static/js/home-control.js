
var pawmdApp = angular.module('pawmdApp', []);
pawmdApp.controller('HomePageCtrl', function ($scope, $http, $window, $rootScope) {

  $scope.getBreedInfo = function() {

    $http.get("/home/" + $scope.breed_name)
        .success(function(data){
          $scope.breedInfo = data;
    });	
  }

  $scope.breedSearch = function() {
	  	$window.location.href = '../search.html';
  }

  $scope.loadBreedInfo = function() {
      $http.get("/getSavedBreedName")
        .success(function(data){ 
            console.log("data " + data);

            if (data !== "") {
                $http.get("/home/" + data)
                  .success(function(data){
                  $scope.breedInfo = data;
                });

                $http.post("/clearName");

            }
        });
  }

  $scope.loadBreedInfo();
});