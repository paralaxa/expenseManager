package sk.stopangin.spring.security.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sk.stopangin.spring.security.model.User;
import sk.stopangin.spring.security.model.UserRole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by myPC on 23. 5. 2015.
 */
public class UserConverter {
    public static UserDetails convertToSpringUser(User user){
        final List<GrantedAuthority> authorities = buildAuthoritiesListFromRolesSet(user.getUserRole());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.isEnabled(), true, true, true, authorities);
    }

    private static List<GrantedAuthority> buildAuthoritiesListFromRolesSet(Set<UserRole> userRoles){
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
       return new ArrayList<GrantedAuthority>(setAuths);


    }

}
