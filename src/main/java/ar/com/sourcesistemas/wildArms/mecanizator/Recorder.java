package ar.com.sourcesistemas.wildArms.mecanizator;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class Recorder {

	
	private List<String> movements = new LinkedList<String>();
	
	private String name;
	
	public void setNamee(String name){
		this.name = name;
		
	}
	
	
	public void addMovement(String movement){
		
		movements.add(movement);
		
	} 
	
	
	public void save(){
		
		
		
	}
	
	
	
}
