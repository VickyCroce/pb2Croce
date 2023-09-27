package ar.unlam.intraconsulta;

import java.util.ArrayList;

public class Materia {
	private Integer id;
	private static Integer contador = 0;
	private Integer codigo;
	private String nombre;
	private ArrayList<Materia> correlativas;

	public Materia(Integer codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
		correlativas = new ArrayList<>();
		this.id = this.generarSiguienteId();
	}
	public Integer generarSiguienteId() {
		return this.contador++;
	}
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(ArrayList<Materia> correlativas) {
		this.correlativas = correlativas;
	}

	public boolean agregarCorrelativa(Materia correlativa) {
		if (correlativas.contains(correlativa))
			return false;

		return correlativas.add(correlativa);
	}
	public Materia buscarCorrelativa(Materia materia) {
        for(int i = 0; i < this.correlativas.size(); i++) {
            if(correlativas.get(i).equals(materia)) {
                return correlativas.get(i);
            }
        }
        return null;
    }
}
