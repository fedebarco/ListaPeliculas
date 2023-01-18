# LISTA DE PELICULAS:

Esta app tiene como fin mostrar las peliculas mas populares del dia. Se observa una lista de peliculas basadas en las consultas diarias de gran cantidad de
personas en la web.

A traves de la api de https://developers.themoviedb.org/3/getting-started/introduction. Consta de dos pantallas 
observables por el usuario: la lista de peliculas(pantalla principal) y el detalle de la pelicula(pantalla detalle).

![alt text](https://github.com/fedebarco/ListaPeliculas/blob/master/archivosAPK/pantallaprincipal.png)
![alt text](https://github.com/fedebarco/ListaPeliculas/blob/master/archivosAPK/pantalladetalle.png)

----
# INSTALACIÓN:

Se cuenta con un archivo APK de instalación en la carpeta archivosAPK en la carpeta raiz del proyecto.

----
# CODIGO:

Se realizo en android studio en la versión Electric Eel en 2022.1.1.

## Dependencias:

Compose y navigation (interfaz y navegación),
moshi y retrofit (consumo de API),
coil (carga de imagenes).

## Generalidades:

### Modelo

La app solo tiene soporte para el idioma español (pudiendo ser extendido posteriormente a traves de la misma API),
en esta versión se llama al endpoint https://developers.themoviedb.org/3/trending/get-trending con los parametros 
de day(del dia),movies(peliculas) and es(idioma). En el modelado de datos se tienen tres clases; MoviesResponse y ResultMovies
que son las encargadas de modelar el Json que devuelve el servidor. Y NavState que es la clase encargada del estado de la interfaz.

### ViewModel

Cuenta con 3 variables:

-listmovies: Que almacena y administra el estado de las peliculas devueltas por el end point
-mainmovie: Almacena y administra el estado de la pelicula de la que se veria el detalle.
-navstate: Almacene y administra el estado de la vista.

y dos operaciones:

-getmovies: conecta y hace llamado a la API para la carga de peliculas

-gotodetail: acción al escoger una pelicula.

### vista:

Se usa solo una activity por el alcance del proyecto, al igual que no se inyectan las dependecias
al ser solo una y considerarse poco practico para un proyecto de este alcance. El unico permiso requerido
es el de INTERNET.

El estilo, color y formas se dejaron por defecto.

Cuenta con dos pantallas la pantalla principal que seria MoviesScreen y la pantalla detalla que seria InfoScreen 
ambas mediadas por un componente de navegación MainNavigation.



