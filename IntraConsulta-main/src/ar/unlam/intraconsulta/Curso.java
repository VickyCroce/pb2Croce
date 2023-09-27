package ar.unlam.intraconsulta;

import java.util.ArrayList;

public class Curso {
	private Integer id;
	private static Integer contador =0;
	private Integer codigo;
	private Integer horario;
	private Materia materia;
	private CicloLectivo cicloLectivo;
	private Aula aula;
	private ArrayList <Cursada> cursadas;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesor> profes;

	public Curso(Integer codigo, Integer horario, Materia materia, Periodos periodoAcademico, Aula aula) {
		this.codigo = codigo;
		this.horario = horario;
		this.materia = materia;
		this.cicloLectivo = new CicloLectivo (periodoAcademico, null, null, null);
		this.aula = aula;
		this.profes = new ArrayList<Profesor>();
		this.alumnos = new ArrayList<Alumno>();
		this.cursadas = new ArrayList<Cursada>();
		this.id = this.generarSiguienteId();
	}
	
	public boolean hayEspacio() {
		if(this.alumnos.size() < this.aula.getCapacidad()) {
			return true;
		}return false;
	}

	public void asignarInicioYFinDePeriodo(Integer inicio, Integer fechaFinal) {
		this.cicloLectivo.setFechaFinalizacion(fechaFinal);
		this.cicloLectivo.setFechaInicio(inicio);
	}
	
	public void asignarFechaInscripciones(Integer fecha) {
		this.cicloLectivo.setFechaInscripcion(fecha);
	}

	public Profesor buscarProfePorDni(Integer dni) {
		for (int i = 0; i < this.profes.size(); i++) {
			if (this.profes.get(i).getDni().equals(dni)) {
				return this.profes.get(i);
			}
		}
		return null;
	}
	
	public boolean agregarProfe(Profesor profe) {
		if(!this.existeProfe(profe.getDni())) {
			return this.profes.add(profe);
		}
		return false;
	}

	public boolean existeProfe(Integer dni) {
		for (int i = 0; i < profes.size(); i++) {
			if (this.profes.get(i).getDni().equals(dni))
				return true;
		}
		return false;
	}
	
	public Alumno buscarAlumnoPorDni(Integer dni) {

		for (int i = 0; i < alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni))
				return this.alumnos.get(i);
		}
		return null;
	}
	
	public boolean agregarAlumno(Alumno alumno) {
		if(!this.existeAlumno(alumno.getDni()) && this.hayEspacio()) {
			this.alumnos.add(alumno);
			return this.cursadas.add(this.crearCursada(alumno.getDni()));
		 
	}
		return false;
}
	
	public Cursada crearCursada(Integer dni) {
		Cursada cursada = new Cursada(this.materia, this.buscarAlumnoPorDni(dni));
		return cursada;
	}
	
	public boolean existeCursada(Integer dni) {
		for (int i = 0; i < cursadas.size(); i++) {
			if (this.cursadas.get(i).getAlumno().getDni().equals(dni)) {
				return true;
		}
		}
		return false;
	}
	
	public boolean existeAlumno(Integer dni) {
		for (int i = 0; i < alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni))
				return true;
		}
		return false;
	}

	public Calificar obtenerResultadoDePruebasDeAlumnos(Integer dniAlumno, Integer parcial1, Integer parcial2) {
		Cursada cursada = this.buscarCursada(dniAlumno);
		cursada.hacerParciales(parcial1, parcial2);	
		return cursada.ponerNotas();	
	}
	
	public Calificar obtenerResultadoFinalAlumnos(Integer dniAlumno, Integer nota) {
	Cursada cursada = this.buscarCursada(dniAlumno);
	cursada.hacerFinal(nota);
	return cursada.getDeFinal();
	
	}
	
	public Calificar verEstadoDelAlumno(Integer dni) {
		Cursada cursada = this.buscarCursada(dni);
		if (cursada.getRecuperatorio() != null) {
			if (cursada.getRecuperatorio() == Calificar.FINAL) {
				return cursada.getDeFinal();
		}else if (cursada.getRecuperatorio() == Calificar.RECURSA || cursada.getRecuperatorio() == Calificar.PROMOCIONADO) {
				return cursada.getRecuperatorio();
		}	
		}
		return cursada.getNotaFinal();
	}
	
	public Calificar obtenerResultadoDelRecuperatorioAlumno(Integer dniAlumno, Integer notaNueva) {
		Cursada cursada = this.buscarCursada(dniAlumno);
		return cursada.obtenerRecuperatorio(notaNueva);	
	}
	
	public Cursada buscarCursada(Integer dni) {
		this.buscarAlumnoPorDni(dni);
		
		for (int i = 0; i < cursadas.size(); i++) {
			if (this.buscarAlumnoPorDni(dni) == cursadas.get(i).getAlumno()) {
				return this.cursadas.get(i);
		}
	}return null;
}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getHorario() {
		return horario;
	}

	public void setHorario(Integer horario) {
		this.horario = horario;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}
	
	public Integer getFechaInicial() {
		return this.cicloLectivo.getFechaInicio();
	}
	public Integer getFechaFinalizacion() {
		return this.cicloLectivo.getFechaFinalizacion();
	}
	public Integer getFechaInscripcion() {
		return this.cicloLectivo.getFechaInscripcion();
	}

	public ArrayList<Cursada> getCursadas() {
		return cursadas;
	}

	public void setCursadas(ArrayList<Cursada> cursadas) {
		this.cursadas = cursadas;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public ArrayList<Profesor> getProfes() {
		return profes;
	}

	public void setProfes(ArrayList<Profesor> profes) {
		this.profes = profes;
	}
	
	public Integer generarSiguienteId() {
		return this.contador++;
	}
	

}
