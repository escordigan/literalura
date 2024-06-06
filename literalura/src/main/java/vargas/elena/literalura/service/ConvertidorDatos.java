package vargas.elena.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertidorDatos implements IConvertidorDatos { //Se agrega la implementacion de la interface//

    //Esta clase funciona como conversor, nos permite transformar el JSON del API a un objeto dentro de una clase Java//

    private ObjectMapper mapper = new ObjectMapper();
    @Override

    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return mapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}