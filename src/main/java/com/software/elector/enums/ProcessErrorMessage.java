package com.software.elector.enums;

/**
 *
 * @author C.Mateo
 */
public enum ProcessErrorMessage {
    
    ERROR_CONEXION_DB("Error al establecer conexión con la base de datos: ");
    
    
    private final String message;

    ProcessErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
