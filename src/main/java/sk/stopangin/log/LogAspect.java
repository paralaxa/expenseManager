package sk.stopangin.log;

/**
 * Created by myPC on 5. 6. 2015.
 */

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @After("@annotation(sk.stopangin.log.Loggable)")
//@After("execution(public * *())")
    public void loggingAdvice(){
        System.out.println("ASPECT LOG AFTER COMPLETED");
    }
}
