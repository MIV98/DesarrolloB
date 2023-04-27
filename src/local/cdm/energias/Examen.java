package local.cdm.energias;

public abstract class Examen implements Accion{
	protected String asignatura;
	protected Integer minutos;
	protected Integer energiaNecesaria;
	
	public Examen(String asignatura, Integer minutos) {
		this.asignatura = asignatura;
		this.minutos = minutos;
	}
	
	@Override
	public abstract void hacer();

	@Override
	public Integer getEnergia() {
		return this.energiaNecesaria;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public Integer getMinutos() {
		return minutos;
	}
	
}
