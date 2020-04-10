package com.discarok.maven.modelo;

/**
 * @author discarok
 * @email amondrave54@gmail.com
 * Clase que corresponde a la direccion que tiene un empleado
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Direccion")
public class Direccion implements Serializable {

	/**
	 * Serial creado por defecto
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "ubicacion", length = 150)
	private String ubicacion;

	@Column(name = "barrio", length = 50)
	private String barrio;

	@Column(name = "municipio", length = 50)
	private String municipio;

	// Mapeo para poder consultar los empleados a traves de la direccion
	@OneToOne(mappedBy = "direccion", fetch = FetchType.LAZY)
	private Empleado empleado;

	public Direccion() {

	}

	public Direccion(Long id, String ubicacion, String barrio, String municipio) {
		this.id = id;
		this.ubicacion = ubicacion;
		this.barrio = barrio;
		this.municipio = municipio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", ubicacion=" + ubicacion + ", barrio=" + barrio + ", municipio=" + municipio
				+ "]";
	}

}
