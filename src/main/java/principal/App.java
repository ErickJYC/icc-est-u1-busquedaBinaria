package principal;

import busqueda.MetodoBusquedaBinaria;
import busqueda.Persona;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();

        System.out.print("Ingrese cantidad de personas: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingrese Persona:");
            System.out.print("  Nombre: ");
            String nombre = scanner.nextLine();

            int edad;
            do {
                System.out.print("  Edad: ");
                edad = scanner.nextInt();
                scanner.nextLine();
                if (edad < 0) {
                    System.out.println("  La edad no puede ser negativa. Intente de nuevo.");
                }
            } while (edad < 0);

            personas.add(new Persona(nombre, edad));
        }

        personas.sort(Comparator.comparingInt(Persona::getEdad));

        System.out.print("Arreglo ordenado por edad: ");
        for (Persona p : personas) {
            System.out.print(p.getEdad() + " | ");
        }
        System.out.println();

        System.out.print("\nValor la persona de la edad: ");
        int objetivo = scanner.nextInt();

        int posicion = MetodoBusquedaBinaria.lee(personas, objetivo);

        if (posicion != -1) {
            System.out.println("La persona con la edad " + objetivo + " es " + personas.get(posicion).getNombre());
        } else {
            System.out.println("No se encontró una persona con esa edad.");
        }

        scanner.close();
    }

}
