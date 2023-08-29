package com.software.elector.config;

import com.software.elector.dao.BarrioDao;
import com.software.elector.dao.CiudadDao;
import com.software.elector.dao.ComunaDao;
import com.software.elector.dao.DireccionDao;
import com.software.elector.dao.PersonaDao;
import com.software.elector.dao.impl.JdbcDaoCiudad;
import com.software.elector.dao.impl.JdbcDaoBarrio;
import com.software.elector.dao.impl.JdbcDaoComuna;
import com.software.elector.dao.impl.JdbcDaoDireccion;
import com.software.elector.dao.impl.JdbcDaoPersona;
import com.software.elector.service.BarrioService;
import com.software.elector.service.CiudadService;
import com.software.elector.service.ComunaService;
import com.software.elector.service.DireccionService;
import com.software.elector.service.PersonaService;
import com.software.elector.util.DatabaseUtil;

/**
 *
 * @author C.Mateo
 */
public class AppConfig {
    
    //Métodos para crear la instancia de los DAO's
    
    public static CiudadDao createCiudadDao(){
        return new JdbcDaoCiudad(DatabaseUtil.getDataSource());
    }
   
    public static BarrioDao createBarrioDao(){
        return new JdbcDaoBarrio(DatabaseUtil.getDataSource());
    }
    
    public static DireccionDao createDireccionDao(){
        return new JdbcDaoDireccion(DatabaseUtil.getDataSource());
    }
    
    public static ComunaDao createComunaDao(){
        return new JdbcDaoComuna(DatabaseUtil.getDataSource());
    }
    
    public static PersonaDao createPersonaDao(){
        return new JdbcDaoPersona(DatabaseUtil.getDataSource());
    }
    
    // Métodos para crear la instancia de los servicios
    
    public static CiudadService createCiudadService() {
        return new CiudadService(createCiudadDao());
    }
    
    public static BarrioService createBarrioService(){
        return new BarrioService(createBarrioDao());
    }
    
    public static DireccionService createDireccionService(){
        return new DireccionService(createDireccionDao());
    }
    
    public static ComunaService createComunaService(){
        return new ComunaService(createComunaDao());
    }

    public static PersonaService createPersonaService() {
        return new PersonaService(createPersonaDao());
    }
}
