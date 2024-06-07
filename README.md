<h1> Literalura </h1>

![literalura image](https://github.com/escordigan/literalura/assets/149540525/294a9e44-f3f1-493e-a7e6-81b390efd840)


<h2 align="left"> Descripción del proyecto </h2>


Aplicacion en Spring Boot, consiste en una especie de base de datos de una libreria, hecha en lenguaje Java, conectada a una base de datos PostgreSQL.

En el menú principal el usuario puede elegir entre 5 opciones pricipales: buscar el libro por título, ver una lista de los libros buscados y registrados, ver una lista de los autores de los libros buscados y registrados, ver una lista de los autores vivos en determinado año, de los libros buscados y registrados, y por último, ver una lista de los libros buscados por idioma seleccionado.
Asimismo, el menú cuenta con la opcion de salir ingresando la letra "e", para terminar la sesión cuando el usuario así lo desee. Estas opciones se muestran al inicio del programa y en cuanto se finaliza la ejecución de alguna opción seleccionada.

![menuliteralura](https://github.com/escordigan/literalura/assets/149540525/e1ae034b-cc4a-422e-9429-db52bd3cf406)

Si el usuario selecciona la opción 1, se le pide que escriba el nombre del título, una vez escrito la aplicacion consume los datos de la API de Gutendex: http://gutendex.com/books/ Se busca la primer coincidencia que contenga o lleve ese nombre en el título, se imprime o muestra en pantalla y a lo interno se convierte ese objeto JSON de la API a un objeto JAVA dentro de una clase, posteriormente este dato es guardado automaticamente en una tabla dentro de una base de datos PostgreSQL, para su posterior consulta.

![literalurabusqueda1](https://github.com/escordigan/literalura/assets/149540525/8cd6dcc2-e3b7-4a57-a447-0177937b6c87)

En el caso en que el usuario seleccione la opción 2, se muestra en pantalla todos los libros buscados hasta el momento, que han sido almacenados en la base de datos PostgreSQL.

![opcion2literalura](https://github.com/escordigan/literalura/assets/149540525/db6e3f24-43b4-4368-975f-8a2a01d6f378)

Cuando el usuario elige la opción 3, se presenta en pantalla una lista de todos los autores de todos los libros buscados hasta el momento. Al mostrar esta lista se indican también algunos datos adicionales del autor, tales como: nombre, fecha de nacimiento, fecha de fallecimiento y libros registrados a su nombre.

![opcion3literalura](https://github.com/escordigan/literalura/assets/149540525/ee501d75-9108-4fd1-b889-722a3413db30)







