package samp02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;
// MethodInterceptor 메서드를 실행할때 가로채서 먼저 실행해줌
public class LogAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = invocation.getMethod().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		System.out.println("작업시작 : "+methodName);
		Object obj = invocation.proceed(); // 실제 본 작업 실행 sayHello();
		sw.stop();
		System.out.println("작업종료 : "+sw.getTotalTimeSeconds()+"초");
		return obj;
	}

}
