# Parcial II - Programación II (G412) - Juego de Batallas de Criaturas
## Integrantes ##
- [Alejandro Ibarra ] 
- [Juan Pablo Rubiano] 

## Aprendizajes
- **Control de Versiones Colaborativo:** Trabajo en equipo mediante ramas separadas, commits descriptivos, sincronización con `git pull` / `git push` y resolución de integración en `main`.
- **Programación Orientada a Objetos (POO):**
  - **Abstracción:** Definición de la clase abstracta `Criatura` como plantilla base con métodos obligatorios `atacar(Criatura)` y `defender(int)`.
  - **Herencia:** Reutilización de atributos y métodos comunes (`nombre`, `salud`, `fuerza`, `estaViva`) en las subclases `Dragon`, `Mago`, `Guerrero` y `Orco`.
  - **Polimorfismo:** Tratamiento uniforme de cualquier criatura a través de la referencia `Criatura`, permitiendo combates dinámicos sin importar la subclase concreta.
  - **Encapsulamiento:** Protección de atributos con visibilidad adecuada (`protected` / `private`) y métodos de acceso (`getters` / `setters`).
  - **Interfaces:** Implementación de `HabilidadEspecial` para dotar de poderes únicos a clases específicas sin acoplar la jerarquía de herencia.
---
## Consultas Realizadas
- **Uso y utilidades de `java.util.Map` en Java:** Consulta sobre cómo almacenar colecciones pares clave-valor (ej. catálogos de criaturas, grimorio de hechizos del mago o conteo de victorias).
- **Configuración de codificación UTF-8 en Maven:** Ajuste de `<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>` en el `pom.xml` para compilar sin conflictos caracteres en español como la letra `ñ` en el parámetro `defender(int daño)`.
- **Estructura de pruebas con JUnit 5 (Jupiter):** Uso de anotaciones `@Test`, `@BeforeEach`, `@DisplayName` y aserciones (`assertEquals`, `assertTrue`, `assertFalse`, `assertInstanceOf`).
---
## Uso de la Inteligencia Artificial
- **Asistencia en arquitectura y código:** Apoyo en la generación de la estructura inicial de las clases abstractas, interfaces y métodos de combate según el diagrama UML.
- **Consultas conceptuales:** Explicación y ejemplos sobre cómo integrar estructuras de datos avanzadas como `Map` en el diseño orientado a objetos.
- **Creación de Casos de Prueba Unitarios:** Apoyo en el diseño de escenarios de prueba exhaustivos con JUnit 5 para validar el comportamiento del daño, mitigación de defensas y finalización de batallas.
---
## Pruebas Unitarias (Puntos Adicionales)
Se implementaron **11 pruebas unitarias** automáticas utilizando **JUnit 5**, divididas en dos suites de prueba:
### 1. `CriaturaTest.java` (Validación de lógica de combate y daño/salud)
1. **`testEstadoInicialYEstaViva`:** Verifica que los atributos se inicialicen correctamente y que `estaViva()` devuelva `true` cuando `salud > 0` y `false` cuando la salud llega a 0.
2. **`testAtaqueDragon`:** Comprueba que el ataque del dragón inflige el doble de su fuerza (`fuerza * 2`).
3. **`testDefensaDragon`:** Valida que las escamas del dragón absorben 5 puntos del daño recibido.
4. **`testAtaqueYDefensaMago`:** Valida el daño base de los hechizos del mago y la reducción de 4 puntos de daño mediante su barrera mágica.
5. **`testAtaqueYDefensaGuerrero`:** Valida el ataque con arma del guerrero y la reducción de 3 puntos de daño gracias a su armadura.
6. **`testAtaqueYDefensaOrco`:** Valida el ataque con bonificación de fuerza bruta (+3) y su resistencia física reduciendo 2 puntos de daño.
7. **`testHabilidadEspecial`:** Comprueba que las criaturas que implementan `HabilidadEspecial` (`Dragon` y `Mago`) puedan ejecutar sus habilidades devastadoras correctamente sobre el objetivo.
8. **`testSaludNoNegativa`:** Garantiza que al recibir daño letal masivo, la salud no quede con valores negativos y se fije en 0.
### 2. `BatallaTest.java` (Simulación de combate y polimorfismo)
9. **`testBatallaDragonVsMago`:** Simula una batalla completa garantizando que el combate finalice con un único ganador vivo y el oponente en 0 de salud.
10. **`testBatallaGuerreroVsOrco`:** Simula el combate entre Guerrero y Orco comprobando la alternancia de turnos y victoria válida.
11. **`testPolimorfismoColeccionCriaturas`:** Demuestra el uso de polimorfismo creando un arreglo de tipo `Criatura[]` que almacena instancias de distintas subclases y las opera de manera genérica.
