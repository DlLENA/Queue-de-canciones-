# 🎵 *Spotify Queue Simulation*

Este proyecto es una simulación de reproducción musical estilo Spotify. Está construido con una arquitectura modular en Java usando Maven, implementando una estructura de datos de Cola (FIFO) 
completamente desde cero, sin depender de las colecciones nativas del JDK.

## ♥ Cómo compilar e instalar la librería localmente

1. Abre tu terminal de comandos.
2. Navega a la raíz de la carpeta de la librería: `cd umg.edu.gt.data-structure.queue`
3. Ejecuta el comando de instalación de Maven: `mvn clean install`
4. Verifica que la consola muestre el mensaje `BUILD SUCCESS`. Esto compilará la estructura y la guardará en tu repositorio local para que el Handler pueda consumirla.

## ♥ Cómo compilar y ejecutar el reproductor (Handler)

1. Navega a la raíz de la carpeta del reproductor: `cd queueHandler`
2. Compila el proyecto: `mvn clean package`
3. Para ejecutar la simulación desde tu IDE (Eclipse), haz clic derecho sobre la clase `Main.java` y selecciona `Run As -> Java Application`. 

## ♥ Explicación del Diseño y Decisiones Técnicas

* **Arquitectura Modular:** El sistema se dividió en dos proyectos Maven independientes. Uno actúa exclusivamente como proveedor de la estructura de datos pura y el otro contiene la lógica de negocio y simulación.
* **Eficiencia O(1):** La cola se diseñó utilizando nodos enlazados (`Node<T>`) con punteros independientes hacia la cabeza (`head`) y la cola (`tail`). Esto garantiza que las operaciones de inserción y extracción sean inmediatas, sin necesidad de recorrer la lista con ciclos.
* **Encapsulamiento de Seguridad:** Los nodos internos y las variables de tamaño son estrictamente privados, exponiendo únicamente los métodos estándar y seguros de una cola FIFO.

## ♥ Implementación del Sistema de Prioridad

Para manejar las canciones de alta prioridad sin romper la regla fundamental FIFO, se optó por una estrategia de **Múltiples Colas Internas**. 
La clase administradora administra dos instancias separadas de nuestra cola personalizada: `vipQueue` (Prioridad 1) y `normalQueue` (Prioridad 2). 
Al momento de reproducir, el sistema evalúa constantemente la cola VIP; solo cuando esta se encuentra completamente vacía, el reproductor avanza con la cola normal. 
Esto garantiza que las prioridades se respeten de forma absoluta y que el orden de llegada dentro de cada categoría permanezca intacto.

## ♥ Simulación de Duración

La reproducción "segundo a segundo" se logró utilizando la instrucción `Thread.sleep(1000)` dentro de un ciclo iterativo. Cada iteración del ciclo representa un segundo en la vida real,
pausando el hilo principal de ejecución de Java e imprimiendo el progreso en la consola para brindar una experiencia realista.

## ♥ Extensiones de Complejidad (Extras Implementados)

Se implementaron dos mejoras adicionales para enriquecer la simulación:
* **Barra de progreso visual:** Un algoritmo matemático calcula el porcentaje de avance de la canción y dibuja dinámicamente una barra de 10 caracteres (ej. `[#####-----]`) que se actualiza cada segundo en los logs.
* **Tiempo total acumulado:** Un acumulador global registra la duración exacta de cada pista finalizada, mostrando el total de segundos reales de reproducción al concluir la lista completa.
