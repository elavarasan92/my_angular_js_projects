// Code goes here
angular.module('list', []);

function ListCtrl($scope, $http) {
  $http({
    method: 'GET',
    url: 'json_price_1.json'
  }).success(function(data) {
    $scope.states = data.states; // response data
    $scope.districts = [];
    $scope.placeOfInterests = [];
    angular.forEach(data.states, function(state, index) {
      if(state.state_name=="Maharashtra"){
      angular.forEach(state.districts, function(district, index) {
        $scope.districts.push(district);
		if(district.district_name=="Aurangabad"){
        angular.forEach(district.placeOfInterests, function(placeOfInterest, index) {
		//alert("place of interest"+placeOfInterest.spotName);
        $scope.placeOfInterests.push(placeOfInterest);
		
      });
	  }
      });
       }
    });
  });
}