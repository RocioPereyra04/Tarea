Este programa en Java gestiona tareas usando una tabla de dispersión (hash). Cada tarea tiene un código único generado automáticamente con UUID, y guarda nombre, descripción, estado y fechas. Las tareas se guardan en un arreglo usando hashing y se manejan colisiones con sondeo cuadrático.
Desde el menú, el usuario puede:
Agregar tareas
Buscar tareas por código
Eliminar (baja lógica)
Ver todas las tareas
También se puede calcular el factor de carga, que muestra qué tan llena está la tabla. Es un sistema básico pero bien estructurado para organizar tareas.
