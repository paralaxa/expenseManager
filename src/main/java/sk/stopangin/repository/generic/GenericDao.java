package sk.stopangin.repository.generic;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by myPC on 7. 6. 2015.
 */
public abstract class GenericDao<T> {
    private EntityManager entityManager;

    public T create(T t){
         entityManager.persist(t);
        return t;
    }

    public T findById(Class<T> tClass, Long id){
        return entityManager.find(tClass, id);
    }

    public T update(T t){
        return entityManager.merge(t);
    }

    public void delete (T t){
        entityManager.remove(t);
    }


}
