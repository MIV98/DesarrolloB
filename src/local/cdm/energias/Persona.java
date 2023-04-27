package local.cdm.energias;

import java.util.ArrayList;
import java.util.List;

public class Persona implements Energetico {
	private String nombre;
	private Double capacidadVejiga;
	private Double estadoVejiga;
	private Integer energiaActual;
	private List<Accion> tareas;
	
	public Persona(String nombre, Double capacidadVejiga) {
		this.nombre = nombre;
		this.capacidadVejiga = capacidadVejiga;
		this.estadoVejiga = 0.0;
		this.energiaActual = 100;
		this.tareas = new ArrayList<>();
	}
	
	public void addTarea(Accion tarea) {
		this.tareas.add(tarea);
	}
	
	public Integer hacerTareas() {
		Integer tareasCompletadas = 0;
		
		for (Accion tarea : tareas) {
			if (this.energiaActual - tarea.getEnergia() < 0) {
				continue;
			} else {
				tarea.hacer();
				this.energiaActual -= tarea.getEnergia();
				this.tareas.remove(tarea);
				tareasCompletadas++;
			}
		}
		
		return tareasCompletadas;
	}
	
	public void vaciarVejiga() {
		this.estadoVejiga = 0.0;
	}
	
	public Double beber(Bebible bebible) {
		Double cantidadBebida = bebible.getLitros();
		this.estadoVejiga += bebible.getLitros();
		if (this.estadoVejiga > this.capacidadVejiga) {
			cantidadBebida = cantidadBebida - this.estadoVejiga - this.capacidadVejiga;
			this.estadoVejiga = this.capacidadVejiga;
		}
		
		// Esto debería calcular el porcentaje bebido y darme la energía en relación
		Double aumentoEnergia = bebible.getEnergia() * (cantidadBebida * 100 / bebible.getLitros());
		this.energiaActual += (int) Math.round(aumentoEnergia);
		
		// Debería devolver esto?
		return cantidadBebida;
	}
	
	@Override
	public Integer getEnergia() {
		return this.energiaActual;
	}

}
