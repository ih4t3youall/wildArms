package ar.com.sourcesistemas.wildArms.entities;

import java.io.Serializable;

public class MovimientosGuardados implements Serializable {

	private String nombre;
	private String[] movimientos;

	public MovimientosGuardados(String nombre, String[] array) {
		this.nombre = nombre;
		this.movimientos = array;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String[] getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(String[] movimientos) {
		this.movimientos = movimientos;
	}

}
