package samp13;

// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component // 객체로 만들어 주는것
@Repository("pd1") //@Component와 같지만 DAO전용 annotation
public class ProductDaoImpl implements ProductDao {
	public Product getProduct(String name) {
		return new Product(name, 9000);
	}
	
}
