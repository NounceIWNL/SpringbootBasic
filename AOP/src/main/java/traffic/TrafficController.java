package traffic;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Aspect

public class TrafficController {
    @Autowired
    Driver driver;
    private Logger logger = Logger.getLogger(TrafficController.class.getName());


    @Pointcut("within(org.itStep.traffic.TrafficLight)")
    public void someMethods() {
    }

    @AfterReturning(pointcut = "execution(public String org.itStep.traffic.TrafficLight.switchRed())", returning = "result")
    public void stopDriver(JoinPoint joinPoint, Object result) {
        driver.stop();
    }

    @AfterReturning(pointcut = "execution(public String org.itstep.traffic.TrafficLight.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        String value = (String)result;
        if (name.equals("switchYellow"))
            driver.ready();
        else if (name.equals("switchGreen"))
            driver.go();
    }
}
