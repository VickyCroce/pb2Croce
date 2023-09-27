package ar.unlam.intraconsulta;

public class Aula {
	private Integer id;
	private static Integer contador = 0;
	private Integer numero;
	private Curso curso;
	private Integer capacidad;

	public Aula(Integer numero) {
		this.numero = numero;
		this.id = this.generarSiguienteId();
	}
	
	public void asignarCurso(Curso curso) {
		this.curso = curso;
		this.actualizarLimiteAlumnos();
	}
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Materia conocerMateria() {
		return this.curso.getMateria();
	}
	
	public Profesor buscarProfes(Integer dni) {
		return this.curso.buscarProfePorDni(dni);
	}
	
	public Integer actualizarLimiteAlumnos() {
		Integer limite = 0;
		for(int i =0; i<curso.getProfes().size();i++) {
			if(curso.getProfes().get(i) !=null) {
				limite++;
			}
		}
		return this.capacidad = 20 * limite;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	public Integer generarSiguienteId() {
		return this.contador++;
	}
	
}

