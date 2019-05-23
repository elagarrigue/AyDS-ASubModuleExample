# Pasos para mover un paquete del proyecto a un submódulo

- Crear el repositorio del submódulo. Agregar un readme (el repositorio del submódulo no puede estar vacío al agregarlo al repositorio del proyecto).

- Agregar el submódulo:

git submodule add git@github.com:elagarrigue/AyDS-ASubModuleSpotifyData.git libs/SpotifyData

![](docs/screenshots/01.png)

- En el proyecto del android studio, crear un nuevo módulo (android library).

![](docs/screenshots/02.png)
![](docs/screenshots/03.png)
![](docs/screenshots/04.png)

- En este punto tenemos el submódulo vacío en libs, y el módulo nuevo en la raíz del proyecto.

![](docs/screenshots/05.png)

- Mover el contenido del módulo a la carpeta del submódulo.

![](docs/screenshots/06.png)
![](docs/screenshots/07.png)

- Modificar settings.gradle para indicar el nuevo path del modulo.

![](docs/screenshots/08.png)

- Al sincronizar, el android studio reconoce el nuevo modulo.

![](docs/screenshots/09.png)

- Actualizar el .gitignore del submodule (copiar el mismo que el del proyecto base). Hacer commit y push del submódulo.

![](docs/screenshots/10.png)
![](docs/screenshots/11.png)

- Hacer commit y push del proyecto.

![](docs/screenshots/12.png)

- Crear en el módulo un paquete con nombre relevante.

![](docs/screenshots/13.png)

- Mover el paquete “external” de model al módulo.

![](docs/screenshots/14.png)
![](docs/screenshots/15.png)

- El nuevo módulo tiene ahora referencias a retrofit. Mover esas dependencias de app/build.gradle a libs/SpotifyData/build.gradle.

![](docs/screenshots/16.png)
![](docs/screenshots/17.png)

- Ademas, setear la misma config en ambos build.gradle (usar target 28). 

![](docs/screenshots/18.png)

- El proyecto va a dejar de compilar, ya que el código de external no lo tenemos más. Lo primero que hay que hacer es agregar la dependencia del nuevo módulo en el build.gradle de app.

![](docs/screenshots/19.png)

- Al hacer el refactor, el ide debería actualizar los imports. En este caso, solo Repository se ve afectado.

![](docs/screenshots/20.png)

- Si external no era independiente (tenia referencias por fuera del paquete), el modulo no va a compilar. 

![](docs/screenshots/21.png)

- En este caso, tenemos que implementar nuestra propia clase (una copia de Song), y luego hacer la conversión en Repository.

![](docs/screenshots/22.png)
![](docs/screenshots/23.png)
![](docs/screenshots/24.png)
![](docs/screenshots/25.png)

- Hacer Clean, build, run. Una vez que compile y ejecute correctamente hacer commit y push del repo del submódulo, y del proyecto. 

![](docs/screenshots/26.png)
![](docs/screenshots/27.png)