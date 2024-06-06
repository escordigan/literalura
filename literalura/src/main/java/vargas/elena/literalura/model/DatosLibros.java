package vargas.elena.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)




public record DatosLibros( //Aqui ponemos los datos especificos del area "results" que queremos leer, con su JsonAlias//

                           
                           @JsonAlias("title")
                           String titulo,
//Importante reconocer en el JSON si es una list o un string e indicarlo para su obtencion//
                           @JsonAlias("authors")
                           List<DatosDeAutor> autor,
//En este caso los datos de autor son una lista en el JSON por eso se pone como tipo list y se le llama DatosDeAutor y se crea la clase tipo record DatosDeAutor para extraer el autor//
                           @JsonAlias("languages")
                           List<String> idiomas,
//Aqui no se mapea en una clase tipo record la lista, solo se lee como String entonces no se crea record para lenguajes//
                           @JsonAlias("download_count")
                           Integer conteoDeDescargas //El dato es un numero y solo se lee//{

){
}