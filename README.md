# **Actividad: Sistema de Gestión de Biblioteca en Kotlin**

**ID actividad:** U4, U5, U6(RA2, RA4 y RA7.) - Examen práctico

**Agrupamiento de la actividad**: Individual

---

- **RECOMENDACIÓN**: Antes de realizar el ejercicio, léelo al completo.

## 1. Descripción

¡Bienvenidos a esta emocionante actividad individual de programación orientada a objetos (POO)! Vamos a embarcarnos en la creación de un **Sistema de Gestión de Biblioteca** utilizando Kotlin, un lenguaje moderno y poderoso que nos permitirá aplicar y profundizar en nuestros conocimientos de POO de manera práctica y efectiva.

En este sistema, seremos capaces de gestionar y realizar préstamos de **libros** y otros elementos que exploraremos más adelante. El objetivo es desarrollar un sistema que no solo sea funcional sino también eficiente, escalable y fácil de mantener.

**Interacción y Usabilidad**: Para verificar el correcto funcionamiento del sistema y facilitar la interacción con el mismo, implementaremos un **menú de usuario**. Este menú incorporará todas las acciones posibles del sistema, permitiendo al usuario interactuar de manera clara y eficaz.

### **1.1 Elementos Clave del Dominio**

Para llevar a cabo este proyecto, trabajaremos con varios **conceptos clave** que formarán la base de nuestro sistema:

- **Libro**: Este será uno de los elementos fundamentales de nuestro sistema. Cada libro contendrá información esencial como por ejemplo **id** (UUID)**, título, autor, año de publicación, temática,** y **estado** (disponible o prestado).
- **GestorBiblioteca**: Esta clase será el corazón de nuestro sistema, encargándose de la lógica para gestionar los libros y otros elementos. Incluirá un **catálogo** de elementos y un registro de préstamos (**RegistroPrestamos)**, permitiendo agregar o eliminar elementos, registrar préstamos y devoluciones, y consultar la disponibilidad de los elementos.
- **Usuario**: Representará a los usuarios de la biblioteca, conteniendo información como **ID, nombre,** y una lista de **libros prestados**.
- **Catálogo**: Este concepto merece especial atención. Se trata de una colección dinámica que alberga todos los elementos disponibles en la biblioteca, desde libros hasta revistas y DVDs. El **catálogo** facilita la organización y el acceso rápido a estos elementos, jugando un papel fundamental en la eficiencia y flexibilidad del sistema.
- **RegistroPrestamos**: Mantendrá un registro de los préstamos actuales y un historial de todos los préstamos realizados, permitiendo registrar préstamos y devoluciones, así como consultar el historial de préstamos de libros específicos o usuarios.

### **1.2 Evolución y Optimización del Sistema**

A lo largo de este proyecto, no solo estableceremos las bases funcionales de nuestro sistema sino que también lo expandiremos y optimizaremos mediante:

- La integración de **métodos estáticos** y el aprovechamiento de **clases genéricas**, lo que nos permitirá manejar diversos tipos de elementos de manera más eficiente.
- La aplicación de principios de **herencia, clases abstractas e interfaces** para construir una arquitectura de software robusta y extensible.

### **1.3 Buenas Prácticas y Organización del Código**

A medida que desarrollamos nuestro sistema, deberemos seguir varias buenas prácticas para asegurar la calidad y la comprensión del código:

- **Comentarios y Documentación**: Es vital comentar adecuadamente aquellos puntos del código que contengan lógica compleja o crítica. Esto no solo ayuda en el proceso de depuración sino que también facilita el mantenimiento y la extensibilidad del sistema.
- **Separación de Responsabilidades**: La salida a consola debe estar estrictamente separada de la lógica de gestión de la biblioteca. Evitaremos colocar **`println`** directamente en las clases que no tienen esa responsabilidad. En su lugar, utilizaremos mecanismos de **log** en clases específicamente diseñadas para interactuar con el usuario, manteniendo así nuestro código limpio y bien organizado.

### **1.4 Trabajo en Ramas**

