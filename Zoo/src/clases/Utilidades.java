package clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Utilidades {
	private static Scanner dameScanner() {
		return new Scanner(System.in);
	}

	public static String pedirCadena(String enunciado) {
		System.out.println(enunciado);
		return dameScanner().nextLine();
	}

	public static int pedirEntero(String enunciado) {
		System.out.println(enunciado);
		return dameScanner().nextInt();
	}

	public static double pedirDouble(String enunciado) {
		System.out.println(enunciado);
		return dameScanner().nextDouble();
	}

	public static Animal rellenarAnimal() {
		return new Animal(pedirCadena("Nombre?"), pedirCadena("Especie?"), pedirDouble("Gastos?"),
				pedirDouble("Ingresos?"));
	}

	public static Jaula rellenarJaula() {

		return new Jaula(pedirEntero("Numero Jaula?"),
				(pedirCadena("Tiene Desperfectos?[S/n]").equalsIgnoreCase("S") ? true : false), rellenarAnimales());
	}

	public static short mostrarMenu(String[] opciones) {
		System.out.println("\n*******************************************************");
		for (int i = 0; i < opciones.length; i++) {
			System.err.println("*     " + i + "-. " + opciones[i].toUpperCase());
		}
		System.out.println("*******************************************************");
		System.out.println("Introduce una opcion del menu".toUpperCase());
		System.out.println("*******************************************************");
		short opc = dameScanner().nextShort();
		System.out.println("*******************************************************");
		return opc;
	}

	public static ArrayList<Animal> rellenarAnimales() {

		ArrayList<Animal> animales;
		int numeroAnimales = pedirEntero("Cuantos animales hay en la jaula? ");
		Animal[] arrayAnimales = new Animal[numeroAnimales];
		for (int i = 0; i < arrayAnimales.length; i++) {
			arrayAnimales[i] = rellenarAnimal();
		}
		animales = new ArrayList<>(Arrays.asList(arrayAnimales));
		return animales;
	}

	public static Jaula[] crearEstructura() {
		Jaula[] zoo = new Jaula[4];
		boolean vacia = (pedirCadena("Estructura vacia?[S/n]").equalsIgnoreCase("S") ? true : false);
		System.out.println("Creando Estructura...");
		for (int i = 0; i < zoo.length; i++) {
			if (vacia) {
				zoo[i] = new Jaula(i, false, new ArrayList<Animal>());
			} else
				zoo[i] = rellenarJaula();
		}
		System.out.println("Estructura creada con éxito");
		return zoo;
	}
}
