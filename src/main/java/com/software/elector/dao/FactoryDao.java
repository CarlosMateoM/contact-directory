package com.software.elector.dao;


/**
 *
 * @author C.Mateo
 */
public interface FactoryDao {
    
    CiudadDao getCiudadDao();
    BarrioDao getBarrioDao();
    ComunaDao getComunaDao();
    DireccionDao getDireccionDao();
    PersonaDao getPersonaDao();
}
