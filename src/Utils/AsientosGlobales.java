package Utils;

import java.util.HashSet;
import java.util.Set;

public class AsientosGlobales {
    private static final Set<String> asientosSeleccionados = new HashSet<>();
    private static final int MAX_ASIENTOS = 48;

    public static void agregarAsiento(String asiento) {
        asientosSeleccionados.add(asiento);
    }

    public static void quitarAsiento(String asiento) {
        asientosSeleccionados.remove(asiento);
    }

    public static boolean estaSeleccionado(String asiento) {
        return asientosSeleccionados.contains(asiento);
    }

    public static Set<String> obtenerAsientos() {
        return new HashSet<>(asientosSeleccionados);
    }

    public static int getTotalSeleccionados() {
        return asientosSeleccionados.size();
    }

    public static int getMaxAsientos() {
        return MAX_ASIENTOS;
    }

    public static void resetearAsientos() {
        asientosSeleccionados.clear();
    }
}