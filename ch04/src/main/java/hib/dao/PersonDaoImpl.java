package hib.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hib.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao{
	@Autowired
	private HibernateTemplate ht;

	public Person select(String id) {
		// SQL문 대신 사용하는 명령어(한건일때) ht.get()
		return ht.get(Person.class, id);
	}

	public void save(Person person) {
		// SQL문 대신 사용하는 명령어 ht.save()
		ht.save(person);
	}

	public void update(Person person) {
		// SQL문 대신 사용하는 명령어 ht.update()
		ht.update(person);
	}

	@SuppressWarnings("unchecked")
	public List<Person> list() {
		// 주의사항 - Person은 테이블명이 아닌 클래스명 대문자로 시작
		// 여러건 데이터는 ht.find()
		return (List<Person>) ht.find("from Person");
	}

	public void delete(String id) {
		// ht.delete(id); 이것만 쓰면 안됨
		// 객체를 생성하고 객체에 key를 setting한 후에 객체 삭제 가능
		Person person = new Person();
		person.setId(id);
		ht.delete(person);
	} 
	
}
