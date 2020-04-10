
package com.discarok.maven.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Discarok
 * @email amondrave54@gmail.com Clase que corresponde al departamento de trabajo
 *        de la empresa
 * 
 */
@Entity
@Table(name = "Departamento")
public class Departamento implements Serializable {

	/**
	 * Serial generado automatico
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "nombre", length = 80, nullable = false, unique = true)
	private String nombre;

	@Column(name = "descripcion", length = 250, nullable = true)
	private String descripcion;

	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	private List<Empleado> empleados;

	public Departamento(Long codigo, String nombre, String descripcion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.empleados = new ArrayList<Empleado>();
	}

	public Departamento() {
		this.empleados = new ArrayList<Empleado>();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((empleados == null) ? 0 : empleados.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (empleados == null) {
			if (other.empleados != null)
				return false;
		} else if (!empleados.equals(other.empleados))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

}
