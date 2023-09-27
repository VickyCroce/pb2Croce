package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAlumno {

	@Test
	public void queSeIngreseUnAlumno() {
		Integer dni = 46265819;
		String nombre = "Pedro";
		String apellido = "Lopez";
		
		Alumno alumno = new Alumno (dni, nombre, apellido);
		
		assertNotNull(alumno);
	}
	
	@Test
	public void queSePuedaComprobarUnId() {
		Integer dni = 46265819;
		String nombre = "Pedro";
		String apellido = "Lopez";
		Integer dni2 = 46265819;
		String nombre2 = "Pedro";
		String apellido2 = "Lopez";
		Integer id = 1;
		Integer id2 = 2;
		
		Alumno alumno = new Alumno (dni, nombre, apellido);
		Alumno alumno2 = new Alumno (dni2, nombre2, apellido2);
		
		assertNotNull(alumno);
		assertEquals(id, alumno.getId());
		assertEquals(id2, alumno2.getId());
	}


}
