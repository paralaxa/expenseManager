package sk.stopangin.log;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(sk.stopangin.log.LoggableDebug)")
    public void loggingAdviceBefore(ProceedingJoinPoint joinPoint) {
        final String className = joinPoint.getTarget().getClass().getName();
        Long start = System.currentTimeMillis();
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("error while logging"+className);
        }
        Long end = System.currentTimeMillis();
        log.debug(className+" call takes: "+(end-start)+" [ms]");
    }

}
