package samp02;

public class MessageBeanImpl implements MessageBean {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	public void sayHello() {
		try {
			Thread.sleep(500); // 0.5초 쉬었다가 실행
		} catch (InterruptedException e) {
		System.out.println(e.getMessage());
		}
		System.out.println(name+"님 안녕하세요");
	}
}
