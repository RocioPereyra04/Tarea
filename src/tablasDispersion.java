public class tablasDispersion {
    // Atributos
    private Tareas[] tabla;         // Array que representa la tabla hash
    private int numElementos;       
    private final int TAMAÑO = 101; // Tamaño de la tabla

    // Constructor: inicializa la tabla y contador
    public tablasDispersion() {
        this.tabla = new Tareas[TAMAÑO];
        this.numElementos = 0;
    }

    // Convierte un código (String) en un valor numérico sumando los valores ASCII de sus caracteres
    private int valor(String codigo) {
        int valor = 0;
        for (int i = 0; i < codigo.length(); i++) {
            valor += codigo.charAt(i);
        }
        return valor;
    }

    // Metodo de la multiplicación
    public int calcularPosicion(String codigo) {
        double A = 0.6180339887; 
        int valor = valor(codigo);
        double producto = valor * A;
        double decimal = producto - Math.floor(producto);
        return (int)(decimal * TAMAÑO);
    }

    // Exploración cuadrática 
    public int resolverColision(int posicionInicial, int i) {
        return (posicionInicial + i * i) % TAMAÑO;
    }

    // Calcula y retorna el factor de carga 
    public double calcularFactorCarga() {
        return (double) numElementos / TAMAÑO;
    }

    // Inserta una tarea en la tabla si hay espacio 
    public boolean insertar(Tareas t) {
        if (numElementos >= TAMAÑO) return false;

        int posicion = calcularPosicion(t.getCodigo());
        int i = 0;

        // Explora hasta encontrar una posición libre o baja
        while (tabla[posicion] != null && tabla[posicion].isALTA()) {
            i++;
            posicion = resolverColision(posicion, i);
        }

        tabla[posicion] = t;
        numElementos++;
        return true;
    }

    public Tareas buscar(String codigo) {
        int posicion = calcularPosicion(codigo);
        int i = 0;

        while (tabla[posicion] != null) {
            if (tabla[posicion].getCodigo().equals(codigo) && tabla[posicion].isALTA()) {
                return tabla[posicion];
            }
            i++;
            posicion = resolverColision(posicion, i);
        }

        return null; 
    }

    // Verifica si la tabla está vacía
    public boolean estaVacia() {
        for (int i = 0; i < TAMAÑO; i++) {
            if (tabla[i] != null) {
                return false;
            }
        }
        return true;
    }

    // Elimina una tarea (le da la baja: cambia esALTA a false)
    public boolean eliminar(String codigo) {
        Tareas t = buscar(codigo);
        if (t != null) {
            t.setALTA(false);
            return true;
        }
        return false;
    }

    // Muestra todas las tareas con su estado
    public void mostrarTabla() {
        System.out.println("\n--- Estado actual de la tabla ---");
        for (int i = 0; i < TAMAÑO; i++) {
            if (tabla[i] != null) {
                String estado = tabla[i].isALTA() ? "ACTIVA" : "BAJA";
                System.out.println("[" + i + "] " + tabla[i] + " --> " + estado);
            }
        }
    }
}
