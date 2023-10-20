package contact.directory.enums;

/**
 *
 * @author C.Mateo
 */
public enum ProcessErrorMessage {
    
    ERROR_CONEXION_DB("Error al establecer conexión con la base de datos: "),
    ERROR_GUARDAR_REGISTRO("Error al intentar guardar el nuevo registro\n"),
    ERROR_OBTENER_REGISTROS("Error al intentar obtener los registros \n"),
    ERROR_OBTENER_REGISTROS_FILTRADOS("Error al obtener los registros filtrados por el termino \"%s\".\n"),
    
    ERROR_VERIFICACION_CEDULA("Error al intentar verificar si la cedula está en uso \n"),
    ERROR_VERIFICACION_TELEFONO("Error al intentar verificar si el teléfono está en uso \n")
    ;
    
    
    private final String message;

    ProcessErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
