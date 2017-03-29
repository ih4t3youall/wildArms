<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="resources/jquery.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>Accenture - GoDigital</title>

<script type="text/javascript">
	var nombreRecord;
	var grabando = false;
	var arrayMovs = [];

	$(document).ready(function() {
		$("#nombreGrabacion").val("");
	});

	function mover(movimiento) {

		if (grabando) {

			movimientoGrabacion(movimiento);
		}

		// 	console.log(movimiento);
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "mover",

			data : "movimiento=" + movimiento,
			success : function(data) {
				console.log("gg");

			},
			error : function(e) {
				console.log("ERROR: ", e);
				console.log(e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});

	}

	function precargado(nombreFile) {

		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "ejecutarPreCargado",
			data : "nombre=" + nombreFile,
			success : function(data) {
				console.log("gg");

			},
			error : function(e) {
				console.log("ERROR: ", e);
				console.log(e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});

	}

	function comenzarGrabacion() {

		if ($("#nombreGrabacion").val() == "") {
			alert("debe escribir un nombre para el block de movimientos");

		} else {
			$('#nombreGrabacion').attr("disabled", "true")
			grabando = true;
		}

	}

	function movimientoGrabacion(movimiento) {
		console.log("movimiento grabacion");
		arrayMovs.push(movimiento);

		$("#tablaMovimientos").append(movimiento);
		$("#tablaMovimientos").append("<br/>");

	}

	function detenerGrabacion() {

		// Array
		var sendArray = [];

		var nombre = $('#nombreGrabacion').val();

		//limpio la tabla
		$("#tablaMovimientos").empty();
		//reactivo el boton 
		$('#nombreGrabacion').removeAttr("disabled");
		grabando = false;

		console.log(nombreRecord);

		$(arrayMovs).each(function(index, item) {

			sendArray.push(item);

		})


		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "movimientosGrabados",
			dataType : "json",
			data : "array=" + sendArray + "&nombre=" + nombre,
			success : function(data) {
				console.log("gg");

			},
			error : function(e) {
				console.log("ERROR: ", e);
				console.log(e);
			},
			done : function(e) {
				console.log("DONE");
			}

		});
		

	}
</script>

<style type="text/css">

.separator{
padding-top: 25px;
padding-bottom: 25px;

}

.goDigital{

background-image: url('resources/img/goDigital2.png');
background-repeat: no-repeat;
height:30%;
width:430px;
}

#contenedor{
/* background-image: url('resources/img/accenture.jpg'); */
background-repeat: no-repeat;


padding-top: 50px;

}

body{
/* background-image: url('resources/img/fondoAzul.png'); */
background-color: black;
}
a{
width:110px;
}


 

</style>

</head>
<body >
<!-- <img src="resources/img/accenture.jpg"/> -->
<div id="contenedor"  >



	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${cama_arriba}')">Brazo arriba</a>
		</div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${adelante}')">adelante</a>
		</div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${munieca_arriba}')">Mu�eca arriba</a>
		</div>
		<div class="col-md-3"></div>
	</div>
	
	<div class="separator"></div>
	
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${cama_abajo}')">Brazo abajo</a>
		</div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${atras}')">atras</a>
		</div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${munieca_abajo}')">Mu�eca abajo</a>
		</div>
		<div class="col-md-3"></div>
	</div>
	<div class="separator"></div>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-1">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${abrir_pinza}')">Abrir pinza</a>
		</div>
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${cerrar_pinza}')">Cerrar pinza</a>
		</div>
		<div class="col-md-3"></div>
	</div>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-1">
		</div>
		<div class="col-md-3 goDigital"></div>
		<div class="col-md-2">
		</div>
		<div class="col-md-3"></div>
	</div>

	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${izquierda}')">Izquierda</a>
		</div>
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${derecha}')">Derecha</a>
		</div>
		<div class="col-md-3"></div>
	</div>
<div class="separator"></div>
	<div class="row">
		<div class="col-md-2">&nbsp;</div>
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${encender_led}')">Encender led</a>
		</div>
		<div class="col-md-2">&nbsp;</div>
		<div class="col-md-3"></div>
	</div>
<div class="separator"></div>
	<div class="row">
		<div class="col-md-3">&nbsp;</div>
		<div class="col-md-2">&nbsp;</div>
		<div class="col-md-2">&nbsp;</div>
		<div class="col-md-2">&nbsp;</div>
		<div class="col-md-3">&nbsp;</div>
	</div>


</div>





</body>
</html>