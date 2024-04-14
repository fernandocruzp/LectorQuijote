Lector de DOn Quijote.

Pequeño proyecto que hace uso de árboles rojinegros y hashmaps para leer el quijote y de manera eficiente regresar el número total de palabras diferentes así como el número de apariciones de cada una en orden alfabético.

Para clonar el proyecto utilice el siguiente comando en la terminal git clone https://github.com/fernandocruzp/LectorQuijote.git, ó descargue el archivo .zip en este repositorio.
Para realizar la instalación es necesario tener descargado maven, una vez que lo tenga, en el directorio raíz intrduzca el comando.
mvn install.
Con eso se creará la carpeta el archivo lectorQuijote.jar en la carpeta target.
El paso anterior es innecesario si clonó el repositorio completo, pues ya viene incluida la carpeta target en el repositorio.
Para ejecutar el programa debe correr en su terminal dentro de la carpeta raíz del proyecto java -jar target/lectorQuijote.jar <Nombre de archivo a leer>

