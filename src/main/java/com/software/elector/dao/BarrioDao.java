package com.software.elector.dao;

import com.software.elector.model.Barrio;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public interface BarrioDao extends GenericDao<Barrio, Integer>{

    List<Barrio> getBarrioByComuna(int id);
    
}
