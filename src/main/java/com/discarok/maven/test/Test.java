package com.discarok.maven.test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.discarok.maven.modelo.Empleado;


public class Test {
	
	 
	 private static EntityManager em;
	 
	 private static EntityManagerFactory emf;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("aplicacion");
		em = emf.createEntityManager();
		
		Empleado empleado = new Empleado(1676L,"Mondragon Rodriguez","Angel",LocalDate.of(1998,12,14));
		em.getTransaction().begin();
		em.persist(empleado);
		em.getTransaction().commit();
		
		imprimirTodo();
		
		
	}
	
	public static void imprimirTodo() {
		@SuppressWarnings({ "unused", "unchecked" })
		List<Empleado> empleados = (List<Empleado>)em.createQuery("FROM Empleado").getResultList();
        System.out.println("La cantidad de empleaos registrados es: "+empleados.size());
        for(Empleado e: empleados) {
        	System.out.println(e.getNombre()+" "+e.getApellidos());
        }
	}

}
