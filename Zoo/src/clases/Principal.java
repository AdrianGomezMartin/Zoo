package clases;

import java.util.ArrayList;

public class Principal {

	public static void darBajaAnimal(Jaula[] zoo) {
		String nombreAnimal = Utilidades.pedirCadena("Nombre del animal que desea dar de baja?");
		boolean encontrado = false;
		for (int i = 0; i < zoo.length; i++) {
			for (int j = 0; j < zoo[i].getAnimales().size(); j++) {
				if (zoo[i].getAnimales().get(j).getNombre().equalsIgnoreCase(nombreAnimal)) {
					encontrado = true;
					System.out.println("Animal encontrado en la jaula" + zoo[i].getNumJaula());
					System.out.println("Dando de baja  animal...");
					zoo[i].getAnimales().remove(j);
					System.out.println("Animal dado de baja con éxito");
				}
			}
		}
		if (!encontrado) {
			System.out.println("El animal " + nombreAnimal + " no existe.");
		}
	}

	public static void mostrarPorEspecie(Jaula[] zoo) {
		String especie = Utilidades.pedirCadena("Especie que desea mostrar");
		ArrayList<Animal> animalesEspecie = new ArrayList<>();
		boolean encontrado = false;
		for (int i = 0; i < zoo.length; i++) {
			for (int j = 0; j < zoo[i].getAnimales().size(); j++) {
				if (zoo[i].getAnimales().get(j).getEspecie().equalsIgnoreCase(especie)) {
					encontrado = true;
					Animal e = zoo[i].getAnimales().get(j);
					animalesEspecie.add(e);
				}
			}
		}
		if (encontrado)
			System.out.println(animalesEspecie);
		else
			System.out.println("No hay ningun animal de la especie: " + especie);
	}

	public static void apuntarDesperfecto(Jaula[] zoo) {
		int numeroJaula = Utilidades.pedirEntero("Introduce el numero de la jaula que tiene  desperfectos");
		for (int i = 0; i < zoo.length; i++) {
			if (zoo[i].getNumJaula() == numeroJaula) {
				zoo[i].setDesperfectos(true);
			}
			if (zoo[i].isDesperfectos())
				System.out.println(zoo[i]);
		}
	}

	public static void mostrarAnimalesQueProducenBeneficio(Jaula[] zoo) {
		for (int i = 0; i < zoo.length; i++) {
			ArrayList<Animal> animales = zoo[i].getAnimales();
			for (int j = 0; j < animales.size(); j++) {
				Animal animal = animales.get(j);
				if (animal.getIngresos() > animal.getGastos())
					System.out.println(animal);
			}
		}
	}

	public static void main(String[] args) {
		short opc;
		Jaula[] zoo = new Jaula[4];
		boolean salir = false;

		do {
			try {
				opc = Utilidades.mostrarMenu(new String[] { "Añadir Animales ", "Dar de Baja Animal",
						"Mostrar por especie", "Apuntar Desperfecto", "Mostrar animales que generen ganancias",
						"Mostrar Zoo", "Salir" });
				switch (opc) {
				case 0:
					zoo = Utilidades.crearEstructura();
					break;
				case 1:
					// Dar de baja animal
					darBajaAnimal(zoo);
					break;
				case 2:
					// Mostrar por especie
					mostrarPorEspecie(zoo);
					break;
				case 3:
					// Apuntar desperfectos
					apuntarDesperfecto(zoo);
					break;
				case 4:
					// Mostrar animales que dan beneficio
					mostrarAnimalesQueProducenBeneficio(zoo);
					break;
				case 5:
					System.out.println(zoo);
					break;
				case 6:
					System.err.println("*******************************************************");
					System.err.println("Saliendo del programa....\n Adiós :)");
					System.err.println("*******************************************************");
					salir = true;
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("\n\nUps. Algo no ha ido como debia");
				System.err.println(
						e.getCause() == null ? "Estas accediendo a un objeto nulo. Rellena las jaulas" : "");
			}

		} while (!salir);
		zoo = null;

	}

}