El proyecto esta formado de un conjunto de ejercicios que evolucionará el sistema en base a las especificaciones. Cada ejercicio se trabajará  en **ramas separadas**, permitiendo una organización clara y facilitando la revisión del trabajo realizado. Los nombres de las ramas seguirán el patrón **ejercicio-N**, donde **N** es el número del ejercicio, ayudando a mantener una estructura ordenada y coherente en el repositorio.

## 2. Ejercicios

### **Ejercicio 1: Sistema de Gestión de Biblioteca**

**Criterio global asociado**: 1. Instancia objetos y hacer uso de ellos.

**Contexto del Ejercicio**:
Desarrollar un sistema simple de gestión para una biblioteca que permita gestionar y realizar prestamos de libros y otros elementos que veremos mas adelante. Este sistema debe permitir agregar/eliminar libros a un catálogo, registrar préstamos/devoluciones de libros a usuarios y consultar el estado actual de un libro (`**disponible**` o `**prestado**`).

**Especificaciones**:

1. **Clase `Libro`**:  solo contendrá datos, sin ninguna lógica asociada.

- Algunos de los datos que contendrá: Id, título, autor, año de publicación, temática, y estado (disponible o prestado).
- Se debe poder inicializar las propiedades del libro, y no pueden ser vacías. El estado inicial de cualquier libro al incorporarse a la biblioteca es `**disponible**`.

1. **Clase `GestorBiblioteca`**: Contendrá la lógica para gestionar los libros, integrará el **(1) catalogo** y  el **(2) registro de prestamos**. Sobre estas dos clases hablaremos a lo largo de los ejercicios e irán evolucionando la implementación de ellas.

   - **Propiedades**:
     - Catalogo de libros (o cualquier otro elemento que se gestione) en la biblioteca. El catalogo de libro se inicializa sin libros, y posteriormente se incorporan.
     - El Registro de prestamos de los elementos del catálogo. Igualmente, el registro de prestamos se inicializa sin registros, y posteriormente se incorporan.
   - **Métodos**:
     - Agregar un libro al catálogo.
     - Eliminar un libro del catálogo.
     - Registrar un préstamo (cambia el estado del libro a prestado si está disponible).
     - Devolver un libro (cambia el estado del libro a disponible).
     - Consultar disponibilidad de un libro.
     - Retornar los libros en función de su estado (todos, disponibles y prestados).
2. **Programa Principal**:

   - Instanciar una **`GestorBiblioteca:`**
   - Agregar al menos tres libros al catálogo.
   - Realizar al menos dos préstamo y dos devoluciones. Tanto un préstamo, como una devolución tiene que ser errónea, debido al estado del libro.
   - Mostrar el estado actual de los libros.

   Recomendación implementar un **menú de usuario**. Este menú incorporará todas las acciones posibles que se vayan incorporando al sistema, permitiendo al usuario interactuar de manera clara y eficaz y facilitar las pruebas.

### **Ejercicio 2: Ampliación del Sistema de Gestión de Biblioteca con Métodos Estáticos**

**Criterio global asociado**: 2. Crear y llamar métodos estáticos.

**Contexto del Ejercicio**:
Sobre la base del sistema de gestión de biblioteca ya desarrollado, ahora se busca ampliar sus funcionalidades incorporando métodos estáticos que permitan realizar operaciones generales sin necesidad de instanciar objetos específicos.

**Especificaciones**:

1. **Clase `UtilidadesBiblioteca`**:
   - Esta clase deberá contener métodos estáticos que ofrezcan funcionalidades adicionales al sistema de gestión de biblioteca sin necesitar una instancia para ser utilizados.
   - **Métodos Estáticos Propuestos**:
     - **`generarIdentificadorUnico()`** que retorne un identificador único (string o número) para cada libro (o cualquier otro elemento) nuevo agregado al catálogo. Este método puede, por ejemplo, combinar la fecha y hora actual con un contador o generar un UUID.
2. Si consideras necesario cualquier otro método estático en cualquier clase, créalo y deja clara su existencia.
3. **Integración con `GestorBiblioteca`**:
   - Modificar el método de agregar libro para que utilice el método estático **`generarIdentificadorUnico()`** para asignar un identificador único a cada libro nuevo antes de agregarlo al catálogo.

