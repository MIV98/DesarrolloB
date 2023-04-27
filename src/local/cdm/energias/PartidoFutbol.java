package local.cdm.energias;

public class PartidoFutbol implements Accion {
	private Integer categoria;
	private Boolean prorroga;
	private Boolean penaltis;
	private Integer energiaNecesaria;
	
	public PartidoFutbol(Integer categoria) {
		if (categoria < 1 && categoria > 7) {
			this.categoria = 1;
		} else {
			this.categoria = categoria;
		}
		
		this.prorroga = false;
		this.penaltis = false;
		
		this.energiaNecesaria = this.categoria * 40;
	}

	@Override
	public Integer getEnergia() {
		return this.energiaNecesaria;
	}

	@Override
	public void hacer() {
		String salida = "Jugando partido de categoria " + this.categoria;
		
		if (this.prorroga) salida += " con prórroga";
		if (this.penaltis) salida += " y penaltis";
		
		System.out.println(salida);
		
	}

	public Boolean getProrroga() {
		return prorroga;
	}

	public Boolean getPenaltis() {
		return penaltis;
	}

	public void setProrroga(Boolean prorroga) {
		this.prorroga = prorroga;
		
		if (this.prorroga) {
			Double energiaNueva = this.energiaNecesaria * 1.15;
			this.energiaNecesaria = energiaNueva.intValue();
		}
	}

	public void setPenaltis(Boolean penaltis) {
		this.penaltis = penaltis;
		if (penaltis && !this.prorroga) {
			this.prorroga = true;
			Double energiaNueva = this.energiaNecesaria * 1.15;
			this.energiaNecesaria = energiaNueva.intValue();
		} else {
			Double energiaNueva = this.energiaNecesaria * 1.05;
			this.energiaNecesaria = energiaNueva.intValue();
		}
	}
	
	
	
}
