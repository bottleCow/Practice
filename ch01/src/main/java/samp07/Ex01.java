package samp07;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex01 {
	public static void main(String[] args) {
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext("classpath:beans07.xml");
		//classpath은 src/main/resources를 가리킴
		MessageBean mb = ac.getBean(MessageBean.class);
		mb.sayHello();
		ac.close();
		
	}
}
