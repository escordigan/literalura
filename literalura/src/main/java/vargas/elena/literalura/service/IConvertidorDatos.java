package vargas.elena.literalura.service;

public interface IConvertidorDatos {

    //La interface contiene el metodo generico para obtener los datos de API//

    <T> T obtenerDatos(String json, Class<T> clase);

}
