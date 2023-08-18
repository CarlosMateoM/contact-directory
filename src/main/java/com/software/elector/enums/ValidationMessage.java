package com.software.elector.enums;

/**
 *
 * @author C.Mateo
 */
public enum ValidationMessage {
    CAMPOS_OBLIGATORIOS("Complete los campos obligatorios."),
    CEDULA_EN_USO("La cédula ya está en uso."),
    TELEFONO_EN_USO("El número de teléfono ya está en uso."),
    VOTANTE_GUARDADO("¡Votante guardado exitosamente!"),
    CIUDAD_GUARDADA("¡Ciudad guardada exitosamente!"),
    SELECCIONE_UNA_CIUDAD("¡Seleccione una ciudad de la tabla!"),
    CIUDAD_INVALIDA("¡Ciudad seleccionada invalida!"),
    COMUNA_GUARDADA("¡Comuna guardada exitosamente!"),
    BARRIO_GUARDADO("¡Barrio guardado exitosamente!");

    private final String message;

    ValidationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
