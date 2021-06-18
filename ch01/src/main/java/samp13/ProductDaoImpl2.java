package samp13;

import org.springframework.stereotype.Repository;

//import org.springframework.stereotype.Component;

//@Component // 객체로 만들어 주는것
@Repository("pd2") //@Component와 같지만 DAO전용 annotation
public class ProductDaoImpl2 implements ProductDao {
	public Product getProduct(String name) {
		return new Product(name, 88000);
	}
	
}
