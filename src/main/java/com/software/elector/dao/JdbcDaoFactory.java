package com.software.elector.dao;

/**
 *
 * @author C.Mateo
 */
public class JdbcDaoFactory implements FactoryDao {
    
    private final CiudadDao ciudadDao;
    private final ComunaDao comunaDao;
    private final BarrioDao barrioDao;
    private final PersonaDao personaDao;
    private final DireccionDao direccionDao;

    public JdbcDaoFactory(
            CiudadDao ciudadDao, 
            ComunaDao comunaDao, 
            BarrioDao barrioDao, 
            PersonaDao personaDao,
            DireccionDao direccionDao
    ) {
        this.ciudadDao = ciudadDao;
        this.comunaDao = comunaDao;
        this.barrioDao = barrioDao;
        this.personaDao = personaDao;
        this.direccionDao = direccionDao;
    }
    
    
    @Override
    public CiudadDao getCiudadDao() {
        return ciudadDao;
    }

    @Override
    public BarrioDao getBarrioDao() {
        return barrioDao;
    }

    @Override
    public ComunaDao getComunaDao() {
        return comunaDao;
    }

    @Override
    public DireccionDao getDireccionDao() {
        return direccionDao;
    }

    @Override
    public PersonaDao getPersonaDao() {
        return personaDao;
    }
    
}
