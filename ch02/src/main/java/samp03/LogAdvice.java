package samp03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LogAdvice {
	public Object kk(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		StopWatch sw = new StopWatch();
		sw.start(method);
		System.out.println("작업 시작 : "+method);
		Object obj = pjp.proceed();
		sw.start();
		System.out.println("작업 종료 : "+sw.getTotalTimeSeconds()+"초");
		return obj;
	}
}
