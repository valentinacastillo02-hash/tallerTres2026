# tallerTres2026
Descripción del proyecto
El proyecto consiste en el desarrollo de un juego basado en la creación, selección y utilización de diferentes tipos de monstruos, además de la administración de jugadores y sus respectivos puntajes históricos.

El programa permite crear cuatro tipos de monstruos: zombies, vampiros, momias y hombres lobo. Cada uno posee atributos generales, como vida, velocidad, fuerza y resistencia, además de características particulares que los diferencian entre sí. Para asegurar el correcto funcionamiento del juego, se implementan métodos de validación que verifican que los atributos ingresados se encuentren dentro de los rangos establecidos.

Por otra parte, el sistema permite registrar jugadores, consultar si ya se encuentran ingresados y recuperar sus puntajes históricos. También cuenta con funcionalidades para ordenar los registros según sus puntuaciones, identificar jugadores nuevos y consultar sus resultados.

Una de las características del proyecto es el almacenamiento de información mediante archivos de texto (TXT). Esto permite cargar los datos de los monstruos y jugadores desde archivos externos, así como guardar los registros actualizados de las partidas. Para ello, se utilizan mecanismos de lectura, escritura y validación de datos, evitando que información con formatos incorrectos sea incorporada al sistema.

En términos generales, el objetivo del proyecto es desarrollar un sistema que integre la programación orientada a objetos, el manejo de colecciones dinámicas, la validación de datos y la manipulación de archivos, permitiendo administrar los distintos elementos necesarios para el funcionamiento del juego.

Integrantes
En esta sección se deben identificar los integrantes que participaron en el desarrollo del proyecto, indicando sus respectivos datos de identificación y usuarios de GitHub.

- Integrante 1: Valentina Castillo

Usuario GitHub:https://github.com/valentinacastillo02-hash.

Estructura del proyecto
El proyecto está desarrollado en Java y utiliza programación orientada a objetos para organizar sus funcionalidades mediante distintas clases e interfaces.

Entre sus componentes principales se encuentra la clase interfaceImple, que implementa la interfaz contratoPrincipal y funciona como administradora de las operaciones del sistema. Esta clase centraliza la creación y validación de monstruos, la administración de jugadores, la selección de monstruos y el manejo de los registros almacenados en archivos de texto.

Además, el proyecto contempla las siguientes clases principales:

Monstrous: representa la estructura general de los monstruos y contiene sus atributos y funcionalidades comunes.

Zombie: representa al monstruo zombie, incorporando como característica particular la fuerza de mordida.

vampiro: representa al vampiro y contempla atributos específicos, como la velocidad de vuelo y la resistencia al sol.

Momia: representa a la momia e incorpora la longitud de sus vendajes como atributo particular.

hombreLobo: representa al hombre lobo, incluyendo su ferocidad y fase lunar.

Jugador: permite representar a los jugadores del sistema, almacenando sus nombres y puntajes históricos.

contratoPrincipal: corresponde a la interfaz que establece los métodos que debe implementar la clase administradora interfaceImple.

Para almacenar y organizar la información durante la ejecución, se utilizan listas dinámicas. Estas permiten mantener los monstruos disponibles, los monstruos seleccionados y los jugadores registrados, facilitando su consulta y modificación.

En cuanto al almacenamiento permanente, se utilizan archivos de texto para conservar los registros de monstruos y jugadores. La información se organiza mediante campos separados por punto y coma, lo que permite recuperar los datos posteriormente y transformarlos en objetos mediante procesos de lectura y validación.

Instrucciones de ejecución
Para ejecutar el proyecto es necesario contar con un entorno de desarrollo compatible con Java y disponer de los archivos correspondientes a las clases que componen el programa.

Primero, se debe descargar o clonar el repositorio del proyecto desde GitHub y abrirlo utilizando un entorno de desarrollo compatible, como Eclipse, IntelliJ IDEA o NetBeans.

Una vez abierto el proyecto, se debe comprobar que todas las clases e interfaces estén correctamente incorporadas y que sus dependencias estén configuradas. También es necesario verificar que los archivos de texto utilizados para almacenar los registros se encuentren en las ubicaciones correspondientes.

Posteriormente, se debe identificar la clase principal del programa, es decir, aquella que contiene el método de inicio de ejecución. Desde el entorno de desarrollo se debe ejecutar dicha clase para iniciar el sistema.

Durante la ejecución, el programa permitirá realizar las operaciones correspondientes a la administración de monstruos y jugadores, incluyendo la carga de registros, validación de atributos, selección de monstruos y consulta de puntajes históricos.

Finalmente, cuando se realicen modificaciones en los registros de los jugadores, el sistema podrá guardar la información actualizada en los archivos TXT correspondientes, permitiendo conservar los datos para futuras ejecuciones.
