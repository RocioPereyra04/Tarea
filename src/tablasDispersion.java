public class tablasDispersion {
    // Atributos
    private Tareas[] tabla;         // Array que representa la tabla hash
    private int numElementos;       // Cantidad de elementos insertados
    private final int TAMAÑO = 101; // Tamaño fijo de la tabla

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

    // Metodo de la multiplicación para calcular la posición en la tabla

    public int calcularPosicion(String codigo) {
        double A = 0.6180339887; // constante recomendada
        int valor = valor(codigo);
        double producto = valor * A;
        double decimal = producto - Math.floor(producto);
        return (int)(decimal * TAMAÑO);
    }

    // Exploración cuadrática para resolver colisiones
    public int resolverColision(int posicionInicial, int i) {
        return (posicionInicial + i * i) % TAMAÑO;
    }

    // Calcula y retorna el factor de carga actual de la tabla
    public double calcularFactorCarga() {
        return (double) numElementos / TAMAÑO;
    }

    // Inserta una tarea en la tabla si hay espacio disponible
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

    // Busca una tarea activa por su código
    public Tareas buscar(String codigo) {
        int posicion = calcularPosicion(codigo);
        int i = 0;

        while (tabla[posicion] != null) {
            if (tabla[posicion].getCodigo().equals(codigo) && tabla[posicion].isALTA()) {
                return tabla[posicion]; // encontrada
            }
            i++;
            posicion = resolverColision(posicion, i);
        }

        return null; // no encontrada
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

    // Elimina una tarea (baja lógica: cambia esALTA a false)
    public boolean eliminar(String codigo) {
        Tareas t = buscar(codigo);
        if (t != null) {
            t.setALTA(false);
            return true;
        }
        return false;
    }

    // Muestra todas las tareas (activas y dadas de baja) con su estado
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
