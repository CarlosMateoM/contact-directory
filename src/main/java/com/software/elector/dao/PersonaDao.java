package com.software.elector.dao;

import com.software.elector.model.Persona;

/**
 *
 * @author C.Mateo
 */
public interface PersonaDao extends GenericDao<Persona, Integer> {

    boolean isTelefonoInUse(String telefono);

    boolean isCedulaInUse(String cedula);
}
