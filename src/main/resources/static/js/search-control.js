var pawmdApp = angular.module('pawmdApp', []);

pawmdApp.controller('SearchPageCtrl', 

	function ($scope, $http, $window, $rootScope) {

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

	$scope.getInfoForDog = function(breed_name) {

		$scope.f1(breed_name);
		//$rootScope.$emit("CallMy2ControllerMethod", {message: 'in search'});
		// console.log("in search " + breed_name);
		// $scope.$broadcast('parentmethod', { message: "gell" });
		//$window.location = '../home.html#searchInfo';
	    
	};


	function searchDogsList()
 	{
	    // Declare variables
	    var input, filter, ul, li, a, i;
	    input = document.getElementById('breedInput');
	    filter = input.value.toUpperCase();
	    ul = document.getElementById("myUL");
	    li = ul.getElementsByTagName('li');

	    // Loop through all list items, and hide those who don't match the search query
	    for (i = 0; i < li.length; i++) {
	        a = li[i].getElementsByTagName("a")[0];
	        if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
	            li[i].style.display = "";
	        } else {
	            li[i].style.display = "none";
	        }
	    }
	}

	$scope.loadBreedList();
	
});


