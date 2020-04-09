package com.discarok.maven.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Empleado")
public class Empleado implements Serializable {

	/**
	 * Serial que se implementa usando serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cod_empleado")
	private Long codigo;

	@Column(name = "apellidos",length = 100)
	private String apellidos;

	@Column(name = "nombre", length = 80)
	private String nombre;

	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	public Empleado(Long codigo, String apellidos, String nombre, Date fechaNacimiento) {
		this.codigo = codigo;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Empleado() {

	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", apellidos=" + apellidos + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}

}
