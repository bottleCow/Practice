package ch01.sample01;
//ex01은 MessageBean.java를 사용한다(의존한다)

public class Ex01 {
	public static void main(String[] args) {
		MessageBean mb = new MessageBean();
		mb.sayHello("Luke");
	}
}
