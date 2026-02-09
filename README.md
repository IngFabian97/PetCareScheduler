# PetCare Scheduler

## Descripción General del Proyecto

**Duración Estimada:** 90-120 minutos

### Objetivos de Aprendizaje

Después de completar este proyecto, podrás demostrar tu capacidad de:

- ✅ Aplicar principios de programación orientada a objetos para diseñar clases Pet y Appointment usando encapsulación
- ✅ Construir y manipular colecciones ArrayList o HashMap para gestionar múltiples registros de mascotas y citas
- ✅ Usar la API de Date and Time de Java para registrar y comparar fechas de registro de mascotas y citas
- ✅ Implementar operaciones de File I/O de Java para persistir y recuperar datos de mascotas y citas desde archivos
- ✅ Manejar entradas inválidas y excepciones en tiempo de ejecución gracefully usando los mecanismos de manejo de excepciones de Java
- ✅ Desarrollar lógica condicional y construcciones de bucles para navegar opciones de menú y mostrar varios historiales de citas e informes
- ✅ Generar reportes simples desde datos almacenados para mostrar citas próximas y vencidas

### Habilidades que Demostrarás

Trabajarás con:

- Fundamentos de programación en Java
- Strings y operaciones con strings
- Operadores y tipos de datos
- Excepciones
- Bucles for y while
- Sentencias condicionales (if/else)
- Arrays, Sets, Maps
- Métodos y funciones básicos
- Programación Orientada a Objetos (POO)

### Prerequisitos

Debes haber completado exitosamente los cursos relacionados con:
- Fundamentos de programación en Java
- Programación Orientada a Objetos en Java
- El proyecto práctico "Eco-Points Recycling Tracker" proporciona una base sólida

---

## Acerca del Proyecto

Eres un desarrollador Java junior trabajando para un pequeño servicio de cuidado de mascotas local que ayuda a los dueños de mascotas a mantener a sus amigos peludos saludables y felices.

Los dueños de mascotas a menudo olvidan tareas importantes como visitas al veterinario, vacunaciones y citas de aseo. **Paws & Whiskers** quiere proporcionar una simple aplicación basada en consola para ayudarles a organizar todas sus necesidades de cuidado de mascotas en un solo lugar.

**Tu objetivo** es construir una aplicación de consola de scheduler de cuidado de mascotas que permita a los usuarios:

- Registrar sus mascotas
- Registrar citas importantes
- Rastrear tareas próximas
- Mantener un historial de visitas pasadas
- Almacenar esta información de forma segura para que no desaparezca cuando la aplicación se cierre

---

## Tareas del Proyecto

### Task 1: Las Clases Blueprint del Objeto

Crea las siguientes clases bien estructuradas:

#### Clase Pet con los siguientes atributos:
- ID único de mascota
- Nombre
- Especies/Raza
- Edad
- Nombre del dueño
- Información de contacto
- Fecha de registro
- Lista de citas, usando un objeto de colección apropiado

#### Clase Appointment con los siguientes atributos:
- Tipo de cita (como visita al veterinario, vacunación, aseo)
- Fecha y hora
- Notas (opcional)

**Importante:** Usa encapsulación para proteger los datos y mantener tu código organizado.

---

### Task 2: La Aplicación Principal

Crea la aplicación PetCare Scheduler que:

- **Cargar Datos:** Carga datos existentes desde los archivos cuando la aplicación comienza. Asegúrate que este método sea privado.
- **Tomar y Procesar Entrada del Usuario:** Toma entrada del usuario y procésala para realizar una de las operaciones permitidas:
  - Registrar una mascota
  - Agendar una cita
  - Guardar los detalles en un archivo
  - Mostrar detalles de mascotas y/o citas
  - Generar reportes

---

### Task 3: Agregar Métodos para Manejar Entrada del Usuario

#### Registrar la Mascota:
Crea nuevos perfiles de mascota que contengan:
- ID único de mascota. Maneja duplicación de ID.
- Nombre
- Especies/Raza
- Edad. Maneja errores causados por entradas inválidas.
- Nombre del dueño/Contacto
- Fecha de registro. Usa los paquetes Date & Time para registrar fechas de registro de mascotas. Maneja errores causados por entradas inválidas.
- Agrega la mascota a la colección

#### Agendar una Cita:
Permite a los usuarios agendar citas para una mascota, incluyendo:
- Tipo de cita (como visita al veterinario, vacunación, aseo)
- Fecha y hora de la cita. Maneja errores causados por entradas inválidas.
- Notas si es necesario
- Agrega la cita a la colección para esa mascota

#### Mostrar Registros:
Muestra la siguiente información basada en la opción elegida:
- Todas las mascotas registradas
- Todas las citas para una mascota específica
- Citas próximas para todas las mascotas
- Historial de citas pasadas para cada mascota

#### Guardar Datos:
Guarda perfiles de mascotas y registros de citas en archivos usando Java File I/O para que los datos persistan cuando el programa se cierre. Maneja errores causados durante File I/O.

#### Generar Reportes:
Produce reportes simples incluyendo:
- Mascotas con citas próximas en la próxima semana
- Mascotas vencidas para una visita al veterinario (Por ejemplo: Sin visita al veterinario en los últimos 6 meses)

---

### Task 4: Compilar y Ejecutar

Compila todos los archivos que has creado y ejecuta la aplicación y verifica que funcione según los requisitos.

---

## Sistema de Calificación

Puedes ganar un total de 50 puntos para este proyecto basado en el siguiente sistema de distribución de puntos:

| Pregunta | Puntos |
|----------|--------|
| Código de la clase Pet | 5 |
| Código de la clase Appointment | 4 |
| Mejor opción para manejar fecha y hora en Appointment | 1 |
| Clase para especificar formato de fecha y hora | 2 |
| Clase que procesa entrada del usuario | 3 |
| Código que maneja selecciones del usuario | 3 |
| Código que maneja registro de mascotas | 3 |
| Código que maneja agendamiento de citas | 4 |
| Código que muestra datos según requisitos | 7 |
| Código que guarda datos en archivo | 3 |
| Código que carga datos desde archivo | 4 |
| Código que genera reportes | 3 |
| Salida del menú de usuario | 3 |
| Salida al registrar una mascota | 3 |
| Salida al agendar una cita | 2 |
| **TOTAL** | **50** |

---

## Consejos para Completar el Proyecto

1. ✏️ Revisa el proyecto antes de comenzar y prepárate para aplicar habilidades practicadas en proyectos anteriores
2. ✏️ Lee y sigue cuidadosamente las instrucciones para completar el proyecto
3. ✏️ Considera guardar tu código en un archivo de texto para fácil acceso
4. ✏️ Lee y sigue cuidadosamente las instrucciones de envío de tareas calificadas

---

## Estructura del Proyecto

```
PetCareScheduler/
├── src/
│   ├── Pet.java
│   ├── Appointment.java
│   └── PetCareScheduler.java
├── data/
│   ├── pets.txt (se creará automáticamente)
│   └── appointments.txt (se creará automáticamente)
└── README.md
```

---

**¡Empecemos a codificar!** 🚀