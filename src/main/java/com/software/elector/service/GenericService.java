
package com.software.elector.service;

import java.util.List;

/**
 *
 * @author C.Mateo
 */
public interface GenericService <T, PK> {
    T getById(PK id);
    List<T> getAll();
    List<T> getByKey(String key);
    int save(T t);
    void update(T t);
    void delete(PK id);
}
