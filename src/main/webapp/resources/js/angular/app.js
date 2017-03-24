var validationApp = angular.module('validationApp', ['ui.bootstrap.modal'])

validationApp.controller('mainController', function($scope,$filter,$window) {
	$scope.CurrentDate = new Date();
	$scope.submitForm = function(isValid) {
		if (isValid) { 
			alert('Vale de salida guardado exitosamente');
		}else{ 
			$scope.showModal1 = true;
			$scope.show = true;
			$scope.okk = function() {
				$scope.showModal1 = false;
			}
		}
	};
	
	$scope.mensajeExito = function() {
		$scope.showModal2 = true;
		$scope.okk = function() {
			$scope.showModal2 = false;		
		}
	};
	
	$scope.listaMensajes = function() {
		$scope.showModal3 = true;
		$scope.okk = function() {
			$scope.showModal3 = false;		
		}
	};
	
	$scope.listaAlmacenistas = function() {
		$scope.showModal4 = true;
		$scope.okk4 = function() {
			$scope.showModal4 = false;		
		}
	};
	
	$scope.redireccionar = function() {
		var obli= obligatoriedad();
		if(obli=='si'){
			$scope.showModal = true;	 
			$scope.ok = function() {
				$scope.redirecion="redirect:/";
				$scope.showModal = false;
			};
			$scope.cancel = function() {
				$scope.redirecion="vales";
				$scope.showModal = false;
			};
		}	
	};
		

	$scope.consultar = function(){
		$scope.filtro={num:$scope.numVale,fec:$scope.fecVale,est:$scope.estVale};
	};
	         		  
	$scope.clicColumn = function(){
		variable=$scope.data.mostrar;
	    if(variable=="Si"){
	    	$scope.data.mostrar="No"
	       	}else{
	       		$scope.data.mostrar="Si"
	        }
	};
	
	$scope.buscarMaterialLista = function(x){
		buscarMaterialListaJS(x);
	}
	
	$scope.convMayusculasListaAng = function(x){
		convMayusculasLista(x);
	}
	
	$scope.convMayusculasAng = function(x){
		convMayusculas();
	}
	         	    
	$scope.clicRegresa = function(){
		variable=$scope.data.regresa;
		if(variable=="No"){
			$scope.CurrentDate = new Date();
			var date = $scope.CurrentDate;
			date = $filter('date')(date, "dd/MM/yyyy");
			$scope.fechaFinalHome=date;
			$scope.data.fechaEsperada="dd/mm/aaaa";
		}else{
			$scope.fechaFinalHome="";			
			$scope.CurrentDate = new Date();
			var date = $scope.CurrentDate;
			date = $filter('date')(date, "dd/MM/yyyy");
			$scope.data.fechaEsperada=date;
			$scope.data.fechaEsperada = {
					value: new Date()
			};
		}
	};
	         	    
	$scope.checkboxModel = {
			valueEst : false,
			valueMot : false,
			valueEmp : false,
			valueNit : false,
			valueCiu : false,
			valuesDest : false
	};
	         	   			
	$scope.vale = [
	  				  
	];
	  		  	         	  
	var valen = {
			valeId: $scope.vale.valeId,
			valeEst:null,
			ValeFec:null
	};
          		    
	$scope.vale.push(valen);

    $scope.materiales = [

             		    ];
             		    
    $scope.contador1=1;
    $scope.contador2=1;
	var contador2=0;
	
	$scope.addMaterial = function(){
		var verificar = obligatoriedadTabla();
		if(verificar=='si'){
			var numero = $scope.material.valorEstimado * $scope.material.vlrUnitario;
		    var material = {
		        fila: $scope.contador1,
		        codigo: $scope.material.codigo,
		        centro: $scope.material.centro,
		        descripcion: $scope.material.descripcion,
		        um: $scope.material.um,
		        cantidad: $scope.material.cantidad,
		        vlrUnitario:$scope.material.vlrUnitario,
		        valorEstimado: $scope.material.vlrUnitario *  $scope.material.cantidad,
		        peso: $scope.material.peso,
		        regresa: $scope.data.regresa,
		        repuesto: $scope.data.repuesto,
		        noOC: $scope.material.noOC,
		        fechaEsperada: $scope.fechaEsperada,
		        fechaFinal:  $scope.fechaFinalHome,
		        ide: $scope.contador1
		    };
		    $scope.materiales.push(material);
		    $scope.contador1+=1;
		    $scope.contador2+=1;
		    var date = $scope.CurrentDate;
			date = $filter('date')(date, "dd/MM/yyyy");
			$scope.fechaFinalisima=date;
			callToolTip();
		}
        };
                    	
      $scope.removeMaterial = function(valor){            
            var newDataList=[];
            var fi = valor;
            var cont=1;
            angular.forEach($scope.materiales, function(selected){
                if(selected.fila!=fi){
                	selected.fila=cont;
                    newDataList.push(selected);
                    cont+=1;                 
                }
            }); 
            $scope.materiales = newDataList;
            $scope.contador1-=1;
        }
      
      $scope.vlrEstimadoLista = function(valor){            
    	  vlrEstimadoListaJQ(valor);
      }
      
      $scope.vlrEstimadoLista1 = function(valor){            
    	  vlrEstimadoListaJQ1(valor);
      }
      
	$scope.recibido=function(x,y){
		var nombre = "varRecibido" + y;
		if(x=='true'){
			$scope[nombre]="No";
		}else{
			$scope[nombre]="Si";
		}		
	}
		  
	$scope.mostrarFecha = function(x,y){					  
		$scope.CurrentDate = new Date();	
		var nombre = 'chekRecibido'+x;
		var nombre1 = 'fechaFinal'+x;
		var nombre2 = 'fechaFinali'+x;
		if(y=="false"){
			var date = $scope.CurrentDate;
			date = $filter('date')(date, "yyyy-MM-dd"); 
			$scope[nombre1]=date;
		}else if($scope[nombre2]==''){
			$scope[nombre1]="";
		}
	};
		  
	$scope.data = {
			singleSelect: "No",
			fin: "No",
			regresa:"Si",
			repuesto:"Si",
			selectMotivo:null,
			mostrar:"No",
			estadoFiltro:"ABIERTO",
			prorroga:"No"
	};

	$scope.editarMaterial=function(){	
		variable=$scope.data.prorroga;
		if(variable=="Si"){
			$scope.data.prorroga="No";
		}else{
			$scope.data.prorroga="Si";		
		}
	};

});