var app = angular.module("googleMap", []);

app.controller("HomeController", function($scope, $window) {

    $window.navigator.geolocation.getCurrentPosition(function(position) {
        var lat = position.coords.latitude;
        var lng = position.coords.longitude;
        var geocoder;
		$scope.state = "";
        geocoder = new google.maps.Geocoder();
        var latlng = new google.maps.LatLng(lat, lng);
        geocoder.geocode({
                'latLng': latlng
            },
            function(results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    if (results[0]) {
                        var add = results[0].formatted_address;
                        var value = add.split(",");
                        count = value.length;
                        country = value[count - 1];
                        state_pincode = value[count - 2];
						res_state = state_pincode.split(" ");
						state = res_state[1];
                        city = value[count - 3];
						$scope.state=state;
                       alert("state name is: " + $scope.state);
						getStateResponse(state);
                    } else {
                        alert("address not found");
                    }
                } else {
                    alert("Geocoder failed due to: " + status);
                }	
            }		 
        );
		
		function getStateResponse(stateData)
		{
		 // $scope.$apply(function() {
         //   $scope.lat = lat;
          //  $scope.lng = lng;
			$scope.state = stateData
			 alert("state name is: " + $scope.state);
           // });
			//return stateData;
		
		}
      
    });
});