**Programa Principal**:

- Utilizar los métodos estáticos de **`UtilidadesBiblioteca`** para mejorar la interacción con el usuario al momento de agregar libros.
- Demostrar el uso de estos métodos estáticos mostrando un flujo de uso claro, asegúrate que los identificadores únicos son asignados correctamente a los libros.

### **Ejercicio 3: Implementación de Control de Acceso y Clases Auxiliares en el Sistema de Gestión de Biblioteca**

**Criterio global asociado**: 4. Definir clases y su contenido.

**Contexto del Ejercicio**:
Refactorizar y extender el sistema de gestión de biblioteca existente, introduciendo conceptos avanzados de definición de clases y control de acceso para mejorar la estructura, eficiencia, y seguridad del sistema.

**Especificaciones**:

1. **Clase `Usuario`**:
   - **Propiedades**: Identificador único (ID), nombre, lista de libros prestados.
   - **Métodos**:
     - Constructor para inicializar el usuario con ID y nombre. La lista de libros prestados debe iniciarse vacía.
     - Métodos para agregar y quitar libros de la lista de libros prestados.
     - Método para consultar los libros prestados por el usuario.
2. **Modificaciones en la Clase `Libro`**:
   - Implementar control de acceso en las propiedades para asegurar que solo se puedan modificar internamente en la clase (privadas) y proporcionar métodos públicos para acceder a ellas de manera controlada si es necesario.
3. **Clase `RegistroPrestamos`**: Ten en cuenta que tienes que refactorizar, porque posiblemente ya tengas algo para registrar los prestamos.
   - **Propiedades**:
     - Mantendrá los registros de los prestamos actuales.
     - Además, mantendra un historial de todos los préstamos realizados.
   - **Métodos**:
     - Registrar un préstamo.
     - Devolver un libro.
     - Consultar el historial de préstamos de un libro específico.
     - Consultar el historial de préstamos de un usuario específico.
4. **Integración y Visibilidad**:
   - Asegurar que el uso de modificadores de acceso esté correctamente implementado en todas las clases para controlar la visibilidad de las propiedades y métodos.
   - Integrar las clases `**Usuario**` y **`RegistroPrestamos`** con **`GestorBiblioteca`** para mantener un registro detallado de los préstamos y devoluciones y poder consultar el historial de prestamos.

**Programa Principal**:

- Crear instancias de varios usuarios y realizar operaciones de préstamo y devolución utilizando el sistema modificado.
- Utilizar la clase **`GestorBiblioteca`,** que hará uso de **`RegistroPrestamos`**, para realizar las operaciones de prestamos y devolución y mostrar el historial de préstamos y devoluciones.
- Demostrar cómo se puede acceder a la información de los libros y usuarios de manera controlada a través de los métodos públicos sin exponer directamente las propiedades internas.

### **Ejercicio 4: Refactorización del Sistema de Gestión de Biblioteca con Herencia, Clases Abstractas e Interfaces**

**Criterio global asociado**: 5. Herencia y uso de clases abstractas e interfaces.

**Contexto del Ejercicio**:
Refactorizar y extender el sistema de gestión de biblioteca existente para incorporar herencia, el uso de clases abstractas e interfaces, y la aplicación de principios SOLID, con énfasis en el principio de inversión de dependencias para mejorar la modularidad y extensibilidad del sistema.

**Especificaciones**:

1. **Introducción de Clases Abstractas e Interfaces**:
   - **`ElementoBiblioteca` (Clase Abstracta)**: Crear una clase abstracta **`ElementoBiblioteca`** que defina propiedades y métodos comunes a todos los elementos de una biblioteca (como libros, revistas, DVDs). Esto puede incluir identificador, título, y estado (`**disponible**` o `**prestado**`)..
   - **`Prestable` (Interface)**: Definir una interfaz **`Prestable`** que especifique los métodos **`prestar()`** y **`devolver()`**. Asegurar que la clase **`Libro`** implemente esta interfaz, lo que garantiza que todos los tipos de elementos que puedan ser prestados cumplan con estos métodos.
