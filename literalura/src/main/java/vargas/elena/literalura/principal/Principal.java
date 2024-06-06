package vargas.elena.literalura.principal;
import vargas.elena.literalura.model.Autores;
import vargas.elena.literalura.model.DatosGenerales;
import vargas.elena.literalura.model.DatosLibros;
import vargas.elena.literalura.model.Libros;
import vargas.elena.literalura.repository.AutoresRepository;
import vargas.elena.literalura.repository.LibrosRepository;
import vargas.elena.literalura.service.ConsumoDeAPI;
import vargas.elena.literalura.service.ConvertidorDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Principal {

    private ConsumoDeAPI varConsumoDeAPI = new ConsumoDeAPI();


    private ConvertidorDatos conversor = new ConvertidorDatos();


    private static final String URL_BASE = "http://gutendex.com/books/";


    private Scanner ingresoDeData = new Scanner(System.in);


    private Scanner inputUsuario = new Scanner(System.in);

    private LibrosRepository librosRepository;
    private AutoresRepository autoresRepository;

    public Principal(LibrosRepository librosRepository, AutoresRepository autoresRepository){
        this.librosRepository = librosRepository;
        this.autoresRepository = autoresRepository;
    }

    private DatosLibros obtenerLibro(String libroNombre){
        String json = varConsumoDeAPI.obtenerDatos(URL_BASE + "?search=" + libroNombre.replace(" ", "%20"));
        List<DatosLibros> libros = conversor.obtenerDatos(json, DatosGenerales.class).resultados();
        Optional<DatosLibros> libro = libros.stream()
                .filter(l -> l.titulo().toUpperCase().contains(libroNombre.toUpperCase()))
                .findFirst();
        if (libro.isPresent()){
            System.out.println("Hemos encontrado su libro!");
            return (libro.get());
        } else {
            System.out.println("No hemos encontrado ningún libro con los datos indicados");
            return null;
        }
    }
        private void lecturaDeLibro(Libros libro){
            System.out.println("                            ");
            System.out.println("***** LIBRO ENCONTRADO *****");
            System.out.println("Titulo: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutores().getNombre());
            System.out.println("Idioma: " + libro.getIdiomas());
            System.out.println("Numero de descargas: " + libro.getConteoDeDescargas());
            System.out.println("***************************\n");
        }

        private void lecuraDeAutor(Autores autores){

            System.out.println("Autor: " + autores.getNombre());
            System.out.println("Fecha de nacimiento: " + autores.getFechaDeNacimiento());
            System.out.println("Fecha de fallecimiento: " + autores.getFechaDeFallecimiento());
            List<String> libros = autores.getBooks().stream()
                    .map(l -> l.getTitulo())
                    .collect(Collectors.toList());
            System.out.println("Libros: " + libros + "\n");
        }

        public void menuPrincipal() {

            char ingreso ='0';

            while (ingreso !='e') {

                System.out.println("\n");
                System.out.println("¡Gracias por utilizar nuestra librería Literalura!");
                System.out.println("********************************************************************************");
                System.out.println(" 1-	Búsqueda de libro por título");
                System.out.println(" 2- Listar los libros buscados y su registro");
                System.out.println(" 3- Listar los autores buscados y su registro ");
                System.out.println(" 4- Listar los autores vivos en determinado año");
                System.out.println(" 5 -Listar los libros buscados por idioma");
                System.out.println(" e -Salir");
                System.out.println("*********************************************************************************");
                System.out.println(" Ingrese una opcion válida: ");


                ingreso = ingresoDeData.next().charAt(0);


                if (ingreso =='e'){
                    System.out.println("Saliendo del sistema... Gracias por su preferencia");
                    break;
                }

                if (Character.isDigit(ingreso)) {
                    int numeroCaso = Character.getNumericValue(ingreso);


                switch (numeroCaso) {


                    case 1:

                        System.out.println("Ingrese el nombre del libro que desea buscar:");
                        String nombreLibro = inputUsuario.next();
                        Libros libro = new Libros(obtenerLibro(nombreLibro));
                        lecturaDeLibro(libro);
                        librosRepository.save(libro);

                        break;

                    case 2:
                        List<Libros> libros = librosRepository.findAll();
                        libros.stream()
                                .forEach(this::lecturaDeLibro);
                        break;

                    case 3:
                        List<Autores> autores = autoresRepository.findAll();
                        autores.stream()
                                .forEach(this::lecuraDeAutor);
                        break;

                    case 4:

                        System.out.println("Ingresa el año en el cual deseas verificar si el autor(a) aún se encotraba vivo(a)");
                        Integer fechaDeFallecimiento = inputUsuario.nextInt();
                        List<Autores> autoresVivos = autoresRepository.findByFechaDeFallecimientoGreaterThan(fechaDeFallecimiento);
                        autoresVivos
                                .forEach(this::lecuraDeAutor);

                        break;

                    case 5:
                        System.out.println("Ingrese el idioma para buscar los libros:");
                        System.out.println("es - español");
                        System.out.println("en - ingles");
                        System.out.println("fr - frances");
                        System.out.println("pt - portugues");
                        String idiomas = inputUsuario.next();
                        List<Libros> librosIdioma = librosRepository.findByIdiomas(idiomas);
                        librosIdioma
                                .forEach(this::lecturaDeLibro);
                        break;

                    default:
                        System.out.println("Opción inválida, por favor ingrese una opción correcta");
                        break;
                }
            }
                else {
                    System.out.println("Ha ingresado una o más letras, por favor ingrese una opción válida del menú");
                }
}
}
}





