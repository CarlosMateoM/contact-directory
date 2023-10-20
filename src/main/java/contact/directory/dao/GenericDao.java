package contact.directory.dao;

import java.util.List;

/**
 *
 * @author C.Mateo
 * @param <T>
 * @param <PK>
 */
public interface GenericDao<T, PK> {
    
    T getById(PK id);
    List<T> getAll();
    List<T> getByKey(String key);
    int save(T t);
    void update(T t);
    void delete(PK id);
    
}
