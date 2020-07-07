package pl.phyriak.hotel_reservation_app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

    @Before(value = "onlyServices()")
    public void before(JoinPoint joinPoint){

        Signature signature = joinPoint.getSignature();
        String signatureName = signature.getName();
        System.out.println("Przed wywolaniem "+signatureName);

        Object[] args = joinPoint.getArgs();
        for (Object x :args) {
            System.out.println("Parameter: "+x);

        }
    }

    @Pointcut(value = "within(*..*Service)")
    public void onlyServices(){

    }
    @Pointcut(value = "bean(*)")
    public void allBeans(){

    }
}
