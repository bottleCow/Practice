package ch01.sample02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Ex01 {
	public static void main(String[] args) {
		AbstractApplicationContext ac = new FileSystemXmlApplicationContext("beans01.xml");
		
//		MessageBean mb = ac.getBean("mb", MessageBean.class);
//		MessageBean mb = (MessageBean)ac.getBean("mb");   //3가지 방법중 택 1 가능
		MessageBean mb = ac.getBean(MessageBean.class);

		mb.sayHello("Luke");
		ac.close(); //Abstract를 써야 사용가능
		//beans01.xml을 통해 ex01, messagebeanEn, messageBeanKr의 결합도를 떨어뜨린다
		//beans01.xml만 바꿔주면 다양한 메서드 실행 가능
	}
}
