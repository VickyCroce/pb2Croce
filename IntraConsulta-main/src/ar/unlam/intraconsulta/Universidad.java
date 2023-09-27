package ar.unlam.intraconsulta;

import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {

	private Integer id;
	private static Integer contador=0;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesor> profesores;
	private String nombre;
	private ArrayList<Materia> materias;
	private ArrayList<Curso> curso;
	private ArrayList<Aula> aula;

	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
		this.materias = new ArrayList<>();
		this.profesores = new ArrayList<Profesor>();
		this.curso = new ArrayList<>();
		this.aula = new ArrayList<Aula>();
		this.id = this.generarSiguienteId();
	}

	public boolean registrar(Alumno alumno) {
		if (buscarAlumnoPorDni(alumno.getDni()) == null)
			return this.alumnos.add(alumno);
		return false;
	}
	
	public boolean registraMateria(Materia materia) {
		return this.materias.add(materia);
	}
	
	public boolean registrarProfesor(Profesor profe) {
		return this.profesores.add(profe);
	}

	public Profesor buscarProfePorDni(Integer dni) {
		for (int i = 0; i < this.profesores.size(); i++) {
			if (this.profesores.get(i).getDni().equals(dni)) {
				return this.profesores.get(i);
			}
		}
		return null;
	}

	public Materia buscarMateriaPorCodigo(Integer codigo) {
		for (int i = 0; i < this.materias.size(); i++) {
			if (this.materias.get(i).getCodigo().equals(codigo))
				return this.materias.get(i);
		}
		return null;
	}

	public Alumno buscarAlumnoPorDni(Integer dni) {

		for (int i = 0; i < alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni))
				return this.alumnos.get(i);
		}
		return null;
	}

	public Curso buscarCurso(Integer codigo) {
		for (Integer i = 0; i < this.curso.size(); i++) {
			if (this.curso.get(i).getCodigo().equals(codigo))
				return this.curso.get(i);
		}
		return null;
	}

	public boolean buscarAulaLibreYCrear(Aula aula) {
		for (Integer i = 0; i < this.aula.size(); i++) {
			if (this.aula.get(i).getNumero() == aula.getNumero()) {
				return false;
			}
		}
		return this.aula.add(aula);
	}

	public Aula buscarAulaPorNumero(Integer numero) {
		for (int i = 0; i < this.aula.size(); i++) {
			if (this.aula.get(i).getNumero().equals(numero)) {
				return this.aula.get(i);
		}
	}return null;
	
	}
	
	public Materia buscarCorrelativa(Materia materia, Materia correlativa) {
        for(int i = 0; i < this.materias.size(); i++) {
            if(this.materias.get(i).getCodigo().equals(materia.getCodigo())) {
                return this.materias.get(i).buscarCorrelativa(correlativa);
            }
        }
        return null;
    }
	
	public boolean agregarCurso(Curso curso) {
		return this.curso.add(curso);
	}
	
	public boolean existeAlumno(Integer dni) {
		for (int i = 0; i < alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni))
				return true;
		}
		return false;
	}

	public boolean inscribirAlumnoAUnCurso(Integer dni, Integer codigo) {
		boolean inscripto = false;
		Alumno alumno = this.buscarAlumnoPorDni(dni);
		Materia materia = this.buscarCurso(codigo).getMateria();

		if (alumno == null || materia == null) {
			return inscripto;
		}
		ArrayList<Materia> correlativas = materia.getCorrelativas();
		if(correlativas.size() != 0) {
			for (int i = 0; i < correlativas.size(); i++) {
				Materia correlativa = correlativas.get(i);
				if (!estaAprobado(dni, correlativa.getCodigo()))
					return inscripto;
			}
		}
		this.buscarCurso(codigo).agregarAlumno(alumno);
		return inscripto = true;
	
	}
	
	public void agregarCorrelativa(Materia materia, Materia correlativa) {
		for (int i = 0; i<this.materias.size();i++) {
		if(this.materias.get(i).getCodigo().equals(materia.getCodigo())) {
			this.materias.get(i).agregarCorrelativa(correlativa);
		}
		}
	}
	
	public Curso buscarCursoPorDni(Integer dni) {
		for(int i=0; i<this.curso.size();i++) {
			if(this.curso.get(i).buscarAlumnoPorDni(dni)!= null) {
				return this.curso.get(i);
			}
		}
		return null;
	}
	
	public Curso buscarCursoPorCodigoMateria(Integer codigo) {
		for(int i=0; i<this.materias.size();i++) {
			if(this.curso.get(i).getMateria().getCodigo().equals(codigo)) {
				return this.curso.get(i);
			}
		}
		return null;
	}

	public boolean estaAprobado(Integer dni, Integer codigo) {
		Curso curso = this.buscarCursoPorCodigoMateria(codigo);
		if (curso.verEstadoDelAlumno(dni) == Calificar.APROBADO ||curso.verEstadoDelAlumno(dni) == Calificar.PROMOCIONADO) {
			return true;
		}
		return false;
	}

	public Curso asignarCurso(Integer codigoCurso,Integer codigoMateria, Integer horario, Periodos cicloLectivo, Aula aula, Integer dniProfe) {
		Materia materia1 = this.buscarMateriaPorCodigo(codigoMateria);
		Profesor profes = this.buscarProfePorDni(dniProfe);
		if(this.buscarAulaPorNumero(aula.getNumero())== null) {
		 this.buscarAulaLibreYCrear(aula);
		 aula= this.buscarAulaPorNumero(aula.getNumero());
		}else {
			aula = this.buscarAulaPorNumero(aula.getNumero());
		}
		if (materia1 == null || profes == null) {
			return null;
		}
		Curso curso = new Curso(codigoCurso, horario, materia1, cicloLectivo, aula);
		this.agregarCurso(curso);
		curso.agregarProfe(profes);
		aula.asignarCurso(curso);
		return curso;
	}
	
	public Integer generarSiguienteId() {
		return this.contador++;
	}

}
