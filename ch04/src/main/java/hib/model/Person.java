package hib.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // JPA을 사용하고 ORM을 지원하는 어노테이션
public class Person {
	private String id;
	private String name;
	@Id  //id가 primary key라는 뜻
	@Column(name = "id") // 실제로 table에서 사용하는 key, 같으면 생략가능
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
