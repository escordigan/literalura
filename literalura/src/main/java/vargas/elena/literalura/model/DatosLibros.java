package vargas.elena.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)


public record DatosLibros(                          
                           @JsonAlias("title")
                           String titulo,

                           @JsonAlias("authors")
                           List<DatosDeAutor> autor,

                           @JsonAlias("languages")
                           List<String> idiomas,

                           @JsonAlias("download_count")
                           Integer conteoDeDescargas //El dato es un numero y solo se lee//{

){
}
