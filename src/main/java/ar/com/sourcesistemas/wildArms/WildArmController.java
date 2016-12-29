package ar.com.sourcesistemas.wildArms;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.sourcesistemas.wildArms.activeMq.MessageSender;
import ar.com.sourcesistemas.wildArms.activeMq.Test;
import ar.com.sourcesistemas.wildArms.entities.Command;

@Controller
public class WildArmController {

	@Autowired
	private Test test;
	
	@Autowired
	private MessageSender messageSender;
	
	private ObjectMapper objMap = new ObjectMapper();
	
	@RequestMapping("index")
	public ModelAndView index(){
		
		ModelAndView mav = new ModelAndView("index");
	
		Command command = new Command();
		command.setCommand("comando");
		mav.addObject("msg","la concha de tu hermana");
		try {
			messageSender.sendMessage(command);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mav;
		
	}
	
	
}
