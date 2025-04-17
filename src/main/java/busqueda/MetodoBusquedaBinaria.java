package busqueda;

import java.util.List;

public class MetodoBusquedaBinaria {
    public static int lee(List<Persona> lista, int objetivo) {
        int bajo = 0;
        int alto = lista.size() - 1;

        while (bajo <= alto) {
            int centro = (bajo + alto) / 2;
            Persona personaCentro = lista.get(centro);

            for (int i = bajo; i <= alto; i++) {
                System.out.print(lista.get(i).getEdad());
                if (i < alto) System.out.print(" | ");
            }
            System.out.println();

            System.out.println("bajo=" + bajo + "    alto=" + alto + "    centro=" + centro +
                    "    valorCentro=" + personaCentro.getEdad());

            if (personaCentro.getEdad() == objetivo) {
                System.out.println("--> ENCONTRADO");
                return centro;
            } else if (personaCentro.getEdad() < objetivo) {
                System.out.println("--> DERECHA");
                bajo = centro + 1;
            } else {
                System.out.println("--> IZQUIERDA");
                alto = centro - 1;
            }

            System.out.println();
        }

        return -1; //
    }
}
