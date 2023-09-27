package ar.unlam.intraconsulta;

public class CicloLectivo {
	private Periodos periodoAcademico;
	private Integer fechaInicio;
	private Integer fechaFinalizacion;
	private Integer fechaInscripcion;
	
	public CicloLectivo(Periodos periodoAcademico, Integer fechaInicio, Integer fechaFinalizacion,Integer fechaInscripcion) {
		this.periodoAcademico = periodoAcademico;
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
		this.fechaInscripcion = fechaInscripcion;
	}

	public Periodos getPeriodoAcademico() {
		return periodoAcademico;
	}

	public void setPeriodoAcademico(Periodos periodoAcademico) {
		this.periodoAcademico = periodoAcademico;
	}

	public Integer getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Integer fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Integer getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Integer fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public Integer getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Integer fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	
}