2. **Refactorización de `GestorBiblioteca` para Inyección de Dependencias**:
   - **`IGestorPrestamos` (Interface)**: Crear una interfaz **`IGestorPrestamos`** que defina los métodos necesarios para gestionar préstamos (registrar prestamo/devolución, consultar historial, etc.). La clase **`RegistroPrestamos`** debe implementar esta interfaz. Ten en cuenta que puede que ya los tengas implementados, por tanto tendrias que refactorizar.
   - Modificar la clase **`GestorBiblioteca`** para que acepte una instancia de **`IGestorPrestamos`** a través de su constructor (inyección de dependencias), en lugar de crear una instancia de **`RegistroPrestamos`** directamente dentro de la clase. Esto facilita la extensibilidad y el testing al desacoplar el sistema de gestión de la biblioteca del sistema de registro de préstamos específico. **`GestorBiblioteca`** trabajará con la interface en vez de con la instancia concreta.
   - Hacer lo mismo con el **`Catalogo`**.
3. **Aplicación de Principios SOLID**:
   - Asegurar que la refactorización anterior cumple con el **principio de responsabilidad única** al separar las responsabilidades de gestión de préstamos de la lógica de gestión de la biblioteca.
   - Verificar que el **principio de abierto/cerrado** se cumple permitiendo la extensión del sistema (por ejemplo, añadiendo nuevos tipos de ítems para préstamo) sin modificar el código existente.
   - Aplicar el **principio de sustitución de Liskov** asegurando que las subclases (por ejemplo, diferentes tipos de ítems de la biblioteca) puedan ser utilizadas en lugar de sus clases base sin afectar la correctitud del programa.
   - Confirmar que el **principio de segregación de interfaces** se aplica al crear interfaces específicas y pequeñas que los clientes pueden implementar, en lugar de una única interfaz grande.
   - Implementar el **principio de inversión de dependencias** como se ha descrito anteriormente, dependiendo de abstracciones (interfaces) y no de concreciones (clases).

**Programa Principal**:

- Demostrar la creación de  elementos de biblioteca (libros, revistas, DVDs) que hereden de **`ElementoBiblioteca`** y/o implementen la interfaz **`Prestable`**.
- Instanciar **`GestorBiblioteca`** pasando una instancia de **`RegistroPrestamos`** (que implementa **`IGestorPrestamos`**) para demostrar la inyección de dependencias.
- Realizar operaciones de préstamo y devolución, asegurando que el sistema maneja correctamente los elementos.

### **Ejercicio 5: Implementación de Funcionalidades Genéricas en el Sistema de Gestión de Biblioteca**

**Criterio global asociado**: 9. Utiliza clases genéricas.

**Contexto del Ejercicio**:
Refinar el sistema de gestión de biblioteca existente mediante la introducción de clases y métodos genéricos, con el objetivo de aumentar la reutilización del código, su flexibilidad y facilitar la gestión de diferentes tipos de ítems en la biblioteca con una única estructura de código.

**Especificaciones**:

1. **Clase Genérica `GestorElementos<T>`**: Ten en cuenta que esta clase se utilizará para implementar el catalogo, por tanto es posible que ya tengas alguna lógica implementada de alguna manera, y necesites refactorizar.
   - Crear una clase genérica **`GestorElementos<T>`** que pueda utilizarse para gestionar distintos tipos de elementos, donde **`T`** puede ser cualquier clase que derive de **`ElementoBiblioteca`** (como **`Libro`**, **`Revista`**, **`DVD`**, etc.).
   - **Funcionalidades**: Posiblemente ya lo tengas implementado, consistirá en refactorizar. Los métodos podrían ser por ejemplo:
     - Agregar elementos al gestor de elementos.
     - Eliminar elementos por identificador del gestor de elementos.
     - Retornar los elementos gestionados.
