
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="resources/jquery.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link
	href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
	rel="stylesheet">
<script
	src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>

<title>Insert title here</title>

<script type="text/javascript">
	function disableText() {

		var  isDisabled = $("#text").is(":enabled");
		
		if(isDisabled){
			$("#text").prop("disabled", true);	
			
		}else{
			$("#text").prop("disabled", false);
			
		}
		
		
		
	}

	$(document).ready(function() {
		
		disableText();
		
		
	});

	function cambio(algo) {
		
		disableText();

	}
	
	
	function empezarAGrabar(){
		
		
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "mover",
			data : "grabar=true",
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

	function mover(movimiento) {

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
</script>

</head>
<body>


	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${cama_arriba}')">cama arriba</a>
		</div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${adelante}')">adelante</a>
		</div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${munieca_arriba}')">muñeca arriba</a>
		</div>
		<div class="col-md-3"></div>
	</div>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${cama_abajo}')">cama abajo</a>
		</div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${atras}')">atras</a>
		</div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${munieca_abajo}')">muñeca abajo</a>
		</div>
		<div class="col-md-3"></div>
	</div>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${abrir_pinza}')">abrir pinza</a>
		</div>
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${cerrar_pinza}')">cerrar pinza</a>
		</div>
		<div class="col-md-3"></div>
	</div>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${izquierda}')">izquierda</a>
		</div>
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${derecha}')">derecha</a>
		</div>
		<div class="col-md-3"></div>
	</div>

	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${encender_led}')">encender led</a>
		</div>
		<div class="col-md-2"></div>
		<div class="col-md-3"></div>
	</div>

	<div class="row">
		<div class="col-md-3">.</div>
		<div class="col-md-2">
			<!-- 	boton guardar acciones	 -->
			<div class="form-group">
				<label for="usr">Nombre archivo:</label> <input id="text"
					type="text" class="form-control" id="usr">
			</div>

		</div>
		<div class="col-md-2">

			<div class="checkbox">
				<label> <input onChange="cambio(this)" id="check"
					data-toggle="toggle" type="checkbox">

				</label>
			</div>
		</div>
		<div class="col-md-2"></div>
		<div class="col-md-3"></div>
	</div>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${precision_mas}')">precision mas</a>
		</div>
		<div class="col-md-2">label</div>
		<div class="col-md-2">
			<a href="#" class="btn btn-default" role="button"
				onclick="mover('${precision_menos}')">precision menos</a>
		</div>
		<div class="col-md-3"></div>
	</div>






</body>
</html>