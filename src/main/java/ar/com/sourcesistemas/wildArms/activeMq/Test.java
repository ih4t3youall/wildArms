package ar.com.sourcesistemas.wildArms.activeMq;

import org.springframework.stereotype.Repository;

@Repository
public class Test {

	
	private String string = "last resort";
	
	public Test(){
		
		string = "shupala";
		
		
	}
	
	
	public String getString(){
		
		
		return string;
		
	}
	
	
	
}
