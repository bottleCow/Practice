// <beans> set를 사용해서 여러건의 데이터 받아오기,,,,set를 사용해서 가져오면 중복된 값은 하나만 불러옴


package set;
import java.util.Set;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class Ex01 {
	public static void main(String[] args) {
		AbstractApplicationContext ac = 
			new GenericXmlApplicationContext("/set/set.xml");
		SetBean sb = ac.getBean(SetBean.class);
		Set<String> addrs = sb.getAddrs();
		for (String addr : addrs) {
			System.out.println(addr);
		}
		ac.close();
	}
}
