package local.cdm.energias;

public class ExamenPractico extends Examen {
	
	public ExamenPractico(String asignatura, Integer minutos) {
		super(asignatura, minutos);
		this.energiaNecesaria = minutos / 2;
	}
	
	@Override
	public void hacer() {
		System.out.println("Haciendo el examen práctico de la asignatura " + this.asignatura);
	}
	
}
