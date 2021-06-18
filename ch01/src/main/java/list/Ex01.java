// <beans> list를 사용해서 여러건의 데이터 받아오기,,,,list를 사용해서 가져오면 중복된 값도 일일히 다 출력가능

package list;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Ex01 {
	public static void main(String[] args) {
		AbstractApplicationContext ac =
			new ClassPathXmlApplicationContext("/list/list.xml");
		ListBean lb = ac.getBean(ListBean.class);
		List<String> addrs = lb.getAddr();
		for (String addr:addrs) {
			System.out.println(addr);
		}
		ac.close();
	}
}