package ar.com.sourcesistemas.wildArms;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.sourcesistemas.wildArms.activeMq.MessageSender;
import ar.com.sourcesistemas.wildArms.activeMq.Test;
import ar.com.sourcesistemas.wildArms.entities.Command;
import ar.com.sourcesistemas.wildArms.entities.Constantes;
import ar.com.sourcesistemas.wildArms.entities.MovimientosGuardados;
import ar.com.sourcesistemas.wildArms.mecanizator.Recorder;



@Controller
public class WildArmController {

	@Autowired
	private Test test;

	@Autowired
	private MessageSender messageSender;
	
	@Autowired
	private ObjectMapper objectMapper;

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

		List<MovimientosGuardados> allMovements = recorder.getAllMovements();
		
		List<String> nombresMovimientos = new LinkedList<String>();
		for (MovimientosGuardados movimientosGuardados : allMovements) {
			nombresMovimientos.add(movimientosGuardados.getNombre());
		}
		
		mav.addObject("nombresMovimientos",nombresMovimientos);
		
		return mav;

	}

	@RequestMapping("mover")
	public void mover(String movimiento) {
			System.out.println(movimiento);

			Command command = new Command();
			command.setCommand(movimiento);

			try

			{
				messageSender.sendMessage(command);
			} catch (JMSException e) {
				e.printStackTrace();
			}


	}

	
	@RequestMapping(value = "ejecutarPreCargado", method=RequestMethod.GET)
	public void ejecutarPreCargado(@RequestParam(value="nombre", required=true) String nombre){
		
		MovimientosGuardados movs = recorder.getMovementsFile(nombre);
		messageSender.sendPreSetMovementsMessage(movs);
		
		
		
	}
	
	@RequestMapping(value = "movimientosGrabados", method = RequestMethod.GET)
	public void movimientosGrabados(@RequestParam(value="array",required=true) String[] array,@RequestParam(value="nombre",required=true) String nombre){
		
		MovimientosGuardados mov = new MovimientosGuardados(nombre,array);
		
		try {
			recorder.save(mov);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("volo todo al carajo");
		}
		
		
		
	}
	



}
