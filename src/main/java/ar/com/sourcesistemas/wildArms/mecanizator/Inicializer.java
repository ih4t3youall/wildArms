package ar.com.sourcesistemas.wildArms.mecanizator;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.sourcesistemas.wildArms.entities.Constantes;
import ar.com.sourcesistemas.wildArms.persistencia.Persistencia;

public class Inicializer {
	
	@Autowired
	private Persistencia persistencia;
	
	private final String NOMBRE_CARPETA = "wildArms"; 
	
	public Inicializer(){
		
		if(!persistencia.existeArchivo(Constantes.NOMBRE_CARPETA)){
			
			persistencia.createFolder(Constantes.NOMBRE_CARPETA);
			
		}
		
	}

}
