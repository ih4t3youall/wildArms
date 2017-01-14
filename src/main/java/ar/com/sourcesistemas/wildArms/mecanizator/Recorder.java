package ar.com.sourcesistemas.wildArms.mecanizator;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.com.sourcesistemas.wildArms.persistencia.Persistencia;

@Repository
public class Recorder {

	
	private List<String> movements = new LinkedList<String>();
	
	private String name;
	
	@Autowired
	private Persistencia persistencia;
	
	public void setNamee(String name){
		this.name = name;
		
	}
	
	
	public void addMovement(String movement){
		
		movements.add(movement);
		
	} 
	
	
	public void save() throws IOException{
		
		
		persistencia.save(name,movements);
		name = "";
		movements.clear();
		
		
	}
	
	
	
}
