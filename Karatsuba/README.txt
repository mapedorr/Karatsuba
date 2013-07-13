Karatsuba
=========

Aplicación de escritorio para multiplicar dos números con el algoritmo de Karatsuba. 
Proyecto para Eclipse IDE. 
Ejecutable (JAR).

------------------------------------------------------------------------------------
-------------------------------------EJECUCIÓN--------------------------------------

Para ejecutar este proyecto como una aplicación debe ejecutarse el archivo .jar
ubicado en la carpeta "ejecutable". Para que el .jar funcione adecuadamente el
sistema debe tener instalado el JDK Java que puede descargarse de la siguiente 
página WEB: http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html?ssSourceSiteId=otnes
(Se debe marcar primero la opción Accept License Agreement).

También puede ejecutarse como proyecto de Eclipse IDE. Para esto se debe descargar
(en adición al JDK de Java) el IDE y descomprimirlo en cualquier carpeta:
http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/indigosr2
(las posibles versiones de sistema operativo se encuentran en un pánel a la derecha).



Una vez inicie la aplicación verá tres campos de texto. Dos editables (Primer número y Segundo número) 
y uno de sólo lectura (Resultado). Ingrese en cada uno de los campos los números que desea 
multiplicar y haga clic en el botón "Multiplicar". El resultado de la operación se mostrará 
en pantalla y en caso de haber un error la aplicación se lo mostrará también.

Los campos se redimensionarán para acomodarse al tamaño del número del resultado.

------------------------------------------------------------------------------------
------------------------------------ESTRUCTURA--------------------------------------

El proyecto se basa en el patrón modelo-vista-controlador:
Todo el código se encuentra dentro de la carpeta "src" organizado en paquetes (carpetas)
+ La clase principal (main) se encuentra en el archivo KaratsubaMain.java dentro de la carpeta "main":
    Esta clase se encarga de iniciar todos los objetos del patrón y de hacer visible la ventana de la aplicación
+ La clase de la vista se encuentra en el archivo KaratsubaUI.java dentro de la carpeta "interfazgrafica":
    Esta clase organiza los elementos de la ventana principal para mostrarlos al usuario. Entre las tareas
    que lleva acabo está la distribución de los campos para ingresar datos, la inserción del logo de la
    aplicación y la actualización en pantalla de los valores de los campos y los mensajes de error.
+ La clase del controlador se encuentra en el archivo KaratsubaControlador.java dentro de la carpeta "controlador"
    Esta clase se encarga de controlar los eventos realizados sobre el botón que envía los valores a multiplicar.
    Para ello se usa una clase interna que se asocia como manejador de eventos del botón. 
    En esta clase también se realizan las siguientes validaciones:
       :: Valores no válidos (texto, caracteres especiales, signos)
       :: Valores negativos
    Una vez superadas las verificaciones se llamará al algoritmo de multiplicación y se actualizará
    el resultado en la pantalla.
+ La clase del modelo (nucleo) se encuentra en el archivo KaratsubaAlgoritmo.java dentro de la carpeta "Karatsuba":
    Esta clase contiene el algoritmo para realizar una multiplicación con el método de Karatsuba 
    (http://en.wikipedia.org/wiki/Karatsuba_algorithm#Algorithm). El resultado se guarda en un atributo que
    es leído por la vista para mostrarlo en pantalla.
+ Hay dos clases adicionales. Una de constantes (constantes/Constantes.java) donde se encuentran los textos 
  a mostrar en pantalla para errores, etiquetas de campos y título de la pantalla. Y una que crea un pánel
  sobre el que se pone la imágen de logo de la aplicación (interfazgrafica/PanelLogo.java).

------------------------------------------------------------------------------------
------------------------------------------------------------------------------------

Cualquier comentario escribir a: mapedorr@gmail.com

------------------------------------------------------------------------------------
------------------------------------------------------------------------------------