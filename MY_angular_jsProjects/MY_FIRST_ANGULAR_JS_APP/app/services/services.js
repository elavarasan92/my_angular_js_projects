app.factory('loginService',function($http)
{
	try
	{
    	return{
			getDetails:function()
			{	
				$http.get('app/config/config.json').success(function(responseData)
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
 
 