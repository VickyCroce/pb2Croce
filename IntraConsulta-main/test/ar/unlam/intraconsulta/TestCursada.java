package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCursada {

	@Test
	public void queSePuedaCrearLaCursada() {
		//preparacion
		Materia materia = new Materia (45, "programacion");
		Alumno alumno = new Alumno (46265819, "Pedro", "Lopez");
		
		//ejecucion
		Cursada cursada = new Cursada (materia, alumno);
		
		//verificacion
		assertNotNull(cursada);
	}
	
	@Test
	public void queSePromocione() {
		//preparacion
		Materia materia = new Materia (45, "programacion");
		Alumno alumno = new Alumno (46265819, "Pedro", "Lopez");
		Integer parcial1 = 7;
		Integer parcial2 = 8;
		
		//ejecucion
		Cursada cursada = new Cursada (materia, alumno);
		cursada.hacerParciales(parcial1, parcial2);
		cursada.ponerNotas();
		
		//verificacion
		assertNotNull(cursada);
		assertEquals(Calificar.PROMOCIONADO, cursada.getNotaFinal());
	}
	
	@Test
	public void queSeApruebe() {
		//preparacion
		Materia materia = new Materia (45, "programacion");
		Alumno alumno = new Alumno (46265819, "Pedro", "Lopez");
		Integer parcial1 = 5;
		Integer parcial2 = 8;
		
		//ejecucion
		Cursada cursada = new Cursada (materia, alumno);
		cursada.hacerParciales(parcial1, parcial2);
		cursada.ponerNotas();
		
		//verificacion
		assertNotNull(cursada);
		assertEquals(Calificar.APROBADO, cursada.getNotaFinal());
	}
	
	@Test
	public void queSeDesapruebe() {
		//preparacion
		Materia materia = new Materia (45, "programacion");
		Alumno alumno = new Alumno (46265819, "Pedro", "Lopez");
		Integer parcial1 = 5;
		Integer parcial2 = 2;
		
		//ejecucion
		Cursada cursada = new Cursada (materia, alumno);
		cursada.hacerParciales(parcial1, parcial2);
		cursada.ponerNotas();
		
		//verificacion
		assertNotNull(cursada);
		assertEquals(Calificar.DESAPROBADO, cursada.getNotaFinal());
	}
	
	@Test
	public void queHayaRecuperatorioDisponible() {
		//preparacion
		Materia materia = new Materia (45, "programacion");
		Alumno alumno = new Alumno (46265819, "Pedro", "Lopez");
		Integer parcial1 = 5;
		Integer parcial2 = 8;
		
		//ejecucion
		Cursada cursada = new Cursada (materia, alumno);
		cursada.hacerParciales(parcial1, parcial2);
		cursada.ponerNotas();
		
		//verificacion
		assertNotNull(cursada);
		assertEquals(Calificar.APROBADO, cursada.getNotaFinal());
		assertTrue(cursada.recuperatorioDisponible());
	}
	
	@Test
	public void queSePuedaRecuperar() {
		//preparacion
		Materia materia = new Materia (45, "programacion");
		Alumno alumno = new Alumno (46265819, "Pedro", "Lopez");
		Integer parcial1 = 5;
		Integer parcial2 = 8;
		Integer notaRecuperatorio = 10;
		
		//ejecucion
		Cursada cursada = new Cursada (materia, alumno);
		cursada.hacerParciales(parcial1, parcial2);
		cursada.ponerNotas();
		cursada.obtenerRecuperatorio(notaRecuperatorio);
		
		//verificacion
		assertNotNull(cursada);
		assertEquals(Calificar.APROBADO, cursada.getNotaFinal());
		assertEquals (Calificar.PROMOCIONADO, cursada.getRecuperatorio());	
	}
	
	@Test
	public void queHayaFinalDisponible() {
		//preparacion
		Materia materia = new Materia (45, "programacion");
		Alumno alumno = new Alumno (46265819, "Pedro", "Lopez");
		Integer parcial1 = 5;
		Integer parcial2 = 5;
		
		//ejecucion
		Cursada cursada = new Cursada (materia, alumno);
		cursada.hacerParciales(parcial1, parcial2);
		cursada.ponerNotas();
		
		//verificacion
		assertNotNull(cursada);
		assertEquals(Calificar.APROBADO, cursada.getNotaFinal());
		assertTrue(cursada.finalDisponible());
	}
	
	@Test
	public void queSePuedaRecursas() {
		//preparacion
		Materia materia = new Materia (45, "programacion");
		Alumno alumno = new Alumno (46265819, "Pedro", "Lopez");
		Integer parcial1 = 3;
		Integer parcial2 = 3;
		
		//ejecucion
		Cursada cursada = new Cursada (materia, alumno);
		cursada.hacerParciales(parcial1, parcial2);
		cursada.ponerNotas();
		
		//verificacion
		assertNotNull(cursada);
		assertEquals(Calificar.RECURSA, cursada.getNotaFinal());
		assertFalse(cursada.finalDisponible());
	}
	
	@Test
	public void queSePuedaRecursasConRecuperatorio() {
		//preparacion
		Materia materia = new Materia (45, "programacion");
		Alumno alumno = new Alumno (46265819, "Pedro", "Lopez");
		Integer parcial1 = 3;
		Integer parcial2 = 4;
		Integer recuperatorio =3;
		
		//ejecucion
		Cursada cursada = new Cursada (materia, alumno);
		cursada.hacerParciales(parcial1, parcial2);
		cursada.ponerNotas();
		cursada.obtenerRecuperatorio(recuperatorio);
		
		//verificacion
		assertNotNull(cursada);
		assertEquals(Calificar.DESAPROBADO, cursada.getNotaFinal());
		assertEquals(Calificar.RECURSA, cursada.getRecuperatorio());
		assertFalse(cursada.finalDisponible());
		
	}
	
	@Test
	public void queSePuedaRecursasConFinal() {
		//preparacion
		Materia materia = new Materia (45, "programacion");
		Alumno alumno = new Alumno (46265819, "Pedro", "Lopez");
		Integer parcial1 = 3;
		Integer parcial2 = 6;
		Integer recuperatorio =10;
		Integer notaFinal = 1;
		
		//ejecucion
		Cursada cursada = new Cursada (materia, alumno);
		cursada.hacerParciales(parcial1, parcial2);
		cursada.ponerNotas();
		cursada.obtenerRecuperatorio(recuperatorio);
		cursada.evaluarFinal(notaFinal);
		
		//verificacion
		assertNotNull(cursada);
		assertEquals(Calificar.DESAPROBADO, cursada.getNotaFinal());
		assertEquals(Calificar.FINAL, cursada.getRecuperatorio());
		assertEquals(Calificar.RECURSA, cursada.getDeFinal());
		
	}
	
	
	
}
