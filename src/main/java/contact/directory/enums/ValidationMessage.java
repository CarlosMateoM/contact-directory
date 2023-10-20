package contact.directory.enums;

/**
 *
 * @author C.Mateo
 */
public enum ValidationMessage {
    
    CEDULA_EN_USO("La cédula ya está en uso."),
    TELEFONO_EN_USO("El número de teléfono ya está en uso."),
    
    CAMPOS_OBLIGATORIOS("Complete los campos obligatorios."),
    
    CIUDAD_INVALIDA("¡Ciudad seleccionada invalida!"),
    COMUNA_INVALIDA("¡Comuna seleccionada invalida!"),
    
    VOTANTE_GUARDADO("¡Votante guardado exitosamente!"),
    CIUDAD_GUARDADA("¡Ciudad guardada exitosamente!"),
    COMUNA_GUARDADA("¡Comuna guardada exitosamente!"),
    BARRIO_GUARDADO("¡Barrio guardado exitosamente!"),
    
    CIUDAD_ELIMINADA("¡Ciudad eliminada exitosamente!"),
    COMUNA_ELIMINADA("¡Comuna eliminada exitosamente!"),
    BARRIO_ELIMINADO("¡Barrio eliminado exitosamente!"),
    
    OPERACION_EXITOSA("¡Operacion realizada existosamente!")
    ;

    private final String message;

    ValidationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
