//beans.xml에서 <beans>대신 사용하는 자바파일

package samp17;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
	@Bean
	public MemberDao memberDao() {
		return new MemberDaoImpl();
	}
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl();
	}
}

//Ex01에서 AnnotationConfigApplicationContext(JavaConfig.class)로 바꿔줘야함