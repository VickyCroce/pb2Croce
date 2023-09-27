package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAula {

	@Test
	public void queSePuedaCrearUnAula() {
		//Preparacion
		Integer numero = 56;
		
		//ejecucion
		Aula aula = new Aula (numero);
		
		//verificacion
		assertNotNull(numero);
		
	}
	
	@Test
	public void queSePuedaAsignarCursoAUnAula() {
		//Preparacion
		Integer numero = 56;
		Integer codCurso = 1234;
		Integer horario = 1500;
		Materia materia = new Materia(1223, "pb2");
		Periodos cuatri = Periodos.SEGUNDO_CUATRIMESTRE;
		
		
		//ejecucion
		Aula aula = new Aula (numero);
		Curso curso = new Curso (codCurso, horario, materia, cuatri, aula);
		aula.asignarCurso(curso);
		
		//verificacion
		assertNotNull(numero);
		assertEquals(curso, aula.getCurso());
	}
	
	@Test
	public void queSePuedaConocerLaMateria() {
		//Preparacion
		Integer numero = 56;
		Integer codCurso = 1234;
		Integer horario = 1500;
		Materia materia = new Materia(1223, "pb2");
		Periodos cuatri = Periodos.SEGUNDO_CUATRIMESTRE;
		
		
		//ejecucion
		Aula aula = new Aula (numero);
		Curso curso = new Curso (codCurso, horario, materia, cuatri, aula);
		aula.asignarCurso(curso);
		aula.conocerMateria();
		
		//verificacion
		assertNotNull(numero);
		assertEquals(curso, aula.getCurso());
		assertEquals(materia, aula.conocerMateria());
		
	}
	

	@Test
	public void queSePuedaEncontrarUnProfe() {
		//Preparacion
		Integer numero = 56;
		Integer codCurso = 1234;
		Integer horario = 1500;
		Materia materia = new Materia(1223, "pb2");
		Periodos cuatri = Periodos.SEGUNDO_CUATRIMESTRE;
		Profesor profe = new Profesor (4548215, "Pepe");
		
		
		//ejecucion
		Aula aula = new Aula (numero);
		Curso curso = new Curso (codCurso, horario, materia, cuatri, aula);
		curso.agregarProfe(profe);
		aula.asignarCurso(curso);
		
		//verificacion
		assertNotNull(numero);
		assertEquals(curso, aula.getCurso());
		assertEquals(profe, aula.buscarProfes(profe.getDni()));
		
	}
	

	@Test
	public void queSePuedaConocerCapacidadAula() {
		//Preparacion
		Integer numero = 56;
		Integer codCurso = 1234;
		Integer horario = 1500;
		Materia materia = new Materia(1223, "pb2");
		Periodos cuatri = Periodos.SEGUNDO_CUATRIMESTRE;
		Profesor profe = new Profesor (4548215, "Pepe");
		Integer capacidadEsperada =20;
		
		
		//ejecucion
		Aula aula = new Aula (numero);
		Curso curso = new Curso (codCurso, horario, materia, cuatri, aula);
		curso.agregarProfe(profe);
		aula.asignarCurso(curso);
		
		//verificacion
		assertNotNull(numero);
		assertEquals(curso, aula.getCurso());
		assertEquals(capacidadEsperada, aula.getCapacidad());
		
		
	}
	
	
	
	
	
	
	
	

}
