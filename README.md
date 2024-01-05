Que se necesita para correr el proyecto?

1. Java Development Kit (JDK)
Descargar e instalar JDK y maven 
Configurar las variables de entorno de Java y maven

export JAVA_HOME=/Library/Java/JavaVirtualMachines/{JDK_VERSION_FOLDER}/Contents/Home
export PATH=$PATH:$JAVA_HOME/bin

Se hace lo mismo on amven despues de descomprimir el archivo descargado y poner la ruta respectiva en el path 
Revisar la version del java y maven en terminal con el comando java -version , maver -version

2. ChromeDriver
Descargar el chromeDriver que se asocie con tu version del navegador , se valida la version en el setting de chrome
Pegar el chromeDriver al proyecto 
Download Maven as your build tools

3. Intellij IDEA
Descargar e instalar intellij 
descargar y descomprimir el proyecto de git 
Importar el proyecto usando maven 
Descargar cucumber desde el ayudante de intellij 

4. Correr las pruebas 

Dar click derecho en la clase TestRunner y luego dar click en Run 'TestRunner'
Disfruta de las automatizaciones :D 
