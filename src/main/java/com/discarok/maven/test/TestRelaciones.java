/**
 * 
 */
package com.discarok.maven.test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.discarok.maven.modelo.Departamento;
import com.discarok.maven.modelo.Direccion;
import com.discarok.maven.modelo.Empleado;

/**
 * @author discarok
 * @email amondrave54@gmail.com Clase para probar las relaciones hechas por
 *        hibernate y JPA
 */
public class TestRelaciones {

	/**
	 * @param args
	 */
	
	
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		crearDatos();
		imprimir();
	}

	public static void crearDatos() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Direccion dir1 = new Direccion(15L, "calle 28 3e-05", "Chaparral", "Los Patios");
		Direccion dir2 = new Direccion(16L, "calle 28 3e-05b", "Chaparral", "Los Patios");
		Direccion dir3 = new Direccion(17L, "calle 29 4e-05b", "Chaparral", "Los Patios");
		Direccion dir4 = new Direccion(18L, "calle 29 4e-05b", "Chaparral", "Los Patios");
		Direccion dir5 = new Direccion(19L, "calle 29 4e-05b", "Chaparral", "Los Patios");
		em.persist(dir1);
		em.persist(dir2);
		em.persist(dir3);
		em.persist(dir4);
		em.persist(dir5);
		Departamento depa1 = new Departamento(100L,"Sistemas","departamento de sistemas");
		Departamento depa2 = new Departamento(101L,"Diseño","departamento de diseño");
		em.persist(depa1);
		em.persist(depa2);
		
		Empleado e1 = new Empleado(1L,"Mondragon Rodriguez","Angel",LocalDate.of(1998, 12, 14),dir1,depa1);
		Empleado e2 = new Empleado(2L,"Mondragon Rodriguez","Nestor",LocalDate.of(2003, 9, 26),dir4,depa2);
		Empleado e3 = new Empleado(3L,"Geromel","Pedro",LocalDate.of(1985, 4, 7),dir3,depa1);
		Empleado e4 = new Empleado(4L,"Perez","Pablo",LocalDate.of(1988, 3, 27),dir2,depa1);
		Empleado e5 = new Empleado(5L,"Viera do Santos","Cristiano Ronaldo",LocalDate.of(1985, 2, 5),dir5,depa2);
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		em.persist(e5);
		em.getTransaction().commit();
		
		em.close();
	}

	public static void imprimir() {
		EntityManager em = emf.createEntityManager();
		Direccion dir = em.find(Direccion.class, 17L);
		System.out.println(dir);
		
		Departamento dep = em.find(Departamento.class, 100L);
		List<Empleado>empleados = dep.getEmpleados();
		for(Empleado e : empleados) {
			System.out.println(e.toString());
		}
		em.close();
        
	}

}
