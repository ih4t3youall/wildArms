
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="resources/jquery.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>

<script type="text/javascript">

function mover(movimiento){
	
// 	console.log(movimiento);
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "mover",
		
		data :"movimiento="+movimiento,
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

</head>
<body>


	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button" onclick="mover('${cama_arriba}')" >cama arriba</a>
		</div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"onclick="mover('${adelante}')" >adelante</a>
		</div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button" onclick="mover('${munieca_arriba}')">muñeca arriba</a>
		</div>
		<div class="col-md-3"></div>
	</div>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button" onclick="mover('${cama_abajo}')">cama abajo</a>
		</div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button" onclick="mover('${atras}')">atras</a>
		</div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button" onclick="mover('${munieca_abajo}')">muñeca abajo</a>
		</div>
		<div class="col-md-3"></div>
	</div>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button" onclick="mover('${abrir_pinza}')">abrir pinza</a>
		</div>
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button" onclick="mover('${cerrar_pinza}')">cerrar pinza</a>
		</div>
		<div class="col-md-3"></div>
	</div>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button" onclick="mover('${izquierda}')">izquierda</a>
		</div>
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button" onclick="mover('${derecha}')" >derecha</a>
		</div>
		<div class="col-md-3"></div>
	</div>

	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2">nada</div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button" onclick="mover('${encender_led}')">encender led</a>
		</div>
		<div class="col-md-2">nada</div>
		<div class="col-md-3"></div>
	</div>

	<div class="row">
		<div class="col-md-3">nada</div>
		<div class="col-md-2">nada</div>
		<div class="col-md-2">nada</div>
		<div class="col-md-2">nada</div>
		<div class="col-md-3">nada</div>
	</div>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button" onclick="mover('${precision_mas}')">precision mas</a>
		</div>
		<div class="col-md-2">label</div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button" onclick="mover('${precision_menos}')">precision menos</a>
		</div>
		<div class="col-md-3"></div>
	</div>






</body>
</html>