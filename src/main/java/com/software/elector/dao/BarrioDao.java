package com.software.elector.dao;

import com.software.elector.model.Barrio;
import com.software.elector.model.Comuna;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public interface BarrioDao extends GenericDao<Barrio, Integer>{

    List<Barrio> getBarriosByComuna(int id);
    List<Barrio> getBarriosByComuna(Comuna comuna, String key);
}
