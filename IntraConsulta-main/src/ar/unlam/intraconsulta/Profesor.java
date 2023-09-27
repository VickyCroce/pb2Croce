package ar.unlam.intraconsulta;

public class Profesor {
	private Integer id;
	private static Integer contador =0;
	private String nombre;
	private Integer dni;

	public Profesor(Integer dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
		this.id = this.generarSiguienteId();
	}
	
	public Integer generarSiguienteId() {
		return this.contador++;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

}
