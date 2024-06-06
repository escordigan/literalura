package vargas.elena.literalura.service;

public interface IConvertidorDatos {

    <T> T obtenerDatos(String json, Class<T> clase);

}
