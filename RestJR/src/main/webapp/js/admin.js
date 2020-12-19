var app = angular.module('ModuleAdmin', []);
app.controller('ControladorAdmin', function ($scope, $http, $rootScope) {

	$scope.datos =  {};
	
	$scope.cerrarSesion = function () {
		localStorage.setItem('sesion', false);
		location.href="login.html";
	}
		

});

app.run(['$rootScope',function($rootScope) {
  $rootScope.tieneSesion=false;
}]);
 