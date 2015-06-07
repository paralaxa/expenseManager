package sk.stopangin.spring.security.repository;


import sk.stopangin.spring.security.model.User;

/**
 * Created by myPC on 23. 5. 2015.
 */
public interface UserDao {

    User findByUserName(String username);

}
