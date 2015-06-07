package sk.stopangin.spring.security.util;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by myPC on 23. 5. 2015.
 */
public class SecurityContextUtil {
    public static String getUserName() {
        String currentUserName ="xxx";
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (!(authentication instanceof AnonymousAuthenticationToken)) {
//            currentUserName = authentication.getName();
//        }
        return currentUserName;
    }
}
