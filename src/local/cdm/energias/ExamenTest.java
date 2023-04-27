package local.cdm.energias;

public class ExamenTest extends Examen {
	private Integer numPreguntas;
	private Boolean resta;
	
	public ExamenTest(String asignatura, Integer numPreguntas, Boolean resta) {
		super(asignatura, numPreguntas / 2);
		this.numPreguntas = numPreguntas;
		this.resta = resta;
		
		if (this.resta) {
			this.energiaNecesaria = numPreguntas / 2;
		} else {
			this.energiaNecesaria = numPreguntas / 4;			
		}
	}
	
	@Override
	public void hacer() {
		for (int i = 1; i <= this.numPreguntas; i++) {
			System.out.println("Haciendo pregunta " + i + " del examen de la asignatura " + this.asignatura);
		}
	}

	public Integer getNumPreguntas() {
		return numPreguntas;
	}

	public Boolean getResta() {
		return resta;
	}
	
	
}
