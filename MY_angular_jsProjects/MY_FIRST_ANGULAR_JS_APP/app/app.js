var app = angular.module('oab', []);

app.controller('loginCtrl',function($scope,loginService){
    $scope.firstName = "Elavarasan";
    $scope.lastName = "Natarajan";
    $scope.getPersonDetails = function()
    {
    	var response =  loginService.getDetails();
    }

});

 app.factory('loginService',function($http)
{
	try
	{
	var loginData = '{"map":{"Service":"Login","Channel":"IB","Password":"abcd","UserId":"oab","Module":"Login"}}';
    	return{
			getDetails:function()
			{	
				$http.post('http://172.25.0.52:3030/OABDemo/service',loginData).success(function(responseData,status)
				{
				alert(JSON.stringify(responseData));
				}).error(function (failure)
				{
				alert(JSON.Stringify(failure));
				});
				}
	}
}
	catch(e)
	{
		alert(e);
	}
 });
 