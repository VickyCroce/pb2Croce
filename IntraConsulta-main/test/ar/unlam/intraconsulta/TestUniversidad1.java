package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUniversidad1 {

	@Test
	public void queSePuedaCrearUnaUniversidad() {
		//Preparacion
		String nombre = "unlam";
		
		//Ejecucion
		Universidad unlam = new Universidad("UNLAM");
	
		//Verificacion
		assertNotNull(unlam);
	}

	@Test
	public void queSePuedaRegistrarYBuscarProfe() {
		//Preparacion
		String nombre = "unlam";
		String nombreprofe = "Pedro";
		Integer dni =46265819;
		
		//Ejecucion
		Universidad unlam = new Universidad("UNLAM");
		Profesor profe = new Profesor (dni, nombreprofe);
		unlam.registrarProfesor(profe);
		
		//Verificacion
		assertNotNull(unlam);
		assertEquals(profe, unlam.buscarProfePorDni(dni));
	}
	
	@Test
	public void queSePuedaRegistrarMateriaYBuscar() {
		//Preparacion
		String nombre = "unlam";
		String materiaCorrelativa = "Pb2";
		String nombreMateria = "pb1";
		Integer codigo = 1234;
		Integer codCorrelativa =4321;
		
		//Ejecucion
		Universidad unlam = new Universidad("UNLAM");
		Materia materia1 = new Materia(codigo, nombreMateria);
		Materia materia2 = new Materia(codCorrelativa, materiaCorrelativa);
		unlam.registraMateria(materia1);
		
		
		//Verificacion
		assertNotNull(unlam);
		assertEquals(materia1, unlam.buscarMateriaPorCodigo(codigo));
		
	}
	
	@Test
	public void queSePuedaRegistrarMateriaConCorrelativaYBuscar() {
		//Preparacion
		String nombre = "unlam";
		String materiaCorrelativa = "Pb2";
		String nombreMateria = "pb1";
		Integer codigo = 1234;
		Integer codCorrelativa =4321;
		
		//Ejecucion
		Universidad unlam = new Universidad("UNLAM");
		Materia materia1 = new Materia(codigo, nombreMateria);
		Materia materia2 = new Materia(codCorrelativa, materiaCorrelativa);
		unlam.registraMateria(materia1);
		unlam.agregarCorrelativa(materia1, materia2);
		
		
		//Verificacion
		assertNotNull(unlam);
		assertEquals(materia1, unlam.buscarMateriaPorCodigo(codigo));
		assertEquals(materia2, unlam.buscarCorrelativa(materia1, materia2));
	}
	
	@Test
	public void queSePuedaAsignarElAula() {
		//Preparacion
		String nombre = "unlam";
		Integer numAula = 602;
		
		//Ejecucion
		Universidad unlam = new Universidad("UNLAM");
		Aula aula = new Aula (numAula);
		unlam.buscarAulaLibreYCrear(aula);
		
		
		
		//Verificacion
		assertNotNull(unlam);
		assertEquals(aula, unlam.buscarAulaPorNumero(aula.getNumero()));
	}
	
	@Test
	public void queSePuedaAsignarUnCurso() {
		//Preparacion
		String nombre = "unlam";
		String nombreMateria = "pb1";
		Integer codigoMateria = 1234;
		Integer horario = 1200;
		Integer numAula = 602;
		Periodos periodo = Periodos.SEGUNDO_CUATRIMESTRE;
		String nombreprofe = "Pedro";
		Integer dniProfe =46265819;
		Integer codCurso = 5555;
		
		
		//Ejecucion
		Universidad unlam = new Universidad(nombre);
		Materia materia1 = new Materia(codigoMateria, nombreMateria);
		Profesor profe = new Profesor (dniProfe, nombreprofe);
		Aula aula = new Aula(numAula);
		unlam.registraMateria(materia1);
		unlam.registrarProfesor(profe);
		unlam.buscarAulaLibreYCrear(aula);
		Curso curso =unlam.asignarCurso(codCurso,codigoMateria, horario, periodo, aula, profe.getDni() );
		

		//Verificacion
		assertNotNull(unlam);
		assertEquals(materia1, unlam.buscarMateriaPorCodigo(codigoMateria));
		assertEquals(profe, unlam.buscarProfePorDni(dniProfe));
		assertEquals(curso, unlam.buscarCurso(codCurso));
	}
	
	@Test
	public void queSePuedaRegistrarUnAlumno() {
		//Preparacion
		String nombre = "unlam";
		String nombreAlumno = "delfi";
		Integer dni = 1234;
		String apellido = "Pedro";
		
		
		//Ejecucion
		Universidad unlam = new Universidad(nombre);
		Alumno alumno = new Alumno (dni, apellido, nombre);
		unlam.registrar(alumno);
		
		

		//Verificacion
		assertNotNull(unlam);
		assertEquals(alumno, unlam.buscarAlumnoPorDni(dni));
	}
	
	@Test
	public void queSePuedaInscribirAlumnoACurso() {
		//Preparacion
		String nombre = "unlam";
		String nombreMateria = "pb1";
		Integer codigo = 1234;
		Integer horario = 1200;
		Integer numAula = 602;
		Periodos periodo = Periodos.SEGUNDO_CUATRIMESTRE;
		String nombreprofe = "Pedro";
		Integer dniProfe =46265819;
		String nombreAlumno = "delfi";
		Integer dni = 1234;
		String apellido = "Pedro";
		Integer codCurso = 5555;
		
		
		//Ejecucion
		Universidad unlam = new Universidad(nombre);
		Materia materia1 = new Materia(codigo, nombreMateria);
		Alumno alumno = new Alumno (dni, apellido, nombre);
		Profesor profe = new Profesor (dniProfe, nombreprofe);
		Aula aula = new Aula(numAula);
		unlam.registraMateria(materia1);
		unlam.registrarProfesor(profe);
		unlam.registrar(alumno);
		unlam.buscarAulaLibreYCrear(aula);
		Curso curso = unlam.asignarCurso(codCurso,codigo, horario, periodo, aula, profe.getDni() );
		unlam.inscribirAlumnoAUnCurso(alumno.getDni(), unlam.buscarCurso(codCurso).getCodigo());

		//Verificacion
		assertNotNull(unlam);
		assertEquals(materia1, unlam.buscarMateriaPorCodigo(codigo));
		assertEquals(profe, unlam.buscarProfePorDni(dniProfe));
		assertEquals(curso, unlam.buscarCurso(codCurso));
		assertEquals(alumno, curso.buscarAlumnoPorDni(dni));
	}
	@Test
	public void queNoSePuedaInscribirAlumnoACurso() {
		
		// Preparacion
				String nombre = "UNLAM";
				Integer codigoCurso = 5557, horario = 1200, horasSemanales = 4;
				Materia matematicas = new Materia(1771, "Matematicas");
				Materia matematicas2 = new Materia(1772, "Matematicas 2");
				Periodos periodo1 = Periodos.PRIMER_CUATRIMESTRE;
				Periodos periodo2 = Periodos.SEGUNDO_CUATRIMESTRE;
				Aula aula = new Aula(45);
				Aula aula2 = new Aula(46);
				Alumno facundo = new Alumno(46364928, "Facundo", "Mamani Quispe");
				Integer parcial1 = 1, parcial2 = 2;
				Profesor profeMati = new Profesor(46364928, "Matias");
				Profesor profePablo = new Profesor(46265819, "Pablo");

				// Ejecucion
				Universidad unlam = new Universidad(nombre);
				unlam.registrar(facundo);
				unlam.registraMateria(matematicas);
				unlam.registrarProfesor(profeMati);
				unlam.registraMateria(matematicas2);
				unlam.registrarProfesor(profePablo);
				Curso curso = new Curso(codigoCurso, horario, matematicas, periodo1, aula);
				unlam.agregarCurso(curso);
				unlam.asignarCurso(codigoCurso, matematicas.getCodigo(), horario, periodo1, aula, profeMati.getDni());
				unlam.inscribirAlumnoAUnCurso(facundo.getDni(), codigoCurso);
				curso.obtenerResultadoDePruebasDeAlumnos(facundo.getDni(), parcial1, parcial2);
				Curso curso2 = new Curso(1234, 1200, matematicas2, periodo2, aula2);
				unlam.agregarCurso(curso2);
				unlam.asignarCurso(curso2.getCodigo(), matematicas2.getCodigo(), horario, periodo2, aula2, profePablo.getDni());
				unlam.agregarCorrelativa(matematicas2, matematicas);
				
				// Validacion
				assertNotNull(curso);
				assertEquals(facundo, unlam.buscarAlumnoPorDni(facundo.getDni()));
				assertTrue(curso.existeAlumno(facundo.getDni()));
				assertEquals(matematicas, unlam.buscarMateriaPorCodigo(matematicas.getCodigo()));
				assertEquals(matematicas, curso.getMateria());
				assertEquals(Calificar.RECURSA, curso.verEstadoDelAlumno(facundo.getDni()));
				assertFalse(unlam.inscribirAlumnoAUnCurso(facundo.getDni(), curso2.getCodigo()));
	}

}
