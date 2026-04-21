1 Realizar un fork del repositorio
Acceder al repositorio original en GitHub y hacer clic en el botón "Fork" para crear una copia en la cuenta personal.


2 Clonar el fork en la máquina local
Copiar la URL del fork y clonarlo en la máquina local utilizando el siguiente comando:

git clone <URL_DEL_FORK> #ej: git clone https://github.com/(tu usuario)/(tu nombre de este fork)

cd (tu nombre de este fork)


3 Definir el repositorio original como upstream
Configurar el repositorio original como upstream para poder obtener actualizaciones en el futuro (por ejemplo: avances en el trabajo):

git remote add upstream https://github.com/wotoko131-dev/CubirdsE


4 Comprobar sise ha subido un nuevo cambio. Para ello, lo que se hace es ejecutar pull sobre el remoto upstream (asegurarse que estais en cd (nombre del fork)). Se ejecuta el siguiente comando:

git pull upstream main --no-rebase --no-edit


5 Trabajar y añadir los cambios con 
git add . 
//añade los cambios

git commit -m "Respondidas a las preguntas 1 a 4 del Tema 1"
//confirma los cambios, dandoles nombre

git push origin main
//comparte los cambios
