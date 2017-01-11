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
import ar.com.sourcesistemas.wildArms.entities.Constantes;
import ar.com.sourcesistemas.wildArms.mecanizator.Recorder;

@Controller
public class WildArmController {

	@Autowired
	private Test test;

	@Autowired
	private MessageSender messageSender;
	
	@Autowired
	private Recorder recorder;

	private ObjectMapper objMap = new ObjectMapper();

	private boolean grabar = false;

	@RequestMapping("index")
	public ModelAndView index() {

		ModelAndView mav = new ModelAndView("index");

		Command command = new Command();
		command.setCommand(Constantes.ARRIBA);
		mav.addObject("msg", "commando enviado: " + Constantes.ARRIBA);
		mav.addObject("cama_arriba", Constantes.ARRIBA);
		mav.addObject("cama_abajo", Constantes.ABAJO);
		mav.addObject("munieca_arriba", Constantes.MUNIECA_ARRIBA);
		mav.addObject("munieca_abajo", Constantes.MUNIECA_ABAJO);
		mav.addObject("adelante", Constantes.ADELANTE);
		mav.addObject("atras", Constantes.ATRAS);
		mav.addObject("abrir_pinza", Constantes.PINZA_ABRIR);
		mav.addObject("cerrar_pinza", Constantes.PINZA_CERRAR);
		mav.addObject("izquierda", Constantes.IZQUIERDA);
		mav.addObject("derecha", Constantes.DERECHA);
		mav.addObject("encender_led", Constantes.ENCENDER_LED);
		mav.addObject("precision_mas", Constantes.PRECISION_MAS);
		mav.addObject("precision_menos", Constantes.PRECISION_MENOS);

		return mav;

	}

	@RequestMapping("mover")
	public void mover(String movimiento) {
		if (!grabar) {
			System.out.println(movimiento);

			Command command = new Command();
			command.setCommand(movimiento);

			try

			{
				messageSender.sendMessage(command);
			} catch (JMSException e) {
				e.printStackTrace();
			}

		} else {

			
			
			
		}

	}

	@RequestMapping("grabar")
	public void grabar() {

	}

}
