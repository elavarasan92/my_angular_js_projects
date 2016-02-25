var app = angular.module("googleMap", ['ngStorage']);

app.controller('mapCtrl', function($scope, mapService,$localStorage,$window) {
    $scope.name_of_state = "";
    $scope.district_details = {};
    mapService.getState().then(function(map_data) {
        $scope.map_data = map_data;
        $scope.name_of_state = map_data;
        //console.log($scope.name_of_state);
    });
    mapService.getDetails().then(function(district_datas) {
        $scope.district_datas = district_datas;
        $scope.district_details = district_datas;
        console.log(district_datas);
    });
    $scope.makeArray = function() {
        $scope.district_data = [];
        angular.forEach($scope.district_details.states, function(state, key) {
            if (state.state_name == $scope.name_of_state) {
                angular.forEach(state.districts, function(district, index) {
                    $scope.district_data.push(district);
                   // alert(district.district_name);
                });
            }
        });
    }
	
	$scope.selectedMonument = function()
	{
	//alert("selected monument---"+$scope.placeOfInterest_model.spotName);
	$localStorage.placeOfInterest_object = $scope.placeOfInterest_model;
	console.log($localStorage.placeOfInterest_object);
	$window.open('monument.html','_self');
	}
});

app.controller('monumentCtrl', function($scope, $localStorage) {
	$scope.placeOfInterest_object = $localStorage.placeOfInterest_object;
});
app.factory('mapService', function($q, $http) {
    return {
        getState: function() {
            var defer = $q.defer();
            navigator.geolocation.getCurrentPosition(function(position) {
                lat = position.coords.latitude;
                lng = position.coords.longitude;
                var geocoder;
                geocoder = new google.maps.Geocoder();
                var latlng = new google.maps.LatLng(lat, lng);
                geocoder.geocode({
                        'latLng': latlng
                    },
                    function(results, status) {
                        if (status == google.maps.GeocoderStatus.OK) {
                            var state;
                            if (results[0]) {
                                var add = results[0].formatted_address;
                                var value = add.split(",");
                                count = value.length;
                                //country = value[count - 1];
                                state_pincode = value[count - 2];
                                res_state = state_pincode.split(" ");
                                state = res_state[1];
                                //city = value[count - 3];
                                //alert("state name is: " + state);
                                defer.resolve(state);
                            } else {
                                alert("address not found");
                            }
                        } else {
                            alert("Geocoder failed due to: " + status);
                        }
                    }
                );
            });
            return defer.promise;
        },
        getDetails: function() {
            var defer = $q.defer();
            $http.get("js/district_data.json").success(function(response) {
                console.log(response);
                defer.resolve(response);
            }).
            error(function(state_data) {
                defer.reject();
            });
            return defer.promise;
        }
    }
});