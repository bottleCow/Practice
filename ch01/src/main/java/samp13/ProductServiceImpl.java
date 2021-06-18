package samp13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component //객체를 자동으로 생성해줌, samp12와 비교
@Service //@Component와 같지만 Service전용 annotation
public class ProductServiceImpl implements ProductService{
	@Autowired // setter메서드를 사용안하게 해줌, 생성된 객체와 연결해줌
	@Qualifier("pd2") //@Component에서 값이 pd2인
	private ProductDao pd;
	public Product getProduct() {
		return pd.getProduct("pencil");
	}
}
