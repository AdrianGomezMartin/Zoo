package clases;

import java.util.ArrayList;

public class Jaula {
	private int numJaula;
	private boolean desperfectos;
	private ArrayList<Animal> animales;

	public Jaula() {
	}

	public Jaula(int numJaula, boolean desperfectos, ArrayList<Animal> animales) {
		super();
		this.numJaula = numJaula;
		this.desperfectos = desperfectos;
		this.animales = animales;
	}

	public int getNumJaula() {
		return numJaula;
	}

	public void setNumJaula(int numJaula) {
		this.numJaula = numJaula;
	}

	public boolean isDesperfectos() {
		return desperfectos;
	}

	public void setDesperfectos(boolean desperfectos) {
		this.desperfectos = desperfectos;
	}

	public ArrayList<Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(ArrayList<Animal> animales) {
		this.animales = animales;
	}

	public void addAnimal(Animal a) {
		this.animales.add(a);
	}

	@Override
	public String toString() {
		return "\nJaula [numJaula=" + numJaula + ", desperfectos=" + desperfectos + ", animales=" + animales + "]";
	}

}
