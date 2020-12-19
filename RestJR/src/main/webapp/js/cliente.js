var app = angular.module('ModuleAltaCliente', []);
app.controller('ControladorAltaCliente', function ($scope, $http, $rootScope) {

	$scope.datos =  {};
	
	//Para saber si tiene sesion
	this.sesion = localStorage.getItem('sesion');
	if(this.sesion === "false"){
		location.href="login.html";
	}
	
	$scope.cerrarSesion = function () {
		localStorage.setItem('sesion', false);
		location.href="login.html";
	}
	
		 function obtenerClientes() {
				
		      
				//llamar servicios
				$http.get('http://localhost:8080/RestJR/services/JavaRevolutions/consultarClientes').then(
					function (response) {
								console.log(response.data);
								$scope.arregloClientes = response.data;
							},
				 //Funcion entra cuando hay error
				 function (response) { 
					console.log(response);
		});

	};
	obtenerClientes();
	
	$scope.eliminarCliente = function(cliente) {			      
				$http.post('http://localhost:8080/RestJR/services/JavaRevolutions/eliminarusuario', angular.toJson(cliente)).then(
					function (response) {
								obtenerClientes();
							},
				 //Funcion entra cuando hay error
				 function (response) { 
					console.log(response);
		});
		obtenerClientes();
	};
	
		
			 $scope.altaCliente = function() {			      
				//llamar servicios
				$http.post('http://localhost:8080/RestJR/services/JavaRevolutions/altaCliente', JSON.stringify($scope.datos)).then(
					function (response) {
								console.log(response.data);
								obtenerClientes();
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
 