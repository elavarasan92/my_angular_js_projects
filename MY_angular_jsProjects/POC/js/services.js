app.factory('InitializationService', function ($rootScope, $http, $q) {
    try {
        return {
            getDetails: function () {
                var deferred = $q.defer();

                //Get Offline data first
                $http.get('config.json').success(function (responseData) {
                   alert(JSON.stringify(responseData));
                }).error(function (failure) {
                    alert(JSON.stringify(failure));
                });
                return deferred.promise;
            }
        }
    } catch (e) {
	alert("inside catch"+JSON.stringify(e));
        $rootScope.globalException(e);
    }
})