2. **Otro método en `GestorElementos<T>`**:
   - Buscar elementos por diversos criterios (título, estado, etc.): **`filtrarPorCriterio<T>(elementos: T[], criterio: (elemento: T) => boolean): T[]`**, que permite filtrar cualquier lista de elementos basada en un criterio dado. Debe poder filtrar el catálogo por tipo de ítem, estado de préstamo, entre otros criterios.
3. **Aplicación de Clases Genéricas en el Sistema**:
   - Utilizar la clase genérica **`GestorElementos<T>`** para crear una clase **`Catalogo`** que gestione elementos de biblioteca:  **`Libro`**, **`Revista`**, **`DVD`**, etc., demostrando cómo se puede especializar la clase genérica para  **`ElementoBiblioteca`**.
4. Facilitar que **`GestorBiblioteca`** interactúe con el **`Catalogo`** para realizar operaciones sobre los elementos de la biblioteca.

**Programa Principal**:

- Demostrar la creación y uso de una instancia de **`GestorElementos<T>`** para gestionar elementos de biblioteca, realizando operaciones de agregación, eliminación, y búsqueda. Es decir, crear el **`Catalogo`** haciendo uso de esta clase.
- Ten en cuenta que la interación con **`Catalogo`** se realizará a través de la clase **`GestorBiblioteca.`** Se tendrá que realizar la inyección de una instancia creada, sobre **`GestorBiblioteca`** para hacer cumplir el principio de inversión de dependencias, como se indica en el ejercicio 4.

### **Ejercicio 6: Expansión y Optimización del Sistema de Gestión de Biblioteca Mediante Jerarquías de Clases**

**Criterio global asociado**: 6. Diseño de jerarquía de clases.

**Contexto del Ejercicio**:
Ampliar el sistema de gestión de biblioteca con una jerarquía de clases bien definida que abarque una gama más amplia de elementos disponibles en la biblioteca, aprovechando la herencia para maximizar la reutilización de código y facilitar la extensibilidad del sistema.

**Especificaciones**:

1. **Expansión de la Jerarquía de `ElementoBiblioteca`**:
   - **Clases Derivadas de `ElementoBiblioteca`**: Extender **`ElementoBiblioteca`** para incluir varias categorías de ítems, como **`Revista`**, **`DVD`**, y **`LibroElectronico`**, cada una con propiedades y métodos específicos adecuados a su tipo.
     - **`Revista`** podría incluir propiedades específicas como **`edicion`** y **`tematica`.**
     - **`DVD`** podría tener **`duracion`** y **`genero`.**
     - **`LibroElectronico`** podría incluir **`formatoDigital`** y **`tamañoArchivo`**.
   - **Implementación de `Prestable`**: Asegurar que todas las clases derivadas que representan ítems prestables implementen la interfaz **`Prestable`**.
     - **`LibroElectronico` no será prestable.**
2. **Revisión de la Clase `Catalogo`**:
   - Asegurar que la clase **`Catalogo`** utilice polimorfismo para manejar cualquier tipo de **`ElementoBiblioteca`**. Esta clase deberá poder agregar, eliminar, y buscar ítems en el catálogo, independientemente de su tipo específico.
3. **Integración con el Sistema de Gestión de Biblioteca**:
   - Integrar la jerarquía de clases con el sistema de gestión existente, permitiendo que **`GestorBiblioteca`** interactúe con el **`Catalogo`** para realizar operaciones sobre ítems de la biblioteca.
4. **OPCIONAL: Pruebas y Depuración (Si vas bien de tiempo)**
   - Desarrollar un conjunto de pruebas unitarias para verificar el correcto funcionamiento de la jerarquía de clases, especialmente la adición, eliminación, búsqueda, y filtrado de ítems en el **`Catalogo`**.
   - Implementar pruebas para los métodos específicos de cada clase derivada, asegurando que las propiedades y comportamientos específicos funcionen como se espera.

**Programa Principal**:

- Demostrar la creación de un catálogo variado con diferentes tipos de ítems (libros, revistas, DVDs, libros electrónicos), mostrando la flexibilidad del sistema para manejar distintas categorías.
- Ejecutar pruebas de préstamo y devolución para diferentes tipos de ítems, ilustrando el uso de la interfaz **`Prestable`** y el polimorfismo en acción.
- Realizar búsquedas y filtrados en el catálogo para encontrar ítems por diversos criterios, demostrando la eficacia de la clase **`Catalogo`**.

