package com.software.elector.dao;

import com.software.elector.model.Comuna;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public interface ComunaDao extends GenericDao<Comuna, Integer> {
    List<Comuna> getComunasByCiudad(int id);
}
