package ch01.sample02;
// interface를 구현한다는 것은 interface에 있는 메서드 overriding해야 한다
public class MessageBeanKr implements MessageBean {
	public void sayHello(String name) {
		System.out.println("안녕하세요, "+name+"!");
	}
}