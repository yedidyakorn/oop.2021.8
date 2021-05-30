package Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logging {

    @Pointcut("execution(* *.*(..))")
    private void selectAll(){}

    @Pointcut("execution(* *.*.set*(..))")
    private void selectSetters(){}

    @Pointcut("args(int)")
    private void selectArgs(){}

    @Pointcut("@annotation(Loggable)")
    private void selectLoggable(){}

    @Before("selectSetters()")
    public void beforeSetters(JoinPoint jp) throws Throwable{
        System.out.println("Calling " + jp.getSignature().getName()
                + " with " + jp.getArgs()[0]);
    }
    @Before("selectAll()")
    public void beforeAll(JoinPoint jp) throws Throwable{
        System.out.println("Calling " + jp.getSignature().getName());
    }
    @Before("selectLoggable()")
    public void beforeLoggable(JoinPoint jp) throws Throwable{
        System.out.println("Calling loggable function " + jp.getSignature().getName() + " from "+jp.getThis());

    }
}

