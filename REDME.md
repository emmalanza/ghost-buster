# Ghostbusters en Asturias 👻


![Java](https://img.shields.io/badge/Java-21-blue)
![JUnit](https://img.shields.io/badge/JUnit-Test-green)
![Maven](https://img.shields.io/badge/Maven-Build-orange)

## Tabla de Contenidos
- [Descripción](#descripción)
- [Cómo Jugar](#cómo-jugar)
- [Opciones del Jugador](#opciones-del-jugador)
- [Instalación](#instalación)
- [Uso](#uso)
- [Ejemplo de Interacción](#ejemplo-de-interacción)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Autores](#autores)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)

---

## Descripción

Juego donde te puedes divertir capturando y liberando fantasmas, con múltiples opciones para salvar Asturias de sucesos paranormales y convertirte en un Ghostbuster.

🚨 **Algo muy extraño está sucediendo en Asturias** 🚨

Los habitantes de algunas aldeas, villas costeras e incluso grandes ciudades han comenzado a detectar sucesos paranormales:

- 👻 **Fantasma feudal** que mueve objetos con telequinesis.
- 🌊 **Marinero invisible** que muestra visiones de naufragios.
- 🏰 **Dama fantasmal** que posee a los visitantes.
- 🔥 **Voces espectrales** y luces manipuladas por energía.
- ⛪ **Monja levitante** que crea tormentas.
- 🌑 **Sombra gigantesca** que induce miedo.

Un nuevo equipo de Ghostbusters ha sido creado para proteger la región. ¡Vosotros formaréis parte de ese equipo!

La base de operaciones está en un viejo almacén industrial en Avilés, acondicionado para albergar trampas ectoplásmicas y equipo de investigación.

---

## Cómo Jugar 🎮

1. **Captura fantasmas** que rondan diferentes lugares de Asturias.
2. **Consulta tu colección** para analizar características y planear estrategias.
3. **Libera fantasmas** menos peligrosos si necesitas más espacio.
4. **Filtra y estudia los fantasmas** por clase y fecha de captura.
5. **Asegura la protección de Asturias** y conviértete en un legendario Ghostbuster.

---

## Opciones del Jugador

1. Capturar un nuevo fantasma.
2. Ver lista de fantasmas capturados.
3. Liberar un fantasma.
4. Filtrar fantasmas por clase.
5. Ver fantasmas capturados en un mes.
6. Salir del juego.

---

## Instalación

### Prerrequisitos
- **Java SE Development Kit (JDK) 11 o superior**. Descárgalo [aquí](https://www.oracle.com/java/technologies/javase-downloads.html).

### Pasos

Clonar el Repositorio:
```bash
git clone https://github.com/emmalanza/ghostbusters-asturias.git
```

Navegar al Directorio del Proyecto:
```bash
cd ghostbusters-asturias
```

Compilar el Proyecto:
```bash
javac -d bin src/com/f5/ghostbuster/**/*.java
```

Ejecutar el Proyecto:
```bash
java -cp bin com.f5.ghostbuster.Main
```

---

## Uso

Al iniciar el programa, se mostrará un menú con las opciones disponibles. Selecciona ingresando el número correspondiente y sigue las instrucciones.

---

## Ejemplo de Interacción

```plaintext
============================================
    ¡Bienvenido a la Base Ghostbusters Asturias!
============================================

Opciones:
1. Capturar un nuevo fantasma
2. Ver lista de fantasmas capturados
3. Liberar un fantasma
4. Filtrar fantasmas por clase
5. Ver fantasmas capturados en un mes
6. Salir

Por favor, selecciona una opción (1-6):
```

Ejemplo de lista de fantasmas capturados:

| ID | Nombre                           | Clase  | Nivel de Peligro | Fecha de Captura |
|----|----------------------------------|--------|-----------------|------------------|
| 1  | Espíritu del Pescador de Lastres | Clase IV | Bajo          | 2025-01-26       |
| 2  | Sombras del Monte Naranco       | Clase II | Medio         | 2025-01-24       |
| 3  | Entidad de las Minas            | Clase VI | Alto          | 2025-01-20       |

---

## Tecnologías Utilizadas

- **Java (JDK 21)**
- **JUnit** (para pruebas)
- **Maven** (gestión de dependencias)
- **Hamcrest** (para pruebas unitarias)

---

## Autores

👤 **Emma Lanza**
- GitHub: [@emmalanza](https://github.com/emmalanza)

👤 **Yef Gav**
- GitHub: [@YefGav](https://github.com/YefGav)

---

## Contribuciones

¡Las contribuciones son bienvenidas! Sigue estos pasos:

1. **Haz un fork** del repositorio.
2. Crea una nueva rama:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Realiza los cambios y confirma los commits:
   ```bash
   git commit -m "Agregar nueva funcionalidad"
   ```
4. Sube los cambios a tu fork:
   ```bash
   git push origin feature/nueva-funcionalidad
   ```
5. Abre un **Pull Request**.

---

## Licencia

Este proyecto actualmente no tiene una licencia específica.