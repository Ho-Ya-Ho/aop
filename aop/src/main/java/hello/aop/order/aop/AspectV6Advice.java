package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Slf4j
@Aspect
public class AspectV6Advice {

//    @Order(2)
//    @Aspect
//    public static class LogAspect {
//        @Around("hello.aop.order.aop.Pointcuts.allOrder()")
//        public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
//            log.info("[log] {}", joinPoint.getSignature());
//            return joinPoint.proceed();
//        }
//    }
//
//    @Order(1)
//    @Aspect
//    public static class TxAspect {
//        @Around("hello.aop.order.aop.Pointcuts.orderAndService()")
//        public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
//            try {
//                log.info("[transaction start] {}", joinPoint.getSignature());
//                Object result = joinPoint.proceed();
//                log.info("[transaction commit] {}", joinPoint.getSignature());
//                return result;
//            } catch (Exception e) {
//                log.info("[transaction rollback] {}", joinPoint.getSignature());
//                throw e;
//            } finally {
//                log.info("[resource release] {}", joinPoint.getSignature());
//            }
//        }
//    }

    @Before("hello.aop.order.aop.Pointcuts.orderAndService()")
    public void before(JoinPoint joinPoint) {
        log.info("[before] {}", joinPoint.getSignature());
    }

    @AfterReturning(value = "hello.aop.order.aop.Pointcuts.orderAndService()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.info("[afterReturning] {} result:{}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(value = "hello.aop.order.aop.Pointcuts.orderAndService()", throwing = "ex")
    public void doThrowing(JoinPoint joinPoint, Exception exception) {
        log.info("[afterThrowing] {} ex:{}", joinPoint.getSignature(), exception.getClass().getSimpleName());
    }

    @After(value = "hello.aop.order.aop.Pointcuts.orderAndService()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("[after] {}", joinPoint.getSignature());
    }
}
