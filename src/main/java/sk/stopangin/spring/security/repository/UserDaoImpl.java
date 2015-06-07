package sk.stopangin.spring.security.repository;


import org.springframework.stereotype.Component;
import sk.stopangin.spring.security.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by myPC on 23. 5. 2015.
 */
@Component
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    EntityManager entityManager;

    public User findByUserName(String username) {
    return entityManager.createQuery("Select u from user  u join fetch u.userRole  where u.username=:username", User.class).setParameter("username", username).getSingleResult();
    }
}
