package clases;

public class Animal {
	private String nombre;
	private String especie;
	private double gastos;
	private double ingresos;

	public Animal() {

	}

	public Animal(String nombre, String especie, double gastos, double ingresos) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.gastos = gastos;
		this.ingresos = ingresos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public double getGastos() {
		return gastos;
	}

	public void setGastos(double gastos) {
		this.gastos = gastos;
	}

	public double getIngresos() {
		return ingresos;
	}

	public void setIngresos(double ingresos) {
		this.ingresos = ingresos;
	}

	@Override
	public String toString() {
		return "\n\tAnimal [nombre=" + nombre + ", especie=" + especie + ", gastos=" + gastos + ", ingresos=" + ingresos
				+ "]";
	}
	
}
