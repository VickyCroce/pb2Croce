package ar.unlam.intraconsulta;

public class Cursada {
	private Integer id;
	private static Integer contador = 0;
	private Calificar notaFinal;
	private Notas parciales;
	private Materia materia;
	private Alumno alumno;
	private Calificar recuperatorio;
	private Calificar deFinal;
	
	
	public Cursada(Materia materia, Alumno alumno) {
		this.materia = materia;
		this.alumno = alumno;
		this.parciales = null;
		this.recuperatorio = null;
		this.id = this.generarSiguienteId();
	}
	
	public Integer generarSiguienteId() {
		return this.contador++;
	}
	
	public void hacerParciales(Integer nota1, Integer nota2) {
		this.parciales = new Notas (nota1, nota2);
	}
	
	public Calificar ponerNotas() {
		if (this.parciales.getPrimerParcial() >=7 && this.parciales.getSegundoParcial()>=7) {
			notaFinal = Calificar.PROMOCIONADO;
		}else if ((this.parciales.getPrimerParcial() >=4 && this.parciales.getSegundoParcial()>=4) && (this.parciales.getPrimerParcial() <7 || this.parciales.getSegundoParcial()<7)) {
			notaFinal = Calificar.APROBADO;
		}else if (this.parciales.getPrimerParcial() <4 && this.parciales.getSegundoParcial() <4){
			notaFinal = Calificar.RECURSA;
		}else if (this.parciales.getPrimerParcial() <4 || this.parciales.getSegundoParcial() <4){
			notaFinal = Calificar.DESAPROBADO;
		}
		return notaFinal;	
}
	
	public Integer buscarRecuperatorio() {
		Integer parcialBuscado = 0;
		if(this.getNotaFinal() == Calificar.APROBADO) {
			if (this.parciales.getPrimerParcial() < 7 && this.parciales.getSegundoParcial() >=7) {
				parcialBuscado = 1;
			}else if (this.parciales.getSegundoParcial() < 7 && this.parciales.getPrimerParcial() >=7) {
				parcialBuscado = 2;
			}
		}if (this.getNotaFinal() == Calificar.DESAPROBADO) {
			if(this.parciales.getPrimerParcial() < 4 && this.parciales.getSegundoParcial() >=4) {
				parcialBuscado = 1;
			}else if (this.parciales.getSegundoParcial() < 4 && this.parciales.getPrimerParcial() >=4) {
				parcialBuscado = 2;
			}
		}
		return parcialBuscado;
	}

	public void hacerRecuperatorio(Integer parcialARecuperar, Integer notaDelRecuperatorio) {
		this.parciales.usarParcial(parcialARecuperar, notaDelRecuperatorio);
		
	}
	
	public boolean recuperatorioDisponible() {
		if (this.buscarRecuperatorio() == 1 || this.buscarRecuperatorio() == 2) {
			return true;
		}return false;	
	}

	public Calificar obtenerRecuperatorio(Integer notaFinal) {
		Integer parcialDesaprobado = this.buscarRecuperatorio();
		this.hacerRecuperatorio( parcialDesaprobado, notaFinal);
		if(this.evaluarRecuperatorio() == Calificar.FINAL) {
			this.setRecuperatorio(Calificar.FINAL) ;
		}else if(this.evaluarRecuperatorio() == Calificar.RECURSA){
			this.setRecuperatorio(Calificar.RECURSA) ;
		}else if(this.evaluarRecuperatorio() == Calificar.PROMOCIONADO){
			this.setRecuperatorio(Calificar.PROMOCIONADO) ;
		}
		return getRecuperatorio();
	}
	
	public Calificar evaluarRecuperatorio() {
		if (this.parciales.getPrimerParcial() >=7 && this.parciales.getSegundoParcial()>=7) {
			recuperatorio = Calificar.PROMOCIONADO;
		}else if ((this.parciales.getPrimerParcial() >=4 && this.parciales.getSegundoParcial()>=4) && (this.parciales.getPrimerParcial() <7 || this.parciales.getSegundoParcial()<7)) {
			recuperatorio = Calificar.FINAL;
		}else if (this.parciales.getPrimerParcial() <4 || this.parciales.getSegundoParcial() <4){
			recuperatorio = Calificar.RECURSA;
		}
		return recuperatorio;	
}
	
	public Calificar hacerFinal(Integer nota) {
		if(this.finalDisponible()) {
			this.evaluarFinal(nota);
			return this.getDeFinal();
		}
		return null;
	}
	
	public void evaluarFinal(Integer nota) {
		if (nota >=4) {
			this.deFinal = Calificar.APROBADO;
		}else {
		this.deFinal = Calificar.RECURSA;
		}
	}
	
	public boolean finalDisponible() {
		if (this.recuperatorio == Calificar.APROBADO || this.getNotaFinal() == Calificar.APROBADO ) {
		return true;
		}
		return false;
	}
	
	public Calificar getRecuperatorio() {
		return recuperatorio;
	}

	public void setRecuperatorio(Calificar recuperatorio) {
		this.recuperatorio = recuperatorio;
	}

	public Calificar getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(Calificar notaFinal) {
		this.notaFinal = notaFinal;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}


	public Calificar getDeFinal() {
		return deFinal;
	}


	public void setDeFinal(Calificar deFinal) {
		this.deFinal = deFinal;
	}
	
	
}
