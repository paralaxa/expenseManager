package sk.stopangin.spring.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.stopangin.spring.security.model.User;
import sk.stopangin.spring.security.repository.UserDao;
import sk.stopangin.spring.security.util.UserConverter;



/**
 * Created by myPC on 23. 5. 2015.
 */
@Service("userDetailsService")
public class MyUserDetailService implements UserDetailsService {
private static final Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);
    @Autowired
    UserDao userDao;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       final User byUserName = userDao.findByUserName(s);
        if(byUserName==null){
            throw new UsernameNotFoundException("user "+s+" not found");
        }
        return UserConverter.convertToSpringUser(byUserName);
    }


}
