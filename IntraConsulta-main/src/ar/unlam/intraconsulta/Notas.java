package ar.unlam.intraconsulta;

public class Notas {
	private Integer id;
	private static Integer contador = 0;
	private Integer primerParcial;
	private Integer segundoParcial;
	private Integer recuperatorio;

	public Notas(Integer nota1, Integer nota2) {
		this.primerParcial = nota1;
		this.segundoParcial = nota2;
		this.recuperatorio = null;
		this.id = this.generarSiguienteId();
	}
	
	public Integer generarSiguienteId() {
		return this.contador++;
	}
	
	public void usarParcial(Integer numeroParcial, Integer notaNueva) {
		if (numeroParcial == 1) {
			this.setPrimerParcial(notaNueva);
		}else if (numeroParcial == 2) {
			this.setSegundoParcial(notaNueva);
		}
	}

	public Integer getPrimerParcial() {
		return primerParcial;
	}

	public void setPrimerParcial(Integer primerParcial) {
		this.primerParcial = primerParcial;
	}

	public Integer getSegundoParcial() {
		return segundoParcial;
	}

	public void setSegundoParcial(Integer segundoParcial) {
		this.segundoParcial = segundoParcial;
	}

	public Integer getRecuperatorio() {
		return recuperatorio;
	}

	public void setRecuperatorio(Integer recuperatorio) {
		this.recuperatorio = recuperatorio;
	}
	
	
	
}
