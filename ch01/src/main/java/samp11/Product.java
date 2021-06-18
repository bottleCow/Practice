package samp11;
public class Product {
	private String name;
	private int price;
	
	public Product(String name, int price) {
		this.name = name; 
		this.price = price;
	}
	@Override
	public String toString() {
		// 재정의 하지 않으면 객체를 출력하면 패키지명.클래스명@해시코드
		return "제품[이름:"+name+", 가격:"+price+"]";
	}
}