### **Ejercicio 7: Integración de Librerías de Clases en el Sistema de Gestión de Biblioteca**

**Criterio global asociado**: 7. Librerías de clases.

**Contexto del Ejercicio**:
Optimizar y extender las capacidades del sistema de gestión de biblioteca mediante la integración y uso efectivo de librerías de clases externas, especialmente enfocado en la manipulación y gestión avanzada de colecciones de datos.

**Especificaciones**:

1. **Uso de Colecciones Avanzadas**:
   - Incorporar y utilizar librerías de colecciones avanzadas para gestionar el **`CatalogoElementos`** y el **`RegistroPrestamos`**. Por ejemplo, emplear clases **`Map`** y **`List`** de Kotlin (o sus equivalentes en el lenguaje de programación elegido) para almacenar y manipular eficientemente la información.
   - Optimizar el manejo de datos utilizando operaciones de alto nivel proporcionadas por estas colecciones, tales como filtros, ordenaciones, y búsquedas, para mejorar la eficiencia y legibilidad del código.
2. **OPCIONAL: Integración de Librerías Externas**: Un ejemplo posible…. **(Si vas bien de tiempo)**
   - Explorar e integrar una librería externa que aporte valor añadido al sistema. Por ejemplo, utilizar una librería de serialización/deserialización de objetos para facilitar la persistencia de datos del catálogo y los registros de préstamo en un formato estándar (como JSON o XML).
   - Documentar brevemente la elección de la librería, cómo se integra en el sistema, y el valor añadido que proporciona.
3. **Refactorización y Mejoras en el Sistema**:
   - Refactorizar el código existente del sistema de gestión de biblioteca para hacer uso efectivo de las nuevas estructuras de colecciones y librerías integradas, asegurando que el sistema sea más eficiente, mantenible y escalable.
   - Asegurar que todas las nuevas integraciones y cambios en el código sean compatibles con las funcionalidades existentes y que no introduzcan regresiones en la funcionalidad del sistema.

**Programa Principal**:

- Demostrar el uso efectivo de colecciones avanzadas en operaciones típicas del sistema, como la gestión del catálogo y el registro de préstamos.
- **OPCIONAL:** Ilustrar cómo la integración de la librería externa seleccionada mejora una faceta específica del sistema (por ejemplo, la persistencia de datos).
- Realizar pruebas para validar la integración de las librerías y la correcta funcionalidad de las nuevas características implementadas.

## **3. Dinámica de Trabajo durante la realización del Ejercicio**

1. **Inicio del Examen**:
   - Los estudiantes deben comenzar creando su propio repositorio que contiene la base del proyecto del sistema de gestión de biblioteca. A partir de ahí, cada ejercicio se trabajará en una rama separada.
2. **Desarrollo de Ejercicios**:
   - Para cada ejercicio, el estudiante debe crear una nueva rama desde la rama principal (**`main`** o **`master`**, según la denominación inicial del repositorio). La rama para cada ejercicio debe seguir el patrón de nomenclatura **`ejercicio-N`**, donde **`N`** es el número del ejercicio. Esto ayuda a mantener organizado el trabajo y facilita la revisión de cada parte del examen por separado.
3. **Nombres de las Ramas para Cada Ejercicio**:
   - Ejercicio 1: **`ejercicio-1-gestion-biblioteca`**
   - Ejercicio 2: **`ejercicio-2-metodos-estaticos`**
   - Ejercicio 3: **`ejercicio-3-clases-contenido`**
   - Ejercicio 4: **`ejercicio-4-herencia-interfaces`**
   - Ejercicio 5: **`ejercicio-5-jerarquia-clases`**
   - Ejercicio 6: **`ejercicio-6-clases-genericas`**
   - Ejercicio 7: **`ejercicio-7-librerias-clases`**
   - Ejercicio 8: **`ejercicio-8-documentacion`**
   - Ejercicio 9: **`ejercicio-9-uso-entornos`**
