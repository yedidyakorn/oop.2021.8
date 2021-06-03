package sorting;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logging {
    long time;

    @Pointcut("execution(* *.sort(..))")
    private void selectAlgoritem() {
    }

    @Before("selectAlgoritem()")
    public void before(JoinPoint jp) {
        Integer[] tmp = (Integer[]) jp.getArgs()[0];
        System.out.println("Running sort in " + jp.getThis().getClass().getName() + " with array size " + tmp.length);
        time = System.currentTimeMillis();
    }

    @After("selectAlgoritem()")
    public void after(JoinPoint jp) {
        System.out.println("Function sort in " + jp.getThis().getClass().getName() + " took " + (System.currentTimeMillis() - time + " ms"));
    }
}
