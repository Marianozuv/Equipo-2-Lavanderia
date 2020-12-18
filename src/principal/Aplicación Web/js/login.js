var app = angular.module('ModuleLogin', []);
app.controller('ControladorLogin', function ($scope, $http, $rootScope) {

	$scope.datos =  {};
	//Para saber si tiene sesion
	this.sesion = localStorage.getItem('sesion');
	console.log(this.sesion);
	if(this.sesion === "true"){
		location.href="adm.html";
	}
	

	$scope.postdata = function () {
		console.log(JSON.stringify($scope.datos));
        $scope.msj = "";
		//llamar servicios
		$http.post('http://localhost:8080/RestJR/services/JavaRevolutions/validaUsuario', JSON.stringify($scope.datos)).then(function (response) {
		if (response.data){
			console.log("El Usuario Si Existe en la Base");
			 $rootScope.tieneSesion=true;
			localStorage.setItem('sesion', true);
			//redireccionar a la pantalla del administrador
			location.href="adm.html";
		}else{
			console.log("El Usuario No Existe en la Base");
			$scope.msj ="Los Datos Ingresados son Incorrectos, intente de nuevo.";
		}	
		},
		 //Funcion entra cuando hay error
		 function (response) {
			console.log(response);
		});

	};

});

app.run(['$rootScope',function($rootScope) {
  $rootScope.tieneSesion=false;
}]);
 