4. **Integración de Ejercicios en la Rama Principal**:
   - Una vez finalizado un ejercicio, el estudiante debe asegurarse de que el código esté completo, funcional y debidamente probado en su respectiva rama.
   - Posteriormente, realizará un *merge* hacia la rama principal. Es recomendable que, antes de realizar la integración, se haga una revisión del código para asegurarse de que cumple con los requisitos y no introduce errores en la base del proyecto.
   - Este proceso se repite para cada ejercicio, manteniendo la rama principal actualizada con todas las funcionalidades desarrolladas a lo largo del examen.

### **Recomendaciones Finales**

- **Organización**: Mantén tu área de trabajo organizada y limpia. Esto incluye gestionar adecuadamente las ramas y asegurarse de que cada una se enfoque en el ejercicio correspondiente.
- **Commits Regulares**: Realiza commits pequeños y regulares con mensajes claros que describan los cambios realizados. Esto facilita el seguimiento del desarrollo y posibles correcciones.
- **Pruebas**: Antes de solicitar la integración de tu rama al proyecto principal, realiza pruebas exhaustivas para asegurar que el código añadido funciona correctamente y no afecta otras partes del sistema.

## 4. Evaluación

### Ejercicio 1:

**Criterios de Evaluación Aplicados:**

- Instanciación de objetos (libros y gestor de biblioteca).
- Uso de constructores para inicializar propiedades.
- Aplicación de métodos para cambiar el estado de los libros y gestionar préstamos.
- Uso de propiedades para gestionar y acceder a la información de los libros.
- Paso de parámetros a métodos para realizar acciones específicas (como préstamos y devoluciones).

**Rúbrica de Evaluación se basará en la utilizada para el criterio global:**

La evaluación se basará en la capacidad del estudiante para aplicar correctamente los conceptos de POO, la eficacia en la instanciación de objetos y la utilización de constructores, métodos y propiedades, de acuerdo con la rúbrica previamente definida.

### Ejercicio 2:

**Criterios de Evaluación Aplicados**:

- Definición y uso correcto de métodos estáticos.
- Integración de métodos estáticos con la lógica existente de gestión de la biblioteca.
- Uso efectivo de métodos estáticos para realizar operaciones sin necesidad de instancias.

**Rúbrica de Evaluación**:
Se evaluará cómo el estudiante aplica el concepto de métodos estáticos para agregar funcionalidades generales al sistema de gestión de biblioteca, la integración de estos métodos en el flujo existente, y la efectividad en su uso para simplificar y mejorar la gestión de la biblioteca, de acuerdo con la rúbrica previamente definida para el criterio global 2.

### Ejercicio 3:

**Criterios de Evaluación Aplicados**:

- Definición correcta y uso de propiedades y métodos, incluidos constructores.
- Aplicación adecuada de modificadores de acceso para proteger los datos y exponer funcionalidades de manera segura.
- Creación e integración de clases auxiliares que agregan valor y funcionalidad al sistema existente.

**Rúbrica de Evaluación**:
La evaluación se centrará en la capacidad del estudiante para estructurar adecuadamente las clases, aplicar correctamente los modificadores de acceso para proteger los datos, y la eficacia con la que integran nuevas clases para extender la funcionalidad del sistema, de acuerdo con la rúbrica previamente definida para el criterio global 4.

### Ejercicio 4:

**Criterios de Evaluación Aplicados**:

- Implementación correcta y uso de herencia, clases abstractas e interfaces.
- Aplicación efectiva de principios SOLID para mejorar la estructura del código y su mantenibilidad.
- Flexibilidad y extensibilidad del sistema demostrada a través de la capacidad de añadir nuevos tipos de ítems sin modificar el código existente significativamente.

**Rúbrica de Evaluación**:
La evaluación se centrará en la capacidad del estudiante para refactorizar el sistema existente e implementar nuevas características utilizando herencia, clases abstractas e interfaces, además de demostrar una comprensión y aplicación sólida de los principios SOLID, especialmente el de inversión de dependencias, para crear un diseño de software robusto, mantenible y extensible.

