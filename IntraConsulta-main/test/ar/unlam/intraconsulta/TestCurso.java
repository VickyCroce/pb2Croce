package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCurso {

	@Test
	public void queSePuedaCrearUnCurso() {
	//preparacion
		Integer codigo = 4646;
		Integer horario = 1200;
		Materia materia = new Materia (1256, "Programacion");
		Periodos periodo = Periodos.PRIMER_CUATRIMESTRE;
		Aula aula = new Aula(56);
		
	//ejecucion
		Curso curso = new Curso(codigo, horario, materia, periodo, aula);
		
	//validacion
		assertNotNull(curso);
	}
	
	@Test
	public void queSePuedanAsignarFechas() {
	//preparacion
		Integer codigo = 4646;
		Integer horario = 1200;
		Materia materia = new Materia (1256, "Programacion");
		Periodos periodo = Periodos.PRIMER_CUATRIMESTRE;
		Aula aula = new Aula(56);
		Integer fechaInicio = 0103;
		Integer fechaFinalizacion = 2506;
		Integer fechaInscripcion = 3001;
		
		
	//ejecucion
		Curso curso = new Curso(codigo, horario, materia, periodo, aula);
		curso.asignarFechaInscripciones(fechaInscripcion);
		curso.asignarInicioYFinDePeriodo(fechaInicio, fechaFinalizacion);
		
	//validacion
		assertNotNull(curso);
		assertEquals(fechaInscripcion, curso.getFechaInscripcion());
		assertEquals(fechaInicio, curso.getFechaInicial());
		assertEquals(fechaFinalizacion, curso.getFechaFinalizacion());
	}
	
	@Test
	public void queSePuedanAsignarProfes() {
	//preparacion
		Integer codigo = 4646;
		Integer horario = 1200;
		Materia materia = new Materia (1256, "Programacion");
		Periodos periodo = Periodos.PRIMER_CUATRIMESTRE;
		Aula aula = new Aula(56);
		Profesor profe = new Profesor(46464585, "Mati"  );
		
	//ejecucion
		Curso curso = new Curso(codigo, horario, materia, periodo, aula);
		curso.agregarProfe(profe);
        aula.asignarCurso(curso);
		
	//validacion
		assertNotNull(curso);
		assertTrue(curso.existeProfe(profe.getDni()));
	}
	
	@Test
	public void queSePuedanAsignarAlumno() {
	//preparacion
		Integer codigo = 4646;
		Integer horario = 1200;
		Materia materia = new Materia (1256, "Programacion");
		Periodos periodo = Periodos.PRIMER_CUATRIMESTRE;
		Profesor profe = new Profesor(46464585, "Mati"  );
		Aula aula = new Aula(56);
		Alumno alumno = new Alumno(455454, "Carlos", "pelado" );
		
	//ejecucion
		Curso curso = new Curso(codigo, horario, materia, periodo, aula);
		curso.agregarProfe(profe);
        aula.asignarCurso(curso);
		curso.agregarAlumno(alumno);
		
	//validacion
		assertNotNull(curso);
		assertTrue(curso.existeAlumno(alumno.getDni()));
	}
	
	@Test
	public void queSePuedanCrearUnaCursada() {
	//preparacion
		Integer codigo = 4646;
		Integer horario = 1200;
		Materia materia = new Materia (1256, "Programacion");
		Periodos periodo = Periodos.PRIMER_CUATRIMESTRE;
		Profesor profe = new Profesor(46464585, "Mati"  );
		Aula aula = new Aula(56);
		Alumno alumno = new Alumno(455454, "Carlos", "pelado" );
		
	//ejecucion
		Curso curso = new Curso(codigo, horario, materia, periodo, aula);
		curso.agregarProfe(profe);
       aula.asignarCurso(curso);
		curso.agregarAlumno(alumno);
		
	//validacion
		assertNotNull(curso);
		assertTrue(curso.existeCursada(alumno.getDni()));
	}
	
	@Test
	public void queSePuedaObtenerResultadoDePruebaAlumnos() {
	//preparacion
		Integer codigo = 4646;
		Integer horario = 1200;
		Materia materia = new Materia (1256, "Programacion");
		Periodos periodo = Periodos.PRIMER_CUATRIMESTRE;
		Profesor profe = new Profesor(46464585, "Mati"  );
		Aula aula = new Aula(56);
		Alumno alumno = new Alumno(455454, "Carlos", "pelado" );
		Integer parcial1 = 10;
		Integer parcial2 = 9;
		
	//ejecucion
		Curso curso = new Curso(codigo, horario, materia, periodo, aula);
		curso.agregarProfe(profe);
        aula.asignarCurso(curso);
		curso.agregarAlumno(alumno);
		curso.obtenerResultadoDePruebasDeAlumnos(alumno.getDni(), parcial1, parcial2);
		
		
	//validacion
		assertNotNull(curso);
		assertTrue(curso.existeCursada(alumno.getDni()));
		assertEquals(Calificar.PROMOCIONADO, curso.verEstadoDelAlumno(alumno.getDni()));
	}
	
	
	
	@Test
	public void queSePuedaObtenerFinalConRecuperatorio() {
	//preparacion
		Integer codigo = 4646;
		Integer horario = 1200;
		Materia materia = new Materia (1256, "Programacion");
		Periodos periodo = Periodos.PRIMER_CUATRIMESTRE;
		Profesor profe = new Profesor(46464585, "Mati"  );
		Aula aula = new Aula(56);
		Alumno alumno = new Alumno(455454, "Carlos", "pelado" );
		Integer parcial1 = 10;
		Integer parcial2 = 5;
		Integer notaRecu =6;
		
	//ejecucion
		Curso curso = new Curso(codigo, horario, materia, periodo, aula);
		curso.agregarProfe(profe);
        aula.asignarCurso(curso);
		curso.agregarAlumno(alumno);
		curso.obtenerResultadoDePruebasDeAlumnos(alumno.getDni(), parcial1, parcial2);
		curso.obtenerResultadoDelRecuperatorioAlumno(alumno.getDni(),notaRecu);
		
	//validacion
		assertNotNull(curso);
		assertTrue(curso.existeCursada(alumno.getDni()));
		assertTrue(curso.buscarCursada(alumno.getDni()).finalDisponible());
		
	}
	
	
	@Test
	public void queSePuedaObtenerFinal() {
	//preparacion
		Integer codigo = 4646;
		Integer horario = 1200;
		Materia materia = new Materia (1256, "Programacion");
		Periodos periodo = Periodos.PRIMER_CUATRIMESTRE;
		Profesor profe = new Profesor(46464585, "Mati"  );
		Aula aula = new Aula(56);
		Alumno alumno = new Alumno(455454, "Carlos", "pelado" );
		Integer parcial1 = 10;
		Integer parcial2 = 5;
		
	//ejecucion
		Curso curso = new Curso(codigo, horario, materia, periodo, aula);
		curso.agregarProfe(profe);
        aula.asignarCurso(curso);
		curso.agregarAlumno(alumno);
		curso.obtenerResultadoDePruebasDeAlumnos(alumno.getDni(), parcial1, parcial2);
		
	//validacion
		assertNotNull(curso);
		assertTrue(curso.existeCursada(alumno.getDni()));
		assertTrue(curso.buscarCursada(alumno.getDni()).finalDisponible());
	}
	
	@Test
	public void queSeRecurseEnUnFinal() {
	//preparacion
		Integer codigo = 4646;
		Integer horario = 1200;
		Materia materia = new Materia (1256, "Programacion");
		Periodos periodo = Periodos.PRIMER_CUATRIMESTRE;
		Profesor profe = new Profesor(46464585, "Mati"  );
		Aula aula = new Aula(56);
		Alumno alumno = new Alumno(455454, "Carlos", "pelado" );
		Integer parcial1 = 10;
		Integer parcial2 = 4;
		Integer recuperatorio = 4;
		Integer notaFinal= 3;
		
		
	//ejecucion
		Curso curso = new Curso(codigo, horario, materia, periodo, aula);
		curso.agregarProfe(profe);
        aula.asignarCurso(curso);
		curso.agregarAlumno(alumno);
		curso.obtenerResultadoDePruebasDeAlumnos(alumno.getDni(), parcial1, parcial2);
		curso.obtenerResultadoDelRecuperatorioAlumno(alumno.getDni(), recuperatorio);
		curso.obtenerResultadoFinalAlumnos(alumno.getDni(), notaFinal);
		
		
	//validacion
		assertNotNull(curso);
		assertTrue(curso.existeAlumno(alumno.getDni()));
		assertEquals(Calificar.RECURSA, curso.verEstadoDelAlumno(alumno.getDni()));
		assertTrue(curso.buscarCursada(alumno.getDni()).finalDisponible());
	}	
	@Test
	public void queSeApruebeEnUnFinal() {
	//preparacion
		Integer codigo = 4646;
		Integer horario = 1200;
		Materia materia = new Materia (1256, "Programacion");
		Periodos periodo = Periodos.PRIMER_CUATRIMESTRE;
		Profesor profe = new Profesor(46464585, "Mati"  );
		Aula aula = new Aula(56);
		Alumno alumno = new Alumno(455454, "Carlos", "pelado" );
		Integer parcial1 = 10;
		Integer parcial2 = 4;
		Integer recuperatorio = 4;
		Integer notaFinal= 9;
		
		
	//ejecucion
		Curso curso = new Curso(codigo, horario, materia, periodo, aula);
		curso.agregarProfe(profe);
        aula.asignarCurso(curso);
		curso.agregarAlumno(alumno);
		curso.obtenerResultadoDePruebasDeAlumnos(alumno.getDni(), parcial1, parcial2);
		curso.obtenerResultadoDelRecuperatorioAlumno(alumno.getDni(), recuperatorio);
		curso.obtenerResultadoFinalAlumnos(alumno.getDni(), notaFinal);
		
		
	//validacion
		assertNotNull(curso);
		assertTrue(curso.existeAlumno(alumno.getDni()));
		assertEquals(Calificar.APROBADO, curso.verEstadoDelAlumno(alumno.getDni()));
		assertTrue(curso.buscarCursada(alumno.getDni()).finalDisponible());
	}	
	
	@Test
    public void saberSiHayEspacio() {
        //Preparacion
		Integer codigo = 4646;
		Integer horario = 1200;
        Materia matematicas = new Materia(1771, "Matematicas");
        Periodos periodo = Periodos.PRIMER_CUATRIMESTRE;
        Aula aula = new Aula(56);
        Profesor profe = new Profesor(46464585, "Matias");
        Alumno alumno = new Alumno(455454, "Carlos", "pelado" );

        //Ejecucion
        Curso curso = new Curso(codigo, horario, matematicas, periodo, aula);
        curso.agregarProfe(profe);
        aula.asignarCurso(curso);
        curso.agregarAlumno(alumno);

        //Validacion
        assertNotNull(curso);
        assertTrue(curso.existeProfe(profe.getDni()));
        assertTrue(curso.existeAlumno(alumno.getDni()));
        assertTrue(curso.hayEspacio());
    }
	
	
	@Test
    public void saberSiNoHayEspacio() {
        //Preparacion
		Integer codigo = 4646;
		Integer horario = 1200;
        Materia matematicas = new Materia(1771, "Matematicas");
        Periodos periodo = Periodos.PRIMER_CUATRIMESTRE;
        Aula aula = new Aula(56);
        Alumno alumno = new Alumno(455454, "Carlos", "pelado" );

        //Ejecucion
        Curso curso = new Curso(codigo, horario, matematicas, periodo, aula);
        aula.asignarCurso(curso);
        curso.agregarAlumno(alumno);

        //Validacion
        assertNotNull(curso);
        assertFalse(curso.existeAlumno(alumno.getDni()));
        assertFalse(curso.hayEspacio());
    }
	
	

}
