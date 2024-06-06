package vargas.elena.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)



//Aqui ponemos los datos especificos del area "authors" que queremos leer, con su JsonAlias//


public record DatosDeAutor(


    @JsonAlias("name") String nombre,

    @JsonAlias("birth_year") Integer fechaDeNacimiento,

    @JsonAlias("death_year") Integer fechaDeFallecimiento
){

}
