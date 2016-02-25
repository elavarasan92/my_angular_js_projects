var app = angular.module("oab", []);
app.controller("ApplicationController", function($scope,InitializationService) {
    $scope.firstName = "Elavarasan";
    $scope.lastName = "Natarajan";
	$scope.getPersonDeatils = function(){
	 var response = InitializationService.getDetails();
	}
})