### Ejercicio 5:

**Criterios de Evaluación Aplicados**:

- Definición y uso adecuado de clases y métodos genéricos para gestionar diferentes tipos de ítems de biblioteca.
- Capacidad para aplicar la tipificación genérica de manera que mejore la flexibilidad, reutilización y mantenibilidad del código.
- Implementación de operaciones complejas sobre colecciones de ítems de biblioteca utilizando clases y métodos genéricos eficazmente.

**Rúbrica de Evaluación**:
La evaluación se centrará en la capacidad del estudiante para implementar y aplicar correctamente clases y métodos genéricos en el contexto del sistema de gestión de biblioteca, la eficacia en el uso de la tipificación genérica para crear soluciones reutilizables y flexibles, y la creatividad en la aplicación de estos conceptos para optimizar la gestión de la biblioteca. La claridad del código, su mantenibilidad y la cobertura de casos de uso serán aspectos clave para las calificaciones más altas en esta rúbrica.

### Ejercicio 6:

**Criterios de Evaluación Aplicados**:

- Correcta implementación de la jerarquía de clases que extiende **`ElementoBiblioteca`** para incluir diversos tipos de ítems de la biblioteca.
- Uso efectivo del polimorfismo y la interfaz **`Prestable`** para manejar operaciones de préstamo de manera genérica.
- OPCIONAL: Diseño e implementación de pruebas unitarias para validar la funcionalidad y robustez de la jerarquía de clases y el sistema de gestión de catálogo.

**Rúbrica de Evaluación**:
Se evaluará la capacidad del estudiante para diseñar una jerarquía de clases que sea extensible y mantenible, la eficiencia en el uso del polimorfismo para manejar diferentes tipos de ítems en la biblioteca, y la efectividad en la implementación de pruebas y depuración para asegurar el correcto funcionamiento del sistema. La innovación en el diseño de clases y la exhaustividad en las pruebas serán aspectos clave para alcanzar las calificaciones más altas en esta rúbrica.

### Ejercicio 7:

**Criterios de Evaluación Aplicados**:

- Selección adecuada y uso efectivo de librerías de clases para extender la funcionalidad y eficiencia del sistema.
- Integración correcta y coherente de librerías externas que aportan un valor claro y justificable al sistema.
- Capacidad para refactorizar y mejorar el código existente, asegurando la compatibilidad y funcionalidad del sistema.

**Rúbrica de Evaluación**:
La evaluación se centrará en la habilidad del estudiante para identificar, integrar y aprovechar librerías de clases que mejoren significativamente la funcionalidad, eficiencia, y mantenibilidad del sistema de gestión de biblioteca. La claridad en la documentación de las decisiones, la implementación efectiva, y la demostración de las mejoras introducidas serán aspectos clave para las calificaciones más altas en esta rúbrica.




| Criterio                                          | Puntos | 0 | 2  | 4  | 6  | 8  | 10  |
|---------------------------------------------------| ------ | - | -- | -- | -- | -- | --- |
| 1. Instancia objetos y hacer uso de ellos.        | 110    | 0 | 22 | 44 | 66 | 88 | 110 |
| 2. Crear y llamar métodos estáticos.              | 50     | 0 | 10 | 20 | 30 | 40 | 50  |
| 3. ~~Uso de entornos~~                                | 7      | 0 | 1  | 3  | 4  | 6  | 7   |
| 4. Definir clases y su contenido.                 | 40     | 0 | 8  | 16 | 24 | 32 | 40  |
| 5. Herencia y uso de clases abstractas e interfaces | 65     | 0 | 13 | 26 | 39 | 52 | 65  |
| 6. Diseño de jerarquía de clases.                 | 110    | 0 | 22 | 44 | 66 | 88 | 110 |
| 7. Librerías de clases                            | 10     | 0 | 2  | 4  | 6  | 8  | 10  |
| 8. ~~Documentado~~                                | 7      | 0 | 1  | 3  | 4  | 6  | 7   |
| 9. Utiliza clases genéricas.                      | 11     | 0 | 2  | 4  | 7  | 9  | 11  |
